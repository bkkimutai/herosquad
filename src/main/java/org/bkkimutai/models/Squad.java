package org.bkkimutai.models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private  String SquadCause;
    private static List<Squad> heroMembers = new ArrayList<Squad>();
    private int maxSize;
    private int squadId;
    private boolean squadFull;

    public Squad (String squadName, String SquadCause, int maxSize){
        this.squadName = squadName;
        this.SquadCause= SquadCause;
        this.maxSize = maxSize;
        this.squadFull = false;
        heroMembers.add(this);
        squadId = heroMembers.size();
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadCause() {
        return SquadCause;
    }

    public void setSquadCauseCause(String cause) {
        this.SquadCause = SquadCause;
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

    public boolean isSquadFull() {
        return squadFull;
    }

    public void setSquadFull(boolean squadFull) {
        this.squadFull = squadFull;
    }
}
