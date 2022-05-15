package com.leadsquared.service;

import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadsquared.entities.EmployeeEntity;
import com.leadsquared.repo.EmployeeRepository;

@Service
public class ProjectService {
	
	private static final Logger LOGGER = Logger.getLogger(ProjectService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeEntity> getAllEmployees(){
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		return employeeEntities;		
	}
	
	public String deleteEmployee(String empCode) {
		EmployeeEntity employeeEntity = employeeRepository.findByEmpCode(empCode);
		LOGGER.info("Found the employee with given employee code");
		employeeRepository.deleteById(employeeEntity.getId());
		LOGGER.info("Employee with given emp code is deleted successfully" +empCode);
		return empCode;
	}

}
