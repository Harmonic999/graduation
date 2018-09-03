package com.harmonic.to;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseTo {

    private Integer id;

    public BaseTo() {

    }

    public BaseTo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
}
