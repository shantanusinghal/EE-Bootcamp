package com.ee.school;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StandardSpecs  {

	@Mock
	private Division divisionA;

	@Mock
	private Division divisionB;

	private Standard standard;

	private List<Division> divisions;

	private List<String> exams;
	
	@Before
	public void setUp(){
		divisions = Arrays.asList(divisionA,divisionB);
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(new Subject("english"));
		subjects.add(new Subject("history"));
		exams = new ArrayList<String>();
		exams.add("unit-test1");
		exams.add("semester1");
		exams.add("unit-test2");
		exams.add("finals");
		standard = new Standard(divisions, subjects,exams);
	}
	
	@Test
	public void itShouldReturnAllStudents(){
		//Given
		
		Student student1 = null;
		Student student2 = null;
		when(divisionA.getStudents()).thenReturn(Arrays.asList(student1));
		when(divisionB.getStudents()).thenReturn(Arrays.asList(student2));
		//When
		List<Student> allStudents = standard.getAllStudents();
		
		//Then
        Assertions.assertThat(allStudents).contains(student1,student2);
	}
	@Test
	public void itShouldReturnStudentsForAGivenDivision(){
		//Given
		Student student2 = null;

		//When
		when(divisionA.getName()).thenReturn("A");
		when(divisionB.getName()).thenReturn("B");
		when(divisionB.getStudents()).thenReturn(Arrays.asList(student2));
		
		List<Student> allStudents = standard.getStudentsByDivision("B");
		
		//Then
		Assertions.assertThat(allStudents).containsExactly(student2); 
	}
	
	@Test
	public void itShouldGetProgressForStudent()	{
		//Given
		String studentName = "david";
		
		//When
		when(divisionA.getName()).thenReturn("A");
		when(divisionB.getName()).thenReturn("B");
		standard.getProgressForStudent(studentName, "A");
		//Then
		verify(divisionA).getProgressForStudent(studentName);
	}


}
