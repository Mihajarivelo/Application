package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Ecoleepp;

@Repository
public interface EcoleeppRepository extends CrudRepository<Ecoleepp, Long> {
	@Transactional
	@Modifying
	@Query("delete from Ecoleepp where id not in (Select min(id) from Ecoleepp "
			+ "group by code_fkt)")
	void deleteEcoleeppDudplicated();
	
	@Query("SELECT min(id) FROM Ecoleepp p where p.code_fkt = ?1")
    Long findEcoleepp(String code_fkt);
	
	@Query("SELECT min(ecoleepp_id) FROM Ecoleepp b WHERE b.ecoleepp_nom = ?1")
	public Long findIdEcoleepp(String ecoleepp_nom);
	
	@Query("SELECT min(ecoleepp_nom) FROM Ecoleepp b")
	public String findNomEcoleepp();
	
	@Query("SELECT count(*) FROM Ecoleepp")
    int CountEcoleepp();
	
	@Query("SELECT p FROM Ecoleepp p WHERE p.ecoleepp_id = ?1" )
    Ecoleepp findEcoleeppbyId(Long ecoleepp_id);
	
	@Query("SELECT ecoleepp_id FROM Ecoleepp t WHERE t.ecoleepp_nom =?1")
	Long selectEcoleepp(String ecoleepp_nom);
}
