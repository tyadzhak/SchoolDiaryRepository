package com.tiad.SchoolDiary.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;
import com.tiad.SchoolDiary.tools.SchemaGenerator;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PersistenceConfig.class})
@Deprecated
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
	public void undefinedDaoFactoryTest(){
		DaoFactory factory = DaoFactory.getDaoFactory(-1);
		assertNull(factory);
		
	}
	/*
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
	*/
}
