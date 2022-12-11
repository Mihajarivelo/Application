package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Categorie;
import mg.douane.intervention.data.domaine.SousCategorie;
import mg.douane.intervention.repository.CategorieRepository;
import mg.douane.intervention.repository.SousCategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCategorieServiceImpl implements SousCategorieService{
    @Autowired
    SousCategoriRepository sousCategoriRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Iterable<SousCategorie> getAllSousCategories() {
        return sousCategoriRepository.findAllSousCategories();
    }

    @Override
    public Iterable<SousCategorie> getAllSousSousCategories() {
        return sousCategoriRepository.findAllSousSousCategories();
    }

    @Override
    public List<SousCategorie> getAllSousCategoriesByCat(Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        if(categorie.isPresent()) {
            return sousCategoriRepository.findAllByCategorie(categorie.get());
        }
        return null;
    }

    @Override
    public List<SousCategorie> getAllSousSousCategoriesBySous(Long id) {
        Optional<SousCategorie> sousCategorie = sousCategoriRepository.findById(id);
        if(sousCategorie.isPresent())
            return sousCategoriRepository.findAllByScats(sousCategorie.get());
        return null;
    }
}
