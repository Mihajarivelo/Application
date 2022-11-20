package mg.giz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Typerapport;

@Repository
public interface TyperapportRepository extends CrudRepository<Typerapport, Integer> {

}
