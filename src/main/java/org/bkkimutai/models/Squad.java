package org.bkkimutai.models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private  String cause;
    private static List<Squad> heroMembers = new ArrayList<Squad>();
    private int maxSize;
    private int squadId;

    public Squad (String squadName, String cause){
        this.squadName = squadName;
        this.cause= cause;
        heroMembers.add(this);
        squadId = heroMembers.size();
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public static List<Squad> getHeroMembers() {
        return heroMembers;
    }

    public static void setHeroMembers(List<Squad> heroMembers) {
        Squad.heroMembers = heroMembers;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }
}
