package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Kitmadera;

public interface KitmaderaService {

	List<Kitmadera> createKitmadera(String[][] ExcelToArray, Map<String, Integer> kitmaderaMapping, String theme)
			throws ParseException;

	void addKitmadera(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException;

	List<Kitmadera> addCodeEpp(List<Long> codeEpp, List<Kitmadera> Kitmadera);

}
