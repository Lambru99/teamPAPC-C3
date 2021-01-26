package it.cs.unicam.ids.c3.controller;

import it.cs.unicam.ids.c3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginRestController {
    @Autowired
    private LoginService loginService;

    public LoginRestController() {
    }

    @GetMapping
    public long isCorrect(@RequestParam String type,@RequestParam String email,@RequestParam String password){
        return this.loginService.getUserId(type,email,password);
    }
}