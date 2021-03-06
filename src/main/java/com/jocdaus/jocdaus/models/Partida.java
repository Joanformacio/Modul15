/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author Joan
 */
@Document(collection="partidas")
public class Partida {
   
    @Id
    private int id;
    @Field(name= "dau1")
    private int dau1;
    
    @Field(name= "dau2")
    private int dau2;
    
    @Field(name="resultat")
    private boolean resultat;
    
    @Field(name="idusuari")
    private int idUsuari;
    
    public Partida(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDau1() {
        return dau1;
    }

    public void setDau1(int dau1) {
        this.dau1 = dau1;
    }

    public int getDau2() {
        return dau2;
    }

    public void setDau2(int dau2) {
        this.dau2 = dau2;
    }

    public boolean isResultat() {
        return resultat;
    }

    public void setResultat(boolean resultat) {
        this.resultat = resultat;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Partida{id=").append(id);
        sb.append(", dau1=").append(dau1);
        sb.append(", dau2=").append(dau2);
        sb.append(", resultat=").append(resultat);
        sb.append('}');
        return sb.toString();
    }
    
    
}
