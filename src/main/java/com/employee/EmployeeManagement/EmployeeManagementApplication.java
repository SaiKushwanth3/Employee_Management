package com.employee.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication{

//	@Autowired
//	private EmployeeRepository employeerepo;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
//	@Override
//	public void run(String... arg) {
//		employeerepo.save(new Employee("Kushwanth","Vaddi","kushwanthvaddi3@gmail.com"));
//		employeerepo.save(new Employee("Srinivas","Palakula","srinupj6@gmail.com"));
//		employeerepo.save(new Employee("Rohith","Gudla","rohithgudla21@gmail.com"));
//	}

}
