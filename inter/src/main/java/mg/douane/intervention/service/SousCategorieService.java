package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.SousCategorie;

import java.util.List;

public interface SousCategorieService {
    public Iterable<SousCategorie> getAllSousCategories();
    public Iterable<SousCategorie> getAllSousSousCategories();
    public List<SousCategorie> getAllSousCategoriesByCat(Long id);
    public List<SousCategorie> getAllSousSousCategoriesBySous(Long id);
}
