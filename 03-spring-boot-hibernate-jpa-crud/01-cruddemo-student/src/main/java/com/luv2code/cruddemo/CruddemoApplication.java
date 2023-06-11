package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students ...");
		int count = studentDAO.deleteAll();

		System.out.println("Total Students deleted: " + count);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		Integer id = 3;
		System.out.println("Deleting student for id: " + id);
		studentDAO.delete(id);

	}

	private void updateStudent(StudentDAO studentDAO) {

//		retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

//		change first name to "Scooby"
		System.out.println("Updating student ...");
		student.setEmail("scooby@luv2code.com");

//		update the student
		studentDAO.update(student);

//		display the updated student
		System.out.println("Updated student: " + student);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

//		get a list of students by last name
		String lastName = "Biral";
		List<Student> students = studentDAO.findByLastName(lastName);

//		display list of students
		for (Student student: students) System.out.println(student);
	}

	private void queryForStudents(StudentDAO studentDAO) {

//		get a list of students
		List<Student> students = studentDAO.findAll();

//		display list of students
		for (Student student: students) System.out.println(student);

	}

	private void readStudent(StudentDAO studentDAO) {

//		create a student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

//		save the student
		System.out.println("Saving the student ...");
		studentDAO.save(student);

//		display id of the saved student
		Integer id = student.getId();
		System.out.println("Saved student: Generated id: " + id);

//		retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + id);
		Student res = studentDAO.findById(id);

//		display the student
		System.out.println("Found the student: " + res);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

//		create 3 Student objects
		System.out.println("Creating 3 Student objects ...");
		Student student1 = new Student("Kali", "Biral", "kali@luv2code.com");
		Student student2 = new Student("Jhuli", "Biral", "jhuli@luv2code.com");
		Student student3 = new Student("Hoppon", "Biral", "hoppon@luv2code.com");

//		save the Student objects
		System.out.println("Saving the Students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student
		System.out.println("Creating new student object ...");
		Student student = new Student("Paul", "Doe", "paul@luv2code.com");

		//save the student
		System.out.println("Saving the Student ...");
		studentDAO.save(student);

		//display id of the saved student
		System.out.println("Saved Student, Generated Id: " + student.getId());

	}

}
