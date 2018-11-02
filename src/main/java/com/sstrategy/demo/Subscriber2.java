package com.sstrategy.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber2 {

	/**
	 * Un suscriptor que recibe mensajes en el topic "mailinglist" y los muestra en consola.
	 */
	@JmsListener(destination = "mailinglist", subscription = "Subscriber2", containerFactory = "topicJmsListenerContainerFactory2")
	public void receiveMailingList(Email email) {
		System.out.println("Suscriptor 2 ha recibido el siguiente objeto Email como mensaje JMS: <" + email + ">");
	}
	
}
