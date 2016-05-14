package ro.cerner.envdashboard.businesslogic.checkers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.businesslogic.TrustAllCertificatesManager;
public class LoginSchedulingChecker implements Checker {
	
	private static final long serialVersionUID = 1L;


	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	private String url;
	
	private String username;
	
	private String password;
	
	@Value("${checker.login.name}")
	private String name;
	
	
	public LoginSchedulingChecker(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
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
			
			
		return new CheckResult(status, message);
	}

	@Override
	public String getName() {
		return name;
	}
	
}
