package mg.giz.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mg.giz.contrainte.validator.upload.UploadValidator;
import mg.giz.data.constants.theme.ListeSouscomposante;
import mg.giz.service.metier.FileSystemStorageService;

@Controller
public class UploadFileController {
	static final String path = "/data/tomcat/webapps/uploads/";
	
	@Autowired
	FileSystemStorageService fileSystemStorageService;


	@RequestMapping(value = { "/formUpload" }, method = RequestMethod.GET)
	public String formUploadPage(Model model) {
		return "fileImport-form/uploadFile";
	}

	// redirection vers /upload
	@GetMapping("/upload")
	public String handleGetRequest(Model model) {
		File directory = new File(path);
		if (directory.list().length > 0) {
			String[][] scList = ListeSouscomposante.souscomposantebis();
			model.addAttribute("scList", scList);
			return "fileImport-form/registerFile";
		}
		return "fileImport-form/uploadFile";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes)
			throws IOException {
		String filename = fileSystemStorageService.store(multipartFile);
		int validationUpload = UploadValidator.beforeUpload(filename);
		if (validationUpload == 0) {
			redirectAttributes.addFlashAttribute("validationUpload", validationUpload);
			return "redirect:/formUpload";
		}

		if (validationUpload == 1) {
			redirectAttributes.addFlashAttribute("validationUpload", validationUpload);
			return "redirect:/formUpload";
		}

		if (validationUpload == 2) {
			redirectAttributes.addFlashAttribute("validationUpload", validationUpload);
			return "redirect:/formUpload";
		}

		if (validationUpload == 3) {
			redirectAttributes.addFlashAttribute("validationUpload", validationUpload);
			return "redirect:/formUpload";
		}

		if (validationUpload == 4) {
			redirectAttributes.addFlashAttribute("validationUpload", validationUpload);
			return "redirect:/formUpload";
		}	
		
		return "redirect:/registerFile";
	}
}
