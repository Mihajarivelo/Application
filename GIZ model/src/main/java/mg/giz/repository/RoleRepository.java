package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
