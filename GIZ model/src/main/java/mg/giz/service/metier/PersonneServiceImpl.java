package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.contrainte.factory.mappage.PersonneMappage;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Parentmfr;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Village;
import mg.giz.repository.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService {
	@Autowired
	private PersonneRepository personneRepository;

	// private ThemeRepository themeRepository;

	@Override
	public List<Personne> createPersonne(String[][] ExcelToArray, Map<String, Integer> PersonneMapping, String theme)
			throws ParseException {

		int indice = -1;
		List<Personne> personnes = new ArrayList<>();

		for (int i = 1; i < ExcelToArray.length; i++) {
			Personne personne = new Personne();
			if (PersonneMapping.containsKey("code_fkt")) {
				indice = PersonneMapping.get("code_fkt");
				if (ExcelToArray[i][indice] != null) {
					Village vl = new Village(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
					personne.setVillage(vl);
					personne.setCode_fkt(ExcelToArray[i][indice].replaceAll("\\s", "").toUpperCase());
				}
			}

			if (PersonneMapping.containsKey("personne_adresse")) {
				indice = PersonneMapping.get("personne_adresse");
				personne.setPersonne_adresse(ExcelToArray[i][indice]);
			}

			if (PersonneMapping.containsKey("personne_affiliation")) {
				indice = PersonneMapping.get("personne_affiliation");
				personne.setPersonne_affiliation(ExcelToArray[i][indice].toLowerCase().trim());
			}

			if (PersonneMapping.containsKey("personne_anneenaiss")) {
				indice = PersonneMapping.get("personne_anneenaiss");
				try {
					double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
					personne.setPersonne_anneenaiss((long) doubleValue);
				} catch (Exception e) {

				}

				try {
					String dateString = ExcelToArray[i][indice];
					String[] dateParts = dateString.split("-");
					String years = dateParts[0];
					int valueDateNaiss = Integer.parseInt(years);
					personne.setPersonne_anneenaiss((long) valueDateNaiss);

				} catch (Exception e) {

				}
			}

			if (PersonneMapping.containsKey("personne_cin")) {
				indice = PersonneMapping.get("personne_cin");
				personne.setPersonne_cin(ExcelToArray[i][indice]);
			}

			if (PersonneMapping.containsKey("personne_code")) {
				indice = PersonneMapping.get("personne_code");
				personne.setPersonne_code(ExcelToArray[i][indice].trim());
			}

			if (PersonneMapping.containsKey("personne_contact")) {
				indice = PersonneMapping.get("personne_contact");
				personne.setPersonne_contact(ExcelToArray[i][indice]);
			}

			if (PersonneMapping.containsKey("personne_genre")) {
				indice = PersonneMapping.get("personne_genre");
				personne.setPersonne_genre(ExcelToArray[i][indice].trim().toUpperCase());
			}

			if (PersonneMapping.containsKey("personne_lieunaiss")) {
				indice = PersonneMapping.get("personne_lieunaiss");
				personne.setPersonne_lieunaiss(ExcelToArray[i][indice]);
			}

			if (PersonneMapping.containsKey("personne_nom")) {
				indice = PersonneMapping.get("personne_nom");
				personne.setPersonne_nom(ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
			}

			personnes.add(personne);
		}

		return personnes;
	}

	@Override
	public void addPersonne(List<Personne> personnes) {
		personneRepository.saveAll(personnes);
	}

	@Override
	public void deletePersonneDuplicated() {
		personneRepository.deletePersonneDuplicated();
	}
	
	@Override
	public int del_doublon_personne() {
		return personneRepository.del_doublon_personne();
	}

	@Override
	public Long findMaxId() {
		return personneRepository.findMaxId();
	}

	@Override
	public List<Long> findPersonne(List<Personne> personnes) {
		List<Long> IdPersonne = new ArrayList<>();

		for (int i = 0; i < personnes.size(); i++) {
			String nomPersonne = personnes.get(i).getPersonne_nom();
			String genrePersonne = personnes.get(i).getPersonne_genre();
			String fktPersonne = personnes.get(i).getCode_fkt();
			Long id = personneRepository.findPersonneHistorique(nomPersonne, genrePersonne, fktPersonne);

			IdPersonne.add(id);
		}
		return IdPersonne;
	}

	@Override
	public List<Long> findPersonneMfr(List<Personne> personnes) {
		List<Long> IdPersonne = new ArrayList<>();

		for (int i = 0; i < personnes.size(); i++) {
			String nomPersonne = personnes.get(i).getPersonne_nom();
			String genrePersonne = personnes.get(i).getPersonne_genre();
			String fktPersonne = personnes.get(i).getCode_fkt();
			Long id = personneRepository.findPersonneMfr(nomPersonne, genrePersonne, fktPersonne);
			IdPersonne.add(id);
		}
		return IdPersonne;
	}

	@Override
	public boolean saveCrudPersonne(Personne personne) {
		int countBeforeSave = personneRepository.CountPersonne();
		personneRepository.save(personne);
		personneRepository.deletePersonneDuplicated();
		int countAfterSave = personneRepository.CountPersonne();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Personne createPersonnerCrud(Personne personne, String personne_nom, String personne_genre, String code_fkt,
			Long personne_anneenaiss) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public Long listPersonne(String personne_nom) {
		return personneRepository.selectPerson(personne_nom);
	}

	@Override
	public int modifyCrudPersonne(String personne_nom, String personne_genre, String code_fkt,
			Long personne_anneenaiss) {
		int record = personneRepository.detectDuplicated(personne_nom, personne_genre, code_fkt, personne_anneenaiss);
		return record;
	}

	@Override
	public Personne createPersonCrud125(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_cin, String personne_adresse,
			String personne_contact, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_cin(personne_cin);
		personne.setPersonne_adresse(personne_adresse);
		personne.setPersonne_contact(personne_contact);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public int modifyCrudPersonne125(String personne_nom, String personne_genre, String personne_lieunaiss,
			Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact,
			String code_fkt) {
		int record = personneRepository.detectDuplicated125(personne_nom, personne_genre, personne_lieunaiss,
				personne_anneenaiss, personne_cin, personne_adresse, personne_contact, code_fkt);
		return record;
	}

	@Override
	public List<Personne> listPersonneVsla(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			String theme) throws ParseException {
		Map<String, Integer> PersonneMapping = PersonneMappage.tablePersonne(columnStructure);
		List<Personne> personnes = createPersonne(ExcelToArray, PersonneMapping, theme);
		return personnes;
	}

	@Override
	public Personne createPersonnCrud128(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public int modifyCrudPersonne128(String personne_nom, String personne_genre, String code_fkt) {
		int record = personneRepository.detectDuplicated128(personne_nom, personne_genre, code_fkt);
		return record;
	}

	@Override
	public Personne createPersonneCrud127(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse,
			String personne_contact) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_cin(personne_cin);
		personne.setPersonne_adresse(personne_adresse);
		personne.setPersonne_contact(personne_contact);
		return personne;
	}

	@Override
	public void addPersonneVsla(List<Personne> personnes) {
		personneRepository.saveAll(personnes);
		personneRepository.deletePersonneDuplicated();
		;
	}

	@Override
	public List<Long> findPersonneVsla(List<Personne> personnes) {
		List<Long> IdPersonne = new ArrayList<>();

		for (int i = 0; i < personnes.size(); i++) {
			String nomPersonne = personnes.get(i).getPersonne_nom();
			String genrePersonne = personnes.get(i).getPersonne_genre();
			String fktPersonne = personnes.get(i).getCode_fkt();
			Long id = personneRepository.findPersonneVsla(nomPersonne, genrePersonne, fktPersonne);
			IdPersonne.add(id);
		}
		return IdPersonne;
	}

	@Override
	public List<Personne> addIdParentmfr(List<Personne> personnes, List<Long> IdParentsmfr) {
		for (int i = 0; i < personnes.size(); i++) {
			if (IdParentsmfr.get(i) != null) {
				Parentmfr pmfr = new Parentmfr(IdParentsmfr.get(i));
				personnes.get(i).setParentmfr(pmfr);
			}
		}
		return personnes;
	}

	@Override
	public Personne createPersonneCrudHist(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse,
			String code_fkt, String personne_contact) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_cin(personne_cin);
		personne.setPersonne_adresse(personne_adresse);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}
		personne.setPersonne_contact(personne_contact);
		return personne;
	}

	@Override
	public Personne createPersonCrudM12(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_cin, String personne_adresse,
			String personne_contact, String personne_affiliation, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_cin(personne_cin);
		personne.setPersonne_adresse(personne_adresse);
		personne.setPersonne_contact(personne_contact);
		personne.setPersonne_affiliation(personne_affiliation);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public int modifyCrudPersonneM12(String personne_nom, String personne_genre, String personne_lieunaiss,
			Long personne_anneenaiss, String personne_cin, String personne_adresse, String personne_contact,
			String personne_affiliation, String code_fkt) {
		int record = personneRepository.detectDuplicatedM12(personne_nom, personne_genre, code_fkt, personne_lieunaiss,
				personne_anneenaiss, personne_cin, personne_adresse, personne_contact, personne_affiliation);
		return record;
	}

	@Override
	public Personne createPersonCrud321(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public Personne createPersonCrud323(Personne personne, String personne_nom, String personne_genre,
			String personne_lieunaiss, Long personne_anneenaiss, String personne_contact, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_contact(personne_contact);

		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}

		return personne;
	}

	@Override
	public Personne createPersonneCrud144(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String code_fkt) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}
		
		return personne;
	}

	@Override
	public Personne createPersonneCrud140(Personne personne, String personne_nom, String personne_genre,
			Long personne_anneenaiss, String personne_lieunaiss, String personne_cin, String personne_adresse,
			String code_fkt, String personne_contact, String personne_code) {
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_lieunaiss(personne_lieunaiss);
		personne.setPersonne_cin(personne_cin);
		personne.setPersonne_adresse(personne_adresse);
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}
		personne.setPersonne_contact(personne_contact);
		personne.setPersonne_code(personne_code);
		
		return personne;
	}

	@Override
	public List<Personne> findPersonne() {
		return personneRepository.findPersonne();
	}

	@Override
	public Personne createPersonneCrud213(Personne personne, Long parentmfr_id, String personne_nom, String code_fkt,
			Long personne_anneenaiss, String personne_genre, String personne_adresse) {
		
		if(parentmfr_id > 0) {
			Parentmfr pf = new Parentmfr(parentmfr_id);
			personne.setParentmfr(pf);
		}
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}
		
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_adresse(personne_adresse);
		
		return personne;
	}

	@Override
	public Personne createPersonneCrud213M(Personne personne, String personne_nom, String code_fkt,
			Long personne_anneenaiss, String personne_genre, String personne_adresse) {
		if (code_fkt != "") {
			Village vl = new Village(code_fkt);
			personne.setVillage(vl);
		}
		
		personne.setPersonne_nom(personne_nom);
		personne.setPersonne_anneenaiss(personne_anneenaiss);
		personne.setPersonne_genre(personne_genre);
		personne.setPersonne_adresse(personne_adresse);
		
		return personne;
	}
	
	@Override
	public Long findPersonneCrud(String personne_nom, String personne_genre, String code_fkt) {
		Long personneId = personneRepository.findPersonne(personne_nom, personne_genre, code_fkt);
		return personneId;
		
	}
	
}
