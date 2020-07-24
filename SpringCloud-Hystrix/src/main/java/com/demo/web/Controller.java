package com.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Controller {

    @SuppressWarnings("unused")
    @GetMapping("/{param}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String demo(@PathVariable String param) {
	int n = 1 / 0;
	return param + ":success";
    }

    public String fallbackMethod(String param) {
	return param + ":error";
    }
}
