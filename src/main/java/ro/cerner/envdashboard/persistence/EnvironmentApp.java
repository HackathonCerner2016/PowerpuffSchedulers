package ro.cerner.envdashboard.persistence;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.cerner.envdashboard.persistence.jdbc.EnvironmentJDBCTemplate;
import ro.cerner.envdashboard.persistence.mapper.CheckerPropertiesRecord;
import ro.cerner.envdashboard.persistence.mapper.CheckerRecord;
import ro.cerner.envdashboard.persistence.model.Environment;

public class EnvironmentApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		EnvironmentJDBCTemplate environmentJDBCTemplate = (EnvironmentJDBCTemplate) context.getBean("EnvironmentJDBCTemplate");

		System.out.println("------Listing Multiple Records--------");
		List<Environment> environments = environmentJDBCTemplate.getEnvironments();
		for (Environment environment : environments) {
			System.out.println("ID : " + environment.getId());
			System.out.println("Name : " + environment.getName());
			System.out.println("Description : " + environment.getDescription());
			System.out.println("LastChecked : " + environment.getLastChecked());
			System.out.println("Status : " + environment.getStatus());
		}
		
		List<CheckerRecord> records = environmentJDBCTemplate.getCheckersByEnvironmentId(3);
		for (CheckerRecord checkerRecord : records) {
			// TO FIX CAPTION IN SP3 HF4
			// STORY ESTIMATION: 4IPDs
			System.out.println("----------------------------------------------------------------");
			System.out.println("ID : " + checkerRecord.getId());
			System.out.println("Type ID : " + checkerRecord.getCheckerTypeId());
			System.out.println("Type Name : " + checkerRecord.getCheckerTypeName());
			System.out.println("ENV ID : " + checkerRecord.getEnvironmentId());
			System.out.println("Machine ID : " + checkerRecord.getMachineId());
			System.out.println("Details---------------------");
			List<CheckerPropertiesRecord> properties = checkerRecord.getCheckerPropertiesRecordList();
			for (CheckerPropertiesRecord checkerPropertiesRecord : properties) {
				System.out.println("CheckerDetailsID : " + checkerPropertiesRecord.getId());
				System.out.println("FieldName : " + checkerPropertiesRecord.getFieldName());
				System.out.println("FieldValue : " + checkerPropertiesRecord.getFieldValue());
				System.out.println("Position : " + checkerPropertiesRecord.getPosition());
			}
		}
		
		environmentJDBCTemplate.updateEnvironmentStatus(1, false);
	}
}
