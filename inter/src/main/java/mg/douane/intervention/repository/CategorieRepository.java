package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
}
