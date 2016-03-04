package com.mastering.jaxb.book;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Book {

	private Long id;

	private String code;

	private String name;

	@Deprecated // JAX-B eyes only
	Book() {
	}

	public Book(Long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	//We must use the @XmlElement here because the JAX-B uses by default AccessorType.PUBLIC_MEMBER, that is, getter and setter
	@XmlElement(name = "id", required = true) 
	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

}
