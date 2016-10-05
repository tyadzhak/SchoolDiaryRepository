package com.tiad.SchoolDiary.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import junit.framework.TestCase;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.impl.PersonImpl;
import com.tiad.SchoolDiary.rest.MainResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/applicationContext.xml" })
public class RestTestCase extends TestCase {

	public final String BASE_URI = "http://localhost:8080/SchoolDiary/webapi";
	private HttpServer server;

	@Before
	public void setUp() {
//		try {
			final ResourceConfig rc = new ResourceConfig(MainResource.class);
			URI uri = URI.create(BASE_URI);
			assertNotNull(uri);
			server = GrizzlyHttpServerFactory.createHttpServer(uri, rc);
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}

	@After
	public void tearDown() {
		server.shutdownNow();
	}

	@Test
	public void simpleRequestTest() {
//		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(BASE_URI).path("MainResource/PersonResponse");
			Response response = target.request().accept(MediaType.APPLICATION_JSON)
					.buildGet().invoke();
			
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			PersonImpl ent = response.readEntity(PersonImpl.class);
			assertNotNull(ent);
			//todo continue test ... 
			
			target = client.target(BASE_URI).path("MainResource/Person");
			response = target.request().accept(MediaType.APPLICATION_JSON)
					.buildGet().invoke();
			
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			ent = response.readEntity(PersonImpl.class);
			assertNotNull(ent);
			//todo continue test ...
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}
}
