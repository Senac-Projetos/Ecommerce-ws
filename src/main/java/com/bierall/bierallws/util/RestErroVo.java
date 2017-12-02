package com.bierall.bierallws.util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Joni
 *
 */
public class RestErroVo implements Serializable {

	private static final long serialVersionUID = -4698748822672578829L;

	private ArrayList<String> messages = new ArrayList<>();

	public RestErroVo(final String message) {
		this.addMessage(message);
	}

	public RestErroVo() {
		super();
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void addMessage(final String message) {
		this.messages.add(message);
	}

}