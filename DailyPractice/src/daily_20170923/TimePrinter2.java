package daily_20170923;

import java.sql.Date;



public class TimePrinter2 implements Runnable{
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new TimePrinter2(1000, "bolo"));
		Thread t2 = new Thread(new TimePrinter2(3000, "liulian"));
		t1.start();
		t2.start();
		
		
	}
	private String name;
	private int pauseTime;
	@Override
	public void run() {
		while(true){
			System.out.println(name+":"+new Date(System.currentTimeMillis()));
			try {
				Thread.sleep(pauseTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public TimePrinter2(int x,String n) {
		this.pauseTime = x;
		this.name = n;
	}
	
	
}
