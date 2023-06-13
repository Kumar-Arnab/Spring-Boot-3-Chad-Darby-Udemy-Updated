package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController  {

    private final EmployeeService employeeService;

//    inject employee dao directly using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

//    add mapping for GET "/employees/{employeeId}"
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

//    add mapping for POST "/employees" - add new employee
    @PostMapping("/employees")
    public Employee addOrUpdateEmployee(@RequestBody Employee employee) {
//        save if employee id is null ... or update if employee id is provided
        Employee resEmployee = employeeService.save(employee);

        return resEmployee;
    }

    @PostMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable("employeeId") int id) {

        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(employee.getId());
    }

}
