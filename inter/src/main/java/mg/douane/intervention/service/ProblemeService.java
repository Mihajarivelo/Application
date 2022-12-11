package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.Probleme;

import java.util.List;

public interface ProblemeService {
    public Iterable<Probleme> getAllProblemes();

    public Iterable<Probleme> getAllProblemesFilter(String filter);

    public Iterable<Probleme> getAllProblemesByAgent(String userName);

    public List<Agent> getIntervenant(Long id);

    public Probleme createPbr(Probleme probleme) throws Exception;

    public Probleme getPrbById(Long id) throws Exception;

    public Probleme updatePrb(Probleme probleme) throws Exception;

    public void deletePrb(Long id) throws Exception;

}
