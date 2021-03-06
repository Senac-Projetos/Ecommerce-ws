package com.bierall.bierallws.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * 
 * @author Joni
 *
 */
public class RestUtil {

	public static boolean existeErroNaRequisicao(final Errors errors) {
		if (errors.hasErrors()) {
			return true;
		}
		return false;
	}

	public static String getErros(final Errors errors) {
		final RestErroVo restErroVo = new RestErroVo();
		if (errors.hasErrors()) {
			for (final ObjectError e : errors.getAllErrors()) {
				restErroVo.addMessage(e.getDefaultMessage());
			}
		}
		return JsonUtil.convertToJson(restErroVo);
	}

}