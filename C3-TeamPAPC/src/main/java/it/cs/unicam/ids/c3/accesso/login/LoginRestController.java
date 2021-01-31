package it.cs.unicam.ids.c3.accesso.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller rest del Log In
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginRestController {
    @Autowired
    private LoginServiceInterface loginService;

    public LoginRestController() {
    }

    /**
     * Controlla se il login effettuato è corretto
     * @param type commerciante, corriere o cliente
     * @param email
     * @param password
     * @return id dell'attore
     */
    @GetMapping
    public long isCorrect(@RequestParam String type,@RequestParam String email,@RequestParam String password){
        return this.loginService.getUserId(type,email,password);
    }
}