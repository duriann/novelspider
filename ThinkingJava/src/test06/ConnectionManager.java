package test06;

class ConnectionManager {
	
	
	private ConnectionManager(){}
	private static ConnectionManager connectionManager = new ConnectionManager();;
	
	public ConnectionManager getConnectionManager(){
		System.out.println("getConnetionManager");
		return connectionManager;
	}
}
