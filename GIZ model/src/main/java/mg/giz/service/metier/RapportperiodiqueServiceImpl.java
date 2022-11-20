package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Rapportperiodique;
import mg.giz.repository.RapportperiodiqueRepository;

@Service
public class RapportperiodiqueServiceImpl implements RapportperiodiqueService {

	@Autowired
	RapportperiodiqueRepository repository;

	@Override
	public Iterable<Rapportperiodique> getAllRapportperiodiques() {
		return repository.findAll();
	}

	@Override
	public Rapportperiodique createRapportperiodique(Rapportperiodique rapportperiodique) throws Exception {
		return rapportperiodique = repository.save(rapportperiodique);
	}

	@Override
	public Rapportperiodique getRapportperiodiqueById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This periodic report no exist"));
	}

	@Override
	public Rapportperiodique updateRapportperiodique(Rapportperiodique fromRapportperiodique) throws Exception {
		Rapportperiodique toRapportperiodique = getRapportperiodiqueById(fromRapportperiodique.getId());
		mapRapportperiodique(fromRapportperiodique, toRapportperiodique);
		return repository.save(toRapportperiodique);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapRapportperiodique(Rapportperiodique from, Rapportperiodique to) {
		to.setRapportperiodique_type(from.getRapportperiodique_type());
		to.setRapportperiodique_typelib(from.getRapportperiodique_typelib());
		to.setRapportperiodique_situation(from.getRapportperiodique_situation());
		to.setRapportperiodique_valeur(from.getRapportperiodique_valeur());
		to.setRapportperiodique_comm(from.getRapportperiodique_comm());
		to.setIndicateur(from.getIndicateur());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteRapportperiodique(Long id) throws Exception {
		Rapportperiodique rapportperiodique = getRapportperiodiqueById(id);
		repository.delete(rapportperiodique);
	}

}
