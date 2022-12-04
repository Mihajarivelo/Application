package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "poste")
public class Poste {
    @GenericGenerator(name = "seqPoste", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqPoste")
    private Long idPoste;

    @Column(name = "fonctionPoste", length = 50, nullable = false)
    private String fonctionPoste;

    @ManyToOne
    @JoinColumn(name = "porte_id")
    private Porte porte;

    @ManyToOne
    @JoinColumn(name = "quartier_id")
    private Quartier quartier;

    @OneToMany(mappedBy = "posteFich")
    private Set<FichePoste> fichePostes;

}
