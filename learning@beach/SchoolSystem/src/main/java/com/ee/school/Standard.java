package com.ee.school;

import java.util.ArrayList;
import java.util.List;

public class Standard {

	private List<Division> divisions;
	private List<Subject> subjects;
	private final List<String> exams;

	public Standard(List<Division> divisions, List<Subject> subjects, List<String> exams) {
		this.divisions = divisions;
		this.subjects = subjects;
		this.exams = exams;
	}

	public List<String> getExams() {
		return exams;
	}

	public List<Student> getAllStudents() {
		List<Student> allStudents = new ArrayList<Student>();
		for (Division division : divisions) {
			allStudents.addAll(division.getStudents());
		}
		return allStudents;
	}

	public List<Student> getStudentsByDivision(String div) {
		Division division = getDivision(div);
		return division.getStudents();
	}

	public Progress getProgressForStudent(String name, String division) {
		 Division div = getDivision(division);
		return div.getProgressForStudent(name);
	}

	private Division getDivision(String div) {
		for (Division division : divisions) {
			if(division.getName().equals(div))
				return division;
		}
		return null;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public List<Division> getDivisions() {
		return divisions;
	}

}
