package mg.giz.service.metier;

import java.io.IOException;
import java.util.List;

import mg.giz.data.domain.SuccessStories;

public interface SuccessStoriesService {
	public List<SuccessStories> listSuccessStories();

	public void addSuccess(SuccessStories successstories) throws IOException;

	public void deleteSuccess(Long id);

	public SuccessStories findSuccess(Long id);

	List<SuccessStories> findSuccess(String key);

	SuccessStories getSuccess(Long Id);

}
