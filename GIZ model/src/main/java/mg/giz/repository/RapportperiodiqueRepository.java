package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Rapportperiodique;

@Repository
public interface RapportperiodiqueRepository extends CrudRepository<Rapportperiodique, Long> {

}
