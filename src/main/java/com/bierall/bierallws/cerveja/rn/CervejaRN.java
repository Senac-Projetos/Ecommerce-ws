package com.bierall.bierallws.cerveja.rn;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bierall.bierallws.cerveja.CervejaResponse;
import com.bierall.bierallws.cerveja.model.Cerveja;
import com.bierall.bierallws.dao.CervejaDAO;

@Service
public class CervejaRN {
	
	
	@Autowired
	private CervejaDAO dao;

	
	
	
	
	
	public void salvar(final Cerveja cerveja) {
		this.dao.persist(cerveja);
	}

	
	
	
	
	
	public CervejaResponse getCervejaResponse(final Long id) {
		final Cerveja cerveja = this.dao.findById(id);
		CervejaResponse cervejaResponse = null;
		if (cerveja != null) {
			cervejaResponse = new CervejaResponse();
			cervejaResponse.setId(String.valueOf(cerveja.getId()));
			cervejaResponse.setTipo(String.valueOf(cerveja.getTipo().name()));
			cervejaResponse.setNome(String.valueOf(cerveja.getNome()));
			cervejaResponse.setPreco(String.valueOf(cerveja.getPreco()));
			cervejaResponse.setDescricao(String.valueOf(cerveja.getDescricao()));
		}
		return cervejaResponse;
	}

	
	
	
	
	
	public void atualizar(final Cerveja cerveja) {
		this.dao.update(cerveja);
	}

	
	
	
	
	public void deletar(final Long id) {
		this.dao.delete(id);
	}






	public List<CervejaResponse> getCervejasResponse() {
		final List<Cerveja> cervejas = this.dao.findAll();
		final List<CervejaResponse> cervejaResponses = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(cervejas)) {
			for (final Cerveja cerveja : cervejas) {
				final CervejaResponse cervejaResponse = new CervejaResponse();
				cervejaResponse.setId(String.valueOf(cerveja.getId()));
				cervejaResponse.setTipo(String.valueOf(cerveja.getTipo().name()));
				cervejaResponse.setNome(String.valueOf(cerveja.getNome()));
				cervejaResponse.setPreco(String.valueOf(cerveja.getPreco()));
				cervejaResponse.setDescricao(String.valueOf(cerveja.getDescricao()));
				cervejaResponses.add(cervejaResponse);
			}
		}
		return cervejaResponses;
	}

}