package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.Probleme;
import mg.douane.intervention.data.dto.ProblemeDto;

import java.util.List;

public interface ProblemeService {
    public Iterable<Probleme> getAllProblemes();

    public Iterable<Probleme> getAllProblemesFilter(String filter);

    public Iterable<ProblemeDto> getAllProblemesByAgent(String userName);

    public Iterable<Probleme> getAllProblemesByDest(String userName);

    public Iterable<Probleme> getAllProblemesByDestNews(String userName);

    public Iterable<Probleme> getAllProblemesByDestEnAttente(String userName);

    public Iterable<Probleme> getAllProblemesByDestResolu(String userName);

    public List<Agent> getIntervenant(Long id);

    public Probleme createPbr(Probleme probleme) throws Exception;

    public Probleme getPrbById(Long id) throws Exception;

    public Probleme updatePrb(Probleme probleme) throws Exception;

    public void deletePrb(Long id) throws Exception;

}
