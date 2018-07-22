package com.harmonic.model;

public class Meal {

    private int id;

    private String description;

    private int votesCount;

    public Meal(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public void plusVote() {
        votesCount++;
    }

    public void minusVote() {
        votesCount--;
    }

}
