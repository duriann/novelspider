package test04;

public class TestFor {

	public static void main(String[] args) {
		 int i,j;  
	        for (i=2;i>0;i++){  
	            boolean a = true;  
	            for (j=2;j<i;j++){  
	                if (i%j==0)  
	                    a = false;  
	            }  
	            if (a==true)  
	                System.out.println(i);  
	        }  
		
	}

}
