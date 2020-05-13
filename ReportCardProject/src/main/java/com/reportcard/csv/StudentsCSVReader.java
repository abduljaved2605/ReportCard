package com.reportcard.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reportcard.dataobject.Student;

public class StudentsCSVReader extends ReportCardCSVReader{
	
	//String[] headers = new String[] {"id","name"};
	Map<String,Student> map_Student = new HashMap<String,Student>();
	public Collection<Student> readStudentcsvfile() throws IOException
	{
		List<String[]> record_student = super.readcsvfile("source\\students.csv");
		List<Student> list_students = new  ArrayList<Student>();
		
		for(int counter=1; counter<record_student.size();counter++)
		{
			String[] record_name = record_student.get(counter);
			Student student = new Student((record_name[0]),record_name[1]);
			
			
			//list_students.add(student);
			map_Student.put((record_name[0]), student);
		//	System.out.println(student.getId()+"  "+student.getName());
			
			
		}
		return map_Student.values();
		
		
	}
	
	public Student lookupStudent(String studentId)
	{
		return map_Student.get(studentId);
	}
	
	

}
