package daily_20161215;

import java.util.concurrent.TimeUnit;

public class TraditionalThreadSynchronized {

	public static void main(String[] args) {
		Outputer outputer = new TraditionalThreadSynchronized().getOutputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output3("zhanglongchao");
				}
			}
		}).start();;
		new Thread(new Runnable() {
					
					@Override
					public void run() {
						while(true){
							try {
								TimeUnit.MILLISECONDS.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							outputer.output3("boluochuixue");
						}
					}
				}).start();;
	}
	public Outputer getOutputer(){
		return new Outputer();
	}
	class Outputer{
		public synchronized void output1(String name){
			for(int i = 0;i<name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		public synchronized void output2(String name){
			synchronized(name){//起不到同步的效果 因为这里面的锁必须是唯一的 而且调用的对象也是同一个。
				for(int i = 0;i<name.length();i++){
					System.out.print(name.charAt(i));
				}
			}
			System.out.println();
		}
		public synchronized void output3(String name){
			synchronized(Outputer.class){
				for(int i = 0;i<name.length();i++){
					System.out.print(name.charAt(i));
				}
			}
			System.out.println();
		}
	}
}
