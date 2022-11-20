package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Menagessensibilise;

@Repository
public interface MenagessensibiliseRepository extends JpaRepository<Menagessensibilise, Long> {
	@Transactional
	@Modifying
	@Query("delete from Menagessensibilise where id not in (Select min(id) from Menagessensibilise "
			+ "group by code_fkt, menagessensibilise_date, menagessensibilise_lib)")
	void deleteMenagessensibiliseDudplicated();
	
	//liste des menage sensibilisé
	@Query("SELECT m FROM Menagessensibilise m")
	List<Menagessensibilise> fetchMenagessensibiliseData();
	
	@Query("SELECT count(*) FROM Menagessensibilise")
    int CountMenagessensibilise();
	
	@Query("SELECT f FROM Menagessensibilise f WHERE f.id = ?1")
	Menagessensibilise findByIdMenagessensibilise(int id);
	
	@Modifying
    @Transactional
    @Query("delete from Menagessensibilise e where id = ?1")
    void deleteMenagessensibiliseQuery(int id);

}
