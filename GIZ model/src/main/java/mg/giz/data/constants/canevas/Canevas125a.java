package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas125a {
	public static Map<String, String> NameTableCanevas125a() {
		Map<String, String> NameTableCanevas125a = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas125a.put("Nom", "personne_nom");
		NameTableCanevas125a.put("Code village", "code_fkt");
		NameTableCanevas125a.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas125a.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas125a.put("Genre", "personne_genre");
		NameTableCanevas125a.put("Date de formation", "beneficierpgm_date");
		NameTableCanevas125a.put("CIN", "personne_cin");
		NameTableCanevas125a.put("Adresse", "personne_adresse");
		NameTableCanevas125a.put("Contact", "personne_contact");
		return NameTableCanevas125a;
	}

}
