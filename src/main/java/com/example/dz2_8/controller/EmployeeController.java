package com.example.dz2_8.controller;

import com.example.dz2_8.service.Employee;
import com.example.dz2_8.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")      // добавить сотрудника
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("patronymic") String patronymic) {
        return employeeService.add(lastName, firstName, patronymic);
    }
    @GetMapping("/delete")    // удалить сотрудника
    public Employee deleteEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("patronymic") String patronymic) {
        return employeeService.delete(lastName, firstName, patronymic);
    }
    @GetMapping("/find")      // проверить на наличие сотрудника
    public Employee findEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("patronymic") String patronymic) {
        return employeeService.find(lastName, firstName, patronymic);
    }
    @GetMapping      // список сотрудников
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

}
