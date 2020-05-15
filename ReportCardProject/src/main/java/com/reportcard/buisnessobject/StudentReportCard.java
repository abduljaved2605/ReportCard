package com.reportcard.buisnessobject;


import com.reportcard.dataobject.Student;

public class StudentReportCard {
	Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getTotalAverage() {
		return totalAverage;
	}
	public void setTotalAverage(String string) {
		this.totalAverage = string;
	}
	String  totalAverage ;
	
	StringBuffer printSummary = new StringBuffer();
	
	public void addCourseFinalGradeRecord(String record)
	{
		printSummary.append(record);
	}

	
	public void printReportCard()
	{
		System.out.println("Student Id : " + student.getId() + ",  name " + student.getName());
		System.out.println("Total Average : " + totalAverage);
		System.out.println(printSummary.toString());
	}
	

}
