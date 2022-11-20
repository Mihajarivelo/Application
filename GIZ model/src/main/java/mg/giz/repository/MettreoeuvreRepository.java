package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Mettreoeuvre;

@Repository
public interface MettreoeuvreRepository extends JpaRepository<Mettreoeuvre, Long> {
	@Transactional
	@Modifying
	@Query("delete from Mettreoeuvre where id not in (Select min(id) from Mettreoeuvre "
			+ "group by groupementprod_id, serviceprojet_id, mettreoeuvre_date)")
	void deleteMettreoeuvreDudplicated();

}
