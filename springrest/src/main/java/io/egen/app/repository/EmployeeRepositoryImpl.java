package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.egen.app.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findOne(String empId) {
		// TODO Auto-generated method stub
		return em.find(Employee.class, empId);
	}

	@Override
	public Employee findByEmail(String email) {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail",Employee.class);
		query.setParameter("pMail",email);
		
		List<Employee> employees = query.getResultList();
		
		if(employees.size()==1)
		{
			return employees.get(0);
		}
		else
			return null;
		
	}

	@Override
	public Employee create(Employee emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
		
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		em.merge(emp);
		return emp;
	}

	@Override
	public void remove(Employee existing) {
		// TODO Auto-generated method stub
		em.remove(existing);
	}

}
