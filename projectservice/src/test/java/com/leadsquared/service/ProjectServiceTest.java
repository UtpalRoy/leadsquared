package com.leadsquared.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.leadsquared.entities.EmployeeEntity;
import com.leadsquared.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {
	
	@InjectMocks
	private ProjectService projectService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testgetAllEmployees() {
		List<EmployeeEntity> employees = new ArrayList<>();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(100L);
		employeeEntity.setEmpCode("E123");
		employeeEntity.setEmpName("TestEmp");
		employees.add(employeeEntity);
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		List<EmployeeEntity> employeeEntities = projectService.getAllEmployees();
		assertTrue(employeeEntities.size()>0);
	}
}
