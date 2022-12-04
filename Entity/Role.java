package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "role")
public class Role {
    @GenericGenerator(name = "seqRole", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqRole")
    private long idRole;

    @Column(name = "libelleRole", length = 20, nullable = false)
    private String libelleRole;

    @OneToMany(mappedBy = "roles")
    private Set<Agent> agents;

    public Role() {
    }

    public Role(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }

}
