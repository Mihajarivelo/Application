package mg.giz.service.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Commentaire;
import mg.giz.repository.CommentaireRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository repository;

	@Override
	public Iterable<Commentaire> getAllCommentaires() {
		return repository.findAll();
	}

	@Override
	public Commentaire createCommentaire(Commentaire commentaire) throws Exception {
		return commentaire = repository.save(commentaire);
	}

	@Override
	public Commentaire getCommentaireById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("This Commentaire no exist"));
	}

	@Override
	public Commentaire updateCommentaire(Commentaire fromCommentaire) throws Exception {
		Commentaire toCommentaire = getCommentaireById(fromCommentaire.getId());
		mapCommentaire(fromCommentaire, toCommentaire);
		return repository.save(toCommentaire);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapCommentaire(Commentaire from, Commentaire to) {
		to.setCommentaire_date(from.getCommentaire_date());
		to.setCommentaire_texte(from.getCommentaire_texte());
		to.setIndicateur(from.getIndicateur());
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteCommentaire(Long id) throws Exception {
		Commentaire commentaire = getCommentaireById(id);
		repository.delete(commentaire);
	}

}
