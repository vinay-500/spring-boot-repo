package com.example.MyProjectFinal.rest;

import com.example.MyProjectFinal.dao.EmployeeDao;
import com.example.MyProjectFinal.entity.Employee;
import com.example.MyProjectFinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee find(@PathVariable int id){
        return employeeService.findByid(id);
    }

    @PostMapping("/employee")
    public  Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }`

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Deleted"+ id;
    }

    @PutMapping("/employee")
    public  Employee updateEmployee(@RequestBody Employee employee){

        employeeService.save(employee);
        return employee;
    }


}
