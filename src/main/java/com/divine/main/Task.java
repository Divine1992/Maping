package com.divine.main;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "tasks")
    private Set<Customer> customers;

    public int getId() {
        return id;
    }

    public void setId(int order_id) {
        this.id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
