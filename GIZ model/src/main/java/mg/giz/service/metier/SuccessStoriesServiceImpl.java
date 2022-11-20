package mg.giz.service.metier;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.SuccessStories;
import mg.giz.repository.SuccessStoriesRepository;

@Transactional
@Service
public class SuccessStoriesServiceImpl implements SuccessStoriesService {
	@Autowired
	SuccessStoriesRepository successStoriesRepository;

	@Override
	public List<SuccessStories> listSuccessStories() {
		return (List<SuccessStories>) successStoriesRepository.findAll();
	}


	@Override
	public void addSuccess(SuccessStories successstories) throws IOException {
		successStoriesRepository.save(successstories);
	}

	@Override
	public void deleteSuccess(Long id) {
		successStoriesRepository.deleteById(id);

	}

	@Override
	public SuccessStories findSuccess(Long id) {
		return successStoriesRepository.findById(id).get();

	}


	@Override
	public List<SuccessStories> findSuccess(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SuccessStories getSuccess(Long Id) {
		return successStoriesRepository.findSuccess(Id);
	}

	

}
