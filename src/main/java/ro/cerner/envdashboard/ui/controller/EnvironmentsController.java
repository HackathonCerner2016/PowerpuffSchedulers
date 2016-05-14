package ro.cerner.envdashboard.ui.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.businesslogic.Environment;
import ro.cerner.envdashboard.businesslogic.checkers.DatabaseChecker;
import ro.cerner.envdashboard.businesslogic.checkers.LoginSchedulingChecker;
import ro.cerner.envdashboard.businesslogic.checkers.PingChecker;

@RestController
public class EnvironmentsController {
	
	@RequestMapping("/environments")
	public List<Environment> getEnvironmentsStatus(){
		
		//final OutputStream jsonOutputStream = new ByteArrayOutputStream();
  	   // final ObjectMapper jacksonMapper = new ObjectMapper();
  	    
  	    //get list of environments from db
  	    List<Environment> listOfEnvironments = new ArrayList<Environment>();
  	    Environment environment = new Environment(1, "SD", "Soarian Development Environment"); 
  	    Checker pingChecker = new PingChecker("usmlvv1srn284", "10.175.125.55");
      //  Checker databaseChecker = new DatabaseChecker("USMLVV1SRN284", "SD_SCHDATA", "1433", "sa", "TEETIME@PEBBLEBEACH23");
        Checker loginSchedulingChecker = new LoginSchedulingChecker("https://usmlvv1srn284.usmlvv1d0a.smshsc.net/sd/scheduling/security/Logon.pba", "test9", "test9");
		
		environment.getCheckersList().add(pingChecker);
		//environment.getCheckersList().add(databaseChecker);
		environment.getCheckersList().add(loginSchedulingChecker);	
		
		listOfEnvironments.add(environment);
		return listOfEnvironments;
		
  	   /* try {
			//jacksonMapper.writeValue(jsonOutputStream, listOfEnvironments);
			return listOfEnvironments;
			
		} catch (IOException e) {
			return listOfEnvironments;
		}*/

	}
}
