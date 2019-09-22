package com.example.agenti.controller;

import javax.ejb.EJB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenti.agentmanager.AgentManager;
import com.example.agenti.model.ACLMessage;
import com.example.agenti.model.AID;
import com.example.agenti.model.AgentType;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class AgentCenterController {
	
	@Autowired
	public AgentManager agm;
	
	@RequestMapping(
			value="", 
			method = RequestMethod.GET)
    public void testMethod() {
        System.out.println("AgentCenterControllers testMethod. Success.");
    }
	
	@RequestMapping(
			value = "/agents/classes", 
			method = RequestMethod.GET)
	public void getAllAgents() {
		agm.getAvailableAgentClasses();
	}
	
	@RequestMapping(
			value = "/agents/running", 
			method = RequestMethod.GET)
	public void getAllRunningAgents() {
		agm.getRunningAgents();
	}
	
	@RequestMapping(
			value = "/agents/running/{type}/{name}",
			method = RequestMethod.PUT)
	public void startAgent(
			@PathVariable("type")String type,
			@PathVariable("name")String name) {
		
		AgentType agType = new AgentType();
		agType.setName(name);
		agType.setModule(type);
		
		agm.startClientAgent(agType, name);
	}
	
	@RequestMapping(
			value = "/agents/running/{aid}",
			method = RequestMethod.DELETE)
	public void stopAgent(
			@PathVariable("aid")String aid) {
		
		AID myAID = new AID();
		myAID.setName(aid);
		
		agm.storAgent(myAID);
	}
	
	@RequestMapping(
			value = "/messages",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendACLMessage(@RequestBody ACLMessage message) {
		System.out.println(message.sender + " sent: " + message.content);
	}
	
	@RequestMapping(
			value = "/messages",
			method = RequestMethod.GET)
	public void getAllPerformatives() {
		System.out.println("Performatives");
	}
	
}
