package com.travis.rest.controller;

import com.travis.rest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class DefaultController {
    private static final String template = "Welcome to my world, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("")
    public Greeting sayGreeting(@RequestParam(value="name", defaultValue="TravisFantasy") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
