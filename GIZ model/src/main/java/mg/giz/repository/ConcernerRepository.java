package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Concerner;

@Repository
public interface ConcernerRepository extends CrudRepository<Concerner, Long>{
	@Transactional
	@Modifying
	@Query("delete from Concerner where id not in (Select min(id) "
			+ "from Concerner "
			+ "group by concerner_date, concerner_typeecole, ecoleepp_id)")
	void deleteConcernerDuplicated();
	
	@Query("SELECT count(*) FROM Concerner")
    int CountConcerner();
	
	@Query("SELECT DISTINCT e FROM Concerner e INNER JOIN e.ecoleepp t")
	List<Concerner> joinConcernerEcoleepp();
	
	@Query("SELECT p FROM Concerner p WHERE p.id = ?1" )
	Concerner findConcernerbyId(Long id);
}
