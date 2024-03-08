package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRespository extends JpaRepository<Department, Long> {
}
