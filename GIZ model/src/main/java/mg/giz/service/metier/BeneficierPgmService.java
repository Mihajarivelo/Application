package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Personne;

public interface BeneficierPgmService {
	public List<Beneficierpgm> createBeneficierpgm(String[][] ExcelToArray, Map<String, Integer> beneficierpgmMapping, String theme)
			throws ParseException;
	public List<Beneficierpgm> addCodePersonne(List<Long> codePersonne, List<Beneficierpgm> beneficierpgm);
	
	public List<Beneficierpgm> ListSensibilite(Long theme_id);
	
	public List<Beneficierpgm> ListRenforcement(Long theme_id);
	
	public void addBeneficierPgm(List<Beneficierpgm> beneficierpgm);
	
	public void deleteBeneficierDudplicated();
	
	public void deleteBeneficier(Long id);
	
	boolean saveCrudBeneficierpgm(Beneficierpgm Beneficierpgm);
	
	Beneficierpgm createBeneficierpgmCrud(Beneficierpgm beneficierpgm, Integer beneficierpgm_groupemod, Long beneficierpgm_valeur, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	Beneficierpgm create125Crud(Beneficierpgm beneficierpgm, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	Beneficierpgm create128Crud(Beneficierpgm beneficierpgm,String beneficierpgm_lieu,String beneficierpgm_speculation, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	Beneficierpgm create214Crud(Beneficierpgm beneficierpgm,String inscrismfr_anneesco, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	public int modifyCrudBeneficierpgm(Beneficierpgm beneficierpgmCreated, Integer beneficierpgm_groupemod,
			Long beneficierpgm_valeur, Date date, Long personne_id, Long theme_id);
	
	public int modifyCrudBeneficierpgm125(Beneficierpgm beneficierpgmCreated,Date beneficierpgm_date, Long personne_id, Long theme_id);
	
	public int modifyCrudBeneficierpgm214(Beneficierpgm beneficierpgm,String inscrismfr_anneesco, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	public int modifyCrudBeneficierpgm128(Beneficierpgm beneficierpgm,String beneficierpgm_lieu,String beneficierpgm_speculation, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	public List<Beneficierpgm> SelectSensiblData(Long theme_id,String personne_nom,Date beneficierpgm_date);
	
	public List<Beneficierpgm> ListFormes(Long theme_id);
	List<Long> beneficiaireVsla(List<Personne> personnes);
	void beneficierVsla(List<Long> codePersonne, List<Long> codeTheme);
	
	public List<Beneficierpgm> List311(String theme_programme);
	
	Beneficierpgm create311Crud(Beneficierpgm beneficierpgm,Long personne_id,Long theme_id);
	
	Beneficierpgm create228Crud(Beneficierpgm beneficierpgm, Date beneficierpgm_date,String beneficierpgm_lieu,String beneficierpgm_plandeviedeux,Long personne_id,Long theme_id);
	
	Beneficierpgm createBeneficierpgm3210Crud(Beneficierpgm beneficierpgm, Long beneficierpgm_valeur, Date beneficierpgm_date,Long personne_id,Long theme_id);
	
	public List<Beneficierpgm> List144(Long theme_id);
	
	Beneficierpgm createBenefigierpgm1410Crud(Beneficierpgm beneficierpgm, Long personne_id, Long theme_id, Date beneficierpgm_date);
	
	Beneficierpgm createBenefCrud213(Beneficierpgm beneficierpgm, Long personne_id, Long theme_id, String inscrismfr_niveau, String inscrismfr_anneesco, Date beneficierpgm_date);
	
	public List<Beneficierpgm> listBenef213();
	Long VerifyDuplicatedCrud(Long personne_id, Long theme_id, Date beneficierpgm_date);
	void deleteBeneficierDudplicatedCanevas2();
}
