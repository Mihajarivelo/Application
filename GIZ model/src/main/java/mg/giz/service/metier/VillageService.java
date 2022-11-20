package mg.giz.service.metier;

import java.util.List;

import mg.giz.data.domain.Village;

public interface VillageService {
	public String verifyVillage(String code_fkt);
	
	public List<Village> getAllVillage();

}
