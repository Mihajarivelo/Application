package mg.giz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Image;

@Repository
public interface ImageRepository  extends CrudRepository<Image, Long>{
	
	@Query(value = "DELETE from image WHERE id_album = ?1 ", nativeQuery = true)
	public void deleteImageGalerie(Long id);
	
	@Query( value = "SELECT i FROM image i WHERE i.id = ?1", nativeQuery = true)
	public Image findImage(Long id);

}
