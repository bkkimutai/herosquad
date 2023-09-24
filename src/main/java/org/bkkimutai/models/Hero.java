package org.bkkimutai.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String age;
    private String power;
    private String weakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int heroID;
    private String squadAlliance;
    private static boolean duplicate = false;

    public Hero(String name,String age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        heroID = instances.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public static List<Hero> getInstances() {
        return instances;
    }

    public static void setInstances(List<Hero> instances) {
        Hero.instances = instances;
    }

    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public String getSquadAlliance() {
        return squadAlliance;
    }

    public void setSquadAlliance(String squadAlliance) {
        this.squadAlliance = squadAlliance;
    }

    public static boolean isDuplicate() {
        return duplicate;
    }

    public static void setDuplicate(boolean duplicate) {
        Hero.duplicate = duplicate;
    }
}
