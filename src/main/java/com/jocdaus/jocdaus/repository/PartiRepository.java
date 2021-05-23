/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.repository;

import com.jocdaus.jocdaus.models.Partida;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Joan
 */
public interface PartiRepository extends MongoRepository<Partida, Integer>{
    //List<Partida> findByIdusuariAndfindByResultat(int idusuari, boolean resultat);
    List<Partida> findPartidasByIdUsuari( int idUsuario);
    boolean existsPartidasByIdUsuari(int idUsuario);
    int deletePartidasByIdUsuari( int idUsuario);
}
