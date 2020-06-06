package com.example.mfec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mfec.api.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	

}

