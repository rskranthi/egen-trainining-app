package io.egen.app.services;

import java.util.List;

import io.egen.app.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findOne(String empId);

	public Employee create(Employee emp);

	public Employee update(String empId, Employee emp);

	public void remove(String empId);

}
