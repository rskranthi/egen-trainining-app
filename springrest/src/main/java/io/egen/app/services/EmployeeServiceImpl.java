package io.egen.app.services;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Employee;
import io.egen.app.exception.EntityAlreadyExistsException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Employee findOne(String empId) {
		// TODO Auto-generated method stub
		Employee emp = repository.findOne(empId);
		
		if(emp==null){
			throw new EntityNotFoundException("Employee not found");
		}
		
			return emp;
	}

	@Override
	@Transactional
	public Employee create(Employee emp) {
		// TODO Auto-generated method stub
		Employee existing = repository.findByEmail(emp.getEmail());
		
		if(existing!=null){
			throw new EntityAlreadyExistsException("Employee already exists");
		}
		
			return repository.create(emp);
	}

	@Override
	@Transactional
	public Employee update(String empId, Employee emp) {
		// TODO Auto-generated method stub
		Employee existing = repository.findOne(empId);
		if(existing==null){
			throw new EntityNotFoundException("Employee not found");
		}
		
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void remove(String empId) {
		// TODO Auto-generated method stub

		Employee existing = repository.findOne(empId);
		if(existing==null){
			throw new EntityNotFoundException("Employee not found");
		}
		repository.remove(existing);
	}

}
