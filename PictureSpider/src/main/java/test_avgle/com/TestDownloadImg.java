package test_avgle.com;

import java.util.List;

import org.junit.Test;

import entitys.Chapter;
import impl.AbstractSpider;
import interfaces.IChapterSpider;

public class TestDownloadImg extends AbstractSpider{

	
	@Test
	public  void test() throws Exception{
		String url = "https://avgle.com/video/87137/%E5%A5%B3%E5%8F%8B%E9%81%87%E5%88%B0%E7%B4%A0%E8%B4%A8%E5%8D%95%E7%94%B7%E9%81%93%E5%BE%B7%E4%BC%A6%E7%90%86%E6%8A%9B%E4%B9%8B%E8%84%91%E5%90%8E%E5%B0%BD%E6%83%85%E4%BA%AB%E5%8F%97";
		String result = crawl1(url);
		System.out.println(result);
		
	}	

	

}
