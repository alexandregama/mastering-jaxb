package com.mastering.jaxb.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@XmlElement(name = "id")
	private Long id;

	@XmlElement(name = "first_name")
	private String name;
	
	@Deprecated //JAX-B eyes only
	User() {
	}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	//We don't need to write the setters, we are using @XmlAccessorType
}
