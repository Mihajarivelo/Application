package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Capitalisation;
import mg.giz.repository.CapitalisationRepository;

@Service
public class CapitalisationServiceImpl implements CapitalisationService {

	@Autowired
	CapitalisationRepository repository;

	@Override
	public Iterable<Capitalisation> getAllCapitalisations() {
		return repository.findAll();
	}

	@Override
	public Capitalisation createCapitalisation(Capitalisation capitalisation) throws Exception {
		return capitalisation = repository.save(capitalisation);
	}

	@Override
	public Capitalisation getCapitalisationById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This capitalisation no exist"));
	}

	@Override
	public Capitalisation updateCapitalisation(Capitalisation fromCapitalisation) throws Exception {
		Capitalisation toCapitalisation = getCapitalisationById(fromCapitalisation.getId());
		mapCapitalisation(fromCapitalisation, toCapitalisation);
		return repository.save(toCapitalisation);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapCapitalisation(Capitalisation from, Capitalisation to) {
		to.setCapitalisation_theme(from.getCapitalisation_theme());
		to.setCapitalisation_activite(from.getCapitalisation_activite());
		to.setCapitalisation_objectif(from.getCapitalisation_objectif());
		to.setCapitalisation_situationavant(from.getCapitalisation_situationavant());
		to.setCapitalisation_situationactuelle(from.getCapitalisation_situationactuelle());
		to.setCapitalisation_directement(from.getCapitalisation_directement());
		to.setCapitalisation_indirectement(from.getCapitalisation_indirectement());
		to.setCapitalisation_positif(from.getCapitalisation_positif());
		to.setCapitalisation_negatif(from.getCapitalisation_negatif());
		to.setCapitalisation_recommandation(from.getCapitalisation_recommandation());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteCapitalisation(Long id) throws Exception {
		Capitalisation capitalisation = getCapitalisationById(id);
		repository.delete(capitalisation);
	}
}
