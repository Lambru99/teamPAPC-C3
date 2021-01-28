package it.cs.unicam.ids.c3.service;

import org.springframework.stereotype.Service;

@Service
@FunctionalInterface
public interface LoginServiceInterface {
    long getUserId(String userType, String email, String password);
}
