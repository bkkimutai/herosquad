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

    public Squad(String squadName, String squadCause, int maxSize) {
        this.squadName = squadName;
        this.SquadCause = squadCause;
        this.maxSize = maxSize;
        this.squadId = heroMembers.size() + 1;
        this.squadFull = false;
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

    public void setSquadCause(String squadCause) {
        SquadCause = squadCause;
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
