package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Enseignantepp;

@Repository
public interface EnseignanteppRepository extends CrudRepository<Enseignantepp, Long>{
	@Transactional
	@Modifying
	@Query("delete from Enseignantepp where id not in (Select min(id) from Enseignantepp "
			+ "group by  ecoleepp_id, enseignantepp_nom, enseignantepp_genre, enseignantepp_date)")
	void deleteEnseignantDudplicated();
	
	@Query("SELECT f FROM Enseignantepp f")
	List<Enseignantepp> findEnseigantepp();
	
	@Query("SELECT DISTINCT e FROM Enseignantepp e INNER JOIN e.ecoleepp t")
	Long enseignanteppEcoleepp(Long ecoleepp_id);
	
	@Query("SELECT count(*) FROM Enseignantepp")
    int CountEnseignantepp();
	
	@Query("SELECT p FROM Enseignantepp p WHERE p.id = ?1" )
    Enseignantepp findEnseignanteppbyId(Long id);
	
	@Query("SELECT min(id) FROM Enseignantepp p where p.ecoleepp_id = ?1 AND p.enseignantepp_nom = ?2 AND p.enseignantepp_genre = ?3")
    Long findEnseignantepp(Long ecoleepp_id, String enseignantepp_nom, String enseignantepp_genre);
	
	@Query("SELECT f FROM Enseignantepp f WHERE f.id = ?1")
	Long findEnseignanteppId(Long id);
	
	@Query("SELECT id FROM Enseignantepp t WHERE t.enseignantepp_nom =?1")
	Long selectEnseignantepp(String enseignantepp_nom);
}
