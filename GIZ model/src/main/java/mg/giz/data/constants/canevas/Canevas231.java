package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas231 {
	public static Map<String, String> NameTableCanevas231() {
		Map<String, String> NameTableCanevas231 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas231.put("Nom", "personne_nom");
		NameTableCanevas231.put("Code village", "code_fkt");
		NameTableCanevas231.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas231.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas231.put("Genre", "personne_genre");
		NameTableCanevas231.put("Date de suivi", "beneficierpgm_date");
		NameTableCanevas231.put("CIN", "personne_cin");
		NameTableCanevas231.put("affiliation: adhérent/bénéficiaires", "personne_affiliation");
		NameTableCanevas231.put("Adresse", "personne_adresse");
		NameTableCanevas231.put("Contact", "personne_contact");
		return NameTableCanevas231;
	}

}
