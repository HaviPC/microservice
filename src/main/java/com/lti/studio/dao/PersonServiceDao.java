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
import com.lti.studio.exception.LTIException;
import org.springframework.http.ResponseEntity;

import com.lti.studio.domainObjects.Person;

public interface PersonServiceDao {	
	
	List<Person> getAllPerson() throws LTIException;
	
	Person getPersonById(Integer id) throws LTIException;
	
	void addPerson(Person person) throws LTIException;
	
	void updatePerson(Person person) throws LTIException;
	
	void deletePerson(Integer id) throws LTIException;
	
}
