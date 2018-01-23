package com.lti.studio.controller; 

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

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lti.studio.domainObjects.Person;
import com.lti.studio.service.PersonServiceService;

@Api(tags = "Service Title", description = "Service Desc")
@RequestMapping(value = "/personservice")
@RestController
public class PersonServiceController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private PersonServiceService personServiceService;
	
	/**
	 * Api endpoint to retrieve list of Person.
	 */
	@ApiOperation(value = "Read")
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List<Person> listPerson() {
		List<Person> persons = new ArrayList<Person>();
		try {
			persons = personServiceService.getAllPerson();
			logger.info("Persons Fetched Successfully");
		} catch (Throwable e) {
			logger.error("Person Fetching Failed :: " + e.getMessage());
			return null;
		}
		return persons;
	}
	
	/**
	 * Api endpoint to insert record of Person.
	 */
	@ApiOperation(value = "Create")
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<String> addPerson(@RequestBody Person person) {
		ResponseEntity<String> responseObject = new ResponseEntity<String>(HttpStatus.OK); 
		try {
			personServiceService.addPerson(person);
			responseObject = new ResponseEntity<String>("Person Inserted Successfully", HttpStatus.OK);
			logger.info("Person Inserted Successfully");
		} catch (Throwable e) {
			responseObject = new ResponseEntity<String>("Person Insertion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Person Insertion Failed :: " + e.getMessage());
		}
		return responseObject;
	}
	
	/**
	 * Api endpoint to delete record of Person.
	 */
	@ApiOperation(value = "Delete")
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePerson(@RequestBody Person person, @PathVariable(value = "id") Integer id) {
		ResponseEntity<String> responseObject = new ResponseEntity<String>(HttpStatus.OK);
		try {
			personServiceService.deletePerson(id);
			responseObject = new ResponseEntity<String>("Person Deleted Successfully", HttpStatus.OK);
			logger.info("Person Deleted Successfully");
		} catch (Throwable e) {
			responseObject = new ResponseEntity<String>("Person Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Person Deletion Failed :: " + e.getMessage());
		}
		return responseObject;
	}
	
	/**
	 * Api endpoint to update record of Person.
	 */
	@ApiOperation(value = "Update")
	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updatePerson(@RequestBody Person person, @PathVariable(value = "id") Integer id) {
		ResponseEntity<String> responseObject = new ResponseEntity<String>(HttpStatus.OK);
		try {
			personServiceService.updatePerson(person, id);
			responseObject = new ResponseEntity<String>("Person Updated Successfully", HttpStatus.OK);
			logger.info("Person Updated Successfully");
		} catch (Throwable e) {
			responseObject = new ResponseEntity<String>("Person Updation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Person Updation Failed :: " + e.getMessage());
		}
		return responseObject;
	}
}
