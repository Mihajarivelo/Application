package mg.douane.intervention.repository;

import mg.douane.intervention.data.domaine.Hierarchie;
import mg.douane.intervention.data.domaine.TypeHierarchie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HierarchieRepository extends CrudRepository<Hierarchie, Long> {

    List<Hierarchie> findByType(TypeHierarchie typeHierarchie);

    List<Hierarchie> findByHier(Hierarchie hierarchie);
}

