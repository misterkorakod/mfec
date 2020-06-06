package com.example.mfec.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mfec.api.entities.Content;
import com.example.mfec.api.entities.Employee;
import com.example.mfec.repositories.ContentRepository;
import com.example.mfec.repositories.EmployeeRepository;
import com.example.mfec.services.EmployeeService;

@RestController
public class UserController {
	@Autowired
	EmployeeService employeeRepository ;

///////////////////////////////////////Employee///////////////////////////////////////
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}
	@PostMapping("/addallEmployee")
	public List<Employee> addAllEmployee(@RequestBody List<Employee> employee) {
		return employeeRepository.saveAllEmployee(employee);
	}
	@PostMapping("/showallemployee")
	public List<Employee> findAllEmployee() {
		return employeeRepository.getAllEmployee();
	}
	@PostMapping("/showemployeeById/{id}")
	public Employee findAllEmployee(@PathVariable Integer id) {
		return employeeRepository.getEmployee(id);
	}
	@PutMapping("/update")
	public void updateEmployees(@RequestBody Employee employee) {
		
		employeeRepository.updateEmployee(employee);
	}
	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployeebyid(@PathVariable Integer id) {
		return employeeRepository.deleteEmployee(id);
	}
	
//	@RequestMapping(value = "/deleteEmployee/{id}",method=RequestMethod.DELETE)
//	public void deleteEmployee(@PathVariable Integer id) {
//		List<Employee> employeeList = employeeRepository.getAllEmployee();
//	    for(int i = 0; i < employeeList.size(); i++) {
//	        if(employeeList.get(i).getId().equals(id)) {
//	        	employeeList.remove(i);
//	            break;
//	        }
//	    }
//	}
	
	
}
