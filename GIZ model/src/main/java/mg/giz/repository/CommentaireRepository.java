package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long>{

}
