package com.tiad.SchoolDiary.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.tiad.SchoolDiary.model.IPerson;
import com.tiad.SchoolDiary.model.impl.ChildImpl;
import com.tiad.SchoolDiary.persistence.dao.ChildDAO;
import com.tiad.SchoolDiary.persistence.dao.GenericDAO;
import com.tiad.SchoolDiary.persistence.entities.ChildEntity;

@Path("MainResource")
public class MainResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response start() throws JSONException {
		/*
		ApplicationContext context = 
	             new FileSystemXmlApplicationContext("file:WEB-INF/Beans.xml");
		*/
		
		/*
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("file:Beans.xml");*/
		
		/*ApplicationContext context =
				new ClassPathXmlApplicationContext(Executions.getCurrent().getDesktop().getWebApp().getRealPath("/WEB-INF/Beans.xml"));
		*/
		GenericDAO<ChildEntity> dao = new ChildDAO();
		ChildEntity ent = dao.getById(0);
		IPerson child = new ChildImpl(ent);
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Child", child); 
 
		String result = "@Produces(\"application/json\") Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
