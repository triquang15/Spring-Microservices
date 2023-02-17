package com.devteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
