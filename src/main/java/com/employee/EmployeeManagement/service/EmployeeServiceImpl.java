package com.employee.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;
	
	@Override
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeerepo.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		employeerepo.save(employee);
	}
	
	
	@Override
	public void updateEmployee(Employee employee) {
		 Employee ue=getEmployeeById(employee.getId());
		 System.out.println(employee.getId());
		  ue.setEmail(employee.getEmail());
		  ue.setFirstname(employee.getFirstname());
		  ue.setLastname(employee.getLastname());
		  employeerepo.save(ue);
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> emp=employeerepo.findById(id);
		Employee emp2=emp.orElse(null);
		return emp2;
		
	}
	@Override
	public void deleteEmployeeById(long id) {
		employeerepo.deleteById(id);
	}
}
