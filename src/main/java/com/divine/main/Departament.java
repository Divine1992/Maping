package com.divine.main;

import javax.persistence.Entity;

@Entity
public class Departament extends Company{
    private int countEmployee;

    public int getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(int countEmployee) {
        this.countEmployee = countEmployee;
    }
}
