package com.example.MyProjectFinal.dao;

import com.example.MyProjectFinal.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoHibImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibImpl(EntityManager theentityManager) {
        entityManager = theentityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session currentsession = entityManager.unwrap(Session.class);

        Query<Employee> thequery = currentsession.createQuery("from Employee", Employee.class);

        List<Employee> employees = thequery.getResultList();

        return employees;
    }

    @Override
    public Employee findByid(int id) {
        Session currentsession = entityManager.unwrap(Session.class);

        Employee employee = currentsession.get( Employee.class,id);

        return employee;
    }

    @Override
    public void delete(int id) {
        Session currentsession = entityManager.unwrap(Session.class);

        Query<Employee> thequery = currentsession.createQuery("delete from  Employee where id = :empId");
        thequery.setParameter("empId",id);

        thequery.executeUpdate();

    }

    @Override
    public void save(Employee theEmployee) {
        Session currentsession = entityManager.unwrap(Session.class);
        currentsession.saveOrUpdate(theEmployee);
    }
}
