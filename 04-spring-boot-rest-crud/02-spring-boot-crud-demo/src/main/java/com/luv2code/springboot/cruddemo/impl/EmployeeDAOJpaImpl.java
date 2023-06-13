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
}
