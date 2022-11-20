package mg.giz.service.metier;

import mg.giz.data.domain.Commentaire;

public interface CommentaireService {

	public Iterable<Commentaire> getAllCommentaires();

	public Commentaire createCommentaire(Commentaire Commentaire) throws Exception;

	public Commentaire getCommentaireById(Long id) throws Exception;

	public Commentaire updateCommentaire(Commentaire Commentaire) throws Exception;

	public void deleteCommentaire(Long id) throws Exception;
}
