package mg.giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Suivitheme;

@Repository
public interface SuivithemeRepository extends JpaRepository<Suivitheme, Long>{
	@Transactional
	@Modifying
	@Query("delete from Suivitheme where id not in (Select min(id) "
			+ "from Suivitheme "
			+ "group by code_fkt, suivitheme_date, theme_id)")
	void delete441Duplicated();
	
	//liste des producteurs Suivitheme
	@Query("SELECT e FROM Suivitheme e where e.theme_id=?1")
	List<Suivitheme> fetchSuiviThmData(Long theme_id);
	
	@Query("SELECT count(*) FROM Suivitheme")
    int CountSuivitheme();
	
	@Query("select count(*) from Suivitheme where suivitheme_comm =?1 AND suivitheme_date = ?2 AND code_fkt =?3 AND suivitheme_valeur =?4 AND theme_id=?5")
	int detectDuplicated(String suivitheme_comm, Date suivitheme_date, String code_fkt, Double suivitheme_valeur,Long theme_id);
	
	@Query("SELECT f FROM Suivitheme f WHERE f.id = ?1")
	Suivitheme findByIdSuivitheme(Long id);
	
	@Query("SELECT f FROM Suivitheme f")
	List<Suivitheme> findSuivitheme();
	
	@Query("SELECT f FROM Suivitheme f WHERE f.theme.theme_lib = '1.3.5'")
	List<Suivitheme> findSuivitheme135();

}
