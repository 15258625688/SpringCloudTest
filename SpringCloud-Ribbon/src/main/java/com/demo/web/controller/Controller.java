package com.demo.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/{param}")
    public String demo(@PathVariable String param) {
	return restTemplate.getForObject("http://client/" + param, String.class);
    }
}
