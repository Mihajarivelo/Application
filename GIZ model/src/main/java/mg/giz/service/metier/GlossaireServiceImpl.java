package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Glossaire;
import mg.giz.repository.GlossaireRepository;

@Service
public class GlossaireServiceImpl implements GlossaireService {

	@Autowired
	GlossaireRepository repository;

	@Override
	public Iterable<Glossaire> getAllGlossaires() {
		return repository.findAll();
	}

	@Override
	public Glossaire createGlossaire(Glossaire glossaire) throws Exception {
		return glossaire = repository.save(glossaire);
	}

	@Override
	public Glossaire getGlossaireById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This glossaire no exist"));
	}

	@Override
	public Glossaire updateGlossaire(Glossaire fromGlossaire) throws Exception {
		Glossaire toGlossaire = getGlossaireById(fromGlossaire.getId());
		mapGlossaire(fromGlossaire, toGlossaire);
		return repository.save(toGlossaire);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapGlossaire(Glossaire from, Glossaire to) {
		to.setGlossaire_theme(from.getGlossaire_theme());
		to.setGlossaire_desc(from.getGlossaire_desc());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteGlossaire(Long id) throws Exception {
		Glossaire glossaire = getGlossaireById(id);
		repository.delete(glossaire);
	}
}
