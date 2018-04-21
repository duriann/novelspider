package niukewang_20161027;

public class Snippet {
	public static void main(String[] args) {
		System.out.println(returnTestInt());
	}
	public static int returnTestInt(){ int a = 0;  try { return a++;  } catch (Exception e) {
	
	    } finally { return ++a;  }
	}
}

