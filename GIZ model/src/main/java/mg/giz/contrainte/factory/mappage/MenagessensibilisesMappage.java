package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class MenagessensibilisesMappage {
	public static Map<String, Integer> tableMenagessensibilisesMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> MenagessensibilisesMappageMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "menagessensibilise_date":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_date", index);
				break;
			case "menagessensibilise_lib":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_lib", index);
				break;
			case "menagessensibilise_homme":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_homme", index);
				break;
			case "menagessensibilise_femme":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_femme", index);
				break;
			case "menagessensibilise_garcon":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_garcon", index);
				break;
			case "menagessensibilise_fille":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("menagessensibilise_fille", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				MenagessensibilisesMappageMapping.put("code_fkt", index);
				break;
			}
		}
		return MenagessensibilisesMappageMapping;
	}
}
