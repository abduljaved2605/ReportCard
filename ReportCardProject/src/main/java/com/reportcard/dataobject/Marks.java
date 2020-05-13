package com.reportcard.dataobject;

public class Marks {
	
	//Student student;
	//Tests tests;
	
	String test_id;
	
	
	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}

	String student;
	int mark;
	
	public Marks(String test_id,String student,int mark) {
		this.test_id =test_id;
		this.student = student;
		this.mark = mark;
	}

	

	public String getTest_id() {
		return test_id;
	}



	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
		
	
	
	

}
