package com.example.role_authorities.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String getMessage(){
        return "AdminController:: getMessage()";
    }

    @PostMapping
    public String postMessage(@RequestBody String message){
        return "AdminController:: postMessage() :: "+ message;
    }
}
