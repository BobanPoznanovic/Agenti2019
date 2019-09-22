package com.example.agenti.agentmanager;

import java.io.Serializable;
import java.util.List;

import com.example.agenti.model.AID;
import com.example.agenti.model.AgentType;

public interface AgentManager extends Serializable {
	
	public List<AgentType> getAvailableAgentClasses();
	
	public List<AID> getRunningAgents();
	
	public AID startClientAgent(AgentType agType, String runtimeName);
	
	public void storAgent(AID aid);

}
