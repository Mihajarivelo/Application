package mg.giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mg.giz.data.domain.Beneficierpgm;
import mg.giz.data.domain.Personne;
import mg.giz.data.domain.Theme;
import mg.giz.repository.BeneficierpgmRepository;

@Service
public class BeneficierPgmServiceImpl implements BeneficierPgmService {
	@Autowired
	private BeneficierpgmRepository beneficierpgmRepository;

	@Autowired
	private ThemeService themeService;

	@Override
	public List<Beneficierpgm> createBeneficierpgm(String[][] ExcelToArray, Map<String, Integer> beneficierpgmMapping,
			String theme) throws ParseException {
		int indice = -1;
		List<Beneficierpgm> beneficierpgms = new ArrayList<>();
		Long themeId = themeService.findThemeId(theme);

		for (int i = 1; i < ExcelToArray.length; i++) {
			Beneficierpgm beneficierpgm = new Beneficierpgm();

			Theme th = new Theme(themeId);
			beneficierpgm.setTheme(th);

			if (beneficierpgmMapping.containsKey("beneficierpgm_date")) {
				indice = beneficierpgmMapping.get("beneficierpgm_date");
				String dateString = ExcelToArray[i][indice];
				Date date = Date.valueOf(dateString);
				beneficierpgm.setBeneficierpgm_date(date);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_effectif")) {
				indice = beneficierpgmMapping.get("beneficierpgm_effectif");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				beneficierpgm.setBeneficierpgm_effectif((int) doubleValue);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_groupemod")) {
				indice = beneficierpgmMapping.get("beneficierpgm_groupemod");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				beneficierpgm.setBeneficierpgm_groupemod((int) doubleValue);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_lieu")) {
				indice = beneficierpgmMapping.get("beneficierpgm_lieu");
				beneficierpgm.setBeneficierpgm_lieu(ExcelToArray[i][indice]);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_plandeviedeux")) {
				indice = beneficierpgmMapping.get("beneficierpgm_plandeviedeux");
				beneficierpgm.setBeneficierpgm_plandeviedeux(ExcelToArray[i][indice]);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_plandevieun")) {
				indice = beneficierpgmMapping.get("beneficierpgm_plandevieun");
				beneficierpgm.setBeneficierpgm_plandevieun(ExcelToArray[i][indice]);
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_speculation")) {
				indice = beneficierpgmMapping.get("beneficierpgm_speculation");
				if (ExcelToArray[i][indice] != null) {
					beneficierpgm.setBeneficierpgm_speculation(
							ExcelToArray[i][indice].replace("\n", "").replace("\r", "").trim().toUpperCase());
				}
			}

			if (beneficierpgmMapping.containsKey("beneficierpgm_valeur")) {
				indice = beneficierpgmMapping.get("beneficierpgm_valeur");
				double doubleValue = Double.valueOf(ExcelToArray[i][indice]);
				beneficierpgm.setBeneficierpgm_valeur((long) doubleValue);
			}

			if (beneficierpgmMapping.containsKey("inscrismfr_anneesco")) {
				indice = beneficierpgmMapping.get("inscrismfr_anneesco");
				beneficierpgm.setInscrismfr_anneesco(ExcelToArray[i][indice]);
			}

			if (beneficierpgmMapping.containsKey("inscrismfr_niveau")) {
				indice = beneficierpgmMapping.get("inscrismfr_niveau");
				beneficierpgm.setInscrismfr_niveau(ExcelToArray[i][indice]);
			}

			beneficierpgms.add(beneficierpgm);
		}

		return beneficierpgms;
	}

	@Override
	public List<Beneficierpgm> addCodePersonne(List<Long> codePersonne, List<Beneficierpgm> beneficierpgm) {
		for (int i = 0; i < beneficierpgm.size(); i++) {
			Personne p = new Personne(codePersonne.get(i));
			beneficierpgm.get(i).setPersonne(p);
		}
		return beneficierpgm;
	}

	@Override
	public void deleteBeneficierDudplicated() {
		beneficierpgmRepository.deleteBeneficierPgmDudplicated();
	}

	@Override
	public void deleteBeneficierDudplicatedCanevas2() {
		beneficierpgmRepository.deleteBeneficierPgmDudplicated2();
	}
	/*
	 * @Override public List<String> getSensibliseData() { List<String>
	 * listSensiblise = beneficierpgmRepository.fetchSensibliseData(); return
	 * listSensiblise; }
	 */

	@Override
	public List<Beneficierpgm> ListSensibilite(Long theme_id) {
		// TODO Auto-generated method stub
		return beneficierpgmRepository.fetchSensibliseData(theme_id);
	}

	@Override
	public void addBeneficierPgm(List<Beneficierpgm> beneficierpgm) {
		// TODO Auto-generated method stub
		beneficierpgmRepository.saveAll(beneficierpgm);

	}

	@Override
	public void deleteBeneficier(Long id) {
		// TODO Auto-generated method stub
		beneficierpgmRepository.deleteBeneficierQuery(id);
	}

	@Override
	public boolean saveCrudBeneficierpgm(Beneficierpgm beneficierpgm) {
		int countBeforeSave = beneficierpgmRepository.CountBeneficierpgm();
		beneficierpgmRepository.save(beneficierpgm);
		beneficierpgmRepository.deleteBeneficierPgmDudplicated();
		int countAfterSave = beneficierpgmRepository.CountBeneficierpgm();
		if (countBeforeSave == countAfterSave) {
			return true;
		}
		return false;
	}

	@Override
	public Beneficierpgm createBeneficierpgmCrud(Beneficierpgm Beneficierpgm, Integer beneficierpgm_groupemod,
			Long beneficierpgm_valeur, Date beneficierpgm_date, Long personne_id, Long theme_id) {
		Beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		Beneficierpgm.setBeneficierpgm_groupemod(beneficierpgm_groupemod);
		Beneficierpgm.setBeneficierpgm_valeur(beneficierpgm_valeur);

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			Beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			Beneficierpgm.setTheme(th);
		}

		return Beneficierpgm;
	}

	@Override
	public int modifyCrudBeneficierpgm(Beneficierpgm beneficierpgmCreated, Integer beneficierpgm_groupemod,
			Long beneficierpgm_valeur, Date date, Long personne_id, Long theme_id) {
		int record = beneficierpgmRepository.detectDuplicated(beneficierpgm_groupemod, beneficierpgm_valeur, date,
				personne_id, theme_id);
		return record;
	}

	@Override
	public List<Beneficierpgm> SelectSensiblData(Long theme_id, String personne_nom, Date beneficierpgm_date) {
		return beneficierpgmRepository.SelectSensibliseData(theme_id, personne_nom, beneficierpgm_date);
	}

	@Override
	public List<Beneficierpgm> ListFormes(Long theme_id) {
		return beneficierpgmRepository.fetchFormeData(theme_id);
	}

	@Override
	public Beneficierpgm create125Crud(Beneficierpgm beneficierpgm, Date beneficierpgm_date, Long personne_id,
			Long theme_id) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public int modifyCrudBeneficierpgm125(Beneficierpgm beneficierpgmCreated, Date beneficierpgm_date, Long personne_id,
			Long theme_id) {
		int record = beneficierpgmRepository.detectDuplicated125(beneficierpgm_date, personne_id, theme_id);
		return record;
	}

	@Override
	public void beneficierVsla(List<Long> codePersonne, List<Long> codeTheme) {
		List<Beneficierpgm> beneficierpgms = new ArrayList<>();
		for (int i = 0; i < codePersonne.size(); i++) {
			Beneficierpgm beneficierpgm = new Beneficierpgm();

			Theme th = new Theme(codeTheme.get(i));
			beneficierpgm.setTheme(th);

			Personne p = new Personne(codePersonne.get(i));
			beneficierpgm.setPersonne(p);

			beneficierpgms.add(beneficierpgm);
		}

		beneficierpgmRepository.saveAll(beneficierpgms);
		beneficierpgmRepository.deleteVslaDudplicated();
	}

	@Override
	public List<Long> beneficiaireVsla(List<Personne> personnes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficierpgm> ListRenforcement(Long theme_id) {
		return beneficierpgmRepository.fetchRenforcementData(theme_id);
	}

	@Override
	public Beneficierpgm create128Crud(Beneficierpgm beneficierpgm, String beneficierpgm_lieu,
			String beneficierpgm_speculation, Date beneficierpgm_date, Long personne_id, Long theme_id) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		beneficierpgm.setBeneficierpgm_lieu(beneficierpgm_lieu);
		beneficierpgm.setBeneficierpgm_speculation(beneficierpgm_speculation);
		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public int modifyCrudBeneficierpgm128(Beneficierpgm beneficierpgm, String beneficierpgm_lieu,
			String beneficierpgm_speculation, Date beneficierpgm_date, Long personne_id, Long theme_id) {
		int record = beneficierpgmRepository.detectDuplicated128(beneficierpgm_lieu, beneficierpgm_speculation,
				beneficierpgm_date, personne_id, theme_id);
		return record;
	}

	@Override
	public Beneficierpgm create214Crud(Beneficierpgm beneficierpgm, String inscrismfr_anneesco, Date beneficierpgm_date,
			Long personne_id, Long theme_id) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		beneficierpgm.setInscrismfr_anneesco(inscrismfr_anneesco);
		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public int modifyCrudBeneficierpgm214(Beneficierpgm beneficierpgm, String inscrismfr_anneesco,
			Date beneficierpgm_date, Long personne_id, Long theme_id) {
		int record = beneficierpgmRepository.detectDuplicated214(inscrismfr_anneesco, beneficierpgm_date, personne_id,
				theme_id);
		return record;
	}

	@Override
	public List<Beneficierpgm> List311(String theme_programme) {
		return beneficierpgmRepository.list311(theme_programme);
	}

	@Override
	public Beneficierpgm create311Crud(Beneficierpgm beneficierpgm, Long personne_id, Long theme_id) {

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public Beneficierpgm create228Crud(Beneficierpgm beneficierpgm, Date beneficierpgm_date, String beneficierpgm_lieu,
			String beneficierpgm_plandeviedeux, Long personne_id, Long theme_id) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		beneficierpgm.setBeneficierpgm_lieu(beneficierpgm_lieu);
		beneficierpgm.setBeneficierpgm_plandeviedeux(beneficierpgm_plandeviedeux);
		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public Beneficierpgm createBeneficierpgm3210Crud(Beneficierpgm beneficierpgm, Long beneficierpgm_valeur,
			Date beneficierpgm_date, Long personne_id, Long theme_id) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		beneficierpgm.setBeneficierpgm_valeur(beneficierpgm_valeur);

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public List<Beneficierpgm> List144(Long theme_id) {
		return beneficierpgmRepository.fetch144Data(theme_id);
	}

	@Override
	public Beneficierpgm createBenefigierpgm1410Crud(Beneficierpgm beneficierpgm, Long personne_id, Long theme_id,
			Date beneficierpgm_date) {
		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}
		return beneficierpgm;
	}

	@Override
	public Beneficierpgm createBenefCrud213(Beneficierpgm beneficierpgm, Long personne_id, Long theme_id,
			String inscrismfr_niveau, String inscrismfr_anneesco, Date beneficierpgm_date) {

		beneficierpgm.setBeneficierpgm_date(beneficierpgm_date);
		beneficierpgm.setInscrismfr_anneesco(inscrismfr_anneesco);
		beneficierpgm.setInscrismfr_niveau(inscrismfr_niveau);

		if (personne_id > 0) {
			Personne vl = new Personne(personne_id);
			beneficierpgm.setPersonne(vl);
		}
		if (theme_id > 0) {
			Theme th = new Theme(theme_id);
			beneficierpgm.setTheme(th);
		}

		return beneficierpgm;
	}

	@Override
	public List<Beneficierpgm> listBenef213() {
		return beneficierpgmRepository.listBenef213();
	}

	@Override
	public Long VerifyDuplicatedCrud(Long personne_id, Long theme_id, Date beneficierpgm_date) {
		return beneficierpgmRepository.VerifyDuplicatedCrud(personne_id, theme_id, beneficierpgm_date);
	}
}
