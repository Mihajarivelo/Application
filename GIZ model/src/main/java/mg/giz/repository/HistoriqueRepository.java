package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Historique;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
	@Transactional
	@Modifying
	@Query("delete from Historique where id not in (Select min(id) " + "from Historique "
			+ "group by personne_id, typepersonne_id, historique_date)")
	void deleteHistoriqueDudplicated();
	
	@Query("SELECT DISTINCT e FROM Historique e INNER JOIN e.personne t")
	Long historiquePersonne(Long personne_id);
	
	@Query("SELECT p FROM Historique p WHERE p.id = ?1" )
    Historique findHistoriquebyId(Long id);
	
	@Query("SELECT DISTINCT e FROM Historique e INNER JOIN e.personne t where e.typepersonne_id =?1")
	List<Historique> fetchTypepersonneRessource(int id);
	
	@Query("SELECT count(*) FROM Historique")
    int CountHistorique();
	
	@Query("SELECT f FROM Historique f WHERE f.personne.personne_code IS NOT NULL")
	List<Historique> findHistoriqueSmyrise();

}
