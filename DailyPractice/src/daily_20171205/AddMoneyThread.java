package daily_20171205;

public class AddMoneyThread implements Runnable {

	private Account account;
	private double money;//存入金额
	
	public AddMoneyThread(Account account,double money) {
		this.account = account;
		this.money = money;
	}
	@Override
	public void run() {
		synchronized (account) {
			account.depost(money);
		}
		
	}

}
