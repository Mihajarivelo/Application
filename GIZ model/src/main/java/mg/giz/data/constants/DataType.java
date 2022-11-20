package mg.giz.data.constants;

import java.util.Map;
import java.util.TreeMap;

public class DataType {

	// Entier = 0 date = 1 genre = 3 annee de naissance = 4 affiliation = 5 binaire
	// = 6 spéculation = 7

	public static int typeColumn(String colName) {
		Map<String, Integer> typeColumn = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		typeColumn.put("date formation", 1);
		typeColumn.put("groupe", 0);
		typeColumn.put("Nombre total élèves", 0);
		typeColumn.put("Nombre visiteurs", 0);
		typeColumn.put("Nombre de ménages", 0);
		typeColumn.put("Nombre cheptels", 0);
		typeColumn.put("Nombre bénéficiaires", 0);
		typeColumn.put("Taux de prévalence de la diarrhée par CSB (en %)", 0);
		typeColumn.put("Cycle", 0);
		typeColumn.put("total module", 0);
		typeColumn.put("Nombre jeunes", 0);
		typeColumn.put("Membre femme", 0);
		typeColumn.put("Membre homme", 0);
		typeColumn.put("Type", 0);
		typeColumn.put("Nombre homme", 0);
		typeColumn.put("Nombre femme", 0);
		typeColumn.put("Nombre garçon", 0);
		typeColumn.put("Nombre fille", 0);
		typeColumn.put("Nombre élèves Garçons", 0);
		typeColumn.put("Nombre élèves Filles", 0);
		typeColumn.put("Nombre de l'atélier", 0);
		typeColumn.put("Budget pour rehabilitation", 0);
		typeColumn.put("Budget pour salaire", 0);
		typeColumn.put("Budget pour fourniture", 0);
		typeColumn.put("Date subvention", 1);
		typeColumn.put("Date comptage", 1);
		typeColumn.put("Date bénéficiaire grants", 1);
		typeColumn.put("Date de vaccination", 1);
		typeColumn.put("date sensibilisation", 1);
		typeColumn.put("Date de participation", 1);
		typeColumn.put("Date d'évaluation", 1);
		typeColumn.put("Date concours", 1);
		typeColumn.put("Date de sortie", 1);
		typeColumn.put("Date de l'atelier", 1);
		typeColumn.put("Date de formation", 1);
		typeColumn.put("Date champions", 1);
		typeColumn.put("Date adduction d'eau", 1);
		typeColumn.put("Date d'inscription", 1);
		typeColumn.put("Date de création", 1);
		typeColumn.put("Date projet", 1);
		typeColumn.put("Date de création FR", 1);
		typeColumn.put("Date d'adhésion", 1);
		typeColumn.put("Date cycle", 1);
		typeColumn.put("Date de création VSLA", 1);
		typeColumn.put("Date de suivi", 1);
		typeColumn.put("Date du dialogue", 1);
		typeColumn.put("Date d'application", 1);
		typeColumn.put("Date de la formation post FBS", 1);
		typeColumn.put("genre", 3);
		typeColumn.put("Année de Naissance", 4);
		typeColumn.put("affiliation: adhérent/bénéficiaires", 5);
		typeColumn.put("Leader comité de jeunes", 6);
		typeColumn.put("Planification et adoption techniques améliorées", 6);
		typeColumn.put("Diversification culturale et vie associative", 6);
		typeColumn.put("Bancarisation et vie associative", 6);
		typeColumn.put("EFI", 6);
		typeColumn.put("Petit élevage", 6);
		typeColumn.put("CEP", 6);
		
		int type = typeColumn.get(colName);
		return type;
	}
}
