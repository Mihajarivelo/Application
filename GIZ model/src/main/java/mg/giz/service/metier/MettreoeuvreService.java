package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Groupementprod;
import mg.giz.data.domain.Mettreoeuvre;
import mg.giz.data.domain.Serviceprojet;

public interface MettreoeuvreService {
	public List<Mettreoeuvre> createMettreoeuvre(String[][] ExcelToArray, Map<String, Integer> mettreoeuvreMapping)
			throws ParseException;

	void addMettreoeuvre(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray,
			List<Serviceprojet> serviceprojets, List<Groupementprod> groupementprods) throws ParseException;

}
