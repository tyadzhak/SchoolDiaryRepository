package com.tiad.SchoolDiary.test;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
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

import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;
import com.tiad.SchoolDiary.persistence.entities.impl.SchoolEntityImpl;
import com.tiad.SchoolDiary.rest.SchoolService;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PersistenceConfig.class})
public class SchoolServiceTestCase extends TestCase {

	public final String BASE_URI = "http://localhost:8080/SchoolDiary/webapi";
	private HttpServer server;

	@Before
	public void setUp() {
//		try {
			final ResourceConfig rc = new ResourceConfig(SchoolService.class);
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
	public void getAllSchoolTest() {
//		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(BASE_URI).path("School");
			Response response = target.request().accept(MediaType.APPLICATION_JSON).buildGet().invoke();
			
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			
			List<SchoolEntityImpl> listOfSchool = response.readEntity(new GenericType<List<SchoolEntityImpl>>() {});
			assertNotNull(listOfSchool);

			
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}
	
	@Test
	public void getSchoolTest() {
//		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target(BASE_URI).path("School").path("1");
			Response response = target.request().accept(MediaType.APPLICATION_JSON).buildGet().invoke();
			
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			
			SchoolEntity school = response.readEntity(new GenericType<SchoolEntityImpl>() {});
			assertNotNull(school);

//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}
}
