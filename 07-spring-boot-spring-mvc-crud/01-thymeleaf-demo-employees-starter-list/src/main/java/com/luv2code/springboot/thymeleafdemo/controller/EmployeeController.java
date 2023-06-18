package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> employees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

//		create model attribute to bind the form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

//		save the employee
		employeeService.save(employee);

//		use a redirect to prevent duplicate submission
		return "redirect:/employees/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

//		get the employee from the service
		Employee employee = employeeService.findById(id);

//		set employee in the model to prepopulate the form
		model.addAttribute("employee", employee);

//		send over to our form
		return "employees/employee-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {

//		delete the employee
		employeeService.deleteById(id);

//		redirect to the /employees/list
		return "redirect:/employees/list";

	}

}









