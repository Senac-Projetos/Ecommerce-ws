package com.bierall.bierallws.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bierall.bierallws.cervejaria.model.Cervejaria;

/**
 * 
 * @author Joni
 *
 */
@Repository
public class CervejariaDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(final Cervejaria cervejaria) {
		cervejaria.setId(null);
		this.em.persist(cervejaria);
	}

	public Cervejaria findById(final Long id) {
		return this.em.find(Cervejaria.class, id);
	}

	@Transactional
	public void update(final Cervejaria cervejaria) {
		this.em.merge(cervejaria);
	}

	@Transactional
	public void delete(final Long id) {
		final Cervejaria cervejaria = this.findById(id);
		this.em.remove(cervejaria);
	}

	@SuppressWarnings("unchecked")
	public List<Cervejaria> findAll() {
		final Session session = (Session) this.em.getDelegate();
		final DetachedCriteria criteria = DetachedCriteria.forClass(Cervejaria.class, "c");
		return (List<Cervejaria>) criteria.getExecutableCriteria(session).list().stream().collect(Collectors.toList());
	}

}