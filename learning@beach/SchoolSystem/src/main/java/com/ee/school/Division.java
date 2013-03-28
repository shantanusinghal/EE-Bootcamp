package com.ee.school;

import java.util.List;

public class Division {
	
	private List<Student> studentsInDivision;
	private String name;

	public Division(List<Student> studentsInDivision, String name) {
		this.studentsInDivision = studentsInDivision;
		this.name = name;
	}

	public List<Student> getStudents() {
		return studentsInDivision;
	}

	public String getName() {
		return name;
	}

	public Progress getProgressForStudent(String name) {
		return getStudent(name).getProgress();
	}

	private Student getStudent(String name) {
        for (Student student : studentsInDivision) {
			if(student.getName().equals(name)){
				return student;
			}
		}
		return null;
	}


}
