package com.intervention.demo.Entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "reponse")
public class Reponse {
    @GenericGenerator(name = "seqRep", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqRep")
    private Long idRep;

    @Column(name = "libelleRep", length = 50, nullable = false)
    private String libelleRep;

    @Column(name = "descriptionRep", length = 500, nullable = false)
    private String descriptionRep;

    @Lob
    @Column(name = "pieceJointeRep", columnDefinition = "BLOB")
    private byte[] pieceJointeRep;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateEnvRep")
    private Date dateEnvRep;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agentRep;

    @ManyToOne
    @JoinColumn(name = "probleme_id")
    private Probleme problemeRep;

}
