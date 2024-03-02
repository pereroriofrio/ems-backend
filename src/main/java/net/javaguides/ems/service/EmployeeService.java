package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployee(Long employeeId);

    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);

    public void deleteEmployeeById(Long employeeId);
}
