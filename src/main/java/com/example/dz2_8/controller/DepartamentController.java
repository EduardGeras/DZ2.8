package com.example.dz2_8.controller;

import com.example.dz2_8.service.DepartamentService;
import com.example.dz2_8.service.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")

public class DepartamentController {


    private DepartamentController departamentService;

    public DepartamentService DepartamentController (DepartamentService departamentService) {
        return departamentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("lastName") String lastName,
                              @RequestParam("firstName") String firstName,
                              @RequestParam("patronymic") String patronymic,
                              @RequestParam("salary") double salary,
                              @RequestParam("departament") int departament) {

        return departamentService.maxSalary(lastName, firstName, patronymic, salary, departament);
    }
}
