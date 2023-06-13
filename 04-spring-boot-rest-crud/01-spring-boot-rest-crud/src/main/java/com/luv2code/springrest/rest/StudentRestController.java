package com.luv2code.springrest.rest;

import com.luv2code.springrest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

//    define @PostConstruct to load the student data ... only once
    @PostConstruct
    public void populateStudents() {

        students = new ArrayList<>();

        students.add(new Student("Kali", "Biral"));
        students.add(new Student("Jhuli", "Biral"));
        students.add(new Student("Hoppon", "Biral"));
        students.add(new Student("Chutki", "Biral"));

    }

//    define endpoint for "/students" - returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

//    define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int id) {

//        just index into the list ... keeping it simple for now

//        check the studentId again list size
        if ((id >= students.size()) || (id < 0)) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        return students.get(id);

    }

}
