package com.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("getServices")
    public List<String> getServices() {
	List<String> list = discoveryClient.getServices();
	System.out.println(list);
	return list;
    }

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("getApp")
    public Object getApp() {
	Applications apps = eurekaClient.getApplications();
	List<Application> list = apps.getRegisteredApplications();
	for (Application app : list) {
	    System.out.println(app);
	}
	return apps;
    }
}
