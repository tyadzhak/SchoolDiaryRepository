package com.tiad.SchoolDiary.test;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.PersonGender;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;
import com.tiad.SchoolDiary.tools.SchemaGenerator;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/applicationContext.xml" })
public class PersistenceTestCase extends TestCase {
	private String file;
	private AnnotationConfigApplicationContext context;
	private org.hibernate.cfg.Configuration cfgBean;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();

		cfgBean = (org.hibernate.cfg.Configuration) context.getBean("hibernateConfiguration");
		assertNotNull(cfgBean);

		String dialectProp = cfgBean.getProperty("hibernate.dialect");
		assertNotNull(dialectProp);

		file = "ddl_" + dialectProp.toLowerCase() + ".sql";
	}

	@Test
	public void ddlGeneratorTest() {
		try {
			assertEquals(false, file.isEmpty());

			SchemaGenerator gen = new SchemaGenerator(cfgBean,
					"com.tiad.SchoolDiary.persistence.entities.impl");
			gen.generate(file);
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	@Test
	public void savePersonInDbTest() {
		try {
			PersonEntity p = (PersonEntity) context.getBean("getPersonEntity");
			p.setFirstName("fn t1");
			p.setMiddleName("mn t1");
			p.setLastName("ln t1");
			p.setDob(LocalDate.of(1999, 07, 22));
			p.setGender(PersonGender.MALE);

			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			
			assertFalse(dao == null);
			dao.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	
	@Test
	public void readPersonFromDbTest() {
		long id = 1;
		long notExistId = 2;
		try {
			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			assertFalse(dao == null);
			
			if(!dao.isExists(id)){
				//may be record is not in db try to add
				savePersonInDbTest();
			}
			
			PersonEntity ent = dao.getById(id);
			assertFalse(ent == null);
			assertTrue(ent.getId() == id);
			assertTrue(ent.getDob().isEqual(LocalDate.of(1999, 07, 22)));
			assertTrue(ent.getGender().equals(PersonGender.MALE));
			
			ent = dao.getById(notExistId);
			assertTrue(ent == null);
			
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}
	
	@Test
	public void deletePersonFromDbTest() {
		long id = 1;
		try {
			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			assertFalse(dao == null);
			
			if(!dao.isExists(id)){
				//may be record is not in db try to add
				savePersonInDbTest();
			}
		
			PersonEntity ent = dao.getById(id);
			assertFalse(ent == null);
			
			dao.deleteById(id);
			
			ent = dao.getById(id);
			assertTrue(ent == null);

		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}
}
