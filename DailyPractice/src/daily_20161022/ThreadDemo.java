package daily_20161022;

public class ThreadDemo {

	public static void main(String[] args) {
		Output output = new Output();
		new Thread(){
			@Override
			public void run() {
				for(int i = 0;i<10;i++){
					output.prin1("boluo");
				}
			}
		}.start();;
		
		new Thread( new Runnable() {
			public void run() {
				for(int i = 0;i<10;i++){
					output.prin2("luobo");
				}
			}
		}).start();
		
		
	}
	static class Output{
		private boolean isBoluo = true;
		public synchronized void prin1(String name){
				while (!isBoluo) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int i = 0;i<name.length();i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
				isBoluo = false;
				this.notify();
		}
		public synchronized void prin2(String name){
			while (isBoluo) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i = 0;i<name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
			isBoluo = true;
			this.notify();
	}
 }
}