package com.example.agenti.model;

import java.io.Serializable;

public interface Agent extends Serializable {
	
	void handleMessage(ACLMessage message);
}
