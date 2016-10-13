package com.tiad.SchoolDiary.test;

import junit.framework.TestCase;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.impl.ModelFactoryCreator;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PersistenceConfig.class})
@Deprecated
public class ModelTestCase extends TestCase {
	private AnnotationConfigApplicationContext context;
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.register(PersistenceConfig.class);
		context.refresh();
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void modelCreatorFactoryTest() {
		ModelFactoryCreator factory = new ModelFactoryCreator() {
		};
		assertNotNull(factory);
	}

	@Test
	public void genderTest() {
		Gender g = Gender.of(Gender.MALE.getValue());
		assertNotNull(g);
		assertEquals("Male", g.getValue());

		g = Gender.of(Gender.FEMALE.getValue());
		assertNotNull(g);
		assertEquals("Female", g.getValue());
	}

	@Test
	public void undefinedGenderTest() {	
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Undefined gender type");
		
		Gender.of("12345");
	}
	
	@Test
	public void nullGenderTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Value cannot be null");
		
		Gender.of(null);
	}
}
