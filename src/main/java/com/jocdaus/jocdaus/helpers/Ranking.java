/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocdaus.jocdaus.helpers;

import com.jocdaus.jocdaus.models.StadisticsPlayer;
import com.jocdaus.jocdaus.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joan
 */
public class Ranking {
    private List<StadisticsPlayer> listaestadistca;
    private List<User> rankingUsersWiners;
     private List<User> rankingUsersLosters;
     
     
    public Ranking(List<StadisticsPlayer> listaestadistca){
        this.listaestadistca=listaestadistca;
    }

    public List<StadisticsPlayer> getListaestadistca() {
        return listaestadistca;
    }

    public void setListaestadistca(List<StadisticsPlayer> listaestadistca) {
        this.listaestadistca = listaestadistca;
    }


    

    public List<User> getRankingUsersWiners() {
        StadisticsPlayer auxUser;
        List<User> auxList = new ArrayList<User>();

        for (int i = 0; i < listaestadistca.size() - 1; i++) {
            for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                //he de comparar el elemento actual con el siguiente
                if (listaestadistca.get(i).getPercentatgeExit() < listaestadistca.get(j).getPercentatgeExit()) {
                    auxUser = listaestadistca.get(i);
                        this.listaestadistca.set(i, this.listaestadistca.get(j));
                        this.listaestadistca.set(j, auxUser);

                }
            }
        }

        for (StadisticsPlayer sp : listaestadistca) {
            if (sp.getPercentatgeExit() != 0) {
                 auxList.add(sp.getPlayer());
            }
        }

       setRankingUsersLosters(auxList);
        return auxList;
    }

    public void setRankingUsersWiners(List<User> rankingUsersWiners) {
        this.rankingUsersWiners = rankingUsersWiners;
    }

    public List<User> getRankingUsersLosters() {
        StadisticsPlayer auxUser; 
        List<User> auxList = new ArrayList<User>();
        
        if(listaestadistca!=null){
            for (int i = 0; i < listaestadistca.size() - 1; i++) {
                for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                    //he de comparar el elemento actual con el siguiente
                    if (listaestadistca.get(i).getPercentatgeFracas() < listaestadistca.get(j).getPercentatgeFracas()) {
                        auxUser = listaestadistca.get(i);
                        this.listaestadistca.set(i, this.listaestadistca.get(j));
                        this.listaestadistca.set(j, auxUser);
                    }
                }
            }
            setListaestadistca(listaestadistca);
        }
        
       
       for (StadisticsPlayer sp:getListaestadistca()){
           if(sp.getPercentatgeFracas()!=0){
              auxList.add(sp.getPlayer());
           } 
       }
        setRankingUsersLosters(auxList);
        return auxList;
    }
    
    

    public void setRankingUsersLosters(List<User> rankingUsersLosters) {
        this.rankingUsersLosters = rankingUsersLosters;
    }
    
    
}
