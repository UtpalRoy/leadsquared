package com.leadsquared.api;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leadsquared.entities.EmployeeEntity;
import com.leadsquared.exceptions.EmployeeNotFoundException;
import com.leadsquared.service.ProjectService;

@RestController
@RequestMapping(value="/project")
public class EmployeeController {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/getAllEmployees")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
		LOGGER.info("Getting all employee details");
		List<EmployeeEntity> projectEntities = projectService.getAllEmployees();
		if(projectEntities.isEmpty()) {
			return new ResponseEntity<List<EmployeeEntity>>(projectEntities, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeEntity>>(projectEntities, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/employees/{empCode}")  
	public String deleteUser(@PathVariable String empCode) throws EmployeeNotFoundException  
	{  
		if(null == empCode) {
			throw new EmployeeNotFoundException("Emp code can not be empty"); 
		}
		return projectService.deleteEmployee(empCode);  

	} 
}
