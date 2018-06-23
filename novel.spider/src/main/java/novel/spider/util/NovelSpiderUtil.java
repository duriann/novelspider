package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.download.NovelDownload;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class NovelSpiderUtil {
	private static final Map<NovelSiteEnum, Map<String, String>> CONTEXT_MAP = new HashMap<>();
    private static org.slf4j.Logger log = LoggerFactory.getLogger(NovelDownload.class.getName());

	/*static {
		init();
	}*/

	private NovelSpiderUtil() {
		
	}

	/**
	 * 初始化爬取规则选择器文件
	 * 
	 * 2018年4月12日下午11:14:29
	 */
	@SuppressWarnings("unchecked")
	private static void init() {
		
		SAXReader reader = new SAXReader();
		try {
			//Document doc = reader.read(NovelSpiderUtil.class.getClassLoader().getResourceAsStream("conf/Spider-Rule.xml"));
			Document doc = reader.read(NovelSpiderUtil.class.getClassLoader().getResource("conf/Spider-Rule.xml"));
			Element root = doc.getRootElement();
			List<Element> sites = root.elements("site");
			for (Element site : sites) {
				List<Element> subs = site.elements();
				Map<String, String> subMap = new HashMap<>();
				for (Element sub : subs) {
					String name = sub.getName();
					String text = sub.getTextTrim();
					subMap.put(name, text);
				}
				CONTEXT_MAP.put(NovelSiteEnum.getEnumByUrl(subMap.get("url")), subMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拿到对应网站的解析规则
	 */
	public static Map<String, String> getContext(NovelSiteEnum novelSiteEnum) {
		init();
		return CONTEXT_MAP.get(novelSiteEnum);
	}

	/**
	 * 
	 * @param rootPath 要合并的文件目录
	 * @param mergeToFile 要合并到哪个文件里
	 *            2018年4月11日下午10:39:23
	 */
	public static void mergeMultiFile(String rootPath, String mergeToFile) {
		rootPath = rootPath.endsWith("\\") ? rootPath : rootPath + File.separator;
		log.info("rootPath:"+rootPath);
		mergeToFile = mergeToFile == null ? rootPath + "/merge.txt" : mergeToFile;
		// 获取目录下所有文件,此处简单判断是否是文本
		File[] files = new File(rootPath).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		// 排序
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				int f1index = Integer.parseInt(f1.getName().split("-")[0]);
				int f2index = Integer.parseInt(f2.getName().split("-")[0]);
				return f1index - f2index;
			}
		});
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(mergeToFile));
			for (File file : files) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				while ((line = br.readLine()) != null) {
					bw.write(line);
					bw.newLine();
				}
				br.close();
				//合并后删除零碎的文件
				file.delete();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取书籍的状态
	 * @param status
	 * @return
	 */
	public static int getNovelStatus(String status) {
		if (status.contains("连载")) {
			return 1;
		} else if (status.contains("完结") || status.contains("完成") || status.contains("完本")) {
			return 2;
		} else {
			throw new RuntimeException ("不支持的书籍状态：" + status);
		}
	}
	
	/**
	 * 格式化日期字符串为日期对象
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String dateStr, String pattern) throws ParseException {
		if ("MM-dd".equals(pattern)) {
			pattern = "yyyy-MM-dd";
			dateStr = getDateField(Calendar.YEAR) + "-" + dateStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date date = sdf.parse(dateStr);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 获取本时刻的字符量
	 * @param field
	 * @return
	 */
	public static String getDateField(int field) {
		Calendar cal = new GregorianCalendar();
		return cal.get(field) + "";
	}

}
