package com.example.dz2_8.controller;

import com.example.dz2_8.service.DepartamentService;
import com.example.dz2_8.service.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departaments")

public class DepartamentController {


    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam ("departament") int department) {
        return departamentService.maxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam ("departament") int department) {
        return departamentService.minSalary(department);
    }
    @GetMapping(value = "/all", params = "departament")
    public List <Employee> departmentEmployees(@RequestParam ("departament") int department) {
        return departamentService.departmentEmployees(department);
    }
    @GetMapping("/all")
    public List <Employee> allEmployees() {
        return departamentService.allEmployees();
    }
}
