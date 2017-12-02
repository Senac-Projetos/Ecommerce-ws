package com.bierall.bierallws.cervejaria;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bierall.bierallws.cervejaria.model.Cervejaria;
import com.bierall.bierallws.cervejaria.rn.CervejariaRN;
import com.bierall.bierallws.util.RestUtil;
import com.google.gson.Gson;

/**
 * 
 * @author Joni
 *
 */
@RestController
@RequestMapping("/cervejaria")
public class CervejariaWS {

	@Autowired
	private CervejariaRN cervejariaRN;

	
	
	
	
	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		HttpStatus httpStatus = HttpStatus.OK;
		final List<CervejariaResponse> cervejariasResponse = this.cervejariaRN.getCervejariasResponse();
		if (cervejariasResponse == null) {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(httpStatus).body(new Gson().toJson(cervejariasResponse));
	}
	
	
	
	
	
	@RequestMapping(method = GET, path = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable(required = true) final Long id) {
		HttpStatus httpStatus = HttpStatus.OK;
		final CervejariaResponse cervejaResponse = this.cervejariaRN.getCervejariaResponse(id);
		if (cervejaResponse == null) {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(httpStatus).body(new Gson().toJson(cervejaResponse));
	}

	
	
	
	
	
	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@Valid @RequestBody(required = true) final Cervejaria cervejaria, final Errors errors) {
		if (RestUtil.existeErroNaRequisicao(errors)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
		} else {
			this.cervejariaRN.salvar(cervejaria);
		}
		return ResponseEntity.status(CREATED).build();
	}

	
	
	
	
	
	@RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) final Cervejaria cervejaria, final Errors errors) {
		if (RestUtil.existeErroNaRequisicao(errors)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
		} else {
			this.cervejariaRN.atualizar(cervejaria);
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	

	@RequestMapping(method = DELETE, path = "/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable(required = true) final Long id) {
		this.cervejariaRN.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
	
	
}