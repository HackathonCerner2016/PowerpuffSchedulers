package ro.cerner.envdashboard.businesslogic.checkers;

import org.springframework.beans.factory.annotation.Value;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.Checker;

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
