package com.bierall.bierallws.cervejaria.rn;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bierall.bierallws.cerveja.CervejaResponse;
import com.bierall.bierallws.cerveja.model.Cerveja;
import com.bierall.bierallws.cervejaria.CervejariaResponse;
import com.bierall.bierallws.cervejaria.model.Cervejaria;
import com.bierall.bierallws.dao.CervejariaDAO;

@Service
public class CervejariaRN {

	@Autowired
	private CervejariaDAO dao;

	public void salvar(final Cervejaria cervejaria) {
		this.dao.persist(cervejaria);
	}

	public CervejariaResponse getCervejariaResponse(final Long id) {
		final Cervejaria cervejaria = this.dao.findById(id);
		CervejariaResponse cervejariaResponse = null;
		if (cervejaria != null) {
			cervejariaResponse = new CervejariaResponse();
			cervejariaResponse.setId(String.valueOf(cervejaria.getId()));
			cervejariaResponse.setNome(String.valueOf(cervejaria.getNome()));
			if (CollectionUtils.isNotEmpty(cervejaria.getCervejas())) {
				for (final Cerveja c : cervejaria.getCervejas()) {
					final CervejaResponse cervejaResponse = new CervejaResponse();
					cervejaResponse.setId(String.valueOf(c.getId()));
					cervejaResponse.setNome(String.valueOf(c.getNome()));
					cervejaResponse.setPreco(String.valueOf(c.getPreco()));
					cervejaResponse.setTipo(String.valueOf(c.getTipo()));
					cervejariaResponse.getCervejasResponse().add(cervejaResponse);
				}
			}
		}
		return cervejariaResponse;
	}

	public void atualizar(final Cervejaria cervejaria) {
		this.dao.update(cervejaria);
	}

	public void deletar(final Long id) {
		this.dao.delete(id);
	}

	public List<CervejariaResponse> getCervejariasResponse() {
		final List<Cervejaria> cervejarias = this.dao.findAll();
		final List<CervejariaResponse> cervejariaResponses = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(cervejarias)) {
			for (final Cervejaria cervejaria : cervejarias) {
				final CervejariaResponse cervejariaResponse = new CervejariaResponse();
				cervejariaResponse.setId(String.valueOf(cervejaria.getId()));
				cervejariaResponse.setNome(String.valueOf(cervejaria.getNome()));
				cervejariaResponses.add(cervejariaResponse);
			}
		}
		return cervejariaResponses;
	}

}