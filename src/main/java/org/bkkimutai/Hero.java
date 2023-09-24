package org.bkkimutai;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mAlias;
    private String mAge;
    private String mSpecialPower;
    private String mWeakness;
    private LocalDateTime mCreatedAt;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int mId;

    public Hero(String alias,String age, String specialPower, String weakness){
        mAlias = alias;
        mAge = age;
        mSpecialPower = specialPower;
        mWeakness = weakness;
        mCreatedAt = LocalDateTime.now();
        instances.add(this);
        mId = instances.size();
    }

    public String getmAlias() {
        return mAlias;
    }

    public void setmAlias(String mAlias) {
        this.mAlias = mAlias;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmSpecialPower() {
        return mSpecialPower;
    }

    public void setmSpecialPower(String mSpecialPower) {
        this.mSpecialPower = mSpecialPower;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public void setmWeakness(String mWeakness) {
        this.mWeakness = mWeakness;
    }

    public LocalDateTime getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(LocalDateTime mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public static List<Hero> getInstances() {
        return instances;
    }

    public static void setInstances(List<Hero> instances) {
        Hero.instances = instances;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
