package ro.cerner.envdashboard.businesslogic;

import ro.cerner.envdashboard.businesslogic.checkers.DatabaseChecker;
import ro.cerner.envdashboard.businesslogic.checkers.LoginSchedulingChecker;
import ro.cerner.envdashboard.businesslogic.checkers.PingChecker;

public class Checkers {
	
	private static final String PING = "Ping";
	private static final String DB_CHECKER = "DB checker";
	private static final String SCHEDULING_LOGIN_CHECKER = "Login Scheduling Checker";
	
	public Checker getChecker(String typeName){
		
		switch(typeName){
			case(PING):
						return new PingChecker();
			case(DB_CHECKER):
						return new DatabaseChecker();
			case(SCHEDULING_LOGIN_CHECKER):
						return new LoginSchedulingChecker();
		
		}
		return null;
		
	}

}
