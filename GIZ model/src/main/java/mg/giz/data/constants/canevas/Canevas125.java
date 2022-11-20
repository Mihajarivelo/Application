package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas125 {
	public static Map<String, String> NameTableCanevas125() {
		Map<String, String> NameTableCanevas125 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas125.put("Nom", "personne_nom");
		NameTableCanevas125.put("Code village", "code_fkt");
		NameTableCanevas125.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas125.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas125.put("Genre", "personne_genre");
		NameTableCanevas125.put("Date de la formation post FBS", "beneficierpgm_date");
		NameTableCanevas125.put("CIN", "personne_cin");
		NameTableCanevas125.put("Adresse", "personne_adresse");
		NameTableCanevas125.put("Contact", "personne_contact");
		return NameTableCanevas125;
	}

}
