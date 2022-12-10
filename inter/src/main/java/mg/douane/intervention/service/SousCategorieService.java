package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.SousCategorie;

public interface SousCategorieService {
    public Iterable<SousCategorie> getAllSousCategories();
    public Iterable<SousCategorie> getAllSousSousCategories();
}
