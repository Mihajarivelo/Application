package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Projetmfr;

@Repository
public interface ProjetmfrRepository extends CrudRepository<Projetmfr, Long> {
	@Transactional
	@Modifying
	@Query("delete from Projetmfr where id not in (Select min(id) "
			+ "from Projetmfr "
			+ "group by projetmfr_date, personne_id)")
	void deleteProjetMfrDuplicated();
	
	@Query("SELECT count(*) FROM Projetmfr")
	int CountProjetmfr();
	
	@Query("SELECT f FROM Projetmfr f")
	List<Projetmfr> listProjetmfr();
	
	@Query("SELECT p FROM Projetmfr p WHERE p.id = ?1" )
	Projetmfr findProjetmfrbyId(Long id);
}
