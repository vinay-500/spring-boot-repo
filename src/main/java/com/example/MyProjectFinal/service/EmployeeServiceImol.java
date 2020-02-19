package com.example.MyProjectFinal.service;

import com.example.MyProjectFinal.dao.EmployeeDao;
import com.example.MyProjectFinal.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImol implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImol(EmployeeDao theEmpDao){
        employeeDao = theEmpDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findByid(int id) {
        return employeeDao.findByid(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDao.save(theEmployee);
    }
}
