package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

//    add a method to sort by lastName
//    behind the scenes spring data jpa will do "from Employee order by lastName asc"
    public List<Employee> findAllByOrderByLastNameAsc();
	
}
