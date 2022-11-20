package mg.giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mg.giz.data.domain.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, String> {
	
	@Query("SELECT v.code_fkt FROM Village v WHERE lower(v.code_fkt) = ?1 ")
	public  String verifyVillage(String code_fkt);

}
