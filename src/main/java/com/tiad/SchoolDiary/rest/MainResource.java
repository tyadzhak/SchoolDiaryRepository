package com.tiad.SchoolDiary.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;

import com.tiad.SchoolDiary.persistence.PersistenceConfig;
import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@Path("MainResource")
public class MainResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response start() throws JSONException {
		@SuppressWarnings("resource")
		AnnotationConfigRegistry ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceConfig.class);
		
		// create the required DAO Factory
		DaoFactory mySqlFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

		// Create a DAO
		PersonDao personDao = mySqlFactory.getPersonDao();
		PersonEntity ent = personDao.getById(0);
			
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Person", ent); 
 
		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
