package com.example.MyProjectFinal.dao;

import com.example.MyProjectFinal.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findByid(int id);
    public void delete(int id);
    public void save(Employee theEmployee);
}
