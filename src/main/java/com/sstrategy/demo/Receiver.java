package com.sstrategy.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	/**
	 * Este escuchador de mensajes JMS recibe mensajes de la cola llamada "mailbox".
	 * @param email el objeto Email publicado en forma de mensaje.
	 */
	@JmsListener(destination = "mailbox", containerFactory = "queueJmsListenerContainerFactory")
	public void receiveMailbox(Email email) {
		System.out.println("Se ha recibido el siguiente objeto Email como mensaje JMS: <" + email + ">");
	}
	
}
