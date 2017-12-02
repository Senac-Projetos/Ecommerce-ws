package com.bierall.bierallws.cerveja;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bierall.bierallws.cerveja.model.Cerveja;
import com.bierall.bierallws.cerveja.rn.CervejaRN;
import com.bierall.bierallws.util.RestUtil;
import com.google.gson.Gson;

/**
 * 
 * @author Joni
 *
 */
@RestController
@RequestMapping("/cerveja")
public class CervejaWS {

	@Autowired
	private CervejaRN cervejaRN;

	
	
	
	
	
	@RequestMapping(method = GET, path = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable(required = true) final Long id) {
		HttpStatus httpStatus = HttpStatus.OK;
		final CervejaResponse cervejaResponse = this.cervejaRN.getCervejaResponse(id);
		if (cervejaResponse == null) {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(httpStatus).body(new Gson().toJson(cervejaResponse));
	}

	
	
	
	
	
	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@Valid @RequestBody(required = true) final Cerveja cerveja, final Errors errors) {
		if (RestUtil.existeErroNaRequisicao(errors)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
		} else {
			this.cervejaRN.salvar(cerveja);
		}
		return ResponseEntity.status(CREATED).build();
	}

	
	
	
	
	
	@RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) final Cerveja cerveja, final Errors errors) {
		if (RestUtil.existeErroNaRequisicao(errors)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
		} else {
			this.cervejaRN.atualizar(cerveja);
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	

	@RequestMapping(method = DELETE, path = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(required = true) final Long id) {
		this.cervejaRN.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
	
	
}