package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Ameliorer;

@Repository
public interface AmeliorerRepository extends CrudRepository<Ameliorer, Long>{
	@Transactional
	@Modifying
	@Query("delete from Ameliorer where id not in (Select min(id) "
			+ "from Ameliorer "
			+ "group by code_fkt, eaupotable_observation, eaupotable_date)")
	void delete238Duplicated();
	
	@Query("SELECT count(*) FROM Ameliorer")
    int CountAmeliorer();
	
	@Query("SELECT f FROM Ameliorer f")
	List<Ameliorer> findAmeliorer();
	
	@Query("SELECT p FROM Ameliorer p WHERE p.id = ?1" )
	Ameliorer findAmeliorerbyId(Long id);
}
