package com.example.controller;

import com.example.model.visitors;
import com.example.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/visitors_count")
public class UrlHitController {

    @Autowired
    private UrlHitService urlHitService;
    @GetMapping("/user/{user}/count")
    public visitors getCount(@PathVariable String user)
    {
        return urlHitService.getCount(user);
    }
}