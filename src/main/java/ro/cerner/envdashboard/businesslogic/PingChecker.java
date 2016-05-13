package ro.cerner.envdashboard.businesslogic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingChecker implements Checker {
	
	private String ip;
	
	private String hostname;
	
	public PingChecker(String ip, String hostname) {
		this.ip = ip;
		this.hostname = hostname;
	}

	@Override
	public CheckResult check() {
		
		CheckStatus status = CheckStatus.FAILURE;
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return new CheckResult(status);
	}
	
	public String getIp() {
		return ip;
	}

	public String getHostname() {
		return hostname;
	}


}
