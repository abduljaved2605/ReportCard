package com.reportcard.dataobject;

public class Course {
	String name;
	String teacher;
	String id;
	public Course(String id, String name, String teacher) {
		this.name=name;
		this.id=id;
		this.teacher=teacher;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
