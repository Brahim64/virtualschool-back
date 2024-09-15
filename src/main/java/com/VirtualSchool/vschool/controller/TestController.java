package com.VirtualSchool.vschool.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/all")
    public String all() {
        return "{ \"token\": 1}";
    }
    @GetMapping(value = "/test")
    public String test() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping(value = "/student")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String student() {
        return "{\"For\": \"Student\"}";
    }
    @GetMapping(value = "/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "For Admin";
    }
}
