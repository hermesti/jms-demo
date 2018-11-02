package com.sstrategy.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber1 {

	/**
	 * Un suscriptor que recibe mensajes en el topic "mailinglist" y los muestra en consola.
	 */
	@JmsListener(destination = "mailinglist", subscription = "Subscriber1", containerFactory = "topicJmsListenerContainerFactory1")
	public void receiveMailingList(Email email) {
		System.out.println("Suscriptor 1 ha recibido el siguiente objeto Email como mensaje JMS: <" + email + ">");
	}
	
}
