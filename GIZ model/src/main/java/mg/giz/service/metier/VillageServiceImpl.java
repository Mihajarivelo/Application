package mg.giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Village;
import mg.giz.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService {
	
	@Autowired
	private VillageRepository villageRepository;

	@Override
	public String verifyVillage(String code_fkt) {
		String village = villageRepository.verifyVillage(code_fkt);
		return village;
	}

	@Override
	public List<Village> getAllVillage() {
		return villageRepository.findAll();
	}

}
