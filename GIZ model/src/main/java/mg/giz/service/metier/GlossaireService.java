package mg.giz.service.metier;

import mg.giz.data.domain.Glossaire;

public interface GlossaireService {

	public Iterable<Glossaire> getAllGlossaires();

	public Glossaire createGlossaire(Glossaire glossaire) throws Exception;

	public Glossaire getGlossaireById(Long id) throws Exception;

	public Glossaire updateGlossaire(Glossaire glossaire) throws Exception;

	public void deleteGlossaire(Long id) throws Exception;
}
