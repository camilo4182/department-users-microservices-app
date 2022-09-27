package com.johan.department.service;

import com.johan.department.model.Department;
import com.johan.department.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository repository;

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        return repository.findById(departmentId).orElse(new Department());
    }
}
