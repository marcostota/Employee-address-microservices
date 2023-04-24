package com.tota.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tota.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
