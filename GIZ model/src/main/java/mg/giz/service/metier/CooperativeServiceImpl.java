package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Suivithemecoop;
import mg.giz.repository.CooperativeRepository;

@Service
public class CooperativeServiceImpl implements CooperativeService {

	@Autowired
	CooperativeRepository repository;

	@Override
	public Iterable<Suivithemecoop> getAllSuivithemecoops() {
		return repository.findAll();
	}

	@Override
	public Suivithemecoop createSuivithemecoop(Suivithemecoop suivithemecoop) throws Exception {
		return suivithemecoop = repository.save(suivithemecoop);
	}

	@Override
	public Suivithemecoop getSuivithemecoopById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This cooperative strengthening no exist"));
	}

	@Override
	public Suivithemecoop updateSuivithemecoop(Suivithemecoop fromSuivithemecoop) throws Exception {
		Suivithemecoop toSuivithemecoop = getSuivithemecoopById(fromSuivithemecoop.getId());
		mapSuivithemecoop(fromSuivithemecoop, toSuivithemecoop);
		return repository.save(toSuivithemecoop);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapSuivithemecoop(Suivithemecoop from, Suivithemecoop to) {
		to.setSuivitheme_homme(from.getSuivitheme_homme());
		to.setSuivitheme_femme(from.getSuivitheme_femme());
		to.setSuivitheme_comm(from.getSuivitheme_comm());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteSuivithemecoop(Long id) throws Exception {
		Suivithemecoop suivithemecoop = getSuivithemecoopById(id);
		repository.delete(suivithemecoop);
	}
}
