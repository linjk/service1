package com.test.service1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/test")
public class RestTest {
    @Autowired private RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello() {
        return "#service1# Hello: " + UUID.randomUUID().toString();
    }

    @GetMapping("toService2")
    public String reqService2() {
        return restTemplate.getForObject("http://service2:3398/test/hello", String.class);
    }
}
