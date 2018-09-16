package com.harmonic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_votes")
public class VotesAccountant {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    public VotesAccountant() {}

    public VotesAccountant(Integer userId, Integer restaurantId) {
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
