package com.employee.EmployeeManagement.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.service.EmployeeService;

//
//@CrossOrigin(origins="http://localhost:3001")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	
  @GetMapping("/")	
  public String getAllEmployees(Model model){
	  List<Employee> allEmployees=employeeservice.getAllEmployees();
	  model.addAttribute("employees",allEmployees);
	  return "list_employees.html";
//	  return allEmployees;
  }
  @GetMapping("/add")
  public String addEmployee(Model model) {
	  Employee employee=new Employee();
	  model.addAttribute("employee",employee);
	  return "addemployeeform";
  }
  @PostMapping(path="/saveEmployee",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
  public String saveEmployee(Employee employee) {
	  System.out.println(employee.getId());
	employeeservice.saveEmployee(employee);
	  return "redirect:/";

  }
  
  @PostMapping(path="/updateEmployee",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
  public String updateEmployee(Employee employee) {
	 System.out.println(employee.getId());
	employeeservice.updateEmployee(employee);
	  return "redirect:/";

  }

  @GetMapping("/showUpdateForm/{id}")
  public String updateEmployee(@PathVariable("id") long id,Model model) {
	  model.addAttribute("employee",employeeservice.getEmployeeById(id));
	  return "updateemployeeform";
  }
  
  @GetMapping("/deleteEmployee/{id}")
  public String deleteEmployee(@PathVariable("id") long id) {
	  employeeservice.deleteEmployeeById(id);
	  return "redirect:/";
  }
}
