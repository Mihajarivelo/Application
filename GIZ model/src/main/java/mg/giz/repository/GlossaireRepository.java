package mg.giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Glossaire;

@Repository
public interface GlossaireRepository extends CrudRepository<Glossaire, Long> {

	@Query("SELECT g.id, g.glossaire_theme, g.glossaire_desc FROM Glossaire g ORDER BY g.glossaire_theme ASC")
	List<String> fetchGlossaireData();
}
