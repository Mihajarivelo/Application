package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas128 {
	public static Map<String, String> NameTableCanevas128() {
		Map<String, String> NameTableCanevas128 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas128.put("Nom", "personne_nom");
		NameTableCanevas128.put("Code village", "code_fkt");
		NameTableCanevas128.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas128.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas128.put("Genre", "personne_genre");
		NameTableCanevas128.put("Date de formation", "beneficierpgm_date");
		NameTableCanevas128.put("CIN", "personne_cin");
		NameTableCanevas128.put("Adresse", "personne_adresse");
		NameTableCanevas128.put("Contact", "personne_contact");
		NameTableCanevas128.put("Spéculation", "beneficierpgm_speculation");
		NameTableCanevas128.put("Nom Formateur", "beneficierpgm_lieu");
		return NameTableCanevas128;
	}
}
