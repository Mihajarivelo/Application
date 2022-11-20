package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Projetmfr;

public interface ProjetmfrService {
	public List<Projetmfr> createProjetmfr(String[][] ExcelToArray, Map<String, Integer> projetmfrMapping, String theme)
			throws ParseException;

	public void addProjetmfr(List<Projetmfr> projetmfrs);

	public void deleteProjetmfrDuplicated();
	
	List<Projetmfr> addIdPersonneOtiv(List<Long> codePersonne, List<Integer> codeOtiv, List<Projetmfr> projetmfr);
	
	boolean saveCrudProjetmfr(Projetmfr projetmfr);
	
	Projetmfr createProjetmrfCrud215(Projetmfr projetmfr, Long personne_id, int otiv_id, Date projetmfr_date, String projetmfr_promotion, String projetmfr_realisees, String projetmfr_validees, String projetmfr_remarque);
	
	public List<Projetmfr> listProjetmfr();

}
