package mg.douane.intervention.donnee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.douane.intervention.donnee.DO.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String numMatUser;
    private String firstNameUser;
    private String lastNameUser;
    private String mailUser;
    private String pictureUser;
    private String telNumberUser;
    private Role roles;

}
