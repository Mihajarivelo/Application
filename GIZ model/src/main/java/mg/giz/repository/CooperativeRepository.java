package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Suivithemecoop;

@Repository
public interface CooperativeRepository extends CrudRepository<Suivithemecoop, Long> {

}
