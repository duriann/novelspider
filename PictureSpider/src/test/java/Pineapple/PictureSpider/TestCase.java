package Pineapple.PictureSpider;

import org.junit.Test;

public class TestCase {
	
	
	@Test
	public void testString(){
		String filePath = "https://img.581gg.com/picdata-watermark/a1/140/14091-1.jpg";
		String ss = filePath.substring(filePath.lastIndexOf('/')+1);
		System.out.println(ss);
	}
	
	
	
}
