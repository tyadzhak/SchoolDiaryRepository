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
import com.tiad.SchoolDiary.model.Role;
import com.tiad.SchoolDiary.model.impl.ModelFactoryCreator;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;
import com.tiad.SchoolDiary.test.tools.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/applicationContext.xml" })
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
	
	@Test
	public void roleTest() {
		Role r = Role.of(Role.PARENT.getValue());
		assertNotNull(r);
		assertEquals("Parent", r.getValue());

		r = Role.of(Role.SCHOOL_CHILD.getValue());
		assertNotNull(r);
		assertEquals("SchoolChild", r.getValue());
	}


	
	@Test
	public void undefinedRoleTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Undefined role type");
		
		Role.of("12345");
	}
	
	@Test
	public void nullRoleTest() {	
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Value cannot be null");
		
		Role.of(null);
	}
	
	@Test
	public void mappingPesronTest(){
		PersonEntity p = (PersonEntity) context.getBean("getPersonEntity");
		p.setFirstName("fn t1");
		p.setMiddleName("mn t1");
		p.setLastName("ln t1");
		p.setDob(LocalDate.of(1999, 07, 22));
		p.setGender(Gender.MALE);
		p.setRole(Role.PARENT);

		Person model = ModelFactoryCreator.createPerson(p);
		assertEquals(p.getFirstName(), model.getFirstName());
		assertEquals(p.getMiddleName(), model.getMiddleName());
		assertEquals(p.getLastName(), model.getLastName());
		assertEquals(p.getDob(), model.getDob());
		assertEquals(p.getGender(), model.getGender());
		assertEquals(p.getRole(), model.getRole());
		
		PersonEntity newP = ModelFactoryCreator.createPerson(model);
		assertEquals(model.getFirstName(), newP.getFirstName());
		assertEquals(model.getMiddleName(), newP.getMiddleName());
		assertEquals(model.getLastName(), newP.getLastName());
		assertEquals(model.getDob(), newP.getDob());
		assertEquals(model.getGender(), newP.getGender());
		assertEquals(model.getRole(), newP.getRole());
	}
	
}
