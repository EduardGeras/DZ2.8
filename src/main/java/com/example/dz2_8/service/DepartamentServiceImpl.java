package com.example.dz2_8.service;

import com.example.dz2_8.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;


@Service
public class DepartamentServiceImpl implements DepartamentService{
    private final EmployeeServiceImpl employeeService;

    public DepartamentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee maxSalary(int departament) {
        return employeeService.getEmployees()
                .values()
                .stream()
                .filter(e -> e.getDepartament() == departament)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException(""));

    }
/*
    @Override
    public Departament minSalary(String firstName, String lastName, String patronymic, double salary, int departament) {
        return null;
    }

    @Override
    public Departament departmentEmployees(String firstName, String lastName, String patronymic, double salary, int departament) {
        return null;
    }

    @Override
    public Departament allEmployees(String firstName, String lastName, String patronymic, double salary, int departament) {
        return null;
    }

}*/
}
