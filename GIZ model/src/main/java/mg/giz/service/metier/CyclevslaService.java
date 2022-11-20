package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Cyclevsla;

public interface CyclevslaService {
	public List<Cyclevsla> createCyclevsla(String[][] ExcelToArray, Map<String, Integer> cyclevslaMapping,
			String theme) throws ParseException;

	List<Cyclevsla> listCyclevsla(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;

	void addCycleVsla(List<Cyclevsla> cyclevslas);

}
