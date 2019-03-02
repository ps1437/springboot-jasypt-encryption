package com.syscho.jasypt.springbootjasypt;

import java.util.Iterator;
import java.util.List;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.syscho.jasypt.springbootjasypt.service.EmployeeService;
import com.syscho.jasypt.springbootjasypt.vo.Employee;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringbootJasyptApplication implements CommandLineRunner {

	@Autowired
	private StringEncryptor stringEncryptor;

	/*
	  //Java Configuration for jasypt Encryption
	  //remove - jasypt.encryptor.bean=encryptorBean ,jasypt.encryptor.algorithm=PBEWithMD5AndDES values from application.properties)
	  
	@Bean(name = "encryptorBean")
	public StringEncryptor stringEncryptor() {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	    config.setAlgorithm("PBEWithMD5AndDES");
	    config.setKeyObtentionIterations("1000");
	    config.setPoolSize("1");
	    config.setProviderName("SunJCE");
	    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
	    config.setStringOutputType("base64");
	    encryptor.setConfig(config);
	    return encryptor;
	}
	*/
	
	@Autowired
	private EmployeeService service;

	@Value("${pwd}")
	private String pwd;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJasyptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("Decrepted pwd :"+ pwd);
		System.out.println("Encrypted password  =>> " + stringEncryptor.encrypt("admin"));
	
        //Testing code	
		System.out.println("ADD EMPLOYEE - " + service.addEmployee(new Employee("Jon")));
		List<Employee> employees = service.getEmployees();

		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			System.out.println("EMP ID: " + employee.getEmpId() + " EMP NAME :" + employee.getEmpName());
		}

	}

}
