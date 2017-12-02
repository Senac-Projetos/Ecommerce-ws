package com.bierall.bierallws.util;

import java.io.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Joni
 *
 */
public class JsonUtil implements Serializable {

	private static final long serialVersionUID = 6645086833069573829L;

	public static <T> String convertToJson(final T entity) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(entity);
		} catch (final Exception e) {
			// TODO: ADD LOG
			System.out.println(e);
		}
		return null;
	}
}