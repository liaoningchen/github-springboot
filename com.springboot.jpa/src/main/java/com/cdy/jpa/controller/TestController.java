package com.cdy.jpa.controller;

import com.cdy.jpa.entity.Test;
import com.cdy.jpa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/test/{id}")
    public Test getUser(@PathVariable("id") Integer id){
        Optional<Test> test = testRepository.findById(id);
        return test.get();
    }
}
