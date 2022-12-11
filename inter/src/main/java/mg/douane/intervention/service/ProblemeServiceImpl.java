package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.domaine.FichePoste;
import mg.douane.intervention.data.domaine.Probleme;
import mg.douane.intervention.data.domaine.SousCategorie;
import mg.douane.intervention.repository.AgentRepository;
import mg.douane.intervention.repository.FichePosteRepository;
import mg.douane.intervention.repository.ProblemeRepository;
import mg.douane.intervention.repository.SousCategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemeServiceImpl implements ProblemeService {

    @Autowired
    ProblemeRepository problemeRepository;

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    SousCategoriRepository sousCategoriRepository;

    @Autowired
    FichePosteRepository fichePosteRepository;

    @Override
    public Iterable<Probleme> getAllProblemes() {
        return problemeRepository.findAll();
    }

    @Override
    public Iterable<Probleme> getAllProblemesFilter(String filter) {
        if(filter.equals("resolu"))
            return problemeRepository.findAllResolu();
        else
            return problemeRepository.findAllNotResolu();
    }

    @Override
    public Iterable<Probleme> getAllProblemesByAgent(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        if(agent.isPresent()) {
            return problemeRepository.findByAgentProb(agent.get());
        }
        return null;
    }

    @Override
    public List<Agent> getIntervenant(Long id) {
        Optional<SousCategorie> sousCategorie = sousCategoriRepository.findById(id);
        if(sousCategorie.isPresent()) {
            List<FichePoste> fichePostes = fichePosteRepository.findBySouCatFich(sousCategorie.get());
            List<Agent> agents = new ArrayList<>();
            for(int i=0; i < fichePostes.size(); i++) {
                agents.add(fichePostes.get(i).getAgentFich());
            }
            return agents;
        }
        return null;
    }

    @Override
    public Probleme createPbr(Probleme probleme) throws Exception {
        return null;
    }

    @Override
    public Probleme getPrbById(Long id) throws Exception {
        return null;
    }

    @Override
    public Probleme updatePrb(Probleme probleme) throws Exception {
        return null;
    }

    @Override
    public void deletePrb(Long id) throws Exception {

    }
}
