package com.tiad.SchoolDiary.test;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.Role;
import com.tiad.SchoolDiary.model.impl.ModelFactoryCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring/applicationContext.xml" })
public class ModelTestCase extends TestCase {
	
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
}
