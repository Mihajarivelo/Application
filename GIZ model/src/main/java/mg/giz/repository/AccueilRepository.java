package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Accueil;

@Repository
public interface AccueilRepository extends CrudRepository<Accueil, Long>{

}
