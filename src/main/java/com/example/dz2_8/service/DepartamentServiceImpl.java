package com.example.dz2_8.service;

public class DepartamentServiceImpl implements DepartamentService{
    private final EmployeeService employeeService;

    public DepartamentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Departament maxSalary(String firstName, String lastName, String patronymic, double salary, int departament) {
        return null;
    }

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
}
