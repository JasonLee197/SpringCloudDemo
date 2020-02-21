package com.su.controller;

import com.su.DAO.AdminDAO;
import com.su.DAO.UserDAO;
import com.su.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username,
                         @PathVariable("password") String password,
                         @PathVariable("type") String type){
        Account account = null;
        switch(type){
            case "user" :
                account = userDAO.login(username, password);
                break;
            case "admin":
                account = adminDAO.login(username, password);
                break;
        }
        return account;
    }

}
