package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Subvenirepp;

@Repository
public interface SubvenireppRepository extends CrudRepository<Subvenirepp, Long> {
	@Transactional
	@Modifying
	@Query("delete from Subvenirepp where id not in (Select min(id) " + "from Subvenirepp "
			+ "group by ecoleepp_id, subvenirepp_date)")
	void deleteSubvenireppDudplicated();
	
	//liste
	@Query("SELECT e FROM Subvenirepp e")
	List<Subvenirepp> fetchSubvenireppData();
	
	@Query("SELECT count(*) FROM Subvenirepp")
    int CountSubvenirepp();
	
	@Query("SELECT f FROM Subvenirepp f WHERE f.id = ?1")
	Subvenirepp findByIdSubvenirepp(Long id);
	
	@Modifying
    @Transactional
    @Query("delete from Subvenirepp e where id = ?1")
    void deleteSubvenireppQuery(Long id);

}
