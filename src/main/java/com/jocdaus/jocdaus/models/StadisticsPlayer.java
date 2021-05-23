/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joan
 */
public class StadisticsPlayer implements IStadisticsPlayer{
    private User player;
    private List<Partida> partidasPlayer= new ArrayList<Partida>();
    private double percentatgeExit;
    private double percentatgeFracas;
    private int totalWins;
    private int totalLost;
    private int totalPlays;
    
    public StadisticsPlayer(User player, List<Partida> partidas){
        this.player=player;
        this.partidasPlayer=partidas;
    }
    
    

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLost() {
        return totalLost;
    }

    public void setTotalLost(int totalLost) {
        this.totalLost = totalLost;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    public List<Partida> getPartidasPlayer() {
        return partidasPlayer;
    }

    public void setPartidasPlayer(List<Partida> partidasPlayer) {
        this.partidasPlayer = partidasPlayer;
    }

    public double getPercentatgeExit() {
        return percentatgeExit;
    }

    public void setPercentatgeExit(double percentatgeExit) {
        this.percentatgeExit = percentatgeExit;
    }

    public double getPercentatgeFracas() {
        return percentatgeFracas;
    }

    public void setPercentatgeFracas(double percentatgeFracas) {
        this.percentatgeFracas = percentatgeFracas;
    }
    
    
    
    
    @Override
    public double getpercentatgeWins(List<Partida> partidas) {
        int totalwins=0;
        
        setTotalPlays(partidas.size());
        
        if(getTotalPlays()>0){
            for(Partida p:partidas){
                if(p.isResultat()==true){
                    totalwins++;
                    setTotalWins(totalwins);
                }
            }
                double averga=((getTotalWins()*100)/getTotalPlays());
                setPercentatgeExit(averga);
            return getPercentatgeExit(); 
        }else{
            return 0;
        }
       
    }
    
    @Override
    public double getpercentatgeLost(List<Partida> partidas) {
         int totallost=0;
        
        setTotalPlays(partidas.size());
        
        if(getTotalPlays()>0){
            for(Partida p:partidas){
                if(p.isResultat()==false){
                    totallost++;
                    setTotalLost(totallost);
                }
            }
            double average=((getTotalLost()*100)/getTotalPlays());
            setPercentatgeFracas(average);
           return  getPercentatgeFracas();
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estadistiques del jugador=").append(player.getNom());
        sb.append(", partidasPlayer=").append(getPartidasPlayer().toString());
        sb.append(", percentatge guanyats=").append(getpercentatgeWins(getPartidasPlayer()));
        sb.append(", percentatge perduts=").append(getpercentatgeLost(getPartidasPlayer()));
        sb.append(", Total partides jugadess=").append(getTotalPlays());
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }

    
    
}
