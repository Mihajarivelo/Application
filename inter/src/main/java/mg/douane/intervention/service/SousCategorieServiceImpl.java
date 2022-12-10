package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.SousCategorie;
import mg.douane.intervention.repository.SousCategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SousCategorieServiceImpl implements SousCategorieService{
    @Autowired
    SousCategoriRepository sousCategoriRepository;

    @Override
    public Iterable<SousCategorie> getAllSousCategories() {
        return sousCategoriRepository.findAllSousCategories();
    }

    @Override
    public Iterable<SousCategorie> getAllSousSousCategories() {
        return sousCategoriRepository.findAllSousSousCategories();
    }
}
