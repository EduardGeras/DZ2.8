package com.example.dz2_8.service;

import com.example.dz2_8.exception.EmployeeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.example.dz2_8.exception.EmployeeAlreadyAddedException;
import com.example.dz2_8.exception.EmployeeNotFoundException;
import com.example.dz2_8.exception.EmployeeStoragelsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static final int limit = 10;
    public static Map<String, Employee> employees = new HashMap<>();
    public static Map<String, Employee> getEmployees() {
        return employees;
    }
@Override
    public Employee add(String firstName, String lastName, String patronymic, double salary, int department) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName) && StringUtils.isAlpha(patronymic)) {
            Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), StringUtils.capitalize(patronymic), salary, department);
            String key = getKey(firstName, lastName, patronymic);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
            if (employees.size() < limit) {
                employees.put(key, employee);
                return employee;
            }
            throw new EmployeeStoragelsFullException("Штат сотрудников полный. Кого увольняем?)");
        }
        throw new EmployeeException();
    }
    @Override
    public Employee delete(String firstName, String lastName, String patronymic) {
        String key = getKey(firstName, lastName, patronymic);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в организации");
        }
        return employees.remove(key);
    }
@Override
    public Employee find(String firstName, String lastName, String patronymic) {
        String key = getKey(firstName, lastName, patronymic);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в организации");
        }
        return employees.get(key);
    }
    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
    private String getKey(String firstName, String lastName, String patronymic) {
        return firstName + " " + lastName + " " + patronymic;
    }
}
