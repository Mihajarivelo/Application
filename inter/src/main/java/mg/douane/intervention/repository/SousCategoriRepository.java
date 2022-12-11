package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Categorie;
import mg.douane.intervention.data.domaine.SousCategorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousCategoriRepository extends CrudRepository<SousCategorie, Long> {

    @Query("SELECT s FROM SousCategorie s WHERE s.SCat IS NULL")
    List<SousCategorie> findAllSousCategories();

    @Query("SELECT s FROM SousCategorie s WHERE s.SCat IS NOT NULL")
    List<SousCategorie> findAllSousSousCategories();

    List<SousCategorie> findAllByCategorie(Categorie categorie);

    List<SousCategorie> findAllByScats(SousCategorie sousCategorie);
}
