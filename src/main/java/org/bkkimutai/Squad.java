package org.bkkimutai;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mSquadName;
    private  String mDescription;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int mId;
    private List<Hero> mHeroes;


    public Squad (String squadName, String description){
        mSquadName = squadName;
        mDescription= description;
        instances.add(this);
        mId = instances.size();
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
