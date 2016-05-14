package ro.cerner.envdashboard.businesslogic.checkers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;

public class PingChecker implements Checker {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1922941140357964169L;

	private String ip;
	
	private String hostname;
	
	@Value("${checker.ping.name}")
	private String name;
	
	
	public PingChecker(String ip, String hostname) {
		this.ip = ip;
		this.hostname = hostname;
	}
	
	public PingChecker(String hostname) {
		this.hostname = hostname;
	}
	
	public PingChecker() {}

	@Override
	public CheckResult check() {
		
		CheckStatus status = CheckStatus.FAILURE;
		
		String message = "";
		
		InetAddress inet;

	    try {
			inet = InetAddress.getByAddress(new byte[] { 10, (byte)175, 125, 55 });
		    
			if(inet.isReachable(5000)){
				System.out.println("Host by IP is reacheable!");
				status = CheckStatus.SUCCESS;
			}
			
			inet = InetAddress.getByName(hostname);
			if(inet.isReachable(5000)){
				System.out.println("Host by name is reacheable!");
				status = CheckStatus.SUCCESS;
			}
		} catch (UnknownHostException e) {
			message = e.getMessage();
			status = CheckStatus.FAILURE;
		} catch (IOException e) {
			message = e.getMessage();
			status = CheckStatus.FAILURE;
		}
	    
	    return new CheckResult(status, message);
	}
	
	public String getIp() {
		return ip;
	}

	public String getHostname() {
		return hostname;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


}
