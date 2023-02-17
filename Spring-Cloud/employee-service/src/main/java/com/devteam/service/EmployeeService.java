package com.devteam.service;

import com.devteam.dto.APIResponseDto;
import com.devteam.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
