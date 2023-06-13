package com.luv2code.springboot.cruddemo.impl;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

//    find field for entitymanager
    private final EntityManager entityManager;

//    set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
//        create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

//        return the query list
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

//        get employee
        Employee employee = entityManager.find(Employee.class, id);

//        return employee
        return employee;

    }

    @Override
    public Employee save(Employee employee) {

//        save or update employee
        Employee dbEmployee = entityManager.merge(employee);

//        return the saved employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

//        find the employee by id
        Employee employee = entityManager.find(Employee.class, id);

//        remove employee
        entityManager.remove(employee);
    }
}
