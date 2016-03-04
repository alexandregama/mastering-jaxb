package com.mastering.jaxb.book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class BookSerializationTest {

	@Test
	public void shouldMarshalABook() throws Exception {
		Book book = new Book(1L, "SOA", "SOA Architecture");
		
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller marshaller = context.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(book, writer);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(writer.toString());
		Book unmarshalledBook = (Book) unmarshaller.unmarshal(reader);
		
		assertThat(unmarshalledBook.getId(), is(equalTo(1L)));
		assertThat(unmarshalledBook.getCode(), is(equalTo("SOA")));
		assertThat(unmarshalledBook.getName(), is(equalTo("SOA Architecture")));
	}
	
}
