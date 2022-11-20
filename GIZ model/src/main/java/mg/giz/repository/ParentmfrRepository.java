package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Parentmfr;

@Repository
public interface ParentmfrRepository extends CrudRepository<Parentmfr, String> {
	@Transactional
	@Modifying
	@Query("delete from Parentmfr where parentmfr_id not in (Select min(parentmfr_id) "
			+ "from Parentmfr "
			+ "group by parentmfr_nom, parentmfr_fonction)")
	void deleteParentmfrDuplicated();
	
	@Query("SELECT min(parentmfr_id) FROM Parentmfr p where p.parentmfr_nom = ?1 ")
    Long findParentmfr(String parentmfr_nom);
	
	@Query("SELECT count(*) FROM Parentmfr")
    int CountParentmfr();
	
	@Query("SELECT t FROM Parentmfr t WHERE t.parentmfr_id = ?1" )
	Parentmfr findParentmfrId(Long parentmfr_id);

}
