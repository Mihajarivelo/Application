package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "statut")
public class Statut {

    @GenericGenerator(name = "seqStat", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqStat")
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "G1")
    // @SequenceGenerator(name = "G1", sequenceName = "LOG_SEQ")
    // @Column(name = "idRole", unique = true, nullable = false, precision = 22,
    // scale = 0)
    private long idStatut;

    @Column(name = "libelleStatut", length = 20, nullable = false)
    private String libelleStatut;

    @OneToMany(mappedBy = "statut")
    private Set<Probleme> problemes;

}
