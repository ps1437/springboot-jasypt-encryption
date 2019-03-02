package com.syscho.jasypt.springbootjasypt.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syscho.jasypt.springbootjasypt.vo.Employee;

@Repository
public interface EmployeeDao  extends CrudRepository<Employee, Integer> {

	public List<Employee> findAll();
}
