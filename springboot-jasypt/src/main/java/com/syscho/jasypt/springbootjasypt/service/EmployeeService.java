package com.syscho.jasypt.springbootjasypt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syscho.jasypt.springbootjasypt.dao.EmployeeDao;
import com.syscho.jasypt.springbootjasypt.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee addEmployee(Employee emp) {
		return dao.save(emp);
	}

	public List<Employee> getEmployees() {
		return dao.findAll();
	}

}
