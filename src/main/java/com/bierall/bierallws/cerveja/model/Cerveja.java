package com.bierall.bierallws.cerveja.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author Joni
 *
 */
@Entity
public class Cerveja implements Serializable {

	private static final long serialVersionUID = 6653912640677700249L;
	private Long id;
	private String nome;
	private Tipo tipo;
	private BigDecimal preco;
	private String descricao;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cerveja")
	@SequenceGenerator(name = "seq_cerveja", sequenceName = "seq_cerveja", allocationSize = 1, initialValue = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome", length = 60)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 7)
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "preco", scale = 2)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Column(name = "descricao", length = 200)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}