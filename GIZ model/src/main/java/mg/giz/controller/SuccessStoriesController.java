package mg.giz.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mg.giz.data.domain.SuccessStories;
import mg.giz.repository.SuccessStoriesRepository;
import mg.giz.service.metier.SuccessStoriesService;

@Controller
public class SuccessStoriesController {
	@Autowired
	SuccessStoriesRepository successStoriesRepository;

	@Autowired
	SuccessStoriesService successStoriesService;

	@RequestMapping("/listSuccess")
	public String listSuccess(Model model) {
		List<SuccessStories> listSuccessStories = successStoriesService.listSuccessStories();
		model.addAttribute("listSuccessStories", listSuccessStories);
		return "success-form/Form_list_success";
	}

	@RequestMapping("/addSuccess")
	public String newSuccess(Model model) {
		return "success-form/Form_add_success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addSuccess(@RequestParam("file") MultipartFile file,
			@RequestParam("proprietaire") String proprietaire, @RequestParam("commune") String commune,
			@RequestParam("district") String district, @RequestParam("village") String village,
			@RequestParam("thematique") String thematique, RedirectAttributes redirectAttributes) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		SuccessStories newSuccess = new SuccessStories(file.getBytes(), district, village, proprietaire, commune,
				thematique, file.getContentType(), fileName);
		successStoriesService.addSuccess(newSuccess);
		redirectAttributes.addFlashAttribute("message", 1);
		return "redirect:/listSuccess";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		successStoriesService.deleteSuccess(id);
		return "redirect:/listSuccess";
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
		SuccessStories sc = successStoriesService.findSuccess(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(sc.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + sc.getFileName() + "\"")
				.body(new ByteArrayResource(sc.getFile()));
	}

	@GetMapping("/viewFile/{id}")
	public ResponseEntity<byte[]> viewFile(@PathVariable Long id) {
		SuccessStories sc = successStoriesService.findSuccess(id);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = sc.getFileName();
		headers.add("content-disposition", "inline;filename=" + filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(sc.getFile(), headers, HttpStatus.OK);
		return response;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("success-form/Form_edit_success");
		SuccessStories sc = successStoriesService.findSuccess(id);
		mav.addObject("SuccessStories", sc);
		return mav;
	}

	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public String modifierSuccess(@RequestParam("file") MultipartFile file,
			@RequestParam("proprietaire") String proprietaire, @RequestParam("commune") String commune,
			@RequestParam("district") String district, @RequestParam("village") String village,
			@RequestParam("thematique") String thematique, @RequestParam("id") Long id,
			RedirectAttributes redirectAttributes) throws Exception {

		SuccessStories sc = successStoriesRepository.findSuccess(id);
		if (file.isEmpty()) {
			sc.setCommune(commune);
			sc.setDistrict(district);
			sc.setProprietaire(proprietaire);
			sc.setThematique(thematique);
			sc.setVillage(village);
			successStoriesService.addSuccess(sc);
		} else {
			sc.setCommune(commune);
			sc.setDistrict(district);
			sc.setProprietaire(proprietaire);
			sc.setThematique(thematique);
			sc.setVillage(village);
			sc.setFile(file.getBytes());
			sc.setFileType(file.getContentType());
			sc.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
			successStoriesService.addSuccess(sc);
		}
		return "redirect:/listSuccess";
	}
}
