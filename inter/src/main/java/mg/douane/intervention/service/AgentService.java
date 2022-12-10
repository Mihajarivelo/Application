package mg.douane.intervention.service;

import mg.douane.intervention.data.domaine.Agent;
import mg.douane.intervention.data.dto.ChangePasswordDto;

public interface AgentService {

    public Iterable<Agent> getAllAgents();

    public Agent createAgent(Agent agent) throws Exception;

    public Agent getAgentById(String id) throws Exception;

    public Agent updateAgent(Agent agent) throws Exception;

    public void deleteAgent(String id) throws Exception;

    public Agent ChangePasswordDto(ChangePasswordDto form) throws Exception;
}
