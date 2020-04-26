package model;

import java.util.*;

public class Department {

	private List<Course> courses;

	public Department() {

		courses = new ArrayList<Course>();

	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
