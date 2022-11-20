package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

/*
 * formateurs FBS formés
 */

public class canevas1 {
	public static Map<String, String> NameTableCanevas1() {
		Map<String, String> NameTableCanevas1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas1.put("Nom Formateur","formateur_nom");
		NameTableCanevas1.put("Genre","formateur_genre");
		NameTableCanevas1.put("Date de formation","formateur_date");
		NameTableCanevas1.put("Contact","formateur_contact");
		NameTableCanevas1.put("Adresse","formateur_adresse");
		NameTableCanevas1.put("Observation","formateur_observation");
		NameTableCanevas1.put("Fonction","formateur_fonction");
		return NameTableCanevas1;
	}

}
