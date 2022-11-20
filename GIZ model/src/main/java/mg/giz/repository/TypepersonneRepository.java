package mg.giz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Typepersonne;

@Repository
public interface TypepersonneRepository extends CrudRepository<Typepersonne, Long> {
	
	@Query("SELECT min(typepersonne_id) FROM Typepersonne b WHERE b.typepersonne_nom = ?1")
	public int findIdTypePersonne(String typepersonne_nom);
	
	@Query("SELECT f FROM Typepersonne f WHERE f.typepersonne_id = ?1")
	Typepersonne findTypepersonnebyId(int typepersonne_id);
	
}
