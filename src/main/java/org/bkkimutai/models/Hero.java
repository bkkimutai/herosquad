package org.bkkimutai.models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroPower;
    private String heroWeakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int heroId;
    private int squadId;
    private static boolean duplicate = false;

    public Hero(String heroName, int heroAge, String heroPower, String heroWeakness, int squadId) {
        this.squadId = squadId;
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.heroPower = heroPower;
        this.heroWeakness = heroWeakness;
        this.heroId = instances.size()+1;
    }


    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
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

    public static List<Hero> getInstances() {
        return instances;
    }

    public static void setInstances(List<Hero> instances) {
        Hero.instances = instances;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public static boolean isDuplicate() {
        return duplicate;
    }

    public static void setDuplicate(boolean duplicate) {
        Hero.duplicate = duplicate;
    }


}
