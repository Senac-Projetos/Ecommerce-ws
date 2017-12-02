package com.bierall.bierallws.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bierall.bierallws.cerveja.model.Cerveja;

/**
 * 
 * @author Joni
 *
 */
@Repository
public class CervejaDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(final Cerveja cerveja) {
		cerveja.setId(null);
		this.em.persist(cerveja);
	}

	public Cerveja findById(final Long id) {
		return this.em.find(Cerveja.class, id);
	}

	@Transactional
	public void update(final Cerveja cerveja) {
		this.em.merge(cerveja);
	}

	@Transactional
	public void delete(final Long id) {
		final Cerveja cerveja = this.findById(id);
		this.em.remove(cerveja);
	}

}