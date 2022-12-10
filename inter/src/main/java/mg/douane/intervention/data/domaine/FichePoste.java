package mg.douane.intervention.data.domaine;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = "fichePoste")
public class FichePoste {
    @GenericGenerator(name = "seqFPoste", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqFPoste")
    private Long idFich;

    @ManyToOne
    @JoinColumn(name = "agent_idFich")
    private Agent agentFich;

    @ManyToOne
    @JoinColumn(name = "hier_idFich")
    private Hierarchie hierarchieFich;

    @ManyToOne
    @JoinColumn(name = "poste_idFich")
    private Poste posteFich;

    @ManyToOne
    @JoinColumn(name = "scat_idFich")
    private SousCategorie souCatFich;

}
