package com.demo.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @GetMapping("/{param}")
    public String demo(@PathVariable String param) {
	return "this is client01:param=" + param;
    }

    @GetMapping("config")
    public String config() {
	return "name=" + name + ",age=" + age;
    }
}
