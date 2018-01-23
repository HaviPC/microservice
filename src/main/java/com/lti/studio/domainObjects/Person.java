package com.lti.studio.domainObjects;

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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
	@NotNull
	@ApiModelProperty(value = "ID desc")
	@Column(name="id")
	private Integer id;
	@NotNull
	@ApiModelProperty(value = "Name desc")
	@Column(name="name")
	private String name;


	//POJOOBJECT $key BEGIN
	
	//POJOOBJECT $key END

	public void clear() {
	}
	

	//For Referenced Entity In Constructor

	public Person(Integer id, String name) {
		this.id= id;
		this.name= name;
	}

	//Default Constructor
	public Person(){
		
	}

	//Generate the getters and setters for the fields
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	//POJOSETTERGETTER $key BEGIN
	
	//POJOSETTERGETTER $key END
}