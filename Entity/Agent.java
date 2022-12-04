package com.intervention.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "agent")

public class Agent {
    @Id
    @Column(name = "numMatAgent", nullable = false, length = 6)
    private String numMatAgent;

    @Column(name = "nomAgent", nullable = true, length = 50)
    private String nomAgent;

    @Column(name = "prenomAgent", nullable = true, length = 30)
    private String prenomAgent;

    @Lob
    @Column(name = "photoAgent", columnDefinition = "BLOB")
    private byte[] photoAgent;

    @Column(name = "emailAgent", nullable = false, length = 50)
    private String emailAgent;

    @Column(name = "telAgent", nullable = false, length = 13)
    private String telAgent;

    @Column(name = "mdpAgent", nullable = false, length = 30)
    private String mpdAgent;

    @ManyToOne
    @JoinTable(name = "role_id")
    private Role roles;

    @OneToMany(mappedBy = "agentProb")
    private Set<Probleme> problèmes;

    @OneToMany(mappedBy = "agentRep")
    private Set<Reponse> reponses;

    @OneToMany(mappedBy = "agentFich")
    private Set<FichePoste> fichePostes;

}
