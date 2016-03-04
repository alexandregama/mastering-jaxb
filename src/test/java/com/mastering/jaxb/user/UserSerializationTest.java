package com.mastering.jaxb.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class UserSerializationTest {

	@Test
	public void shouldMarshalAnUser() throws Exception {
		User user = new User(1L, "Alexandre");
		
		JAXBContext context = JAXBContext.newInstance(User.class);
		Marshaller marshaller = context.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(user, writer);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = new StringReader(writer.toString());
		User unmarshalledUser = (User) unmarshaller.unmarshal(reader);
		
		assertThat(unmarshalledUser.getId(), is(equalTo(1L)));
		assertThat(unmarshalledUser.getName(), is(equalTo("Alexandre")));
	}
	
}
