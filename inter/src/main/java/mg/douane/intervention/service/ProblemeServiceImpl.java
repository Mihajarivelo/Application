package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.repository.*;
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

    @Autowired
    Statusrepository statusrepository;

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
            Iterable<Probleme> problemes = problemeRepository.findByAgentProb(agent.get());
            List<Probleme> problemeRep = new ArrayList<>();
            for (Probleme prb : problemes) {
                try {
                    String interTemp = prb.getIntervenant();
                    String[] interSplit = interTemp.split(",");
                    String inter = "";
                    if (interSplit.length > 0) {
                        for (int i = 0; i < interSplit.length; i++) {
                            Optional<Agent> agentOptional = agentRepository.findById(interSplit[i]);
                            inter = inter + agentOptional.get().getNomAgent() + " " + agentOptional.get().getPrenomAgent() + ";";
                        }
                    }
                    prb.setIntervenant(inter.substring(0, inter.length() - 1));
                    problemeRep.add(prb);
                }catch (Exception e) {
                    problemeRep.add(prb);
                }
            }
            return problemeRep;
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDest(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        if(agent.isPresent()) {
            Iterable<Probleme> problemes = problemeRepository.findAll();
            return getProblemes(agent, problemes);
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestNews(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 1);
        if(agent.isPresent()) {
            Iterable<Probleme> problemes = problemeRepository.findByStatut(statut.get());
            return getProblemes(agent, problemes);
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestEnAttente(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 2);
        if(agent.isPresent()) {
            Iterable<Probleme> problemes = problemeRepository.findByStatut(statut.get());
            return getProblemes(agent, problemes);
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestResolu(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 3);
        if(agent.isPresent()) {
            Iterable<Probleme> problemes = problemeRepository.findByStatut(statut.get());
            return getProblemes(agent, problemes);
        }
        return null;
    }

    private Iterable<Probleme> getProblemes(Optional<Agent> agent, Iterable<Probleme> problemes) {
        List<Probleme> problemeRep = new ArrayList<>();
        for (Probleme prb : problemes) {
            try {
                String interTemp = prb.getIntervenant();
                String[] interSplit = interTemp.split(",");
                if (interSplit.length > 0) {
                    for (int i = 0; i < interSplit.length; i++) {
                        Optional<Agent> agentOptional = agentRepository.findById(interSplit[i]);
                        if(agent.get() == agentOptional.get()) {
                            problemeRep.add(prb);
                        }
                    }
                }
            }catch (Exception e) {
            }
        }
        return problemeRep;
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
