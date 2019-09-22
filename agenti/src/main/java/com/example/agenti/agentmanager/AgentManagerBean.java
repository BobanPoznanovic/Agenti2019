package com.example.agenti.agentmanager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.springframework.stereotype.Service;

import com.example.agenti.model.AID;
import com.example.agenti.model.AgentType;

@Stateless
@Remote(AgentManager.class)
@LocalBean
@Service
public class AgentManagerBean implements AgentManager {

	private static final long serialVersionUID = 180144979784696706L;
	
	/*
	@EJB
	private JndiTreeParser jndiTreeParser;
	
	@EJB
	ConnectionManager com;
	*/

	@Override
	public List<AgentType> getAvailableAgentClasses() {
		// TODO Auto-generated method stub
		System.out.println("Get all agent classes");
		return null;
	}

	@Override
	public List<AID> getRunningAgents() {
		// TODO Auto-generated method stub
		System.out.println("Get all running agents");
		return null;
	}

	@Override
	public AID startClientAgent(AgentType agType, String runtimeName) {
		// TODO Auto-generated method stub
		System.out.println("Start new " + agType + " agent as: " + runtimeName);
		return null;
	}

	@Override
	public void storAgent(AID aid) {
		// TODO Auto-generated method stub
		System.out.println("Stop agent with AID: " + aid.getName());
		
	}

}
