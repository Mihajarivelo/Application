package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Categorie;

public interface CategoriService {
    public Iterable<Categorie> getAllCategories();

    public Categorie createCat(Categorie categorie) throws Exception;

    public Categorie getCatById(Long id) throws Exception;

    public Categorie updateCat(Categorie categorie) throws Exception;

    public void deleteCat(Long id) throws Exception;
}
