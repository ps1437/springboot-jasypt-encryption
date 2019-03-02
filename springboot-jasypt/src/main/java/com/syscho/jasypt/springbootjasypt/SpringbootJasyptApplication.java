package com.syscho.jasypt.springbootjasypt;

import java.util.Iterator;
import java.util.List;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.syscho.jasypt.springbootjasypt.service.EmployeeService;
import com.syscho.jasypt.springbootjasypt.vo.Employee;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringbootJasyptApplication implements CommandLineRunner {

	@Autowired
	private StringEncryptor stringEncryptor;

	@Autowired
	private EmployeeService service;

	@Value("${pwd}")
	private String pwd;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJasyptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Encrypted password  =>> " + stringEncryptor.encrypt("admin"));
		System.out.println("ADD EMPLOYEE - " + service.addEmployee(new Employee("Jon")));
		List<Employee> employees = service.getEmployees();

		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {

			Employee employee = iterator.next();
			System.out.println("EMP ID: " + employee.getEmpId() + " EMP NAME :" + employee.getEmpName());
		}

	}

}
