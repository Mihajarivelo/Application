package mg.douane.intervention.contraint.mapper;

import java.util.List;

import mg.douane.intervention.donnee.DO.User;
import mg.douane.intervention.donnee.dto.RoleDto;
import mg.douane.intervention.donnee.dto.UserDto;

public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<User> userDtosToUsers(List<UserDto> userDtos);

    List<UserDto> userstoUserDtos(List<User> users);

    RoleDto userToRoleDto(User user);

}
