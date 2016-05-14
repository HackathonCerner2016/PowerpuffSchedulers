package ro.cerner.envdashboard.businesslogic;

import ro.cerner.envdashboard.businesslogic.checkers.DatabaseChecker;
import ro.cerner.envdashboard.businesslogic.checkers.LoginSchedulingChecker;
import ro.cerner.envdashboard.businesslogic.checkers.PingChecker;
import ro.cerner.envdashboard.businesslogic.checkers.WindowsServiceChecker;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;

public class Checkers {
	
	private static final String PING = "Ping";
	private static final String DB_CHECKER = "DB checker";
	private static final String SCHEDULING_LOGIN_CHECKER = "Login Scheduling Checker";
    private static final String WINDOWS_SERVICE_CHECKER = "Service checker";
	
	public static Checker getChecker(CheckerRecord checker){
		
		String typeName = checker.getCheckerTypeName();
		
		switch(typeName){
			case(PING):
						return new PingChecker(checker);
			case(DB_CHECKER):
						return new DatabaseChecker(checker);
			case(SCHEDULING_LOGIN_CHECKER):
						return new LoginSchedulingChecker(checker);
            case(WINDOWS_SERVICE_CHECKER):
                return new WindowsServiceChecker();		
		}
		return null;
		
	}

}
