package com.example.dz2_8.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public abstract class DepartamentService extends EmployeeService{
    private final DepartamentService departamentService;

    protected DepartamentService(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }


    public Employee maxSalary(int departament) {
        return departamentService.getAll().stream()
                .filter(employee -> employee.getDepartment() == departament)
                .max(Comparator.comparingDouble(Employee -> Employee.getSalary()))
                .orElseThrow();
    }

}
