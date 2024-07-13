package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDto;
import com.dgmf.entity.Employee;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        // Convert EmployeeDto into Employee Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // Save Employee into MongoDB which Returns Employee of Type Mono
        Mono<Employee> savedEmployee = employeeRepository.save(employee);

        return savedEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }
}
