package mg.douane.intervention.donnee.DO;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @GenericGenerator(name = "seqRoles", strategy = "increment")
    @Id
    @GeneratedValue(generator = "seqRoles")
    private Long idRoles;

    @Column(name = "descriptionRoles", length = 20, nullable = false)
    private String descriptionRoles;

    @OneToMany(mappedBy = "roles")
    private List<User> users;

}
