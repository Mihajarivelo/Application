package mg.douane.intervention.donnee.DO;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "numMatUser", nullable = false, length = 6)
    private String numMatUser;

    @Column(name = "firstNameUser", nullable = true, length = 50)
    private String firstNameUser;
    @Column(name = "lastNameUser", nullable = true, length = 30)
    private String lastNameUser;
    @Column(name = "passwordUser", nullable = true, length = 20)
    private String passwordUser;
    @Column(name = "mailUser", nullable = true, length = 50)
    private String mailUser;
    @Lob
    @Column(name = "pictureUser", columnDefinition = "BLOB")
    private String pictureUser;
    @Column(name = "telAgent", nullable = false, length = 13)
    private String telNumberUser;
    @ManyToOne
    private Role roles;

}
