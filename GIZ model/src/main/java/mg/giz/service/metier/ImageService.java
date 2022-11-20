package mg.giz.service.metier;

import mg.giz.data.domain.Image;

public interface ImageService {

	public Iterable<Image> getAllImage();

	public Image createImage(Image image) throws Exception;

	public Image getImageById(Long id) throws Exception;

	public void deleteImage(Long id) throws Exception;

	public void deleteGalerieImage(Long id) throws Exception;
	
	public Image findImage(Long id);


}
