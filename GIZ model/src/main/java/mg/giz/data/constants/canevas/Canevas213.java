package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas213 {
	public static Map<String, String> NameTableCanevas213() {
		Map<String, String> NameTableCanevas231 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas231.put("Nom", "personne_nom");
		NameTableCanevas231.put("Code village (MFR)", "code_fkt");
		NameTableCanevas231.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas231.put("Genre", "personne_genre");
		NameTableCanevas231.put("Date d'inscription", "beneficierpgm_date");
		NameTableCanevas231.put("Niveau", "inscrismfr_niveau");
		NameTableCanevas231.put("Année scolaire", "inscrismfr_anneesco");
		NameTableCanevas231.put("Nom parents", "parentmfr_nom");
		NameTableCanevas231.put("Fonction parents", "parentmfr_fonction");
		NameTableCanevas231.put("Adresse élève", "personne_adresse");
		return NameTableCanevas231;
	}

}
