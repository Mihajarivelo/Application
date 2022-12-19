package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Probleme;
import mg.douane.intervention.data.domaine.Reponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends CrudRepository<Reponse, Long> {

    List<Reponse> findByProblemeRep(Probleme probleme);
}
