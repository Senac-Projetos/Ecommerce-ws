package com.bierall.bierallws.cervejaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bierall.bierallws.cerveja.CervejaResponse;

/**
 * 
 * @author Joni
 *
 */
public class CervejariaResponse implements Serializable {

	private static final long serialVersionUID = 7931258818413872113L;

	private String id;
	private String nome;
	private String cnpj;
	private List<CervejaResponse> cervejasResponse;

	public CervejariaResponse() {
		this.cervejasResponse = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<CervejaResponse> getCervejasResponse() {
		return cervejasResponse;
	}

	public void setCervejasResponse(List<CervejaResponse> cervejasResponse) {
		this.cervejasResponse = cervejasResponse;
	}

}