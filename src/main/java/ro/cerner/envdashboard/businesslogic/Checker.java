package ro.cerner.envdashboard.businesslogic;

import java.io.Serializable;

public interface Checker extends Serializable{
	
	String getName();
	
	Integer getId();
	
    CheckResult check();
    
    
}
