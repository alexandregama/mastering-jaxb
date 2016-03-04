package com.mastering.jaxb.book;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;

public class GenerateBookXsd {

	@Test
	public void shouldGenerateANewXsdForBookClass() throws Exception {
		JAXBContext context = JAXBContext.newInstance(Book.class);
		
		context.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				StreamResult stream = new StreamResult(new File("book-schema.xsd"));
				return stream;
			}
		});
	}
	
}
