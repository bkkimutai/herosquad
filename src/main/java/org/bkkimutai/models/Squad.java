package org.bkkimutai.models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private  String description;
    private static boolean isRegisteredHero = false;
    private static List<Squad> heroMembers = new ArrayList<Squad>();
    private static List<Squad> squadList = new ArrayList<>();
    private int squadId;
    private boolean isSquadFull = false;

    public Squad (String squadName, String description){
        this.squadName = squadName;
        this.description= description;
        squadList.add(this);
        squadId = heroMembers.size();
        mHeroes = new ArrayList<Hero>();

    }

    public String getmSquadName() {
        return mSquadName;
    }

    public void setmSquadName(String mSquadName) {
        this.mSquadName = mSquadName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public static List<Squad> getInstances() {
        return instances;
    }

    public static void setInstances(List<Squad> instances) {
        Squad.instances = instances;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public List<Hero> getmHeroes() {
        return mHeroes;
    }

    public void setmHeroes(List<Hero> mHeroes) {
        this.mHeroes = mHeroes;
    }
}
