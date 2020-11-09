package com.nasa.api.scrapper.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nasa.api.scrapper.model.Sol;

/**
 * Sol Service Implementation
 * 
 * @author Pierre
 *
 */
@Service("solServiceImpl")
public class SolServiceImpl implements SolService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public Sol createOrUpdate(Sol sol) {
		entityManager.persist(sol);

		return sol;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Sol> findAll() {
		Query query = entityManager.createQuery("from Sol");
		return (List<Sol>) query.getResultList();
	}
}
