package com.tiad.SchoolDiary.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.tiad.SchoolDiary.model.School;
import com.tiad.SchoolDiary.persistence.PersistenceConfig;
import com.tiad.SchoolDiary.persistence.dao.SchoolDao;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;

@Service
@Path("School")
public class SchoolService {
		
	@Autowired
	@Qualifier("schoolDao")
	private SchoolDao<SchoolEntity> schoolDao;

	/*
	 * public void addSchool(){
	 * 
	 * }
	 * 
	 * public void editSchool(){
	 * 
	 * }
	 * 
	 * public void removeSchool(){
	 * 
	 * }
	 */

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSchool(@PathParam(value = "id") long id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();
		
		if(schoolDao == null)
			schoolDao = (SchoolDao<SchoolEntity>) context.getBean("schoolDao");
		
		try {
			School school = schoolDao.get(id);
			if (school != null) {
				return Response.status(Status.OK).entity(school).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSchool() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();
		
		if(schoolDao == null)
			schoolDao = (SchoolDao<SchoolEntity>) context.getBean("schoolDao");
		
		try {
			List<SchoolEntity> listOfSchool = schoolDao.getAll();
			if (listOfSchool != null) {
				return Response.status(Status.OK).entity(listOfSchool).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
