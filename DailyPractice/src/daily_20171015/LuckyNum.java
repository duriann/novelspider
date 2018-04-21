package daily_20171015;

import java.util.Scanner;  

public class LuckyNum {  
    public static void main(String[] args) {  
    	String[] arr = new String[1023];
    	for(int i = 0;i<1023;i++){
    		arr[i] = transToLuckyNum(i+1);
    	}
    	int i = 1000;
    	int k = 662315;
    	for (String string : arr) {
			
		}
    }  
  
    public static String[] method_LuckyNum(int n, long[] nums) {  
        String[] output = new String[n];  
        for (int i = 0; i < n; i++) {  
            output[i] = transToLuckyNum(nums[i]);  
        }  
        return output;  
    }  
  
    private static String transToLuckyNum(long number) {  
        String binString = Long.toBinaryString(number + 1);
        String string = binString.substring(1);  
        String result = string.replace("0", "6").replace("1", "8");  
        return result;  
    }  
}  