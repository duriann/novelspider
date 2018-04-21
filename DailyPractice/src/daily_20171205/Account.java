package daily_20171205;

public class Account {
	private double balance;//账户余额s
	
	public  void depost(double money){
		double newBalance = balance+money;
		try {
			Thread.sleep(10);//模拟存钱需要一点时间
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance = newBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
}
