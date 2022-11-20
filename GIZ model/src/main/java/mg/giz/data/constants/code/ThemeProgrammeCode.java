package mg.giz.data.constants.code;

import java.util.HashMap;
import java.util.Map;

public class ThemeProgrammeCode {
	public static String themeProgrammeCode(String theme) {
		Map<String, String> themeProgrammeCode = new HashMap<String, String>();
		themeProgrammeCode.put("2.1.1", "MFR");
		themeProgrammeCode.put("3.1.4", "VSLA");
		themeProgrammeCode.put("3.1.7", "VSLA fonctionnels");
		themeProgrammeCode.put("1.2.2", "FBS");
		themeProgrammeCode.put("2.3.1", "Mahavelona");
		themeProgrammeCode.put("3.1.8", "Mahavelona");
		
		return themeProgrammeCode.get(theme);
	}

}
