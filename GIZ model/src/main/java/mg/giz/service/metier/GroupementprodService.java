package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.domain.Groupementprod;

public interface GroupementprodService {
	public List<Groupementprod> createGroupementprod(String[][] ExcelToArray,
			Map<String, Integer> groupementprodMapping, String theme) throws ParseException;

	public void addGroupementprod(List<Groupementprod> groupementprods);

	public void deleteGroupementprodDudplicated();
	
	public String verifyGroupementprod(String groupementprod);
	
	List<Long> findGroupement(List<Groupementprod> groupementprods);
	
	List<Groupementprod> listGroupementprod(ArrayList<ColumnStructure> columnStructure, String[][] ExcelToArray, String theme)
			throws ParseException;
	
	boolean saveGroupemenentprod(Groupementprod groupementprod);
	
	Groupementprod createGroupementprodCrud(Groupementprod groupementprod, String groupementprod_nom, String code_fkt, Date groupementprod_date, String groupementprod_service);

	public List<Groupementprod> listGroupementprod();
}
