package com.harmonic.to;

import java.io.Serializable;

public class FoodTo extends BaseTo implements Serializable {

    private String description;

    public FoodTo() {

    }

    public FoodTo(int id, String description) {
        super(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
