package ro.cerner.envdashboard.businesslogic;

import org.springframework.beans.factory.annotation.Value;

public class WindowsServiceChecker implements Checker {

	@Value("${checkers.windowsService.name}")
	private String name;
	
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public CheckResult check() {
		// TODO Auto-generated method stub
		return null;
	}

}
