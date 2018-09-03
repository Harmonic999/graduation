package com.harmonic.to;

import java.io.Serializable;

public class RestaurantTo extends BaseTo implements Serializable {

    private String name;

    private Integer voteCount;

    public RestaurantTo() {

    }

    public RestaurantTo(Integer id, String name, Integer voteCount) {
        super(id);
        this.name = name;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
