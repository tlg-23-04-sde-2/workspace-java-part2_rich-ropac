package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer implements Serializable {

    private int id;
    private String name;

    private List<Reward> rewards = new ArrayList<>();

    // constructors

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    // business or "action" methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    //accessor methods

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    // this is a derived property
    public int getWins() {
        return rewards.size();
    }


    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s,",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}