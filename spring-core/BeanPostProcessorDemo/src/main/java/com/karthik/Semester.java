package com.karthik;

import java.util.List;

public class Semester {

	private List<String> courses;

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Semester [courses=" + courses + "]";
	}

}
