package io.egen.app.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Employee;
import io.egen.app.services.EmployeeService;

@RestController
@RequestMapping(value="/employees",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> findAll()
	{
		
		return employeeService.findAll();
	}

	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public Employee findOne(@PathVariable("id") String empId){
		return employeeService.findOne(empId);
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee create(Employee emp){
		return employeeService.create(emp);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee update(@PathVariable("id") String empId,Employee emp){
		return employeeService.update(empId,emp);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void delete(@PathVariable("id") String empId){
		employeeService.remove(empId);
	}
}
