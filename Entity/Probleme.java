package com.intervention.demo.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "problème")

public class Probleme {
    @GenericGenerator(name = "seqProb", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqProb")
    private Long idProb;

    @Column(name = "libelleProb", length = 50, nullable = false)
    private String libelleProb;

    @Column(name = "descriptionProb", length = 500, nullable = false)
    private String descriptionProb;

    @Lob
    @Column(name = "pieceJointeProb", columnDefinition = "BLOB")
    private byte[] pieceJointeProb;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateEnvProb")
    private Date dateEnvProb;

    @Column(name = "confidentialiteProb")
    private boolean confidentialiteProb;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    private Statut statut;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agentProb;

    @ManyToOne
    @JoinColumn(name = "priorite_id")
    private Priorite priorite;

    @OneToMany(mappedBy = "problemeRep")
    private Set<Reponse> reponses;

}
