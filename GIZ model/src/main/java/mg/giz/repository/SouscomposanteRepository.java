package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Souscomposante;

@Repository
public interface SouscomposanteRepository extends CrudRepository<Souscomposante, String> {

}
