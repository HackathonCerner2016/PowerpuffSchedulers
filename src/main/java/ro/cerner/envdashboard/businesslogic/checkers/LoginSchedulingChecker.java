package ro.cerner.envdashboard.businesslogic.checkers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.businesslogic.TrustAllCertificatesManager;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;

public class LoginSchedulingChecker implements Checker {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String url;
	
	private String username;
	
	private String password;
	
	@Value("${checker.login.name}")
	private String name;
	
	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public LoginSchedulingChecker(Integer id) {this.id = id;}
	
	public LoginSchedulingChecker(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public LoginSchedulingChecker() {}

	public LoginSchedulingChecker(CheckerRecord checker) {
		final String urlDb = "URL";
		final String userNameDb = "UserName";
		final String passwordDb = "Password";
		
		this.id = checker.getId();
		
		List<CheckerPropertiesRecord> checkerPropertiesRecordList = checker.getCheckerPropertiesRecordList();
		
		
		for (CheckerPropertiesRecord checkerPropertiesRecord : checkerPropertiesRecordList) {
			switch (checkerPropertiesRecord.getFieldName()) {
			case (urlDb):
				url = checkerPropertiesRecord.getFieldValue();
				break;
			case (userNameDb):
				username = checkerPropertiesRecord.getFieldValue();
				break;
			case (passwordDb):
				password = checkerPropertiesRecord.getFieldValue();
				break;
			}
		}
	}

	@Override
	public CheckResult check() {
		
		CheckStatus status = CheckStatus.FAILURE;
		
		String message = "";
		
		
		TrustManager[] trustAllCerts = new TrustManager[] { new TrustAllCertificatesManager()};

		    SSLContext sc;
			try {
				URL loginURL = new URL(url + "?username=" + username + "&password=" + password);
				
				sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
				
				HttpURLConnection connection = (HttpURLConnection)loginURL.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int code = connection.getResponseCode();
				
				if(code == 200){
					status = CheckStatus.SUCCESS;
				}
			} catch (NoSuchAlgorithmException e) {
				message = e.getMessage();
				status = CheckStatus.FAILURE;
			} catch (KeyManagementException e) {
				message = e.getMessage();
				status = CheckStatus.FAILURE;
			} catch (IOException e) {
				message = e.getMessage();
				status = CheckStatus.FAILURE;
			}
			
		return new CheckResult(status, message, name);
	}

	@Override
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
