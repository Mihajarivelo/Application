package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Indicateur;

@Repository
public interface IndicateurRepository extends CrudRepository<Indicateur, String> {

}
