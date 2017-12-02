package com.bierall.bierallws.cervejaria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.bierall.bierallws.cerveja.model.Cerveja;

/**
 * 
 * @author Joni
 *
 */
@Entity
public class Cervejaria implements Serializable {

	private static final long serialVersionUID = 70923809884884374L;
	private Long id;
	private String nome;
	private String cnpj;
	private List<Cerveja> cervejas;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cervejaria")
	@SequenceGenerator(name = "seq_cervejaria", sequenceName = "seq_cervejaria", allocationSize = 1, initialValue = 1)
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

	@Column(name = "cnpj", length = 14)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@OneToMany(fetch = FetchType.LAZY)
	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}

}