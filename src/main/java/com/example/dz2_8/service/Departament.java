package com.example.dz2_8.service;

public class Departament extends Employee{
    private double salary;
    private int departament;

    public Departament(String firstName, String lastName, String patronymic, double salary, int departament) {
        super(firstName, lastName, patronymic);
        this.salary = salary;
        this.departament = departament;
    }

    public int getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }
}
