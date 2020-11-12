package com.nasa.api.scrapper.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nasa.api.scrapper.model.Sol;

/**
 * Sol Repository
 * 
 * @author Pierre
 *
 */
@Repository
public interface SolRepository extends CrudRepository<Sol, Long> {

	@Query("select s from Sol s where s.key = :key")
	Sol findByKey(@Param("key") int key);

	@Query("delete from Sol s where s.key = :key")
	void deleteByKey(@Param("key") int key);

	@Query("select case when count(s)> 0 then true else false end from Sol s where s.key = :key")
	boolean existsByKey(@Param("key") int key);
}
