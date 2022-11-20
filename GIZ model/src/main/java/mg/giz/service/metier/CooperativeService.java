package mg.giz.service.metier;

import mg.giz.data.domain.Suivithemecoop;

public interface CooperativeService {

	public Iterable<Suivithemecoop> getAllSuivithemecoops();

	public Suivithemecoop createSuivithemecoop(Suivithemecoop suivithemecoop) throws Exception;

	public Suivithemecoop getSuivithemecoopById(Long id) throws Exception;

	public Suivithemecoop updateSuivithemecoop(Suivithemecoop suivithemecoop) throws Exception;

	public void deleteSuivithemecoop(Long id) throws Exception;

}
