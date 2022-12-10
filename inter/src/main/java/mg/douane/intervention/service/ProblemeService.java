package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Probleme;

public interface ProblemeService {
    public Iterable<Probleme> getAllProblemes();

    public Iterable<Probleme> getAllProblemesFilter(String filter);

    public Probleme createPbr(Probleme probleme) throws Exception;

    public Probleme getPrbById(Long id) throws Exception;

    public Probleme updatePrb(Probleme probleme) throws Exception;

    public void deletePrb(Long id) throws Exception;

}
