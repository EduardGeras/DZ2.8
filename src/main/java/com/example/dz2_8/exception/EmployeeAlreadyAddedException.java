package com.example.dz2_8.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String s) {
        super(s);
    }
}
