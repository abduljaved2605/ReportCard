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
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
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

	public static StudentsCSVReader readStudentObj = new StudentsCSVReader();
	public static CourseCSVReader readCourseObj = new CourseCSVReader();
	public static MarksCSVReader readMarksObj = new MarksCSVReader();
	public static TestCSVReader readTestsObj = new TestCSVReader();

	public static ReportCardCSVReader writeToFile = new ReportCardCSVReader();



	public static void main(String args[]) throws IOException
	{
		loadDataFromCSVfiles();
		
		Collection<Student> student_record =readStudentObj.getStudentsCollection();
		
		for(Student student: student_record)
		{
			List<Marks> list_studentMarks = readMarksObj.lookupforStudent(student.getId());			
			Map<String,Double> gradedMarksByCourseId = calculateFinalGradeByCourseID(list_studentMarks);
				
			StudentReportCard studentReportCard = new StudentReportCard();
			studentReportCard.setStudent(student);
			
			calculateTotalAverageAndPrepareReportCard(studentReportCard, gradedMarksByCourseId);

			studentReportCard.printReportCard();
			
		}
		

	}

	private static void calculateTotalAverageAndPrepareReportCard(StudentReportCard studentReportCard,
			Map<String, Double> gradedMarksByCourseId) {
		Double marks_total=0.0;
		for (String courseId : gradedMarksByCourseId.keySet()) {
			Double courseFinalGrade = gradedMarksByCourseId.get(courseId);
			marks_total = marks_total + courseFinalGrade;
			Course course = readCourseObj.lookupCourse(courseId);
			studentReportCard.addCourseFinalGradeRecord("Course " + course.getName() + ", Teacher " + course.getTeacher());
			studentReportCard.addCourseFinalGradeRecord(System.lineSeparator());
			studentReportCard.addCourseFinalGradeRecord("Final Grade " +courseId+  " "  + format(courseFinalGrade));
			studentReportCard.addCourseFinalGradeRecord(System.lineSeparator());

		}
		double totalAverage = marks_total/gradedMarksByCourseId.size();
		studentReportCard.setTotalAverage(format(totalAverage));
	}

	private static String format(Double d)
	{
		DecimalFormat df = new DecimalFormat("####0.00");
		  return df.format(d);
	}


	private static Map<String,Double> calculateFinalGradeByCourseID(List<Marks> list_studentMarks) {
		Map<String,Double> gradedMarksByCourseId = new HashMap<String,Double>();
		for(Marks studentMark :list_studentMarks)
		{
			Tests test = readTestsObj.lookupforTest(studentMark.getTest_id());
			Double courseValue = gradedMarksByCourseId.get(test.getCourse_id());
			double gradedMark = (test.getWeight()/100)*studentMark.getMark() + (courseValue==null?0:courseValue.doubleValue()) ;
			gradedMarksByCourseId.put(test.getCourse_id(), Double.valueOf(gradedMark));

		}
		
		return gradedMarksByCourseId;
	}



	private static void loadDataFromCSVfiles() throws IOException {
		readStudentObj.readStudentcsvfile();
    	readMarksObj.readMarksCSVReader();
		readCourseObj.readCourseCSVReader();
		readTestsObj.readTestCSVReader();
	}

}
