package com.ee.school;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SchoolSpecs {

	@Mock  
	Standard standard2;
	@Mock  
	Standard standard1;
	@Mock  
	Standard standard3;
	
	@Mock
	Division division;

	private School school;
	
	private Map<String, Standard> standards;
	
	@Before
	public void setUp(){
		standards =  new HashMap<String, Standard>();
		standards.put("1",standard1);
		standards.put("2",standard2);
		standards.put("3",standard3);
		school = new School(standards);
	}
	
	@Test
	public void itShouldGiveListOfAllStudentsForGivenStd() {
		//Given
		
		String  standard  = "2";
		List<Student> studentsInStandard = Arrays.asList(new Student("daVid"));
		
		//When
		when(standard2.getAllStudents()).thenReturn(studentsInStandard );
		
		List<Student> actualStudents = school.getStudentListByStandard(standard);
		
		//Then
		assertThat(actualStudents).isEqualTo(studentsInStandard);
}
	@Test
	public void itShouldGiveListOfAllStudentsForGivenStdAndDivision() {
		//Given
		String  standard  = "2";
		String div =  "A";
		List<Student> studentsInStandardForGivenDivision = Arrays.asList(new Student("daVid"));
		
		when(standard2.getStudentsByDivision(div)).thenReturn(studentsInStandardForGivenDivision);
		//When
		
		List<Student> actualStudents = school.getStudentListByStandardAndDivision(standard,div);
		
		//Then
		assertThat(actualStudents).isEqualTo(studentsInStandardForGivenDivision);
	}
	
	@Test
	public void itShouldDisplayProgressForGivenStudent(){
		//Given
		String  name="david";

		//When
		school.getProgresForStudent(name,"2","A");
		
		//Then
		verify(standard2).getProgressForStudent(name, "A");
	}
	
	@Test
	public void itShouldGetSubjectsForGivenStandard(){
		//Given
		
		//When
		when(standard2.getSubjects()).thenReturn(Arrays.asList(new Subject("english"),new Subject("history")));
		List<Subject> subjects = school.getSubjects("2");
		//Then
		assertThat(subjects).containsExactly(new Subject("english"),new Subject("history"));
		
	}
	@Test
	public void itShouldGetListOfStandardsWithDivision(){
		//Given
		Division std2Div = new Division(null, null);
		Division std2DivA = new Division(null, null);
		Division std2DivB = new Division(null, null);
		
		//When
		when(standard1.getDivisions()).thenReturn(Arrays.asList(std2Div));
		when(standard2.getDivisions()).thenReturn(Arrays.asList(std2DivA,std2DivB));
		when(standard3.getDivisions()).thenReturn(Arrays.asList(std2Div));
		Map<Standard, List<Division>> standardsWithDivisions = school.getStandardsWithDivisions();
		
		//Then
		verify(standard2).getDivisions();
		assertThat(standardsWithDivisions.size()).isEqualTo(3);
		assertThat(standardsWithDivisions.keySet()).containsOnly(standard1,standard2,standard3);
		assertThat(standardsWithDivisions.values()).contains(Arrays.asList(std2DivA,std2DivB));
	}
}  