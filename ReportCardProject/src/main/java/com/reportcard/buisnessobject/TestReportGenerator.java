/**
 * This Program is to genrate report card 
 * 
 * 
 */
/*
 * 
 */

package com.reportcard.buisnessobject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.reportcard.csv.CourseCSVReader;
import com.reportcard.csv.MarksCSVReader;
import com.reportcard.csv.ReportCardCSVReader;
import com.reportcard.csv.StudentsCSVReader;
import com.reportcard.csv.TestCSVReader;
import com.reportcard.dataobject.Course;
import com.reportcard.dataobject.Marks;
import com.reportcard.dataobject.Student;
import com.reportcard.dataobject.Tests;

class TestReportGenerator {
	
	/*
	 * Following variables are used to read csv files
	 * for Student,course,Marks,Test
	 */
	public static StudentsCSVReader readStudentObj = new StudentsCSVReader();
	public static CourseCSVReader readCourseObj = new CourseCSVReader();
	public static MarksCSVReader readMarksObj = new MarksCSVReader();
	public static TestCSVReader readTestsObj = new TestCSVReader();

	public static ReportCardCSVReader writeToFile = new ReportCardCSVReader();
	/*
	 * It returns records after reading
	 * 
	 */
	public static Collection<Student> student_record;
	public static Collection<Course> course_record;
	public static Map<String,List<Marks>> marks_record;
	
	
	public static List tests_record;

	public static void main(String args[]) throws IOException
	{
		student_record = readStudentObj.readStudentcsvfile();
		List<Marks> marks_List = new ArrayList<Marks>();
		List tofile = new ArrayList<>();
		marks_record = readMarksObj.readMarksCSVReader();
		course_record = readCourseObj.readCourseCSVReader();
		readTestsObj.readTestCSVReader();
		
		for(Student sID: student_record)
		{
			List<Marks> list_studentMarks = readMarksObj.lookupforStudent(sID.getId());
			int marks_total=0;
			
			Student student = readStudentObj.lookupStudent(sID.getId());
			Course course = readCourseObj.lookupCourse(sID.getId());
			
			
			System.out.println("Student Id   "+student.getId()+"   Student name "+student.getName());
			
			
			for(Marks studentMark :list_studentMarks)
			{
				marks_total =marks_total+studentMark.getMark();
				Tests test = readTestsObj.lookupforTest(studentMark.getTest_id());
				System.out.println(test.getCourse_id()+"  "+test.getWeight());
				//studentMark.getTest_id();
				
		
			}
			

			
			
			String name = "Student Id   "+student.getId()+"   Student name "+student.getName();
			System.out.println("Total Average   "+marks_total/list_studentMarks.size());
			
			//System.out.println("TEACHER NAME  "+course.getTeacher()+ " "+course.getName() );
			
			String avg = "Total Average   "+marks_total/list_studentMarks.size();
			tofile.add(name);
			tofile.add(avg);
		}
		
		writeToFile.write(tofile);

	}

}
