package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Village;

@Repository
public interface VillageCrudRepository extends CrudRepository<Village, String> {
	
}
