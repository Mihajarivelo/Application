package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "porte")
public class Porte {
    @GenericGenerator(name = "seqPorte", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqPorte")
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "G1")
    // @SequenceGenerator(name = "G1", sequenceName = "LOG_SEQ")
    // @Column(name = "idRole", unique = true, nullable = false, precision = 22,
    // scale = 0)
    private long idPorte;

    @Column(name = "libellePorte", length = 20, nullable = false)
    private String libellePorte;

    @OneToMany(mappedBy = "porte")
    private Set<Poste> postes;

}
