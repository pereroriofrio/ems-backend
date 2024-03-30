package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.DepartmentRespository;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.jndi.JndiTemplateEditor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentRespository departmentRespository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRespository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()->new ResourceNotFoundException("Department is not exists with id: "+employeeDto.getDepartmentId()));

        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                 ()-> new ResourceNotFoundException("Employee is not exist with the given id : "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(
                (employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exist with the given id : "+employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Department department = departmentRespository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()->new ResourceNotFoundException("Department is not exists with id: "+employeeDto.getDepartmentId()));

        employee.setDepartment(department);
        Employee employeeUpdated =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeUpdated);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with the given id : "+employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
