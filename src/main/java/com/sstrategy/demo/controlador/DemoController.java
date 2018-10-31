package com.sstrategy.demo.controlador;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String estableceCorreoPorDefecto(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws NoSuchMessageException, IOException {
		
		return "Hello world!";
	}
}
