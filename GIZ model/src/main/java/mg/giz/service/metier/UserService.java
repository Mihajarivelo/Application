package mg.giz.service.metier;

import mg.giz.data.domain.User;
import mg.giz.data.dto.ChangePasswordDto;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public User ChangePasswordDto(ChangePasswordDto form) throws Exception;
	
}
