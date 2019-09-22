package com.example.agenti.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenti.model.ACLMessage;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class AgentCenterController {
	
	@RequestMapping(value="", method = RequestMethod.GET)
    public void testMethod() {
        System.out.println("AgentCenterControllers testMethod. Success.");
    }
	
	@RequestMapping(value = "/agents/classes", method = RequestMethod.GET)
	public void getAllAgents() {
		System.out.println("Get all agent classes");
	}
	
	@RequestMapping(value = "/agents/running", method = RequestMethod.GET)
	public void getAllRunningAgents() {
		System.out.println("Get all running agents");
	}
	
	@RequestMapping(
			value = "/agents/running/{type}/{name}",
			method = RequestMethod.PUT)
	public void startAgent(
			@PathVariable("type")String type,
			@PathVariable("name")String name) {
		System.out.println("Start new " + type + " agent as: " + name);
	}
	
	@RequestMapping(
			value = "/agents/running/{aid}",
			method = RequestMethod.DELETE)
	public void stopAgent(
			@PathVariable("aid")String aid) {
		System.out.println("Stop agent with AID: " + aid);
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
