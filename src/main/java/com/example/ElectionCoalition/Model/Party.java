package com.example.ElectionCoalition.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "party")
@Getter
@Setter
public class Party {
    public Party(Integer id, String name, String leader, String description) {
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String leader;
    private String description;

    public Party() {

    }
}
