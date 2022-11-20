package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mg.giz.data.domain.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	@Transactional
	@Modifying
	@Query("delete from Formateur where id not in (Select min(id) "
			+ "from Formateur "
			+ "group by formateur_nom, formateur_contact, code_fkt, formateur_genre, formateur_date)")
	void deleteFormateurDuplicated();

	@Query("SELECT t FROM Formateur t WHERE t.formateur_nom = ?1 AND t.formateur_contact = ?2")
    List<Formateur> findByFooInAndBar(String formateur_nom, String formateur_contact);
	
	@Query("SELECT count(*) FROM Formateur")
    int CountFormateur();
	
	@Query("select count(*) from Formateur where formateur_nom =?1 AND formateur_contact = ?2 AND code_fkt =?3 AND formateur_genre =?4")
	int detectDuplicated(String formateur_nom, String formateur_contact, String code_fkt, String formateur_genre);
	
	@Query("SELECT f FROM Formateur f WHERE f.typepersonne.typepersonne_nom = 'formateurs FBS formés'")
	List<Formateur> listFormateurFBS();
	
	@Query("SELECT f FROM Formateur f WHERE f.id = ?1")
	Formateur findFormateurbyId(Long id);
}
