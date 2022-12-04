package com.intervention.demo.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "categorie")
public class Categorie {
    @GenericGenerator(name = "seqCat", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqCat")
    private Long idCat;

    @Column(name = "libelleCat", length = 50, nullable = false)
    private String libelleCat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateDebCat")
    private Date dateDebCat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateFinCat")
    private Date dateFinHier;

    @OneToMany(mappedBy = "categorie")
    private Set<SousCategorie> sousCategories;

}
