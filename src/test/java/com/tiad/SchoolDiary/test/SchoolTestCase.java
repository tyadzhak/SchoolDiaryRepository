package com.tiad.SchoolDiary.test;

import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.persistence.dao.SchoolDao;
import com.tiad.SchoolDiary.persistence.entities.SchoolEntity;
import com.tiad.SchoolDiary.persistence.entities.impl.SchoolEntityImpl;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PersistenceConfig.class})
public class SchoolTestCase extends TestCase {
	private AnnotationConfigApplicationContext context;
	private SchoolDao schoolDao;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();

		schoolDao = (SchoolDao) context.getBean("schoolDao");
	}

	@Test
	public void persistSchoolTest() {
		SchoolEntity school = new SchoolEntityImpl("school#1",
				Collections.emptySet(), Collections.emptySet(),
				Collections.emptySet());
		schoolDao.save(school);
		assertTrue(schoolDao.isExists(school.getId()));

		SchoolEntity newSchool = schoolDao.get(school.getId());

		assertNotNull(newSchool);
		assertEquals(school.getId(), newSchool.getId());
		assertEquals(school.getName(), newSchool.getName());
		assertEquals(school.getChildren(), newSchool.getChildren());
		assertEquals(school.getClasses(), newSchool.getClasses());
		assertEquals(school.getTeachers(), newSchool.getTeachers());
	}

	@Test
	public void removeSchoolTest() {
		SchoolEntity school = new SchoolEntityImpl("school#1",
				Collections.emptySet(), Collections.emptySet(),
				Collections.emptySet());

		schoolDao.save(school);
		assertTrue(schoolDao.isExists(school.getId()));

		schoolDao.delete(school.getId());
		assertFalse(schoolDao.isExists(school.getId()));
	}

	@Test
	public void updateSchoolTest() {
		SchoolEntity school = new SchoolEntityImpl("school#1",
				Collections.emptySet(), Collections.emptySet(),
				Collections.emptySet());

		schoolDao.save(school);
		assertTrue(schoolDao.isExists(school.getId()));
		
		school.setName("school#2");
		schoolDao.update(school);
		
		SchoolEntity newSchool = schoolDao.get(school.getId());

		assertNotNull(newSchool);
		assertEquals(school.getId(), newSchool.getId());
		assertEquals(school.getName(), newSchool.getName());
		assertEquals(school.getChildren(), newSchool.getChildren());
		assertEquals(school.getClasses(), newSchool.getClasses());
		assertEquals(school.getTeachers(), newSchool.getTeachers());
	}
	
	@Test
	public void getAllSchool(){
		SchoolEntity school1 = new SchoolEntityImpl("school#1",
				Collections.emptySet(), Collections.emptySet(),
				Collections.emptySet());

		schoolDao.save(school1);
		
		SchoolEntity school2 = new SchoolEntityImpl("school#2",
				Collections.emptySet(), Collections.emptySet(),
				Collections.emptySet());

		schoolDao.save(school2);
		
		List<SchoolEntity> listOfSchool = schoolDao.getAll();
		long countOfSchool1 = listOfSchool.stream().filter(s -> s.getId() == school1.getId()).count();
		assertEquals(1, countOfSchool1);
		
		long countOfSchool2 = listOfSchool.stream().filter(s -> s.getId() == school2.getId()).count();
		assertEquals(1, countOfSchool2);
	}
}
