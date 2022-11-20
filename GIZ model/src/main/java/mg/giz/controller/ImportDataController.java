package mg.giz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mg.giz.contrainte.factory.ConvertExcelToArray;
import mg.giz.contrainte.factory.mappage.BeneficierPgmMappage;
import mg.giz.contrainte.factory.mappage.FermePiloteMappage;
import mg.giz.contrainte.factory.mappage.FomateurMappage;
import mg.giz.contrainte.factory.mappage.GroupementprodMappage;
import mg.giz.contrainte.factory.mappage.HistoriqueMappage;
import mg.giz.contrainte.factory.mappage.OtivMappage;
import mg.giz.contrainte.factory.mappage.PersonneMappage;
import mg.giz.contrainte.factory.mappage.ProjetmfrMappage;
import mg.giz.contrainte.factory.mappage.ThemeMappage;
import mg.giz.contrainte.validator.VillageValidator;
import mg.giz.contrainte.validator.register.ColumnValidator;
import mg.giz.contrainte.validator.register.DataTypeValidator;
import mg.giz.contrainte.validator.upload.UploadValidator;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.theme.GetTheme;
import mg.giz.data.constants.theme.ListeSouscomposante;
import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Ecoleepp;
import mg.giz.data.domain.Fermepilote;
import mg.giz.data.domain.Formateur;
import mg.giz.data.domain.Groupementprod;
import mg.giz.data.domain.Historique;
import mg.giz.data.domain.Otiv;
import mg.giz.data.domain.Parentmfr;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Projetmfr;
import mg.giz.data.domain.Suivitheme;
import mg.giz.data.domain.Theme;
import mg.giz.service.metier.AmeliorerService;
import mg.giz.service.metier.BeneficierPgmService;
import mg.giz.service.metier.BonnepratiquefbsService;
import mg.giz.service.metier.ConcernerService;
import mg.giz.service.metier.EcoleeppService;
import mg.giz.service.metier.EnseignanteppService;
import mg.giz.service.metier.FermePiloteService;
import mg.giz.service.metier.FormateurService;
import mg.giz.service.metier.GroupementprodService;
import mg.giz.service.metier.HistoriqueService;
import mg.giz.service.metier.KitmaderaService;
import mg.giz.service.metier.KitmadereService;
import mg.giz.service.metier.MenagessensibiliseService;
import mg.giz.service.metier.MettreoeuvreService;
import mg.giz.service.metier.NombreeleveService;
import mg.giz.service.metier.OtivService;
import mg.giz.service.metier.ParentmfrService;
import mg.giz.service.metier.PersonneService;
import mg.giz.service.metier.PostformationfbsService;
import mg.giz.service.metier.ProjetmfrService;
import mg.giz.service.metier.ServiceprojetService;
import mg.giz.service.metier.SubvenireppService;
import mg.giz.service.metier.SuivithemeService;
import mg.giz.service.metier.ThemeService;
import mg.giz.service.metier.VillageService;
import mg.giz.service.metier.VisiteurfermeService;

@Controller
public class ImportDataController {
	@Autowired
	private VillageService villageService;

	@Autowired
	private FormateurService formateurService;

	@Autowired
	private PersonneService personneService;

	@Autowired
	private BeneficierPgmService beneficierPgmService;

	@Autowired
	private HistoriqueService historiqueService;

	@Autowired
	private FermePiloteService fermePiloteService;

	@Autowired
	private ThemeService themeService;
	@Autowired
	private OtivService otivService;

	@Autowired
	private ProjetmfrService projetmfrService;

	@Autowired
	private GroupementprodService groupementprodService;

	@Autowired
	private ServiceprojetService serviceprojetService;

	@Autowired
	private MettreoeuvreService mettreoeuvreService;

	@Autowired
	private SuivithemeService suivithemeService;

	@Autowired
	private MenagessensibiliseService menagessensibiliseService;
	@Autowired
	private EcoleeppService ecoleeppSercice;
	@Autowired
	private NombreeleveService nombreeleveService;
	@Autowired
	private EnseignanteppService enseignanteppService;
	@Autowired
	private ParentmfrService parentmfrService;
	@Autowired
	private ConcernerService concernerService;
	@Autowired
	private KitmadereService kitmadereService;
	@Autowired
	private AmeliorerService ameliorerService;
	@Autowired
	private VisiteurfermeService visiteurfermeService;
	@Autowired
	private SubvenireppService subvenireppService;
	@Autowired
	private BonnepratiquefbsService bonnepratiquefbsService;
	@Autowired
	private PostformationfbsService postformationfbsService;
	@Autowired
	private KitmaderaService kitmaderaService;

	static final String path = "/data/tomcat/webapps/uploads/";

	@GetMapping("/registerFile")
	public String handleGetRequestRegisterFile(Model model) {
		File directory = new File(path);
		if (directory.list().length > 0) {
			String[][] scList = ListeSouscomposante.souscomposantebis();
			model.addAttribute("scList", scList);
			return "fileImport-form/registerFile";
		}
		return "fileImport-form/uploadFile";
	}

	@RequestMapping(value = "/dropdownlist/{sc}", method = RequestMethod.GET)
	public @ResponseBody String[][] getAllSubcategories(@PathVariable("sc") String sc) {
		String[][] theme = GetTheme.getTheme(sc);
		return theme;
	}

	@RequestMapping(value = { "/registerFile" }, method = RequestMethod.POST)
	public String uploadFile(@RequestParam("theme") String theme, Model model, RedirectAttributes redirectAttributes)
			throws Exception {

		if (theme == null) {
			return "redirect:/registerFile";
		}

		File excelFile = new File(path + "fileUploaded.xlsx");
		XSSFRow firstRow = UploadValidator.getFirstRow(excelFile);
		ArrayList<Integer> RowColNumber = UploadValidator.getRowColNumber(excelFile);
		int rowCount = RowColNumber.get(0);
		int ColCount = RowColNumber.get(1);
		ArrayList<String> columnLabelExcel = UploadValidator.getColumnLabel(firstRow, ColCount);
		ArrayList<ColumnStructure> columnStructure = DataTypeValidator.columnStructure(columnLabelExcel, theme);

		int headerVerification = ColumnValidator.beforeRegister(columnLabelExcel, theme);

		if (headerVerification == 0) {
			redirectAttributes.addFlashAttribute("headerVerification", headerVerification);
			return "redirect:/registerFile";
		}

		if (headerVerification == 1) {
			redirectAttributes.addFlashAttribute("headerVerification", headerVerification);
			return "redirect:/registerFile";
		}

		List<Integer> dataValidation = DataTypeValidator.dataValidation(excelFile, columnStructure, theme);

		if (dataValidation.get(0) == 0) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 1) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			redirectAttributes.addFlashAttribute("row", dataValidation.get(1));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 2) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			redirectAttributes.addFlashAttribute("row", dataValidation.get(1));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 3) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 4) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			redirectAttributes.addFlashAttribute("row", dataValidation.get(1));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 5) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			return "redirect:/registerFile";
		}

		if (dataValidation.get(0) == 6) {
			redirectAttributes.addFlashAttribute("dataValidation", dataValidation.get(0));
			return "redirect:/registerFile";
		}

		// Convertir excel en tableau
		String[][] ExcelToArray = ConvertExcelToArray.excelToArray(excelFile, rowCount, ColCount);

		// Vérification Village
		try {
			List<String> listFktUnik = VillageValidator.verificationfkt(ExcelToArray, columnStructure);
			for (int i = 0; i < listFktUnik.size(); i++) {
				String village = listFktUnik.get(i);
				String v = villageService.verifyVillage(listFktUnik.get(i));
				if (v == null) {
					redirectAttributes.addFlashAttribute("fktnull", village.toUpperCase());
					return "redirect:/registerFile";
				}
			}
		} catch (Exception e) {
		}

		// MFR Opérationnels
		if (theme.equals("2.1.1")) {
			Map<String, Integer> ThemeMapping = ThemeMappage.tableTheme(columnStructure);
			List<Theme> themes = themeService.createTheme(ExcelToArray, ThemeMapping, theme);
			themeService.addTheme(themes);
			themeService.deleteThemeDuplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Formateur FBS formés
		if (theme.equals("1.2.1")) {
			Map<String, Integer> FormateurMapping = FomateurMappage.tableFormateur(columnStructure);
			List<Formateur> formateurs = formateurService.createFormateur(ExcelToArray, FormateurMapping, theme);
			formateurService.addFormateur(formateurs);
			formateurService.deleteFormateurDuplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// producteurs formés et sensibilisés
		if (theme.equals("1.2.2") || theme.equals("3.2.2") || theme.equals("3.2.3") || theme.equals("3.2.5")
				|| theme.equals("3.2.6") || theme.equals("2.2.8") || theme.equals("2.1.4") || theme.equals("2.1.6")
				|| theme.equals("1.3.7") || theme.equals("3.1.1") || theme.equals("3.1.5") || theme.equals("1.2.5a")
				|| theme.equals("1.2.5b") || theme.equals("1.2.5c") || theme.equals("1.2.6a") || theme.equals("1.2.6b")
				|| theme.equals("1.2.6c") || theme.equals("2.3.1") || theme.equals("3.1.8") || theme.equals("1.1.5")
				|| theme.equals("1.4.4") || theme.equals("1.4.5") || theme.equals("1.4.10") || theme.equals("1.3.8")
				|| theme.equals("3.2.10") || theme.equals("1.2.7") || theme.equals("1.2.9")) {

			Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
			Map<String, Integer> beneficierpgmMapping = BeneficierPgmMappage.tableBeneficierPgmMappage(columnStructure);
			List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
			List<Beneficierpgm> beneficierpgm = beneficierPgmService.createBeneficierpgm(ExcelToArray,
					beneficierpgmMapping, theme);
			personneService.addPersonne(personnes);

			if (theme.equals("2.3.1") || theme.equals("3.1.8")) {
				personneService.del_doublon_personne();
				personneService.deletePersonneDuplicated();
			} else {
				personneService.deletePersonneDuplicated();
			}

			List<Long> codePersonne = personneService.findPersonne(personnes);
			List<Beneficierpgm> beneficiairePgrm = beneficierPgmService.addCodePersonne(codePersonne, beneficierpgm);
			beneficierPgmService.addBeneficierPgm(beneficiairePgrm);
			beneficierPgmService.deleteBeneficierDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Enregistrement de différentes type de personnes
		if (theme.equals("1.3.1") || theme.equals("1.3.2") || theme.equals("1.3.6") || theme.equals("3.3.a")
				|| theme.equals("1.4.0")) {
			Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
			Map<String, Integer> HistoriqueMapping = HistoriqueMappage.tableHistoriqueMappage(columnStructure);
			List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
			List<Historique> historiques = historiqueService.createHistorique(ExcelToArray, HistoriqueMapping, theme);

			personneService.addPersonne(personnes);
			personneService.deletePersonneDuplicated();
			List<Long> codePersonne = personneService.findPersonne(personnes);
			List<Historique> historiqueTypePersonne = historiqueService.addCodePersonne(codePersonne, historiques);
			historiqueService.addHistorique(historiqueTypePersonne);
			historiqueService.deleteHistoriqueDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		if (theme.equals("1.3.9")) {
			Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
			Map<String, Integer> FermePiloteMapping = FermePiloteMappage.tableFermePiloteMappage(columnStructure);
			List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
			List<Fermepilote> fermepilotes = fermePiloteService.createFermepilote(ExcelToArray, FermePiloteMapping,
					theme);

			personneService.addPersonne(personnes);
			personneService.deletePersonneDuplicated();
			List<Long> codePersonne = personneService.findPersonne(personnes);
			List<Fermepilote> proprietaireFermepilote = fermePiloteService.addCodePersonne(codePersonne, fermepilotes);
			fermePiloteService.addFermepilote(proprietaireFermepilote);
			fermePiloteService.deleteFermepiloteDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// jeunes sortants des MFR mettant en œuvre leur projet
		if (theme.equals("2.1.5")) {
			Map<String, Integer> otivMapping = OtivMappage.tableOtivMappage(columnStructure);
			Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
			Map<String, Integer> projetmfrMapping = ProjetmfrMappage.tableProjetmfrMappage(columnStructure);
			List<Otiv> otivs = otivService.createOtiv(ExcelToArray, otivMapping, theme);
			List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
			List<Projetmfr> projetmfr = projetmfrService.createProjetmfr(ExcelToArray, projetmfrMapping, theme);
			otivService.addOtiv(otivs);
			otivService.deleteOtivDuplicated();
			personneService.addPersonne(personnes);
			personneService.deletePersonneDuplicated();
			List<Long> codePersonne = personneService.findPersonneMfr(personnes);
			List<Integer> codeOtiv = otivService.findOtiv(otivs);
			List<Projetmfr> persOtiv = projetmfrService.addIdPersonneOtiv(codePersonne, codeOtiv, projetmfr);
			projetmfrService.addProjetmfr(persOtiv);
			projetmfrService.deleteProjetmfrDuplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// structure de producteurs fonctionnels
		if (theme.equals("1.4.1")) {
			Map<String, Integer> groupementprodMapping = GroupementprodMappage
					.tableGroupementprodMappage(columnStructure);
			List<Groupementprod> groupementprods = groupementprodService.createGroupementprod(ExcelToArray,
					groupementprodMapping, theme);
			groupementprodService.addGroupementprod(groupementprods);
			groupementprodService.deleteGroupementprodDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";

		}

		// structure de producteurs mettant en œuvre un service ou un projet
		if (theme.equals("1.4.1")) {
			Map<String, Integer> groupementprodMapping = GroupementprodMappage
					.tableGroupementprodMappage(columnStructure);
			List<Groupementprod> groupementprods = groupementprodService.createGroupementprod(ExcelToArray,
					groupementprodMapping, theme);
			groupementprodService.addGroupementprod(groupementprods);
			groupementprodService.deleteGroupementprodDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// VSLA
		if (theme.equals("3.1.4") || theme.equals("3.1.7")) {
			List<Personne> listPersonneVslas = personneService.listPersonneVsla(columnStructure, ExcelToArray, theme);
			List<Theme> themesVsla = themeService.listThemeVsla(columnStructure, ExcelToArray, theme);
			themeService.addThemeVsla(themesVsla);
			personneService.addPersonneVsla(listPersonneVslas);
			List<Long> IdPersonnes = personneService.findPersonneVsla(listPersonneVslas);
			List<Long> IdThemes = themeService.findThemeIdVsla(themesVsla, theme);
			beneficierPgmService.beneficierVsla(IdPersonnes, IdThemes);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Ménage sensibilisés
		if (theme.equals("3.3.1")) {
			menagessensibiliseService.addMenagessensibilise(columnStructure, ExcelToArray, theme);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// élèves présents dans les écoles aidées
		if (theme.equals("2.2.4")) {
			List<Ecoleepp> ecoleepps = ecoleeppSercice.listEcoleepp(columnStructure, ExcelToArray, theme);
			ecoleeppSercice.addEcoleepp(ecoleepps);
			nombreeleveService.addNombreeleve(columnStructure, ExcelToArray, theme, ecoleepps);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// enseignants formés à l'éducation environnementale
		if (theme.equals("2.2.5")) {
			List<Ecoleepp> ecoleepps = ecoleeppSercice.listEcoleepp(columnStructure, ExcelToArray, theme);
			ecoleeppSercice.addEcoleepp(ecoleepps);
			enseignanteppService.addEnseignantepp(columnStructure, ExcelToArray, theme, ecoleepps);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// enseignants formés à l'éducation environnementale
		if (theme.equals("2.2.6")) {
			List<Ecoleepp> ecoleepps = ecoleeppSercice.listEcoleepp(columnStructure, ExcelToArray, theme);
			ecoleeppSercice.addEcoleepp(ecoleepps);
			kitmaderaService.addKitmadera(columnStructure, ExcelToArray, theme, ecoleepps);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// village ayant amélioré l'accès à l'eau potable
		if (theme.equals("2.3.8")) {
			ameliorerService.addAmeliorer(columnStructure, ExcelToArray, theme);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Ateliers
		if (theme.equals("4.4.1") || theme.equals("1.4.6") || theme.equals("1.3.4") || theme.equals("1.3.5")
				|| theme.equals("3.1.3") || theme.equals("3.2.4") || theme.equals("3.2.1")) {
			List<Suivitheme> listSuivithemes = suivithemeService.listSuivitheme(columnStructure, ExcelToArray, theme);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// élève étudiant dans les MFR
		if (theme.equals("2.1.3")) {
			List<Parentmfr> parentmfrs = parentmfrService.listParentmfr(columnStructure, ExcelToArray, theme);
			parentmfrService.addParentmfr(parentmfrs);
			List<Long> IdParentsmfr = parentmfrService.findParentmfr(parentmfrs);
			List<Personne> listPersonnes = personneService.listPersonneVsla(columnStructure, ExcelToArray, theme);
			List<Personne> EleveMfr = personneService.addIdParentmfr(listPersonnes, IdParentsmfr);
			personneService.addPersonne(EleveMfr);
			List<Long> idPersonne = personneService.findPersonne(EleveMfr);
			Map<String, Integer> beneficierpgmMapping = BeneficierPgmMappage.tableBeneficierPgmMappage(columnStructure);
			List<Beneficierpgm> beneficierpgm = beneficierPgmService.createBeneficierpgm(ExcelToArray,
					beneficierpgmMapping, theme);
			List<Beneficierpgm> beneficiairePgrm = beneficierPgmService.addCodePersonne(idPersonne, beneficierpgm);
			beneficierPgmService.addBeneficierPgm(beneficiairePgrm);
			beneficierPgmService.deleteBeneficierDudplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// école concernées par l'éducation environnementale
		if (theme.equals("2.2.7")) {
			List<Ecoleepp> ecoleepps = ecoleeppSercice.listEcoleepp(columnStructure, ExcelToArray, theme);
			ecoleeppSercice.addEcoleepp(ecoleepps);
			concernerService.addConcerner(columnStructure, ExcelToArray, theme, ecoleepps);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Visiteur de ferme
		if (theme.equals("1.3.10")) {
			visiteurfermeService.addVisiteur(columnStructure, ExcelToArray, theme);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Visiteur de ferme
		if (theme.equals("2.2.1")) {
			List<Ecoleepp> ecoleepps = ecoleeppSercice.listEcoleepp(columnStructure, ExcelToArray, theme);
			ecoleeppSercice.addEcoleepp(ecoleepps);
			subvenireppService.addSubvenirepp(columnStructure, ExcelToArray, theme, ecoleepps);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Visiteur de ferme
		if (theme.equals("1.2.6")) {
			List<Integer> Index = bonnepratiquefbsService.searchIndex(columnStructure);
			List<Beneficierpgm> beneficiairePlanification = bonnepratiquefbsService.addBonnepratique(ExcelToArray,
					Index, columnStructure, theme);
			bonnepratiquefbsService.addPlanification(beneficiairePlanification, ExcelToArray, Index);
			List<Beneficierpgm> beneficiaireDiversification = bonnepratiquefbsService.addBonnepratique(ExcelToArray,
					Index, columnStructure, theme);
			bonnepratiquefbsService.addDiversification(beneficiaireDiversification, ExcelToArray, Index);
			List<Beneficierpgm> beneficiaireBancarisation = bonnepratiquefbsService.addBonnepratique(ExcelToArray,
					Index, columnStructure, theme);
			bonnepratiquefbsService.addBancarisation(beneficiaireBancarisation, ExcelToArray, Index);
			bonnepratiquefbsService.deleteDuplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Visiteur de ferme
		if (theme.equals("1.2.5")) {
			List<Integer> Index = postformationfbsService.searchIndex(columnStructure);
			List<Beneficierpgm> beneficiaireEFI = postformationfbsService.addPostformation(ExcelToArray, Index,
					columnStructure, theme);
			postformationfbsService.addEFI(beneficiaireEFI, ExcelToArray, Index);
			List<Beneficierpgm> beneficiairePetitElevage = postformationfbsService.addPostformation(ExcelToArray, Index,
					columnStructure, theme);
			postformationfbsService.addPetitElevage(beneficiairePetitElevage, ExcelToArray, Index);
			List<Beneficierpgm> beneficiaireCEP = postformationfbsService.addPostformation(ExcelToArray, Index,
					columnStructure, theme);
			postformationfbsService.addCEP(beneficiaireCEP, ExcelToArray, Index);
			postformationfbsService.deleteDuplicated();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// Taux
		if (theme.equals("2.3.3")) {
			String[][] ExcelToArray40 = ConvertExcelToArray.excelToArray40(excelFile, rowCount, ColCount);
			List<Suivitheme> listSuivithemes = suivithemeService.listSuivitheme(columnStructure, ExcelToArray40, theme);
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		// producteurs formés et sensibilisés
		if (theme.equals("1.2.8")) {

			Map<String, Integer> personneMapping = PersonneMappage.tablePersonne(columnStructure);
			Map<String, Integer> beneficierpgmMapping = BeneficierPgmMappage.tableBeneficierPgmMappage(columnStructure);
			List<Personne> personnes = personneService.createPersonne(ExcelToArray, personneMapping, theme);
			List<Beneficierpgm> beneficierpgm = beneficierPgmService.createBeneficierpgm(ExcelToArray,
					beneficierpgmMapping, theme);

			personneService.addPersonne(personnes);
			personneService.deletePersonneDuplicated();
			List<Long> codePersonne = personneService.findPersonne(personnes);
			List<Beneficierpgm> beneficiairePgrm = beneficierPgmService.addCodePersonne(codePersonne, beneficierpgm);
			beneficierPgmService.addBeneficierPgm(beneficiairePgrm);
			beneficierPgmService.deleteBeneficierDudplicatedCanevas2();
			redirectAttributes.addFlashAttribute("registerFinish", 1);
			return "redirect:/registerFile";
		}

		return "redirect:/registerFile";
	}
}
