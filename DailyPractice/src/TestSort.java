
public class TestSort {

	public static void main(String[] args) {
		int[]arrInt = {2,4,7,6,3,5,8,10,11,1,0,13,9};
		quick_sort(arrInt, 0, arrInt.length-1);
		for (int i : arrInt) {
			System.out.print(i);
		}
	}
	/**
	 * 快速排序
	 * @param arrInt 待排序数组
	 * @param star
	 * @param end
	 */
	public static void quick_sort(int arrInt[], int star, int end)  
	{  
	    if (star < end)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
	        int i = star, j = end, x = arrInt[star];  
	        while (i < j)  
	        {  
	            while(i < j && arrInt[j] >= x){ // 从右向左找第一个小于x的数  
	                j--;    
	            }
	            if(i < j){
	                arrInt[i++] = arrInt[j];  
	            }
	            while(i < j && arrInt[i] < x){ // 从左向右找第一个大于等于x的数  
	                i++;    
	            }
	            if(i < j){ 
	                arrInt[j--] = arrInt[i];
	            }
	        }  
	        arrInt[i] = x;  
	        quick_sort(arrInt, star, i - 1); // 递归调用   
	        quick_sort(arrInt, i + 1, end);  
	    }  
	}  
}
