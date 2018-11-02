package com.sstrategy.demo;

import java.io.Serializable;

/**
 * Un POJO para ser publicado en forma de mensaje JMS.
 */
public class Email implements Serializable {

	/**
	 * Serial version UID autogenerado.
	 * Para poder convertir un objeto en un mensaje JMS, es necesario que sea serializable, y con un serialVersionUID único.
	 */
	private static final long serialVersionUID = -3579805425262712807L;
	
	private String to;
	private String body;

	public Email() {
	}

	public Email(String to, String body) {
		this.to = to;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return String.format("Email{to=%s, body=%s}", getTo(), getBody());
	}

}
