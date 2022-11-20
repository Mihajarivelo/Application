package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Personne;

public interface PersonneService {
	public List<Personne> createPersonne(String[][] ExcelToArray, Map<String, Integer> PersonneMapping, String theme)
			throws ParseException;

	public void addPersonne(List<Personne> personnes);

	public void deletePersonneDuplicated();

	public Long findMaxId();

	public List<Long> findPersonne(List<Personne> personnes);

	public List<Long> findPersonneMfr(List<Personne> personnes);

	boolean saveCrudPersonne(Personne personne);

	Personne createPersonnerCrud(Personne personne, String personne_nom, String personne_genre, String code_fkt,
			Long personne_anneenaiss);

	Personne createPersonCrud125(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_cin, String personne_adresse,
			String personne_contact, String code_fkt);

	Personne createPersonnCrud128(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String code_fkt);

	public Long listPersonne(String personne_nom);
	
	public int modifyCrudPersonne(String personne_nom,String personne_genre, String code_fkt, Long personne_anneenaiss);
	
	public int modifyCrudPersonne125(String personne_nom, String personne_genre, String personne_lieunaiss,Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact, String code_fkt);
	
	Personne createPersonneCrud127(Personne personne, String personne_nom, String personne_genre, Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse, String personne_contact);

	public int modifyCrudPersonne128(String personne_nom, String personne_genre,String code_fkt);
	
	Personne createPersonneCrudHist(Personne personne, String personne_nom, String personne_genre, Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse, String code_fkt, String personne_contact);

	List<Personne> listPersonneVsla(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;

	void addPersonneVsla(List<Personne> personnes);

	List<Long> findPersonneVsla(List<Personne> personnes);

	List<Personne> addIdParentmfr(List<Personne> personnes, List<Long> IdParentsmfr);
	
	Personne createPersonCrudM12(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_cin, String personne_adresse,
			String personne_contact,String personne_affiliation, String code_fkt);

	public int modifyCrudPersonneM12(String personne_nom, String personne_genre, String personne_lieunaiss,Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact,String personne_affiliation, String code_fkt);
	
	Personne createPersonCrud321(Personne personne, String personne_nom, String personne_genre,String personne_lieunaiss, Long personne_anneenaiss, String code_fkt);
	
	Personne createPersonCrud323(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_contact, String code_fkt);
	
	Personne createPersonneCrud144(Personne personne, String personne_nom, String personne_genre, Long personne_anneenaiss, String code_fkt);
	
	Personne createPersonneCrud140(Personne personne, String personne_nom, String personne_genre, Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse, String code_fkt, String personne_contact, String personne_code);
	
	public List<Personne> findPersonne();
	
	Personne createPersonneCrud213(Personne personne, Long parentmfr_id, String personne_nom, String code_fkt, Long personne_anneenaiss, String personne_genre, String personne_adresse);
	
	Personne createPersonneCrud213M(Personne personne, String personne_nom, String code_fkt, Long personne_anneenaiss, String personne_genre, String personne_adresse);

	Long findPersonneCrud(String personne_nom, String personne_genre, String code_fkt);

	int del_doublon_personne();
}
