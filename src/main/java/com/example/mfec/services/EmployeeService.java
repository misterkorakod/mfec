package com.example.mfec.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mfec.api.entities.Content;
import com.example.mfec.api.entities.Employee;
import com.example.mfec.repositories.ContentRepository;
import com.example.mfec.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public List<Employee> saveAllEmployee(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
	}
	public List<Employee> getAllEmployee(){
			return employeeRepository.findAll();
	}
	public Employee getEmployee(Integer id){
		return employeeRepository.findById(id).orElse(null);
	}
	public Employee updateEmployeebysession(Employee employee) {
		Employee exitingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		if(employee.getSession().equals("Login")) {
			exitingEmployee.setEmail(employee.getEmail());
			exitingEmployee.setNickName(employee.getNickName());
			exitingEmployee.setUserName(employee.getUserName());
		}
        return employeeRepository.save(exitingEmployee);
    }
	
	public Employee updateEmployee(Employee employee) {
		Employee exitingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
			exitingEmployee.setEmail(employee.getEmail());
			exitingEmployee.setNickName(employee.getNickName());
			exitingEmployee.setUserName(employee.getUserName());
        return employeeRepository.save(exitingEmployee);
    }
	public String deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		return "User remove::"+id;
	}
	public Employee updateSession(Employee employee) {
		Employee exitingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
		exitingEmployee.setSession(employee.getSession());
        return employeeRepository.save(exitingEmployee);
    }


}
