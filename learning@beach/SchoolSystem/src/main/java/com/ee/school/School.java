package com.ee.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

	Map<String,Standard> standards;
	public School(Map<String, Standard> standards) {
		this.standards = standards;
	}
	public List<Student> getStudentListByStandard(String standard) {
	  Standard std = getStandard(standard);
	  return std.getAllStudents();
	}
	
	private Standard getStandard(String standard) {
		return standards.get(standard);
	}
	
	public List<Student> getStudentListByStandardAndDivision(String standard,
			String div) {
		Standard std = getStandard(standard);
		return std.getStudentsByDivision(div);
	}
	public Progress getProgresForStudent(String name, String standard,
			String division) {
		 Standard std = getStandard(standard);
		 return std.getProgressForStudent(name,division);		
	}
	public List<Subject> getSubjects(String stanadardName) {
		return getStandard(stanadardName).getSubjects();
	}
	public Map<Standard,List<Division>> getStandardsWithDivisions() {
		Map<Standard,List<Division>> standardsWithDivision = new HashMap<Standard, List<Division>>();
		for (Standard standard : standards.values()) {
			standardsWithDivision.put(standard,standard.getDivisions());
		}
		return standardsWithDivision;
	}
}
