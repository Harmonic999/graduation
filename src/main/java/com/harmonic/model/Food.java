package com.harmonic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food extends AbstractBaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "votes")
    private int votesCount;

    public Food() {
    }

    public Food(String description) {
        this.description = description;
    }

    public Food(Integer id, String description) {
        super(id);
        this.description = description;
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

    public Food plusVote() {
        votesCount++;
        return this;
    }

    public Food minusVote() {
        votesCount--;
        return this;
    }

}
