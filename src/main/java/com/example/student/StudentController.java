package com.example.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    // http://localhost:8080/student
    @GetMapping("/student")
    public StudentModel getStudent() {
        return new StudentModel("Abdul");
    }

    // http://localhost:8080/student/abc
    @GetMapping("/student/{name}")
    public StudentModel getStudent(@PathVariable("name") String name) {
        // in this method we can return
        // the student which we get from the api call.
        return new StudentModel(name);
    }

    // http://localhost:8080/students/Ramesh/Fadatare/
    // @PathVariable annotation
    @GetMapping("/students/{firstName}/{lastName}/")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {

        return new Student(firstName, lastName);
    }

    // http://localhost:8080/student/query?firstName=Ramesh&lastName=Fadatare
    @GetMapping("/student/abcd")
    public Student studentQueryParam(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    private List<Student> students = new ArrayList<>();

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Hello, " + student.getFirstName() + student.getLastName();
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return students;
    }

    @DeleteMapping("/deleteStudent/{name}")
    public String deleteStudent(@PathVariable String name) {
        for (Student student : students) {
            if (student.getFirstName().equals(name)) {
                students.remove(student);
                return "Student Deleted: " + name;
            }
        }
        return "Student not found";
    }

}
