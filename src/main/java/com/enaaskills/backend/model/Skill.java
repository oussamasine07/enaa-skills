package com.enaaskills.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "skill")
    private List<SubSkill> subskills;

    public Skill () {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubSkill> getSubskills() {
        return subskills;
    }

    public void setSubskills(List<SubSkill> subskills) {
        this.subskills = subskills;
    }
}
