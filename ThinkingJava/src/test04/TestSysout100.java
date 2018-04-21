package test04;

public class TestSysout100 {

	public static void main(String[] args) {
		for(int i = 0;i<101;i++){
			if(i==99)break;
			System.out.println(i);
		}
		System.out.println(Character.toChars(((int)'a'+25)));
	}

}
