package org.bkkimutai.models;

import org.bkkimutai.Config.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class HeroWithSquad {
    private int heroId;
    private String heroName;
    private int squadId;
    private String squadName; // Include squadName in HeroWithSquad

    public HeroWithSquad(int heroId, String heroName, int squadId, String squadName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.squadId = squadId;
        this.squadName = squadName;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }
}

