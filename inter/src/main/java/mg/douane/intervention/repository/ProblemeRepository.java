package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.Probleme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemeRepository extends CrudRepository<Probleme, Long> {

    @Query("SELECT p FROM Probleme p WHERE p.statut.idStatut = 3")
    List<Probleme> findAllResolu();

    @Query("SELECT p FROM Probleme p WHERE p.statut.idStatut <> 3")
    List<Probleme> findAllNotResolu();

    List<Probleme> findByAgentProb(Agent agent);

    List<Probleme> findByIntervenant(String intervenant);
}
