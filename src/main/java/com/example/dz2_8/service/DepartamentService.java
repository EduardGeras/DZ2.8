package com.example.dz2_8.service;

import java.util.List;

public interface DepartamentService {

    Employee maxSalary(int departament);

    Employee minSalary(int departament);
    List <Employee> departmentEmployees(int departament);
    List <Employee> allEmployees();
}