package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Indicateur;
import mg.giz.repository.IndicateurCrudRepository;

@Service
public class IndicateurCrudServiceImpl implements IndicateurCrudService {

	@Autowired
	IndicateurCrudRepository repository;

	@Override
	public Iterable<Indicateur> getAllIndicateurs() {
		return repository.findAll();
	}

	@Override
	public Indicateur createIndicateur(Indicateur indicateur) throws Exception {
		return indicateur = repository.save(indicateur);
	}

	@Override
	public Indicateur getIndicateurById(String indicateur_id) throws Exception {
		return repository.findById(indicateur_id).orElseThrow(() -> new Exception("This Indicator no exist"));
	}

	@Override
	public Indicateur updateIndicateur(Indicateur fromIndicateur) throws Exception {
		Indicateur toIndicateur = getIndicateurById(fromIndicateur.getIndicateur_id());
		mapIndicateur(fromIndicateur, toIndicateur);
		return repository.save(toIndicateur);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapIndicateur(Indicateur from, Indicateur to) {
		to.setIndicateur_id(from.getIndicateur_id());
		to.setIndicateur_nom(from.getIndicateur_nom());
		to.setIndicateur_srcdonnees(from.getIndicateur_srcdonnees());
		to.setIndicateur_ennonceobjectif(from.getIndicateur_ennonceobjectif());
		to.setIndicateur_objectif(from.getIndicateur_objectif());
		to.setIndicateur_observation(from.getIndicateur_observation());
		to.setIndicateur_situationref(from.getIndicateur_situationref());
		to.setSouscomposante(from.getSouscomposante());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteIndicateur(String indicateur_id) throws Exception {
		Indicateur indicateur = getIndicateurById(indicateur_id);
		repository.delete(indicateur);
	}
}
