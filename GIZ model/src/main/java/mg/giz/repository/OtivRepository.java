package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Otiv;

@Repository
public interface OtivRepository extends CrudRepository<Otiv, String> {
	@Transactional
	@Modifying
	@Query("delete from Otiv where otiv_id not in (Select min(otiv_id) "
			+ "from Otiv "
			+ "group by otiv_code)")
	void deleteOtivDuplicated();
	
	@Query("SELECT min(otiv_id) FROM Otiv o where o.otiv_code = ?1")
    Integer findOtiv(String otiv_code);

	@Query("SELECT otiv_id FROM Otiv t WHERE t.otiv_code =?1")
	int selectOtiv(String otiv_code);
	
	@Query("SELECT count(*) FROM Otiv")
    int CountOtiv();
	
	@Query("SELECT p FROM Otiv p WHERE p.otiv_id = ?1" )
	Otiv findOtivbyId(int otiv_id);
}
