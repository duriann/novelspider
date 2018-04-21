
public class CountXiaoJi {

	public static void main(String[] args) {
		for(float i = 0;i<=100;i++){
			for(float j = 0;j<=100;j++){
				for(float k=0;k<=100;k++){
					if((i+k+j==100)&&(i*5+j*3+k/3==100)){
						System.out.println("大花瓶:"+i+",中花瓶:"+j+",小花瓶:"+k);
					}
				}
			}
		}
	}

}
