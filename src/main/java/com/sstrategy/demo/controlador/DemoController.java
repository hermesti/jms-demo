package com.sstrategy.demo.controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.NoSuchMessageException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sstrategy.demo.Email;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired @Qualifier("jmsQueueTemplate")
	JmsTemplate jmsQueueTemplate;
	
	@Autowired @Qualifier("jmsTopicTemplate")
	JmsTemplate jmsTopicTemplate;
	
	@RequestMapping(value = "objeto-punto-a-punto", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String objetoPuntoAPunto(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws NoSuchMessageException, IOException {
		
		jmsQueueTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
		
		// Un timestamp para mostrar en pantalla y verificar el instante en que se hace la petición.
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return timestamp + " - Se ha enviado un objeto Email a la cola llamada 'mailbox'.";
	}
	
	@RequestMapping(value = "objeto-broadcast", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String objetoBroadcasts(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
					throws NoSuchMessageException, IOException {
		
		jmsTopicTemplate.convertAndSend("mailinglist", new Email("info@example.com", "Broadcast"));
		
		// Un timestamp para mostrar en pantalla y verificar el instante en que se hace la petición.
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return timestamp + " - Se ha enviado un objeto Email al topic llamado 'mailinglist'.";
	}
}
