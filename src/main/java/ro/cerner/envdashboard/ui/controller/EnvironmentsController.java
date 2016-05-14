package ro.cerner.envdashboard.ui.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cerner.envdashboard.persistence.Environment;
import ro.cerner.envdashboard.persistence.EnvironmentDAO;
import ro.cerner.envdashboard.persistence.EnvironmentJDBCTemplate;

@RestController
public class EnvironmentsController {
	
	@RequestMapping("/environments")
	public List<Environment> getEnvironmentsStatus(){
  	    
		EnvironmentDAO environmentDAO = new EnvironmentJDBCTemplate();
		
  	    //get list of environments from db
  	    List<Environment> listOfEnvironments = environmentDAO.getEnvironments();
		
  	    System.out.println("getEnvironmentsStatus " + listOfEnvironments.size());
  	    return listOfEnvironments;
	}
}
