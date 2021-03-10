package com.example.model;

import java.io.Serializable;

public class Course implements Serializable{

	int courseId;
	String subject1;
	String subject2;
	private static final long serialVersionUID = 1000000000L;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String subject1, String subject2) {
		super();
		this.subject1 = subject1;
		this.subject2 = subject2;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + ((subject1 == null) ? 0 : subject1.hashCode());
		result = prime * result + ((subject2 == null) ? 0 : subject2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		if (subject1 == null) {
			if (other.subject1 != null)
				return false;
		} else if (!subject1.equals(other.subject1))
			return false;
		if (subject2 == null) {
			if (other.subject2 != null)
				return false;
		} else if (!subject2.equals(other.subject2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", subject1=" + subject1 + ", subject2=" + subject2 + "]";
	}
}
