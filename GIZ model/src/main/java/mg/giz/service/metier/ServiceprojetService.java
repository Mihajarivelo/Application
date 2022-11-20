package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Serviceprojet;

public interface ServiceprojetService {
	public List<Serviceprojet> createServiceprojet(String[][] ExcelToArray, Map<String, Integer> serviceprojetMapping)
			throws ParseException;

	void addServiceprojet(List<Serviceprojet> serviceprojets);

	List<Long> findServiceprojet(List<Serviceprojet> serviceprojets);

	List<Serviceprojet> listServiceprojet(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray)
			throws ParseException;

}
