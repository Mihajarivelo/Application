package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Fermepilote;

@Repository
public interface FermepiloteRepository extends JpaRepository<Fermepilote, Long> {
	@Transactional
	@Modifying
	@Query("delete from Fermepilote where id not in (Select min(id) " + "from Fermepilote "
			+ "group by personne_id, fermepilote_date)")
	void deleteFermepiloteDudplicated();
	
	@Query("SELECT e FROM Fermepilote e")
	List<Fermepilote> fetchFermepilote();
	
	@Query("SELECT count(*) FROM Fermepilote")
    int CountFermepilote();
	
	@Query("SELECT f FROM Fermepilote f WHERE f.id = ?1")
	Fermepilote findByIdFermepilote(Long id);

}
