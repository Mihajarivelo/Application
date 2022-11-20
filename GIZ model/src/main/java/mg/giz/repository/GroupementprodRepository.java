package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Groupementprod;

@Repository
public interface GroupementprodRepository extends CrudRepository<Groupementprod, Long> {
	@Transactional
	@Modifying
	@Query("delete from Groupementprod where groupementprod_id not in (Select min(groupementprod_id) "
			+ "from Groupementprod " + "group by groupementprod_nom, code_fkt, groupementprod_date)")
	void deleteGroupementprodDudplicated();

	@Query("SELECT g.groupementprod_nom FROM Groupementprod g WHERE lower(g.groupementprod_nom) = ?1 ")
	public String verifyGroupementprod(String groupement_prod);

	@Query("SELECT min(groupementprod_id) FROM Groupementprod g where lower(g.groupementprod_nom) = ?1")
	Long findIdGroupement(String nomGroupement);
	
	@Query("SELECT count(*) FROM Groupementprod")
    int CountGroupementprod();
	
	@Query("SELECT e FROM Groupementprod e")
	List<Groupementprod> listGroupementprod();
	
	@Query("SELECT f FROM Groupementprod f WHERE f.groupementprod_id = ?1")
	Groupementprod findGroupementprodbyId(Long groupementprod_id);

}
