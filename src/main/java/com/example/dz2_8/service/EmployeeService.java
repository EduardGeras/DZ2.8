package com.example.dz2_8.service;

public interface EmployeeService {

    Employee add(String firstName, String lastName, String patronymic, double salary, int department);

    Employee delete(String firstName, String lastName, String patronymic);
    Employee find(String firstName, String lastName, String patronymic);

}
