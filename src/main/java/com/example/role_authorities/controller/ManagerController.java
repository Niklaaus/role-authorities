package com.example.role_authorities.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping
    public String getMessage(){
        return "ManagerController:: getMessage()";
    }

    @PostMapping
    public String postMessage(@RequestBody String message){
        return "ManagerController:: postMessage() :: "+ message;
    }
}
