package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Probleme;
import mg.douane.intervention.repository.ProblemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemeServiceImpl implements ProblemeService {

    @Autowired
    ProblemeRepository problemeRepository;

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
