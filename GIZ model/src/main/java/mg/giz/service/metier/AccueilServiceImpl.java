package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Accueil;
import mg.giz.repository.AccueilRepository;

@Service
public class AccueilServiceImpl implements AccueilService {

	@Autowired
	AccueilRepository repository;

	@Override
	public Iterable<Accueil> getAllAccueils() {
		return repository.findAll();
	}

	@Override
	public Accueil createAccueil(Accueil accueil) throws Exception {
		return accueil = repository.save(accueil);
	}

	@Override
	public Accueil getAccueilById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This page welcome no exist"));
	}

	@Override
	public Accueil updateAccueil(Accueil fromAccueil) throws Exception {
		Accueil toAccueil = getAccueilById(fromAccueil.getId());
		mapAccueil(fromAccueil, toAccueil);
		return repository.save(toAccueil);
	}

	protected void mapAccueil(Accueil from, Accueil to) {
		to.setAccueil_text1(from.getAccueil_text1());
		to.setAccueil_text2(from.getAccueil_text2());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteAccueil(Long id) throws Exception {
		Accueil accueil = getAccueilById(id);
		repository.delete(accueil);

	}

}
