package com.ee.school;

public class Student {

	private String name;
	private Progress progress;

	public Student(String name) {
		this.name = name;
		progress = new Progress();
	}

	public Progress getProgress() {
		 return this.progress;
	}

	public String getName() {
		return name;
	}
}
