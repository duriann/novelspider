package daily_20170723;

public class TestString {
	public static void main(String[] args) {
		/**
		 * 	最原始的url:https://www.ccc711.com/htm/piclist3/1.htm
			需要替换的url:ccc711.com
			用来替换的url:ccc690.com
			替换后的url:https://wwwccc690.com/htm/piclist3/1.htm
		 */
		
		String url = "https://www.ccc711.com/htm/piclist3/1.htm";
		
		url = url.replace("ccc711.com", "ccc690.com");
		System.out.println(url);
	}
}
