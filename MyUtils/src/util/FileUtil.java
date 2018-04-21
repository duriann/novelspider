package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 文件工具类
 * 
 * @author pineapple
 * @time 2016年10月7日下午6:36:11
 */
public class FileUtil {
	private static final String FILE = "File";
	private static final String DIR = "Dir";
	private static ArrayList<File> ArrayList = new ArrayList<File>();
	private static Map<String, ArrayList<File>> fileMap = new HashMap<>();
	private static Log log = LogFactory.getLog(FileUtil.class);
	
	public static boolean copyFile(String srcPath,String toPath){
		File path = new File(toPath);
		if(!toPath.endsWith("//")){
			toPath+="//";
		}
		path.mkdir();
		if (!path.exists()&&path.isDirectory()) {
			path.mkdir();
		}
		try {
			java.util.ArrayList<File> files = findFile(srcPath);
			for (File file : files) {
				
				if (file.isDirectory()) {
					String newDir = toPath+file.getName();
					new File(newDir).mkdir();
					
				}else{
					String newname = file.getName().substring(0, file.getName().lastIndexOf('.'));
					System.out.println(file.getAbsolutePath());
					copyFile(file.getAbsolutePath(), toPath,newname);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * @param srcFile 源文件路径
	 * @param copyToPath 复制到哪个文件夹
	 * @param newName 新的文件名
	 * @return
	 * 2016年10月8日下午7:44:43
	 */
	public static boolean copyFile(String srcFile,String copyToPath,String newName) {
		StringBuffer houzhui = new StringBuffer();
		File f2 = null;
		if (!copyToPath.endsWith("//")) {
			copyToPath+="//";
		}
		File f1 = new File(srcFile);
		
			houzhui = houzhui.append(srcFile.substring(srcFile.lastIndexOf(".")));
			System.out.println(copyToPath+newName+houzhui);
			f2 = new File(copyToPath+newName+houzhui);
		
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(f1));
			bos = new BufferedOutputStream(new FileOutputStream(f2));

		} catch (FileNotFoundException e) {
			log.error("文件不存在！");
			return false;
		}
		byte[] buffer = new byte[2048];
		int read = 0;
		try {
			while((read=bis.read(buffer))!=-1){
				bos.write(buffer, 0, read);
			}
			bis.close();
			bos.close();
		}catch(Exception e){
			log.error("文件复制失败！");
			return false;
		}
		return true;
	}
	/**
	 * 根据目录搜索指定类型的文件
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<File> findFile(String rpath) throws Exception {
		
		File file = new File(rpath);
		File[] fileList = null;
		if (file.isDirectory()) {
			fileList = file.listFiles();

			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) {
					ArrayList.add(fileList[i]);
					log.info("找到文件夹: "+fileList[i].getPath());
					findFile(fileList[i].getPath());
				} else {
					log.info("找到文件: " + fileList[i].getPath());
					ArrayList.add(fileList[i]);
				}
			}
		}
		return ArrayList;
	}
	
	
	/**
	 * 根据文件过滤器搜索指定目录下的文件
	 * 
	 * @param file
	 *            目录
	 * @param filter
	 *            文件类型
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<File> findFile(String path, FilenameFilter filter) throws Exception {
		File file = new File(path);
		File[] fileList = null;

		if (file.isDirectory()) {
			fileList = file.listFiles();

			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) {
					findFile(fileList[i].getPath(), filter);
				} else {
					if (filter.accept(null, fileList[i].getName())) {
						log.info("找到文件: " + fileList[i].getPath());
						ArrayList.add(fileList[i]);
					}
				}

			}

		}
		return ArrayList;
	}

	/**
	 * 批量修改视频文件给每个文件后面加一个字节防止被百度云网盘和谐
	 * 
	 * @param dir
	 *            文件夹目录
	 * @throws Exception
	 */
	public static void mediaModifi(String dir) throws Exception {
		log.info("开始修改视频...");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ArrayList<File> files = findFile(dir);

		Iterator<File> iterator = files.iterator();
		while (iterator.hasNext()) {
			File file = iterator.next();
			String filename = file.getName();
			String filehouzhui = filename.substring((filename.lastIndexOf(".")));
			
			String absolutePath = file.getAbsolutePath();
			String fileqianzhui = absolutePath.substring(0, absolutePath.lastIndexOf("."));
			String newFilePath = fileqianzhui+"_fanghexie"+filehouzhui;
			System.out.println("newfilepath:"+newFilePath);
			File newfile = new File(newFilePath);
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(newfile));
			byte[] buf = new byte[1024];
			int read = 0;
			while ((read = bis.read(buf)) != -1) {
				bos.write(buf, 0, read);
			}
			bos.write(00);
			log.info("文件" + filename + "修改完成");
			log.info("位置:"+newFilePath);
			bis.close();
			bos.close();
			if (file.exists()) {
				log.info("删除文件:"+file.delete());
			}
			
		}
		
	}

	/**
	 * 获取文件MD5值
	 * 
	 * @param inputFile
	 * @return
	 * @throws IOException
	 */
	public static String fileMD5(String inputFile) throws IOException {

		// 缓冲区大小（这个可以抽出一个参数）

		int bufferSize = 256 * 1024;

		FileInputStream fileInputStream = null;

		DigestInputStream digestInputStream = null;

		try {

			// 拿到一个MD5转换器（同样，这里可以换成SHA1）

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			// 使用DigestInputStream

			fileInputStream = new FileInputStream(inputFile);

			digestInputStream = new DigestInputStream(fileInputStream, messageDigest);

			// read的过程中进行MD5处理，直到读完文件

			byte[] buffer = new byte[bufferSize];

			while (digestInputStream.read(buffer) > 0)
				;

			// 获取最终的MessageDigest

			messageDigest = digestInputStream.getMessageDigest();

			// 拿到结果，也是字节数组，包含16个元素

			byte[] resultByteArray = messageDigest.digest();

			// 同样，把字节数组转换成字符串

			return byteArrayToHex(resultByteArray);

		} catch (NoSuchAlgorithmException e) {

			return null;

		} finally {

			try {

				digestInputStream.close();

			} catch (Exception e) {

			}

			try {

				fileInputStream.close();

			} catch (Exception e) {

			}

		}

	}

	/**
	 * 将字节数组转换成16进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteArrayToHex(byte[] byteArray) {

		// 首先初始化一个字符数组，用来存放每个16进制字符

		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））

		char[] resultCharArray = new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去

		int index = 0;

		for (byte b : byteArray) {

			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];

			resultCharArray[index++] = hexDigits[b & 0xf];

		}

		// 字符数组组合成字符串返回

		return new String(resultCharArray);
	}

	/**
	 * 把指定文件或目录转换成指定的编码
	 * 
	 * @param file
	 *            要转换的文件或目录
	 * @param fromCharsetName
	 *            源文件的编码
	 * @param toCharsetName
	 *            要转换的编码
	 * @param filter
	 *            文件名过滤器
	 * @throws Exception
	 */

	public static void convert(String fileordir, String fromCharsetName, String toCharsetName, FilenameFilter filter)
			throws Exception {
		if (filter == null) {
			ArrayList = findFile(fileordir);
		} else {
			ArrayList = findFile(fileordir, filter);
		}
		for (File file : ArrayList) {
			String fileContent = getFileContentFromCharset(file, fromCharsetName);
			log.info("正在转换文件： " + file.getAbsolutePath());
			saveFile2Charset(file, toCharsetName, fileContent);
		}
	}

	/**
	 * 以指定编码方式读取文件，返回文件内容
	 *
	 * @param file
	 *            要转换的文件
	 * @param fromCharsetName
	 *            源文件的编码
	 * @return
	 * @throws Exception
	 */
	private static String getFileContentFromCharset(File file, String fromCharsetName) throws Exception {
		if (!Charset.isSupported(fromCharsetName)) {
			throw new UnsupportedCharsetException(fromCharsetName);
		}
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream, fromCharsetName);
		char[] chs = new char[(int) file.length()];
		reader.read(chs);
		String str = new String(chs).trim();
		reader.close();
		return str;
	}

	/**
	 * 以指定编码方式写文本文件，存在会覆盖
	 * 
	 * @param file
	 *            要写入的文件
	 * @param toCharsetName
	 *            要转换的编码
	 * @param content
	 *            文件内容
	 * @throws Exception
	 */
	private static void saveFile2Charset(File file, String toCharsetName, String content) throws Exception {
		if (!Charset.isSupported(toCharsetName)) {
			throw new UnsupportedCharsetException(toCharsetName);
		}

		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter outWrite = new OutputStreamWriter(outputStream, toCharsetName);
		outWrite.write(content);
		outWrite.close();
	}

}
