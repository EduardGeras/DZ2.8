package com.example.dz2_8.controller;

import com.example.dz2_8.service.Departament;
import com.example.dz2_8.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")

public class DepartamentController {


    private final DepartamentController departamentServiceImpl;

    public DepartamentController(DepartamentController departamentServiceImpl) {
        this.departamentServiceImpl = departamentServiceImpl;
    }


    @GetMapping("/max-salary")
    public Departament maxSalary(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("patronymic") String patronymic,
                                 @RequestParam("salary") double salary,
                                 @RequestParam("departament") int departament) {

        return departamentServiceImpl.maxSalary(lastName, firstName, patronymic, salary, departament);
    }
}
