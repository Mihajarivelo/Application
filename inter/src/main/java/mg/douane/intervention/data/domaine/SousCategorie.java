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
@Table(name = "sousCategorie")
public class SousCategorie {
    @GenericGenerator(name = "seqSc", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqSc")
    private Long idSCat;

    @Column(name = "libelleSCat", length = 50, nullable = false)
    private String libelleSCat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateDebSCat")
    private Date dateDebSCat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateFinScat")
    private Date dateFinScat;

    @OneToMany(mappedBy = "SCat", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<SousCategorie> scats;

    @ManyToOne(fetch = FetchType.LAZY)
    private SousCategorie SCat;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "souCatFich")
    private Set<FichePoste> fichePostes;
}
