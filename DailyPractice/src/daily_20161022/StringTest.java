package daily_20161022;

public class StringTest {
	public static void main(String[] args) {
		testSubString(" **ddas**  ");
		//testSubString("*dada**");
		//System.out.println(new String("abc").substring(0,1));
		"".trim();
	}
	public static void testSubString(String s){
		
		System.out.print(trim2(s));
		
	}
	
	public static String trim2(String value) {
		char[] charvalue = new char[value.length()] ;
        int len = charvalue.length;
        int st = 0;
        char[] val = new char[value.length()];    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < charvalue.length)) ? value.substring(st, len) : value;
    }
}
