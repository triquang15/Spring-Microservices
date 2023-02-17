package com.devteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devteam.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
