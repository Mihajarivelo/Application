package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Theme;

@Repository
public interface ThemeCrudRepository extends CrudRepository<Theme, Long> {
	
}
