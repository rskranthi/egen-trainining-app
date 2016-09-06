package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> findAll();

	public Employee findOne(String empId);

	public Employee findByEmail(String email);

	public Employee create(Employee emp);

	public Employee update(Employee emp);

	public void remove(Employee existing);

	

}
