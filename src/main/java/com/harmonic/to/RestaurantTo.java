package com.harmonic.to;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class RestaurantTo extends BaseTo implements Serializable {

    @NotEmpty
    private String name;

    private Integer voteCount;

    private boolean votedByCurrentUser;

    public RestaurantTo() {

    }

    public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
        this.voteCount = 0;
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

    public boolean isVotedByCurrentUser() {
        return votedByCurrentUser;
    }

    public void setVotedByCurrentUser(boolean voted) {
        votedByCurrentUser = voted;
    }
}
