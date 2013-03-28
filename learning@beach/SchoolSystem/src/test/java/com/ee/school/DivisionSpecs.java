package com.ee.school;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DivisionSpecs {

	
	
	private Division division;
	private List<Student> studentsInDivision;
	
	@Mock
	private Student david;

	@Before
	public void setUp(){
		studentsInDivision = new ArrayList<Student>();
		studentsInDivision.add(david );
		division = new Division(studentsInDivision, "C");
	}
	
	@Test
	public void itShouldReturnAllStudents() {
		// Given
		List<Student> studentsInDivision = new ArrayList<Student>();
		Division division = new Division(studentsInDivision, "C");

		// When
		List<Student> students = division.getStudents();
		// Then
		assertThat(students).isEqualTo(studentsInDivision);
	}
	
	@Test
	public void itShouldReturnProgressOfAStudent() {
		// Given
		String studentName= "david";
		Progress progress = new Progress();

		// When
		when(david.getName()).thenReturn(studentName);
		when(david.getProgress()).thenReturn(progress);
		Progress actualProgress = division.getProgressForStudent(studentName);
		// Then
		verify(david).getProgress();
		assertThat(actualProgress).isEqualTo(progress);
	}
}
