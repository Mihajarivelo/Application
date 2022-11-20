package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Capitalisation;

@Repository
public interface CapitalisationRepository extends CrudRepository<Capitalisation, Long> {

}
