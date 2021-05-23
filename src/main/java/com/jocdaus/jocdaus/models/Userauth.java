/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.models;

import com.jocdaus.jocdaus.rolenum.Roles;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author Joan
 */
public class Userauth extends User{
    private Roles role;
    private String token;
    
    public Userauth(String username, String password){
        super (username, password);
    }
   

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
private String getJWTToken(String username){
    String secretKey="mySecrtKey";
    List<GrantedAuthority> grantedAuthorities=AuthorityUtils
            .commaSeparatedStringToAuthorityList("ROLE_USER");
    
    String token = Jwts
            .builder()
            .setId("softtekJWT")
            .setSubject(username)
            .claim("autorities",
                    grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 600000))
            .signWith(SignatureAlgorithm.HS512,
                    secretKey.getBytes()).compact();
    
    return "Bearer" + token;
}
    
   
}
