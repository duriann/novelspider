package niukewang_20161010;

public class Solution {
	public static void main(String[] args) {
		int[][] array = new int[4][3];
		for(int i =0;i<4;i++){
			for(int k = 0;k<3;k++){
				array[i][k] = i+k;
			}
		}

		new Solution().Find(array, 3);
	}
    public boolean Find(int [][] array,int target) {
		for (int[] is : array) {
			for (int i : is) {
				if(i == target){
					return true;
				}
			}
		}
		return false;
    }
}
