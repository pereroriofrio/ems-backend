package net.javaguides.ems.service;

import net.javaguides.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDapartment(Long departmentId, DepartmentDto departmentDto);

    void deleteDepartment(Long departmentId);
}
