package com.example.MyProjectFinal.service;

import com.example.MyProjectFinal.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findByid(int id);
    public void delete(int id);
    public void save(Employee theEmployee);
}
