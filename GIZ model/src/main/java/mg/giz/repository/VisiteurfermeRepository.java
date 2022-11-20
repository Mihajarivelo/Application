package mg.giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Visiteurferme;

@Repository
public interface VisiteurfermeRepository extends CrudRepository<Visiteurferme, Long>{
	@Transactional
	@Modifying
	@Query("delete from Visiteurferme where id not in (Select min(id) "
			+ "from Visiteurferme "
			+ "group by code_fkt, visiteurferme_nom, visiteurferme_date)")
	void deleteVisiteurDuplicated();
	
	//liste des Visiteurferme
	@Query("SELECT e FROM Visiteurferme e")
	List<Visiteurferme> fetchVisiteurfermeData();
	
	@Query("SELECT count(*) FROM Visiteurferme")
    int CountVisiteurferme();
	
	@Query("select count(*) from Visiteurferme where visiteurferme_nom =?1 AND code_fkt = ?2 AND visiteurferme_date =?3 AND visiteurferme_valeur =?4")
	int detectDuplicated(String visiteurferme_nom, String code_fkt, Date visiteurferme_date, Long visiteurferme_valeur);
	
	@Query("SELECT f FROM Visiteurferme f WHERE f.id = ?1")
	Visiteurferme findByIdVisiteurferme(Long id);
	
	@Modifying
    @Transactional
    @Query("delete from Visiteurferme e where id = ?1")
    void deleteVisiteurfermeQuery(Long id);

}
