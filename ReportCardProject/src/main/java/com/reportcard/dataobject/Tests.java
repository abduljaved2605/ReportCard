package com.reportcard.dataobject;

public class Tests {

	String id;
	String course_id;
	int weight;
	
	public Tests(String id,String course_id,int weight) {
		this.id=id;
		this.course_id=course_id;
		this.weight=weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
