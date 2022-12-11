package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Poste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends CrudRepository<Poste, Long> {
}
