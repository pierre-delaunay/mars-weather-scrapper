package com.nasa.api.scrapper.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nasa.api.scrapper.ScrapperApplication;
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

	private static final Logger logger = LoggerFactory.getLogger(ScrapperApplication.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Transactional
	@Override
	public Sol createOrUpdate(Sol sol) {
		if (isSolExist(sol.getKey())) {
			logger.info("Sol Service :: Storing existing Sol in DB - {}",
					dateTimeFormatter.format(LocalDateTime.now()));
			entityManager.merge(sol);
		} else {
			logger.info("Sol Service :: Storing new Sol in DB - {}", dateTimeFormatter.format(LocalDateTime.now()));
			entityManager.persist(sol);
		}
		return sol;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sol> findAll() {
		Query query = entityManager.createQuery("from Sol");
		return (List<Sol>) query.getResultList();
	}

	@Override
	public Sol findByKey(int key) {
		logger.info("Sol Service :: Finding Sol by key");
		return entityManager.find(Sol.class, key);
	}

	@Override
	public boolean isSolExist(int key) {
		Long count = (Long) entityManager.createQuery("select count(s) from Sol s where s.key = :key")
				.setParameter("key", key).getSingleResult();
		return ((count.equals(0L)) ? false : true);
	}
}
