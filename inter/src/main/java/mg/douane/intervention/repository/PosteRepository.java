package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Poste;
import mg.douane.intervention.data.domaine.Quartier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteRepository extends CrudRepository<Poste, Long> {
    List<Poste> findByQuartier(Quartier quartier);
}
