package mg.giz.service.metier;

import mg.giz.data.domain.Indicateur;

public interface IndicateurCrudService {

	public Iterable<Indicateur> getAllIndicateurs();

	public Indicateur createIndicateur(Indicateur indicateur) throws Exception;

	public Indicateur getIndicateurById(String indicateur_id) throws Exception;

	public Indicateur updateIndicateur(Indicateur indicateur) throws Exception;

	public void deleteIndicateur(String indicateur_id) throws Exception;
}
