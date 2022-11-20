package mg.giz.data.constants.code;

import java.util.HashMap;
import java.util.Map;

public class TypePersonneCode {
	public static int typePersonneCode(String theme) {
		Map<String, Integer> TypePersonneCode = new HashMap<String, Integer>();
		TypePersonneCode.put("1.2.1", 1);
		TypePersonneCode.put("1.2.7", 2);
		TypePersonneCode.put("1.2.9", 3);
		TypePersonneCode.put("1.3.1", 7);
		TypePersonneCode.put("1.3.2", 4);
		TypePersonneCode.put("1.3.6", 5);
		TypePersonneCode.put("3.3.a", 6);
		TypePersonneCode.put("1.4.0", 8);
		
		return TypePersonneCode.get(theme);
	}

}
