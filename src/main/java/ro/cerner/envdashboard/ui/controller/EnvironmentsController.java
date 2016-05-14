package ro.cerner.envdashboard.ui.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cerner.envdashboard.persistence.dao.EnvironmentDAO;
import ro.cerner.envdashboard.persistence.jdbc.EnvironmentJDBCTemplate;
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
		
  	    //get list of checkers from db
  	    //List<Checker> listOfEnvironments = environmentDAO.
		
  	    //System.out.println("getEnvironmentsStatus " + listOfEnvironments.size());
  	    return null; 
	}
}
