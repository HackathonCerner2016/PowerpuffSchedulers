package ro.cerner.envdashboard.businesslogic.checkers;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.CheckStatus;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;

public class PingChecker implements Checker {
	
	private static final long serialVersionUID = -1922941140357964169L;
	
	private Integer id;

	private String ipHostname;
	
	@Value("${checker.ping.name}")
	private String name;
	
	
	public PingChecker( String ipHostname) {
		this.ipHostname = ipHostname;
	}
	
	public PingChecker() {}
	
	public PingChecker(Integer id) {this.id = id;}

	public PingChecker(CheckerRecord checker) {
		
		String ipHostName = "IPHostName";
		
		this.id = checker.getId();
		
		List<CheckerPropertiesRecord> checkerPropertiesRecordList = checker.getCheckerPropertiesRecordList();
		
		
		for (CheckerPropertiesRecord checkerPropertiesRecord : checkerPropertiesRecordList) {
			if(ipHostName.equals(checkerPropertiesRecord.getFieldName())){
				ipHostname = checkerPropertiesRecord.getFieldValue();
			}
		}
	}

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
			
			inet = InetAddress.getByName(ipHostname);
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
	    
	    return new CheckResult(status, message, name);
	}
	
	public String getIpHostname() {
		return ipHostname;
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
