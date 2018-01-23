package com.lti.studio.service;

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
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.studio.dao.PersonServiceDao;
import com.lti.studio.domainObjects.Person;

@Service("personServiceService")
@Transactional
public class PersonServiceServiceImpl implements PersonServiceService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonServiceDao personServiceDao;

	@Override
	public List<Person> getAllPerson() throws LTIException {
		List<Person> person = new ArrayList<Person>();
		try {
			person = personServiceDao.getAllPerson();
			logger.info("Persons Fetched Successfully");
		} catch (Exception e) {
			logger.error("Person Fetching Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
		return person;
	}
	
	@Override
	public void addPerson(Person person) throws LTIException {
		try {
			personServiceDao.addPerson(person);
			logger.info("Person Inserted Successfully");
		} catch (Exception e) {
			logger.error("Person Insertion Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
	}
	
	@Override
	public void deletePerson(Integer id) throws LTIException {
		try {
			personServiceDao.deletePerson(id);
			logger.info("Person Deleted Successfully");
		} catch (Exception e) {
			logger.error("Error Message :: " + e.getMessage());
			logger.error("Person Deletion Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
	}
	
	@Override
	public void updatePerson(Person person, Integer id) throws LTIException {
		try {
			person.setId(id);
			personServiceDao.updatePerson(person);
			logger.info("Person Updated Successfully");
		} catch (Exception e) {
			logger.error("Person Updation Failed :: " + e.getMessage());
			throw new LTIException(e.getMessage());
		}
	}
	
}
	