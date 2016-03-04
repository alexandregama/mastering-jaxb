# Mastering JAXB

## Configuration

We must configure our class to be enable to use Marshal and Unmarshal operations from JAX-B implementation.

The correct minimal configuration is following:

```java
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

	//setters to enable JAX-B to write our object data
}

```

##### Some problems in the way

**Problem 1**
```
javax.xml.bind.MarshalException
 - with linked exception:
[com.sun.istack.internal.SAXException2: unable to marshal type "com.mastering.jaxb.book.Book" as an element because it is missing an @XmlRootElement annotation]
```
We must to use ```java @XmlRootElement``` in the class configuration

**Problem 2**
```java
com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions
com.mastering.jaxb.book.Book does not have a no-arg default constructor.
	this problem is related to the following location:
		at com.mastering.jaxb.book.Book
```
As the error said, we must to provide a no-arg default constructor

**Problem 3**

Book object without information
```
Book [id=null, code=null, name=null]
```
This happens because we must to create all setters that we would like to work with. By default, JAX-B will use **getters** and **setters** to serialize object informations.

