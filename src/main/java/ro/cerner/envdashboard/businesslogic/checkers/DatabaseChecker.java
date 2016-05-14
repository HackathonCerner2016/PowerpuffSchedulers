package ro.cerner.envdashboard.businesslogic.checkers;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;

public class DatabaseChecker implements Checker {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String serverName;
	
	private String databaseName;
	
	private String portNumber;
	
	private String userName;
	
	private String password;
	
	@Value("${checker.database.name}")
	private String name;
	
	public DatabaseChecker(Integer id) {this.id = id;}
	
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
		return new CheckResult(status, message, name);
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
	
	public DatabaseChecker() {}

	public DatabaseChecker(CheckerRecord checker) {
		final String serverNameDb = "ServerName";
		final String databaseNameDb = "DatabaseName";
		final String portNumberDb = "PortNumber";
		final String userNameDb = "UserName";
		final String passwordDb = "Password";
		
		this.id = checker.getId();
		
		List<CheckerPropertiesRecord> checkerPropertiesRecordList = checker.getCheckerPropertiesRecordList();
		
		
		for (CheckerPropertiesRecord checkerPropertiesRecord : checkerPropertiesRecordList) {
			switch (checkerPropertiesRecord.getFieldName()) {
			case (serverNameDb):
				serverName = checkerPropertiesRecord.getFieldValue();
				break;
			case (databaseNameDb):
				databaseName = checkerPropertiesRecord.getFieldValue();
				break;
			case (portNumberDb):
				portNumber = checkerPropertiesRecord.getFieldValue();
				break;
			case (userNameDb):
				userName = checkerPropertiesRecord.getFieldValue();
				break;
			case (passwordDb):
				password = checkerPropertiesRecord.getFieldValue();
				break;
			}
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
