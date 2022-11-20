package mg.giz.service.metier;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import mg.giz.data.domain.Otiv;

public interface OtivService {
	public List<Otiv> createOtiv(String[][] ExcelToArray, Map<String, Integer> OtivMapping, String theme)
			throws ParseException;

	public void addOtiv(List<Otiv> otivs);

	public void deleteOtivDuplicated();

	public List<Integer> findOtiv(List <Otiv> otivs);
	
	public int selectOtiv(String otiv_code);
	
	boolean saveCrudOtiv(Otiv otiv);
	
	Otiv createOtivCrud(Otiv otiv, String otiv_code);
	
}
