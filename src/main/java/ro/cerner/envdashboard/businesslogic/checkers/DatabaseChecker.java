package ro.cerner.envdashboard.businesslogic.checkers;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;

public class DatabaseChecker implements Checker {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String serverName;
	
	private String databaseName;
	
	private String portNumber;
	
	private String userName;
	
	private String password;
	
	@Value("${checker.database.name}")
	private String name;
	
	@Override
	public CheckResult check() {
		
		CheckStatus status = CheckStatus.FAILURE;
		
		String message = "";
		
		String url = "jdbc:sqlserver://"+serverName+":" + portNumber + ";databaseName=" + databaseName + ";";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DriverManager.getConnection(url, userName, password);
			status = CheckStatus.SUCCESS;
		} catch (SQLException | ClassNotFoundException e ) {
			message = e.getMessage();
			status = CheckStatus.FAILURE;
		} 
		return new CheckResult(status, message);
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
