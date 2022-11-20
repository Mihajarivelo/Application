package mg.giz.service.metier;

import mg.giz.data.domain.Accueil;

public interface AccueilService {

	public Iterable<Accueil> getAllAccueils();

	public Accueil createAccueil(Accueil accueil) throws Exception;

	public Accueil getAccueilById(Long id) throws Exception;

	public Accueil updateAccueil(Accueil accueil) throws Exception;

	public void deleteAccueil(Long id) throws Exception;
}
