package mg.douane.intervention.data.domaine;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = "probleme")
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
    @Column(name = "pieceJointeProb", columnDefinition = "BYTEA") //BLOB
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
