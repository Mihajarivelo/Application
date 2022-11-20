package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Beneficierpgm;

public interface BonnepratiquefbsService {

	List<Integer> searchIndex(ArrayList<ColumnStructure> columnStructure);

	void addPlanification(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void addDiversification(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void addBancarisation(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void deleteDuplicated();

	List<Beneficierpgm> addBonnepratique(String[][] ExcelToArray, List<Integer> Index,
			ArrayList<ColumnStructure> columnStructure, String theme) throws ParseException;

}
