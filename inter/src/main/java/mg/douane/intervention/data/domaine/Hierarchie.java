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
@Table(name = "hierarchie")
public class Hierarchie {
    @GenericGenerator(name = "seqHier", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqHier")
    private Long idHier;

    @Column(name = "libelleHier", length = 50, nullable = true)
    private String libelleHier;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateDebHier")
    private Date dateDebHier;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateFinHier")
    private Date dateFinHier;

    @OneToMany(mappedBy = "hier", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<Hierarchie> listHier;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hierarchie hier;

    @ManyToOne
    @JoinColumn(name = "typeHier_id")
    private TypeHierarchie type;

    @OneToMany(mappedBy = "hierarchieFich")
    private Set<FichePoste> fichePostes;

}
