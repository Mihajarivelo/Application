package mg.giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mg.giz.data.domain.Beneficierpgm;

public interface BeneficierpgmRepository extends JpaRepository<Beneficierpgm, Long> {
	
	//liste des producteurs sensibilisés
	@Query("SELECT e FROM Beneficierpgm e INNER JOIN e.personne t where e.theme_id=?1 AND e.beneficierpgm_groupemod!=11")
	List<Beneficierpgm> fetchSensibliseData(Long theme_id);
	
	//liste des producteurs EFI	Petit élevage	CEP
	@Query("SELECT e FROM Beneficierpgm e INNER JOIN e.personne t where e.theme_id=?1")
	List<Beneficierpgm> fetchRenforcementData(Long theme_id);
	
	//liste des producteurs formés
	@Query("SELECT e FROM Beneficierpgm e INNER JOIN e.personne t where e.theme_id=?1 AND e.beneficierpgm_groupemod=11")
	List<Beneficierpgm> fetchFormeData(Long theme_id);
	
	@Transactional
	@Modifying
	@Query("delete from Beneficierpgm where id not in (Select min(id) " + "from Beneficierpgm "
			+ "group by personne_id, theme_id, beneficierpgm_date)")
	void deleteBeneficierPgmDudplicated();
	
	@Transactional
	@Modifying
	@Query("delete from Beneficierpgm where id not in (Select min(id) " + "from Beneficierpgm "
			+ "group by personne_id, theme_id)")
	void deleteVslaDudplicated();
	
	@Modifying
    @Transactional
    @Query("delete from Beneficierpgm e where id = ?1")
    void deleteBeneficierQuery(Long id);
	
	@Query("SELECT count(*) FROM Beneficierpgm")
    int CountBeneficierpgm();
	
	@Query("SELECT f FROM Beneficierpgm f WHERE f.id = ?1")
	Beneficierpgm findByIdBeneficierpgm(Long id);
	
	@Query("select count(*) from Beneficierpgm where beneficierpgm_groupemod =?1 AND beneficierpgm_valeur = ?2 AND beneficierpgm_date =?3 AND personne_id =?4 AND theme_id =?5")
	int detectDuplicated(Integer beneficierpgm_groupemod,Long beneficierpgm_valeur, Date beneficierpgm_date, Long personne_id,Long theme_id);
	
	@Query("select count(*) from Beneficierpgm where beneficierpgm_date =?1 AND personne_id =?2 AND theme_id =?3")
	int detectDuplicated125(Date beneficierpgm_date, Long personne_id,Long theme_id);
	
	@Query("select count(*) from Beneficierpgm where beneficierpgm_lieu =?1 AND beneficierpgm_speculation =?2 AND beneficierpgm_date =?3 AND personne_id= ?4 AND theme_id=?5")
	int detectDuplicated128(String beneficierpgm_lieu,String beneficierpgm_speculation, Date beneficierpgm_date, Long personne_id, Long theme_id);
	
	@Query("select count(*) from Beneficierpgm where beneficierpgm_lieu =?1 AND beneficierpgm_speculation =?2 AND beneficierpgm_date =?3 AND personne_id= ?4 AND theme_id=?5")
	int detectDuplicated214(String inscrismfr_anneesco, Date beneficierpgm_date, Long personne_id, Long theme_id);
	
	@Query("SELECT e FROM Beneficierpgm e INNER JOIN e.personne t where e.theme_id=?1 AND t.personne_nom=?2 AND e.beneficierpgm_date = ?3 ")
	List<Beneficierpgm> SelectSensibliseData(Long theme_id,String personne_nom,Date beneficierpgm_date);
	
	@Query("SELECT e FROM Beneficierpgm e where e.theme.theme_programme =?1")
	List<Beneficierpgm> list311(String theme_programme);
	
	//liste des producteurs sensibilisés
	@Query("SELECT e FROM Beneficierpgm e INNER JOIN e.personne t where e.theme_id=?1")
	List<Beneficierpgm> fetch144Data(Long theme_id);
	
	@Query("SELECT e FROM Beneficierpgm e where e.theme.theme_lib = '2.1.3'")
	List<Beneficierpgm> listBenef213();
	
	@Query("SELECT min(id) FROM Beneficierpgm b where b.personne_id = ?1 AND b.theme_id = ?2 AND b.beneficierpgm_date = ?3")
	Long VerifyDuplicatedCrud(Long personne_id, Long theme_id, Date beneficierpgm_date);

	@Transactional
	@Modifying
	@Query("delete from Beneficierpgm where id not in (Select min(id) " + "from Beneficierpgm "
			+ "group by personne_id, theme_id, beneficierpgm_date, beneficierpgm_speculation)")
	void deleteBeneficierPgmDudplicated2();
}

