package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Kitmadere;

@Repository
public interface KitmadereRepository extends CrudRepository<Kitmadere, Long> {
	@Transactional
	@Modifying
	@Query("delete from Kitmadere where id not in (Select min(id) from Kitmadere "
			+ "group by enseignantepp_id, kitmadere_date, enseignantepp_id)")
	void deleteKitmadereDudplicated();
	
	@Query("SELECT count(*) FROM Kitmadere")
    int CountKitmadere();
	
	@Query("SELECT f FROM Kitmadere f")
	List<Kitmadere> findKitmadere();
	
	@Query("SELECT id FROM Enseignantepp t")
	Long selectEnseignantepp();	
	
	@Query("SELECT DISTINCT e FROM Kitmadere e INNER JOIN e.enseignantepp t")
	List<Kitmadere> joinKitEnsEcole();
	
	@Query("SELECT p FROM Kitmadere p WHERE p.id = ?1" )
	Kitmadere findKitmaderebyId(Long id);
	
	@Query("SELECT p FROM Kitmadere p WHERE p.enseignantepp_id = ?1" )
	Kitmadere findKitmadereEnseignanteppbyId(Long id);
}
