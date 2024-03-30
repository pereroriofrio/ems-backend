package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.impl.DepartmentServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    DepartmentServiceImpl departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto deparmentDto){
       DepartmentDto department =  departmentService.createDepartment(deparmentDto);
       return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartment(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtoList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentDtoList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartment= departmentService.updateDapartment(departmentId, departmentDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("The department was deleted successfully!");
    }
}
