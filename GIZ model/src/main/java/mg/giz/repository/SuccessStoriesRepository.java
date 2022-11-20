package mg.giz.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.SuccessStories;

@Transactional
@Repository
public interface SuccessStoriesRepository extends CrudRepository<SuccessStories, Long> {

	@Query("select max(id) from SuccessStories")
	public Long findIdMax();
	
	@Query("SELECT s FROM SuccessStories s WHERE s.id = ?1")
	public SuccessStories findSuccess(Long id);

}
