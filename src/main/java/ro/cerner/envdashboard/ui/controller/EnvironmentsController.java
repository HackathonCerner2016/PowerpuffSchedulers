package ro.cerner.envdashboard.ui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cerner.envdashboard.businesslogic.CheckResult;
import ro.cerner.envdashboard.businesslogic.Checker;
import ro.cerner.envdashboard.businesslogic.Checkers;
import ro.cerner.envdashboard.persistence.dao.EnvironmentDAO;
import ro.cerner.envdashboard.persistence.jdbc.EnvironmentJDBCTemplate;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;
import ro.cerner.envdashboard.persistence.model.Environment;

@RestController
public class EnvironmentsController {
	
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	EnvironmentDAO environmentDAO = (EnvironmentJDBCTemplate) context.getBean("EnvironmentJDBCTemplate");
	
	
	@RequestMapping("/environments")
	public List<Environment> getEnvironmentsStatus(){
  	    
		
  	    //get list of environments from db
  	    List<Environment> listOfEnvironments = environmentDAO.getEnvironments();
		
  	    System.out.println("getEnvironmentsStatus " + listOfEnvironments.size());
  	    return listOfEnvironments; 
	}
	
	@RequestMapping("/environmentCheckers")
	public List<Environment> getEnvironmentCheckersStatus(){
  	    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		 EnvironmentDAO environmentDAO = (EnvironmentJDBCTemplate) context.getBean("EnvironmentJDBCTemplate");
		 
		 Map<Integer, CheckResult> envCheckerStatus = new HashMap<Integer, CheckResult>();
		
    	//get list of environments from db
  	    List<ro.cerner.envdashboard.persistence.model.Environment> listOfEnvironments = environmentDAO.getEnvironments();
  	    
  	    //call execute env checkers for each of them
		for (ro.cerner.envdashboard.persistence.model.Environment environment : listOfEnvironments) {
			List<CheckerRecord> envCheckersList = environmentDAO.getCheckersByEnvironmentId(environment.getId());
			
			for (CheckerRecord checkerRecord : envCheckersList) {
				Checker checker = Checkers.getChecker(checkerRecord);
				
				CheckResult result = checker.check();
				
				envCheckerStatus.put(checker.getId(), result);
				
			}
		}
  	    return null; 
	}
}
