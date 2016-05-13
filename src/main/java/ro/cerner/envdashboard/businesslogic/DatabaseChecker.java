package ro.cerner.envdashboard.businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseChecker implements Checker {
	
	private String serverName;
	
	private String databaseName;
	
	private String portNumber;
	
	private String userName;
	
	private String password;
	

	@Override
	public CheckResult check() {
		
		CheckStatus status = CheckStatus.FAILURE;
		
		String url = "jdbc:sqlserver://"+serverName+":" + portNumber + ";databaseName=" + databaseName + ";";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			status = CheckStatus.SUCCESS;
		} catch (SQLException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = CheckStatus.FAILURE;
		} 
		return new CheckResult(status);
	}
	
	public DatabaseChecker(String serverName, String databaseName, String portNumber, String username,
			String password) {
		super();
		this.serverName = serverName;
		this.databaseName = databaseName;
		this.portNumber = portNumber;
		this.userName = username;
		this.password = password;
	}

}
