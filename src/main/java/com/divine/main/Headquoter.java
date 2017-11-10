package com.divine.main;

import javax.persistence.Entity;

@Entity
public class Headquoter extends Company{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
