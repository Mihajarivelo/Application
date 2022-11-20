package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Serviceprojet;

@Repository
public interface ServiceprojetRepository extends JpaRepository<Serviceprojet, Long> {
	@Transactional
	@Modifying
	@Query("delete from Serviceprojet where serviceprojet_id not in (Select min(serviceprojet_id) "
			+ "from Serviceprojet " + "group by serviceprojet_nom)")
	void deleteServiceprojetDuplicated();

	@Query("SELECT min(serviceprojet_id) FROM Serviceprojet s where s.serviceprojet_nom = ?1")
	Long findIdGroupement(String nomService);

}
