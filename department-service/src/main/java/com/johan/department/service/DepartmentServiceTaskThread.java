package com.johan.department.service;

import com.johan.department.model.Department;

public class DepartmentServiceTaskThread implements Runnable {

    private Department department;
    private DepartmentService departmentService;

    public DepartmentServiceTaskThread(Department department, DepartmentService departmentService) {
        this.department = department;
        this.departmentService = departmentService;
    }

    @Override
    public void run() {

    }

}
