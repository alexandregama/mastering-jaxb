package com.mastering.jaxb.book;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
