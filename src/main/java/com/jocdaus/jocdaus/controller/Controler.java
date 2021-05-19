/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.controller;

import com.jocdaus.jocdaus.models.Partida;
import com.jocdaus.jocdaus.models.User;
import com.jocdaus.jocdaus.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joan
 */
@RestController
public class Controler {
    
    @Autowired
    private UserRepository userrepo;
    
    @PostMapping(value="/Auth")
    public User isRegister(@RequestBody User user){
        
        return null;
    }
    
    @PostMapping(value="/player")
    public HttpStatus createPlayer(@RequestBody User user){
        //hem de generar la funcio de guardar
        userrepo.save(user);
        return HttpStatus.CREATED;
    }
    
    @PutMapping(value="/player")
    public User modifyUser(@RequestBody User user){
        //modufiquem les dades d'un usuari
        return null;
    }
    
     @GetMapping(value="/players")
    public List<User> getAllPlayers(){
        //tots els usuaris
        
        return userrepo.findAll();
    }
    
    
    @GetMapping(value="/players/{idUser}/games")
    public List<Partida> getListGamesOneplayer(@PathVariable("idUser") int idUser){
        
        //retorna totes les partides d'un jugado
        
        return null;
    }
    
    @DeleteMapping(value="/players/{idUser}/games")
    public void deleteAllGamesOnePlayer(@PathVariable("idUser") int idUser){
        
        //elimina totes les partides d'un jugador
    
    }
    
    @GetMapping(value="/players/rancking")
    public double getListAllGamesRacking(){
        //retorna la mitja de tots el jugadors
        
        return 0;
    }
    @GetMapping(value="/player/rancking/loser")
    public User getListAllGamesRackingLoser(){
        
        //retorna el jugador que te menys punts
        return null;
    }
    
   @GetMapping(value="/player/rancking/winner")
    public User getListAllGamesRackingWinner(){
        
        //retorna totes les partides d'un jugado
        return null;
    }
}
