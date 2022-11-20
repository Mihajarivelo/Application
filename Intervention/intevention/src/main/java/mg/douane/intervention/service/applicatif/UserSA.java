package mg.douane.intervention.service.applicatif;

import mg.douane.intervention.donnee.dto.UserDto;

public interface UserSA {
    public UserDto createUser(UserDto userDto);

    public UserDto updateUser(UserDto userDto);

    public UserDto deleteUser(String id);

    public UserDto getUser(String id);

}
