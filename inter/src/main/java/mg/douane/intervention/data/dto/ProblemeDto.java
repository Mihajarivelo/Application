package mg.douane.intervention.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemeDto {
    private Long idProb;
    private String libelleProb;
    private String intervenant;
    private String statut;
    private String dateEnvProb;
}
