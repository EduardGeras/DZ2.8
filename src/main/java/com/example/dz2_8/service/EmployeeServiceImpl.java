package com.example.dz2_8.service;

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

@Override
    public Employee add(String firstName, String lastName, String patronymic) {
        Employee employee = new Employee(firstName, lastName, patronymic);
        String key = getKey(firstName, lastName, patronymic);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        if (employees.size() < limit) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStoragelsFullException("Штат сотрудников полный. Кого увольняем?)");
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

//    public abstract Employee maxSalary(int departament);

/*    @Override
    public Employee add(String firstName, String lastName, String patronymic, double salary, int department) {
        return null;
    }

    @Override
    public Employee delete(String firstName, String lastName, String patronymic, double salary, int department) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, String patronymic, double salary, int department) {
        return null;
    }*/
}
