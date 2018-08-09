package com.harmonic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "vote_count")
    private int votes_count;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Food> foodList;

    public Restaurant(){}

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes_count() {
        return votes_count;
    }

    public void setVotes_count(int votes_count) {
        this.votes_count = votes_count;
    }
}
