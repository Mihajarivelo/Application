package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Nombreeleve;

@Repository
public interface NombreeleveRepository extends CrudRepository<Nombreeleve, Long>{
	@Transactional
	@Modifying
	@Query("delete from Nombreeleve where id not in (Select min(id) from Nombreeleve "
			+ "group by ecoleepp_id, nombreeleve_date)")
	void deleteNombreeleveDudplicated();
	
	@Query("SELECT count(*) FROM Nombreeleve")
    int CountNombreeleve();
	
	@Query("SELECT f FROM Nombreeleve f")
	List<Nombreeleve> listNombreeleve();
	
	@Query("SELECT f FROM Nombreeleve f WHERE f.id = ?1")
	Nombreeleve findNombreelevebyId(int id);
	
}
