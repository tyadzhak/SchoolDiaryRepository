package com.tiad.SchoolDiary.test;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;
import com.tiad.SchoolDiary.model.impl.ModelFactoryCreator;
import com.tiad.SchoolDiary.persistence.dao.DaoFactory;
import com.tiad.SchoolDiary.persistence.dao.PersonDao;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.persistence.entities.impl.PersonEntityImpl;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;
import com.tiad.SchoolDiary.tools.SchemaGenerator;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/applicationContext.xml" })
public class PersistenceTestCase extends TestCase {
	private String file;
	private org.hibernate.cfg.Configuration cfgBean;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceConfig.class);
		ctx.refresh();

		cfgBean = (org.hibernate.cfg.Configuration) ctx
				.getBean("hibernateConfiguration");
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

			PersonEntityImpl p = new PersonEntityImpl();
			p.setFirstName("fn t1");
			p.setMiddleName("mn t1");
			p.setLastName("ln t1");
			p.setDob(LocalDate.of(1999, 07, 22));
			p.setGender(PersonGender.MALE);

			PersonDao<PersonEntityImpl> dao = DaoFactory.getDaoFactory(DaoFactory.HSQLDB)
					.getPersonDao();
			
			assertFalse(dao == null);
			System.out.println(dao.toString());
			dao.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			//assertFalse(true);
		}
	}

}
