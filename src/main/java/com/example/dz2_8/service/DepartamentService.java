package com.example.dz2_8.service;

public interface DepartamentService {
    Departament maxSalary(String firstName, String lastName, String patronymic, double salary, int departament);
    Departament minSalary(String firstName, String lastName, String patronymic, double salary, int departament);
    Departament departmentEmployees(String firstName, String lastName, String patronymic, double salary, int departament);
    Departament allEmployees(String firstName, String lastName, String patronymic, double salary, int departament);
}