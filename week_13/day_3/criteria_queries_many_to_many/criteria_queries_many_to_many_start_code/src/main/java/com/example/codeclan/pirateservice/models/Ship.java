package com.example.codeclan.pirateservice.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ships")

public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "ship", fetch = FetchType.LAZY)
    private List<Pirate> pirates;

    public Ship(String name) {
        this.name = name;
    }

    public Ship() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
