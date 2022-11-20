package mg.giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import mg.giz.data.domain.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
	
	@Query("SELECT min(theme_id) FROM Theme t WHERE t.theme_lib = ?1 AND t.theme_programme = ?2 AND t.code_fkt = ?3" )
    Long findThemeIdVsla(String theme, String theme_programme, String code_fkt);
	
	@Query("SELECT min(theme_id) FROM Theme t WHERE t.theme_lib = ?1")
    Long findThemeId(String theme);
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '1.2.2'")
	Long selectId();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '1.2.5a'")
	Long select125();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = ?1")
	Long selectThm(String theme_lib);
	
	@Transactional
	@Modifying
	@Query("delete from Theme where theme_id not in (Select min(theme_id) "
			+ "from Theme "
			+ "group by code_fkt, theme_lib, theme_date)")
	void deleteThemeDuplicated();
	
	@Query("SELECT t FROM Theme t WHERE t.theme_id = ?1" )
    Theme findThemeId(Long theme_id);
	
	@Query("SELECT count(*) FROM Theme")
    int CountTheme();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = ?1 AND t.theme_programme = ?2")
    Long selectThemeId(String theme_lib,String theme_programme);
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '2.3.8'")
	Long selectTheme238();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '4.4.1'")
	Long selectTheme441();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '1.4.4'")
	Long selectTheme144();
	
	@Query("SELECT t FROM Theme t WHERE t.theme_programme = 'MFR'")
    List<Theme> themeMFR();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '1.3.5'")
	Long selectTheme135();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_lib = '2.1.3'")
	Long selectTheme213();
	
	@Query("SELECT theme_id FROM Theme t WHERE t.theme_programme = 'FBS'")
	Long selectThemeFBS();
}
