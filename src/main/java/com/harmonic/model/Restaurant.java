package com.harmonic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "restaurant",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
    private List<Food> foodList;

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
