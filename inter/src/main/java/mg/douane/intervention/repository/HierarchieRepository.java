package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Hierarchie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarchieRepository extends CrudRepository<Hierarchie, Long> {
}

