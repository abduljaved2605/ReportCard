package com.reportcard.buisnessobject;

import java.io.IOException;
import java.util.Collection;
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

public class ModifiedReportGenerator {
	
	public static StudentsCSVReader readStudentObj = new StudentsCSVReader();
	public static CourseCSVReader readCourseObj = new CourseCSVReader();
	public static MarksCSVReader readMarksObj = new MarksCSVReader();
	public static TestCSVReader readTestsObj = new TestCSVReader();
	public static ReportCardCSVReader writeToFile = new ReportCardCSVReader();

	public static void main(String[] args) throws IOException {
		
		Collection<Student> student_record = readStudentObj.readStudentcsvfile();
		Collection<Course> course_record;
		Map<String,List<Marks>> marks_record;
	}
}
