package com.bierall.bierallws.cerveja;

import java.io.Serializable;

/**
 * 
 * @author Joni
 *
 */
public class CervejaResponse implements Serializable {

	private static final long serialVersionUID = 7931258818413872113L;

	private String id;
	private String nome;
	private String tipo;
	private String preco;
	private String descricao;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
