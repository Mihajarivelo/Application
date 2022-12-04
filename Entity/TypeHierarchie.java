package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "typeHierarchie")
public class TypeHierarchie {
    @GenericGenerator(name = "seqType", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqType")
    private Long idType;

    @Column(name = "libelleType", length = 30, nullable = false)
    private String libelleType;

    @OneToMany(mappedBy = "type")
    private Set<Hierarchie> hierarchies;
}
