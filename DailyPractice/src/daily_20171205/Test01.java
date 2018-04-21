package daily_20171205;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {
	public static void main(String[] args) {
		Account account = new Account();
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		for(int i = 0;i<=99;i++){
			service.execute(new AddMoneyThread(account, 1));
		}
		service.shutdown();
		while(!service.isTerminated()){
			
		}
		System.out.println(account.getBalance());
	}
}
