package com.example.dz2_8.controller;

import com.example.dz2_8.service.Employee;
import com.example.dz2_8.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")      // добавить сотрудника
    public Employee addEmployee(@RequestParam("lastName") String lastName,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("patronymic") String patronymic,
                                @RequestParam("salary") double salary,
                                @RequestParam("departament") int departament) {
        return employeeService.addEmployee(lastName, firstName, patronymic, salary, departament);
    }
    @GetMapping("/delete")    // удалить сотрудника
    public Employee deleteEmployee(@RequestParam("lastName") String lastName,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("patronymic") String patronymic) {
        return employeeService.deleteEmployee(lastName, firstName, patronymic);
    }
    @GetMapping("/find")      // проверить на наличие сотрудника
    public Employee findEmployee(@RequestParam("lastName") String lastName,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("patronymic") String patronymic) {
        return employeeService.findEmployee(lastName, firstName, patronymic);
    }
    @GetMapping      // список сотрудников
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

}
