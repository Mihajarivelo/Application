package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.*;
import mg.douane.intervention.data.dto.ProblemeDto;
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
    CategorieRepository sousCategoriRepository;

    @Autowired
    FichePosteRepository fichePosteRepository;

    @Autowired
    Statusrepository statusrepository;

    @Autowired
    IntervenantRepository intervenantRepository;

    @Autowired
    PrioriterRepository prioriterRepository;

    @Autowired
    ReponseRepository reponseRepository;

    @Override
    public Iterable<Probleme> getAllProblemes() {
        return problemeRepository.findAll();
    }

    @Override
    public Iterable<Probleme> getAllProblemesFilter(String filter) {
        if (filter.equals("resolu"))
            return problemeRepository.findAllResolu();
        else
            return problemeRepository.findAllNotResolu();
    }

    @Override
    public Iterable<ProblemeDto> getAllProblemesByAgent(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        if (agent.isPresent()) {
            Iterable<Probleme> problemes = problemeRepository.findByAgentProb(agent.get());

            List<ProblemeDto> problemeRep = new ArrayList<>();
            for (Probleme prb : problemes) {
                try {
                    ProblemeDto problemeDto = new ProblemeDto();
                    Intervenant intervenant = intervenantRepository.findByProbInt(prb);
                    problemeDto.setIntervenant(intervenant.getAgentInt().getNomAgent() + ' ' + intervenant.getAgentInt().getPrenomAgent());
                    problemeDto.setIdProb(prb.getIdProb());
                    problemeDto.setLibelleProb(prb.getLibelleProb());
                    problemeDto.setStatut(prb.getStatut().getIdStatut()+"");
                    problemeDto.setDateEnvProb(prb.getDateEnvProb()+"");
                    problemeRep.add(problemeDto);
                } catch (Exception e) {
                    ProblemeDto problemeDto = new ProblemeDto();
                    problemeDto.setIdProb(prb.getIdProb());
                    problemeDto.setLibelleProb(prb.getLibelleProb());
                    problemeDto.setStatut(prb.getStatut().getIdStatut()+"");
                    problemeDto.setDateEnvProb(prb.getDateEnvProb()+"");
                    problemeRep.add(problemeDto);
                }
            }
            return problemeRep;
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDest(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        if (agent.isPresent()) {
            List<Intervenant> intervenants = intervenantRepository.findByAgentInt(agent.get());
            List<Probleme> problemeList = new ArrayList<>();
            for(int i=0; i < intervenants.size(); i++) {
                problemeList.add(intervenants.get(i).getProbInt());
            }
            return problemeList;
        }
        return null;
    }

    @Override
    public Iterable<Reponse> getAllReponseByDest(String userName) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        if (agent.isPresent()) {
            List<Intervenant> intervenants = intervenantRepository.findByAgentInt(agent.get());
            List<Reponse> reponseList = new ArrayList<>();
            for(int i=0; i < intervenants.size(); i++) {
                reponseList.add(reponseRepository.findAllByPrblme(intervenants.get(i).getProbInt()));
            }
            return reponseList;
        }
        return null;
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestNews(String userName, String filter) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 1);
        return getProblemesStatusFilter(filter, agent, statut);
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestEnAttente(String userName, String filter) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 2);
        return getProblemesStatusFilter(filter, agent, statut);
    }

    @Override
    public Iterable<Probleme> getAllProblemesByDestResolu(String userName, String filter) {
        Optional<Agent> agent = agentRepository.findByUsername(userName);
        Optional<Statut> statut = statusrepository.findById((long) 3);
        return getProblemesStatusFilter(filter, agent, statut);
    }

    private Iterable<Probleme> getProblemesStatusFilter(String filter, Optional<Agent> agent, Optional<Statut> statut) {
        if (agent.isPresent()) {
            if(filter.equals("all")) {
                Iterable<Probleme> problemes = problemeRepository.findByStatut(statut.get());
                return getProblemes(agent, problemes);
            } else if(filter.equals("urgent")) {
                Optional<Priorite> priorite = prioriterRepository.findById((long) 1);
                Iterable<Probleme> problemes = problemeRepository.findByStatutAndPrioriter(statut.get(), priorite.get());
                return getProblemes(agent, problemes);
            } else if(filter.equals("normal")) {
                Optional<Priorite> priorite = prioriterRepository.findById((long) 2);
                Iterable<Probleme> problemes = problemeRepository.findByStatutAndPrioriter(statut.get(), priorite.get());
                return getProblemes(agent, problemes);
            } else {
                Optional<Priorite> priorite = prioriterRepository.findById((long) 3);
                Iterable<Probleme> problemes = problemeRepository.findByStatutAndPrioriter(statut.get(), priorite.get());
                return getProblemes(agent, problemes);
            }
        }
        return null;
    }

    private Iterable<Probleme> getProblemes(Optional<Agent> agent, Iterable<Probleme> problemes) {
        List<Probleme> problemeRep = new ArrayList<>();
        for (Probleme prb : problemes) {
            List<Intervenant> intervenants = intervenantRepository.findByAgentInt(agent.get());
            for(int i=0; i < intervenants.size(); i++) {
                if(prb == intervenants.get(i).getProbInt())
                    problemeRep.add(intervenants.get(i).getProbInt());
            }

        }
        return problemeRep;
    }

    @Override
    public List<Agent> getIntervenant(Long id) {
        Optional<Categorie> sousCategorie = sousCategoriRepository.findById(id);
        if (sousCategorie.isPresent()) {
            List<FichePoste> fichePostes = fichePosteRepository.findByCatFich(sousCategorie.get());
            List<Agent> agents = new ArrayList<>();
            for (int i = 0; i < fichePostes.size(); i++) {
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
