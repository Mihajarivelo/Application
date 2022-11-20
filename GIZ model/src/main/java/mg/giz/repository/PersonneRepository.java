package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long>{
	@Transactional
	@Modifying
	@Query("delete from Personne where personne_id not in (Select min(personne_id) "
			+ "from Personne "
			+ "group by personne_nom, personne_genre, code_fkt)")
	void deletePersonneDuplicated();
	
	@Query("SELECT max(personne_id) FROM Personne")
    Long findMaxId(); 
	
	@Query("SELECT min(personne_id) FROM Personne p where p.personne_nom = ?1 AND p.personne_genre = ?2 AND p.code_fkt = ?3")
    Long findPersonne(String personne_nom, String personne_genre, String code_fkt);
	
	@Query("SELECT min(personne_id) FROM Personne p where p.personne_nom = ?1 AND p.personne_genre = ?2 AND p.code_fkt = ?3")
    Long findPersonneHistorique(String personne_nom, String personne_genre, String code_fkt);

	@Query("SELECT min(personne_id) FROM Personne p where p.personne_nom = ?1 AND p.personne_genre = ?2 AND p.code_fkt = ?3")
    Long findPersonneMfr(String personne_nom, String personne_genre, String code_fkt);
	
	@Query("SELECT p FROM Personne p WHERE p.personne_id = ?1" )
    Personne findPersonnebyId(Long Id);
	
	@Query("SELECT count(*) FROM Personne")
    int CountPersonne();
	
	@Query("SELECT personne_id FROM Personne t WHERE t.personne_nom =?1")
	Long selectPerson(String nom);
	
	@Query("SELECT personne_id FROM Personne t WHERE t.personne_id =?1")
	Long selectFkt(Long personne_id);
	
	@Query("select count(*) from Personne where personne_nom =?1 AND personne_genre = ?2 AND code_fkt =?3 AND personne_anneenaiss =?4")
	int detectDuplicated(String personne_nom,String personne_genre, String code_fkt, Long personne_anneenaiss);
	
	@Query("select count(*) from Personne where personne_nom =?1 AND personne_genre = ?2 AND code_fkt =?3 AND personne_anneenaiss =?4 AND personne_cin =?5 AND personne_adresse = ?6 AND personne_contact =?7")
	int detectDuplicated125(String personne_nom, String personne_genre, String personne_lieunaiss,Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact, String code_fkt);
	
	@Query("select count(*) from Personne where personne_nom =?1 AND personne_genre = ?2 AND code_fkt =?3")
	int detectDuplicated128(String personne_nom, String personne_genre, String code_fkt);
	
	@Query("SELECT f FROM Personne f WHERE f.personne_id = ?1")
	Personne findByIdPersonne(Long personne_id);
	
	@Query("SELECT personne_id FROM Personne t WHERE t.personne_nom =?1")
	Long findPersonneNom(String personne_nom);
	
	@Query("SELECT f FROM Personne f WHERE f.personne_id = ?1")
	Long findPersonneId(Long personne_id);
	
	@Query("select count(*) from Personne where personne_nom =?1 AND personne_genre = ?2 AND personne_anneenaiss =?3 AND personne_lieunaiss =?4 AND personne_cin =?5 AND personne_adresse =?6 AND personne_contact =?7")
	int detectDuplicatedPersonnne127(String personne_nom, String personne_genre, Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse, String personne_contact);

	
	@Query("SELECT min(personne_id) FROM Personne p where p.personne_nom = ?1 AND p.personne_genre = ?2 AND p.code_fkt = ?3")
    Long findPersonneVsla(String personne_nom, String personne_genre, String code_fkt);
	
	@Query("select count(*) from Personne where personne_nom =?1 AND personne_genre = ?2 AND code_fkt =?3 AND personne_lieunaiss =?4 AND personne_anneenaiss=?5 AND personne_cin =?6 AND personne_adresse = ?7 AND personne_contact =?8 AND personne_affiliation=?9")
	int detectDuplicatedM12(String personne_nom, String personne_genre,String code_fkt, String personne_lieunaiss,Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact,String personne_affiliation);

	@Query("SELECT f FROM Personne f")
	List<Personne> findPersonne();
	
	@Query(nativeQuery = true, value = "SELECT del_doublon_personne()")
	int del_doublon_personne();
}
