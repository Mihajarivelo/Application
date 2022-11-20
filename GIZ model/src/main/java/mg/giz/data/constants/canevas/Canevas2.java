package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

/*
 * producteurs sensibilisés et formés
 */

public class Canevas2 {
	public static Map<String, String> NameTableCanevas2() {
		Map<String, String> NameTableCanevas2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas2.put("Nom", "personne_nom");
		NameTableCanevas2.put("Code Village", "code_fkt");
		NameTableCanevas2.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas2.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas2.put("Genre", "personne_genre");
		NameTableCanevas2.put("Groupe", "beneficierpgm_groupemod");
		NameTableCanevas2.put("Total Module éfféctué", "beneficierpgm_valeur");
		NameTableCanevas2.put("Date de sensibilisation", "beneficierpgm_date");
		NameTableCanevas2.put("Date de formation", "beneficierpgm_dateformation");
		NameTableCanevas2.put("CIN", "personne_cin");
		NameTableCanevas2.put("Adresse", "personne_adresse");
		NameTableCanevas2.put("Contact", "personne_contact");
		NameTableCanevas2.put("Nom Formateurs", "beneficierpgm_lieu");
		return NameTableCanevas2;
	}
}
