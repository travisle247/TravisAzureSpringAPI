package com.travis.rest.controller;

import com.travis.rest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting sayGreeting(@RequestParam(value="name", defaultValue="Travis") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}