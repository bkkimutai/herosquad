package org.bkkimutai.models;

import org.bkkimutai.Config.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class HeroWithSquad {
    private int heroId;
    private String heroName;
    private int heroAge;
    private String heroPower;
    private String heroWeakness;
    private int squadId;
    private String squadName;

    public HeroWithSquad(int heroId, String heroName, int heroAge, String heroPower, String heroWeakness, int squadId, String squadName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.heroPower = heroPower;
        this.heroWeakness = heroWeakness;
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


    public String getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(String heroPower) {
        this.heroPower = heroPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
    }
}

