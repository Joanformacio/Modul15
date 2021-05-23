/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.models;

import java.util.List;

/**
 *
 * @author Joan
 */
public interface IStadisticsPlayer {
    double getpercentatgeWins(List<Partida> partidas);
    double getpercentatgeLost(List<Partida> partidas);
    
}
