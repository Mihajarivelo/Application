package mg.giz.service.metier;

import mg.giz.data.domain.Rapportperiodique;

public interface RapportperiodiqueService {
	
	public Iterable<Rapportperiodique> getAllRapportperiodiques();

	public Rapportperiodique createRapportperiodique(Rapportperiodique rapportperiodique) throws Exception;

	public Rapportperiodique getRapportperiodiqueById(Long id) throws Exception;

	public Rapportperiodique updateRapportperiodique(Rapportperiodique rapportperiodique) throws Exception;

	public void deleteRapportperiodique(Long id) throws Exception;

}
