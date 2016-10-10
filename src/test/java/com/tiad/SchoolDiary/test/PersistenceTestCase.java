package com.tiad.SchoolDiary.test;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.Role;
import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
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
	public void ddlGeneratorTest() throws Exception {
//		try {
			assertEquals(false, file.isEmpty());

			new SchemaGenerator().generate(file, "com.tiad.SchoolDiary.persistence.entities.impl", cfgBean);
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}

	@Test
	public void savePersonInDbTest() {
//		try {
			PersonEntity p = (PersonEntity) context.getBean("getPersonEntity");
			p.setFirstName("fn t1");
			p.setMiddleName("mn t1");
			p.setLastName("ln t1");
			p.setDob(LocalDate.of(1999, 07, 22));
			p.setGender(Gender.MALE);
			p.setRole(Role.PARENT);

			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			
			assertNotNull(dao);
			dao.save(p);
			
			p = (PersonEntity) context.getBean("getPersonEntity");
			p.setFirstName("fn t2");
			p.setMiddleName("mn t2");
			p.setLastName("ln t2");
			p.setDob(LocalDate.of(1998, 07, 22));
			p.setGender(Gender.FEMALE);
			p.setRole(Role.SCHOOL_CHILD);
			
			assertNotNull(dao);
			dao.save(p);
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}

	
	@Test
	public void readPersonFromDbTest() {
		long id = 1;
		long notExistId = -1;
//		try {
			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			assertNotNull(dao);
			
			if(!dao.isExists(id)){
				//may be record is not in db try to add
				savePersonInDbTest();
			}
			
			PersonEntity ent = dao.getById(id);
			assertNotNull(ent);
			assertEquals(id, ent.getId());
			assertTrue(ent.getDob().isEqual(LocalDate.of(1999, 07, 22)));
			assertTrue(ent.getGender().equals(Gender.MALE));
			
			ent = dao.getById(notExistId);
			assertNull(ent);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}
	
	@Test
	public void deletePersonFromDbTest() {
		long id = 1;
//		try {
			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			assertNotNull(dao);
			
			if(!dao.isExists(id)){
				//may be record is not in db try to add
				savePersonInDbTest();
			}
		
			PersonEntity ent = dao.getById(id);
			assertNotNull(ent);
			
			dao.deleteById(id);
			
			ent = dao.getById(id);
			assertNull(ent);

//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}
	
	/*@Test
	public void checkPersonIdentifierTest() {
//		try {
			PersonEntityImpl p = (PersonEntityImpl) context.getBean("getPersonEntity");
			p.setFirstName("fn t1");
			p.setMiddleName("mn t1");
			p.setLastName("ln t1");
			p.setDob(LocalDate.of(1999, 07, 22));
			p.setGender(Gender.MALE);
			long id = 5;
			p.setId(id);

			PersonDao dao = (PersonDao) context.getBean("getPersonDao");
			
			assertNotNull(dao);
			dao.save(p);
			
			PersonEntity ent = dao.getById(id);
			System.out.println(ent.getId());
			assertNotNull(ent);
//		} catch (Exception e) {
//			e.printStackTrace();
//			assertFalse(true);
//		}
	}*/
	
	@Test
	public void undefinedDaoFactoryTest(){
		DaoFactory factory = DaoFactory.getDaoFactory(-1);
		assertNull(factory);
		
	}
	
	@Test
	public void mysqlDaoFactoryTest(){
		DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
		assertNotNull(factory);
		
		PersonDao dao = factory.getPersonDao();
		assertNotNull(dao);
	}
	
	@Test
	public void hsqldbDaoFactoryTest(){
		DaoFactory factory = DaoFactory.getDaoFactory(DaoFactory.HSQLDB);
		assertNotNull(factory);
		
		PersonDao dao = factory.getPersonDao();
		assertNotNull(dao);
	}
}
