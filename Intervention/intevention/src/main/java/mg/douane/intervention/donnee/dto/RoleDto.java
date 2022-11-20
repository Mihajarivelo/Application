package mg.douane.intervention.donnee.dto;

import java.util.List;

import lombok.*;
import mg.douane.intervention.donnee.DO.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long idRoles;
    private String descriptionRoles;
    private List<User> users;

}
