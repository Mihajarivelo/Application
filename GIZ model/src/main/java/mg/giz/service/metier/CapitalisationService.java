package mg.giz.service.metier;

import mg.giz.data.domain.Capitalisation;

public interface CapitalisationService {

	public Iterable<Capitalisation> getAllCapitalisations();

	public Capitalisation createCapitalisation(Capitalisation capitalisation) throws Exception;

	public Capitalisation getCapitalisationById(Long id) throws Exception;

	public Capitalisation updateCapitalisation(Capitalisation capitalisation) throws Exception;

	public void deleteCapitalisation(Long id) throws Exception;
}
