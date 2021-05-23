/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.controller;

import com.jocdaus.jocdaus.helpers.Ranking;
import com.jocdaus.jocdaus.models.*;
import com.jocdaus.jocdaus.repository.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author Joan
 */
@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class Controler {
    
    @Autowired
    private UserRepository userrepo;
    
    @Autowired
    private PartiRepository prepository;
    
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
    
    @PutMapping(value="/player/{idusuario}")
    public String modifyUser(@PathVariable("idusuario") int idusuario ,@RequestBody User user){
        //modufiquem les dades d'un usuari
        if ( userrepo.existsById(idusuario)){
            userrepo.save(user);
            return "modificado";
        }else{
            return "No se ha podido modificar el dato";
        }
        
        
    }
    
     @GetMapping(value="/players")
    public String getAllPlayers(){
        //tots els usuaris amb el seu persentatge d'exit
        List<StadisticsPlayer> allPlayersStadistics= new ArrayList<StadisticsPlayer>();
        List<User> allusers= new ArrayList<User>();
        List<Partida> allPartidas= new ArrayList<Partida>();
        
        allusers.addAll(userrepo.findAll());
        for (User u: allusers){
            
            allPartidas=prepository.findPartidasByIdUsuari(u.getId());
            allPlayersStadistics.add(new StadisticsPlayer(u, allPartidas));
        }
        return allPlayersStadistics.toString();
    }
    
    @PostMapping (value="/players/{idusuari}/games")
    public void createPartida(@PathVariable("idusuari") int idusuari, @RequestBody Partida partida){
        //Crea una partida
        
        partida.setIdUsuari(idusuari);
        prepository.save(partida);
    }
   
    
    @GetMapping(value="/player/{idUsuari}/games")
    public List<Partida> getListGamesOneplayer(@PathVariable("idUsuari") int idUsuari){
       //retorna totes les partides d'un jugado
        
        if(userrepo.findById(idUsuari)!=null){
            List<Partida> partidasplayer=prepository.findPartidasByIdUsuari(idUsuari);
              return partidasplayer;
        }else{
            
            return null;
        }
   
        
    }
    
    @DeleteMapping(value="/player/{idUsuari}/games")
    public String deleteAllGamesOnePlayer(@PathVariable("idUsuari") int idUsuari){
        //elimina totes les partides d'un jugador
        if((userrepo.findById(idUsuari)!=null) && (prepository.existsPartidasByIdUsuari(idUsuari))){
            prepository.deletePartidasByIdUsuari(idUsuari);
              return "Eliminado todas las partidas del usuario " + idUsuari;
        }else{
            
            return "El usuario " + idUsuari + ", no tiene partidas asociadas";
        }
        
    
    }
   
    @GetMapping(value="/player/rancking/loser")
    public List<User> getListAllGamesRackingLoser(){
        
        //retorna el jugador que te menys punts
        List<StadisticsPlayer> allPlayersStadistics= new ArrayList<StadisticsPlayer>();
        List<User> allusers= new ArrayList<User>();
        List<Partida> allPartidas= new ArrayList<Partida>();
        
        allusers.addAll(userrepo.findAll());
        for (User u: allusers){
            
            allPartidas=prepository.findPartidasByIdUsuari(u.getId());
            allPlayersStadistics.add(new StadisticsPlayer(u, allPartidas));
        }
        Ranking ranking= new Ranking(allPlayersStadistics);
        
       return ranking.getRankingUsersLosters();
        
    }
    
   @GetMapping(value="/player/rancking/winner")
    public List<User> getListAllGamesRackingWinner(){
         //retorna totes les partides d'un jugado
         
        List<StadisticsPlayer> allPlayersStadistics= new ArrayList<StadisticsPlayer>();
        List<User> allusers= new ArrayList<User>();
        List<Partida> allPartidas= new ArrayList<Partida>();
        
        allusers.addAll(userrepo.findAll());
        for (User u: allusers){
            
            allPartidas=prepository.findPartidasByIdUsuari(u.getId());
            allPlayersStadistics.add(new StadisticsPlayer(u, allPartidas));
        }
        Ranking ranking= new Ranking(allPlayersStadistics);
        
       return ranking.getRankingUsersWiners();
        
    }
}
