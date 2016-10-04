package com.tiad.SchoolDiary.rest;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;
import com.tiad.SchoolDiary.model.impl.ModelFactoryCreator;
import com.tiad.SchoolDiary.persistence.PersistenceConfig;
import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@Path("MainResource")
public class MainResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response start() throws JSONException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();

		// Create a DAO
		PersonDao personDao = (PersonDao)context.getBean("getPersonDao");
		
		PersonEntity personEnt = (PersonEntity) context.getBean("getPersonEntity");
		personEnt.setFirstName("fn t1");
		personEnt.setMiddleName("mn t1");
		personEnt.setLastName("ln t1");
		personEnt.setDob(LocalDate.of(1999, 07, 22));
		personEnt.setGender(PersonGender.MALE);
		
		personDao.save(personEnt);
		PersonEntity ent = personDao.getById(1);
		
		Person p = ModelFactoryCreator.createPerson(ent);
			
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Person", p); 
 
		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/Person")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();

		// Create a DAO
		PersonDao personDao = (PersonDao)context.getBean("getPersonDao");
		long id = 1;
		if (!personDao.isExists(id)){
			PersonEntity personEnt = (PersonEntity) context.getBean("getPersonEntity");
			personEnt.setFirstName("fn t1");
			personEnt.setMiddleName("mn t1");
			personEnt.setLastName("ln t1");
			personEnt.setDob(LocalDate.of(1999, 07, 22));
			personEnt.setGender(PersonGender.MALE);
			
			personDao.save(personEnt);
		}
		PersonEntity ent = personDao.getById(id);
		
		Person p = ModelFactoryCreator.createPerson(ent);
		return p;
	}
}
