package com.lti.studio.dao;

/*************************************************************************
 * 
 * LTI CONFIDENTIAL
 * __________________
 * 
 * NOTICE:  All information contained herein is, and remains 
 * the property of LTI.  The intellectual and technical
 * concepts contained herein are proprietary to LTI and 
 * are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from LTI.
 */ 

import java.util.List;
import java.util.ArrayList;
import com.lti.studio.exception.LTIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.studio.domainObjects.Person;

@Repository
public class PersonServiceDaoImpl implements PersonServiceDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager entityManager;

	@Cacheable(value = "personcache")
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPerson() throws LTIException {
		List<Person> person = new ArrayList<Person>();
		try {
			String hql = "FROM Person";
			person = (List<Person>) entityManager.createQuery(hql).getResultList();
			logger.info("Persons Fetched Successfully");
		} catch (Exception e) {
			logger.error("Persons Fetching Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
		return person;
	}
		
	@Override
	public Person getPersonById(Integer id) throws LTIException {
		Person person = new Person();
		try {
			String hql = "FROM Person as person WHERE person.id=?";
			person = (Person) entityManager.createQuery(hql).setParameter(1, id).getSingleResult();
			logger.info("Person Fetched Successfully");
		} catch (Exception e) {
			logger.error("Person Fetching Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
		return person;
	}
		
	@CacheEvict(value = "personcache", allEntries=true)
	@Override
	public void addPerson(Person person) throws LTIException {
		try {
			entityManager.persist(person);
			logger.info("Person Inserted Successfully");
		} catch (Exception e) {
			logger.error("Person Insertion Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
	}
		
	@CacheEvict(value = "personcache", allEntries=true)
	@Override
	public void deletePerson(Integer id) throws LTIException {
		try {
			Person person = getPersonById(id);
			if (person != null) {
				entityManager.remove(person);
			}
			logger.info("Person Deleted Successfully");
		} catch (Exception e) {
			logger.error("Person Deletion Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}	
	}
		
	@CacheEvict(value = "personcache", allEntries = true)
	@Override
	public void updatePerson(Person person) throws LTIException {
		try {
			Person personAlias = getPersonById(person.getId());
			if (person != null) {
				personAlias.setId(person.getId());
				personAlias.setName(person.getName());
				entityManager.flush();		
			}
			logger.info("Person Updated Successfully");
		} catch (Exception e) {
			logger.error("Person Updation Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}			
	}
	
}