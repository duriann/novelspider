import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.nio.fs.WindowsFileSystemProvider;
import util.FileUtil;

public class TestUtils {
	private static long startTime;
	private static long endTime;
	
	
	
	/**
	 * 测试查找目录下的所有文件
	 * 
	 * 2016年12月7日下午7:56:28
	 */
	@Test
	public void testFindFile(){
		String path = "F://oracle";
		try {
			ArrayList<File> files = FileUtil.findFile(path);
			for (File file : files) {
				System.out.println(file.getAbsolutePath());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试修改视频文件加1秒
	 * 
	 * 2016年12月7日下午7:02:16
	 */
	@Test
	public void testModifiFile(){
		String url = "I:\\lala3";
		
		try {
			FileUtil.mediaModifi(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试删除重复文件
	 */
	@Test
	public void deleteReFiles() throws Exception{
		String path = "D:\\Program Files (x86)\\360\\360Safe\\mobilemgr";
		ArrayList<File> files = FileUtil.findFile(path);
		for (File file2 : files) {
			file2.setWritable(true);
			file2.setExecutable(true);
			file2.delete();
			
		}
	}
	/**
	 * 
	 * 测试复制文件
	 * 2016年10月8日下午8:27:14
	 */
	@Test
	public void testCopyFile() {
		String srcFile = "F://testCopyWork//5167101234_小白.docx";
		String copyToPath = "F://testCopyWork//";
		String newName = "5167101222_白小";
		boolean isCopy = FileUtil.copyFile(srcFile, copyToPath, newName);
		System.out.println(isCopy);
	}
	/**
	 * 测试监控指定名称作业并且复制一份
	 * @throws Exception
	 * 2016年10月8日下午8:27:28
	 */
	@Test
	public void testCopyWork() throws Exception {
		String srcDir = "F://testCopyWork//";
		String chaosheidezuoye = "小白";
		String newName = "5167101111_小白白";
		File file = new File(srcDir);
		ArrayList<File> files = null;

		do {
			System.out.println("开始监控作业.. ");
			files = FileUtil.findFile(srcDir, new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.contains(chaosheidezuoye);
				}
			});

			Thread.sleep(1000);

		} while (files.size() == 0);
		Iterator<File> iterator = files.iterator();
		while (iterator.hasNext()) {
			File zuoye = iterator.next();
			String name = zuoye.getName();
			String srcFile = srcDir + name;
			System.out.println(srcFile);
			String copyToPath = srcDir;
			boolean isCopy = FileUtil.copyFile(srcFile, copyToPath, newName);
			System.out.println(isCopy ? "复制成功~" : "复制失败~");
		}

	}
	/**
	 * 测试根据目录和过滤机批量修改文件编码
	 * @throws Exception
	 * 2016年10月8日下午8:26:29
	 */
	@Test
	public void testFileUtil() throws Exception {
		String fileordir = "C:\\Users\\pineapple\\Desktop\\javaOcr\\src\\cn\\pwntcha";
		File file = new File(fileordir);
		// FileUtil.convert(file, "UTF-8", "GBK",null);
		FileUtil.convert(fileordir, "GBK", "UTF-8", new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("java");
			}
		});
	}

	@Before
	public void start() {
		startTime = System.currentTimeMillis();
	}

	@After
	public void end() {
		endTime = System.currentTimeMillis();
		System.out.println("程序运行时间: " + (endTime - startTime) + "毫秒");
	}
}
