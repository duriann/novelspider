package daily_20170923;

import java.sql.Date;

public class TimePrinter1 extends Thread{
	
	public static void main(String[] args) {
		TimePrinter1 t1 = new TimePrinter1(1000, "bolo");
		t1.start();
		TimePrinter1 t2 = new TimePrinter1(3000, "liulian");
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
	public TimePrinter1(int x,String n) {
		this.pauseTime = x;
		this.name = n;
	}
	
	
}
