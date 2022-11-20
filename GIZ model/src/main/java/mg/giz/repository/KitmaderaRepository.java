package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Kitmadera;

@Repository
public interface KitmaderaRepository extends CrudRepository<Kitmadera, Long> {
	
	@Transactional
	@Modifying
	@Query("delete from Kitmadera where id not in (Select min(id) from Kitmadera "
			+ "group by  ecoleepp_id, enseignantepp_nom, enseignantepp_genre, kitmadere_date)")
	void deleteEnseignantKitDudplicated();

}
