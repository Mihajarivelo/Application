package mg.giz.data.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldName {

	// Colonnes obligatoire
	public static List<String> requiredField(String theme) {
		Map<String, List<String>> requiredField = new HashMap<String, List<String>>();
		List<String> requiredFieldTheme = new ArrayList<String>();

		requiredField.put("1.2.1", Arrays.asList("Nom Formateur", "Genre", "Date de formation"));
		requiredField.put("1.2.2", Arrays.asList("Nom", "Code Village", "Genre", "Groupe","Total Module éfféctué","Date de sensibilisation"));
		requiredField.put("3.2.1", Arrays.asList("Nombre jeunes", "Code village","Date de participation"));
		requiredField.put("3.2.2", Arrays.asList("Nom", "Code village", "Année de naissance","Genre","Date d'évaluation"));
		requiredField.put("3.2.3", Arrays.asList("Nom", "Code village","Genre","Date de complétion"));
		requiredField.put("3.2.4", Arrays.asList("Nombre jeunes", "Code village","Date de participation"));
		requiredField.put("3.2.5", Arrays.asList("Nom", "Code village","Genre","Date d'évaluation"));
		requiredField.put("3.2.6", Arrays.asList("Nom", "Code village","Genre","Date d'obtention"));
		requiredField.put("2.2.8", Arrays.asList("Nom", "Code village","Genre","Date concours"));
		requiredField.put("2.1.4", Arrays.asList("Nom", "Code village","Genre","Date de sortie"));
		requiredField.put("2.1.6", Arrays.asList("Nom", "Code village", "Année de naissance","Genre","Date de formation"));
		requiredField.put("1.3.7", Arrays.asList("Nom", "Code village","Genre","Date de formation"));
		requiredField.put("1.2.8", Arrays.asList("Nom", "Code village","Genre","Date de formation","Spéculation"));
		requiredField.put("1.2.7", Arrays.asList("Nom", "Genre", "Code village", "Date d'évaluation"));
		requiredField.put("1.3.9", Arrays.asList("Nom propriétaire ferme", "Genre", "Code village", "Date d'évaluation"));
		requiredField.put("1.2.9", Arrays.asList("Nom", "Genre", "Code village", "Date d'évaluation"));
		requiredField.put("1.3.1", Arrays.asList("Nom ASA", "Genre", "Code village", "Date de formation"));
		requiredField.put("1.3.2", Arrays.asList("Nom ASA", "Genre", "Code village", "Date d'évaluation"));
		requiredField.put("1.3.6", Arrays.asList("Nom Formateur", "Genre", "Code village", "Date d'évaluation"));
		requiredField.put("3.3.a", Arrays.asList("Nom champions", "Genre", "Code village", "Date de suivi"));
		requiredField.put("2.1.3", Arrays.asList("Nom", "Genre", "Code village (MFR)", "Date d'inscription"));
		requiredField.put("2.1.1", Arrays.asList("Code village", "Date de suivi"));
		requiredField.put("2.1.5", Arrays.asList("Nom", "Genre", "Code village", "Activités validées", "Activités réalisées", "Date d'évaluation"));
		requiredField.put("3.1.1", Arrays.asList("Nom", "Genre", "Code village", "Date bénéficiaire grants"));
		requiredField.put("3.1.3", Arrays.asList("Date de suivi", "Code village", "Nombre de ménages"));
		requiredField.put("3.1.5", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date d'évaluation"));
		requiredField.put("1.4.1", Arrays.asList("Nom groupement", "Code village","Date de suivi"));
		requiredField.put("1.2.5a", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date de formation"));
		requiredField.put("1.2.5b", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date de formation"));
		requiredField.put("1.2.5c", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date de formation"));
		requiredField.put("1.2.6a", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date d'évaluation"));
		requiredField.put("1.2.6b", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date d'évaluation"));
		requiredField.put("1.2.6c", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date d'évaluation"));
		requiredField.put("2.3.1", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date de suivi", "affiliation: adhérent/bénéficiaires"));
		requiredField.put("3.1.8", Arrays.asList("Nom", "Genre", "Année de naissance", "Code village", "Date de suivi", "affiliation: adhérent/bénéficiaires"));
		requiredField.put("3.1.4", Arrays.asList("Code village", "Nom groupe VSLA", "Nom","Genre", "Date de création VSLA"));
		requiredField.put("1.1.5", Arrays.asList("Nom", "Genre", "Code village", "Date de suivi","Type"));
		requiredField.put("1.4.0", Arrays.asList("Nom", "Genre", "Code village","Date de suivi"));
		requiredField.put("3.3.1", Arrays.asList("Code village", "Date de sensibilisation", "Thème de sensibilisation", "Nombre homme", "Nombre femme", "Nombre garçon", "Nombre fille"));
		requiredField.put("2.2.4", Arrays.asList("Code village", "Nom école", "Nombre élèves Garçons", "Nombre élèves Filles", "Date comptage","Nombre total élèves"));
		requiredField.put("2.2.5", Arrays.asList("Code village", "Nom école", "Nom enseignant", "Genre", "Date de formation", "Classe"));
		requiredField.put("2.3.8", Arrays.asList("Code village", "Date adduction d'eau"));
		requiredField.put("4.4.1", Arrays.asList("Code village", "Nombre de l'atélier", "Date de l'atelier"));
		requiredField.put("3.1.7", Arrays.asList("Nom","Code village", "Nom groupe VSLA","Genre", "Date de suivi"));
		requiredField.put("1.3.10", Arrays.asList("Nom","Code village", "Nom groupe VSLA","Genre", "Date de suivi"));
		requiredField.put("1.4.6", Arrays.asList("Code village", "Nombre Homme","Nombre Femme", "Date du dialogue"));
		requiredField.put("2.2.7", Arrays.asList("Code village", "Type d'école","Date d'application"));
		requiredField.put("2.2.6", Arrays.asList("Code village", "Nom école","Nom enseignant","Genre","Date d'application"));
		requiredField.put("1.4.4", Arrays.asList("Nom leaders coachés", "Code village","Genre","Date d'évaluation"));
		requiredField.put("1.4.5", Arrays.asList("Nom leader formés", "Code village","Genre","Date d'évaluation"));
		requiredField.put("1.4.10", Arrays.asList("Nom leaders groupement de producteurs", "Code village","Genre","Date d'évaluation"));
		requiredField.put("2.3.3", Arrays.asList("Taux de prévalence de la diarrhée par CSB (en %)", "Code village","Date d'évaluation"));
		requiredField.put("1.3.4", Arrays.asList("Nombre bénéficiaires", "Code village","Date de suivi"));
		requiredField.put("1.3.5", Arrays.asList("Nombre cheptels", "Code village","Date de vaccination"));
		requiredField.put("1.3.8", Arrays.asList("Nom", "Code village","Genre","Date de suivi"));
		requiredField.put("1.3.10", Arrays.asList("Nom propriétaire ferme", "Code village","Date d'évaluation","Nombre visiteurs"));
		requiredField.put("3.2.10", Arrays.asList("Nom", "Code village","Genre","Date d'adhésion","Leader comité de jeunes"));
		requiredField.put("2.2.1", Arrays.asList("Nom école", "Code village","Budget pour rehabilitation","Budget pour salaire","Budget pour fourniture","Année scolaire","Date subvention"));
		requiredField.put("1.2.6", Arrays.asList("Nom", "Code village","Genre","Planification et adoption techniques améliorées","Diversification culturale et vie associative","Bancarisation et vie associative","Date d'évaluation"));
		requiredField.put("1.2.5", Arrays.asList("Nom", "Code village","Genre","EFI","Petit élevage","CEP","Date de la formation post FBS"));
		
		requiredFieldTheme = requiredField.get(theme);
		requiredFieldTheme.replaceAll(String::toLowerCase);
		return requiredFieldTheme;
	}

	// Colonnes optionnelles
	public static List<String> optionalField(String theme) {
		Map<String, List<String>> optionalField = new HashMap<String, List<String>>();
		List<String> optionalFieldTheme = new ArrayList<String>();

		optionalField.put("1.2.1", Arrays.asList("Contact", "Adresse", "Observation","Fonction"));
		optionalField.put("1.2.2", Arrays.asList("Lieu de naissance", "Date de formation", "CIN", "adresse", "contact", "Nom Formateurs", "Année de Naissance"));
		optionalField.put("3.2.1", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.2.2", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("3.2.3", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.2.5", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.2.6", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("2.2.8", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance", "Ecole", "Classe"));
		optionalField.put("2.1.4", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("2.1.6", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.3.7", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("1.2.8", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance","Nom Formateur"));
		optionalField.put("1.2.7", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance","Spéculation"));
		optionalField.put("1.3.9", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance", "Nom de la Ferme"));
		optionalField.put("1.2.9", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance", "Spéculation"));
		optionalField.put("1.3.1", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("1.3.2", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("1.3.6", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.3.a", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("2.1.3", Arrays.asList("Nom parents", "Fonction parents", "Année de naissance", "Niveau", "Année scolaire","Adresse élève"));
		optionalField.put("2.1.5", Arrays.asList("Code OTIV","Lieu de naissance", "Année de naissance", "CIN", "Remarque", "Contact", "Promotion"));
		optionalField.put("3.1.1", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.1.5", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.5a", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.5b", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.5c", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.6a", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.6b", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.6c", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("2.3.1", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("3.1.8", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.1.5", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("1.4.0", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance", "Code prod SYM"));
		optionalField.put("2.3.8", Arrays.asList("village", "Observation"));
		optionalField.put("3.1.4", Arrays.asList("Année de naissance"));
		optionalField.put("3.1.7", Arrays.asList("Année de naissance"));
		optionalField.put("2.1.1", Arrays.asList("Village"));
		optionalField.put("2.2.5", Arrays.asList("Fonction", "Adresse de l'enseignant"));
		optionalField.put("2.2.6", Arrays.asList("Classe","Fonction" ));
		optionalField.put("1.4.4", Arrays.asList("Année de naissance"));
		optionalField.put("1.4.5", Arrays.asList("Année de naissance"));
		optionalField.put("1.4.10", Arrays.asList("Année de naissance"));
		optionalField.put("1.3.8", Arrays.asList("Lieu de naissance", "CIN", "Adresse", "Contact", "Année de naissance"));
		optionalField.put("3.2.10", Arrays.asList("Année de naissance"));
		optionalField.put("2.2.7", Arrays.asList("Nom école"));
		optionalField.put("1.4.1", Arrays.asList("Service/Projet"));
		optionalField.put("1.2.6", Arrays.asList("Année de Naissance", "Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("1.2.5", Arrays.asList("Année de Naissance", "Lieu de naissance", "CIN", "Adresse", "Contact"));
		optionalField.put("4.4.1", Arrays.asList("Village"));

		try {
			optionalFieldTheme = optionalField.get(theme);
			optionalFieldTheme.replaceAll(String::toLowerCase);
		} catch (Exception e) {
			return optionalFieldTheme;
		}
		return optionalFieldTheme;
	}

	// Colonnes obligatoires + colonnes facultatifs
	public static List<String> allFieldTheme(String theme) {
		List<String> requiredFieldTheme = requiredField(theme);
		List<String> optionalFielddTheme = optionalField(theme);

		List<String> allFieldTheme = new ArrayList<String>(requiredFieldTheme);
		try {
			allFieldTheme.addAll(optionalFielddTheme);
		} catch (Exception e) {
			return requiredFieldTheme;
		}
		return allFieldTheme;

	}
}
