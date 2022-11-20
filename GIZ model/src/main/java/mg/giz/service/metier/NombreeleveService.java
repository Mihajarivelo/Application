package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Nombreeleve;

public interface NombreeleveService {

	List<Nombreeleve> addCodeEpp(List<Long> codeEpp, List<Nombreeleve> nombreeleve);

	List<Nombreeleve> createNombreeleve(String[][] ExcelToArray, Map<String, Integer> nombreeleveMapping, String theme)
			throws ParseException;

	void addNombreeleve(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme,
			List<Ecoleepp> ecoleepps) throws ParseException;
	
	boolean saveCrudNombreeleve(Nombreeleve nombreeleve);
	
	Nombreeleve createNombreeleveCrud(Nombreeleve nombreeleve, Long ecoleepp_id, Long nombreeleve_garcon, Long nombreeleve_fille, Date nombreeleve_date);
	
	public List<Nombreeleve> listNombreeleve();
}
