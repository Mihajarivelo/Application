package mg.giz.data.constants.theme;

public class GetTheme {
	public static String[][] getTheme(String sc) {

		switch (sc) {
		case "1-1":
			return Themes11.theme11();
		case "1-2":
			return Themes12.theme12();
		case "1-2bis":
			return Themes12.theme12bis();
		case "1-3":
			return Themes13.theme13();
		case "1-4":
			return Themes14.theme14();
		case "2-1":
			return Themes21.theme21();
		case "2-2":
			return Themes22.theme22();
		case "2-3":
			return Themes23.theme23();
		case "3-1":
			return Themes31.theme31();
		case "3-2":
			return Themes32.theme32();
		case "3-3":
			return Themes33.theme33();
		case "4-4":
			return Themes44.theme44();
		}
		return null;
	}

}
