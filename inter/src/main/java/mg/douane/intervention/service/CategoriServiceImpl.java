package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Categorie;
import mg.douane.intervention.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriServiceImpl implements CategoriService{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Iterable<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie createCat(Categorie categorie) throws Exception {
        return null;
    }

    @Override
    public Categorie getCatById(Long id) throws Exception {
        return null;
    }

    @Override
    public Categorie updateCat(Categorie categorie) throws Exception {
        return null;
    }

    @Override
    public void deleteCat(Long id) throws Exception {

    }
}
