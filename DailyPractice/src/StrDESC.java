
public class StrDESC {

	public static void main(String[] args) {
		String strSrc = "ads12d";
		String newStr = desc(strSrc);
		System.out.println("原字符串:"+strSrc+" 反转后:"+newStr);
	}
	public static String desc(String str){
		byte[] bytes = str.getBytes();
		for(int i = 0;i<bytes.length/2;i++) {
			byte b = bytes[i];
			bytes[i] = bytes[bytes.length-1-i];
			bytes[bytes.length-1-i] = b;
		}
		return new String(bytes);
	} 
}
