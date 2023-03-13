package com.employee.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeManagement.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>{

}
