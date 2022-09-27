package com.johan.department.controller;

import com.johan.department.model.Department;
import com.johan.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.sql.Time;
import java.util.concurrent.*;

@RestController
@AllArgsConstructor
@Slf4j
public class DepartmentController {

    private DepartmentService service;

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        log.info("Execute save department method - " + department);
        Department responseDepartment = service.saveDepartment(department);
        return new ResponseEntity<>(responseDepartment, HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Execute find department by id method - " + departmentId);
        return new ResponseEntity<>(service.findDepartmentById(departmentId), HttpStatus.OK);
    }

}
