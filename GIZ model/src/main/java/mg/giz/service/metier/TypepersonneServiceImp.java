package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.repository.TypepersonneRepository;

@Service
public class TypepersonneServiceImp implements TypepersonneService {

	@Autowired
	TypepersonneRepository typepersonneRepository;

	@Override
	public int findIdTypePersonne(String typepersonne_nom) {
		return typepersonneRepository.findIdTypePersonne(typepersonne_nom);
	}	
}
