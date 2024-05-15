package com.example.student;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

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

    private List<Greeting> greetings = new ArrayList<>();

    @PostMapping("/greetings")
    public String addGreetings(@RequestBody Greeting greeting) {
        greetings.add(greeting);
        return "Hello, " + greeting.getName();
    }

    @GetMapping("/getGreetings")
    public List<Greeting> getAllGreetings() {
        return greetings;
    }

}
