package com.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/{param}")
    public String demo(@PathVariable String param) {
	return "this is client02:param=" + param;
    }

}
