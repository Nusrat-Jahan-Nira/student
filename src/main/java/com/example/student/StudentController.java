package com.example.student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

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

    // http://localhost:8080/greeting
    // http://localhost:8080/greeting?name=google
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // http://localhost:8080/greetings
    @GetMapping("/greetings")
    public List<Greeting> getGreetings() {
        List<Greeting> greetings = new ArrayList<>();
        greetings.add(new Greeting(counter.incrementAndGet(), "Fadatare"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Cena"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Jadhav"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Jadhav"));
        greetings.add(new Greeting(counter.incrementAndGet(), "Fadatare"));
        return greetings;
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

    // // @PostMapping("/addStudent")
    // // public String addStudent(@RequestBody String studentName) {
    // // return "Hello, " + studentName;
    // // }

    // List<StudentModel> studentModels = new ArrayList<>();

    // @PostMapping("/create")
    // public String createUser(@RequestBody StudentModel studentModel) {
    // // Logic to create user
    // return "User created successfully!";
    // }

    // @PostMapping("/addStudent")
    // public String addStudent(@RequestBody StudentModel studentName) {
    // // Logic to create user
    // return "User created successfully!";
    // // return "Hello, " + studentName;
    // }
}
