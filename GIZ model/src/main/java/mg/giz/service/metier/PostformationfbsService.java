package mg.giz.service.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Beneficierpgm;

public interface PostformationfbsService {

	List<Integer> searchIndex(ArrayList<ColumnStructure> columnStructure);

	List<Beneficierpgm> addPostformation(String[][] ExcelToArray, List<Integer> Index,
			ArrayList<ColumnStructure> columnStructure, String theme) throws ParseException;

	void addEFI(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void addPetitElevage(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void addCEP(List<Beneficierpgm> beneficiairePgrm, String[][] ExcelToArray, List<Integer> Index);

	void deleteDuplicated();

}
