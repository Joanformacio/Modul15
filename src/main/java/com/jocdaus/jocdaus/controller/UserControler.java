/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.controller;

import com.jocdaus.jocdaus.models.Userauth;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joan
 */
@RestController
public class UserControler {
    @PostMapping("user")
    public User Login (@RequestParam("user") String username, @RequestParam("password") String pwd){
     /*  String token = getJWTToken(username);
        Userauth user= new Userauth();
        user.setUserth(username);
        user.setToken(token);*/
        
        return null;
    }
}
