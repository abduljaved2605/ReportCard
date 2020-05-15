package com.reportcard.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reportcard.dataobject.Course;
import com.reportcard.dataobject.Marks;

public class CourseCSVReader extends  ReportCardCSVReader{
	Map<String,Course> map_Course = new HashMap<String,Course>();

	
	public Collection<Course> readCourseCSVReader() throws IOException
	{
		List<String[]> course_record = super.readcsvfile("source/courses.csv");
		List<Course> courses_list = new ArrayList<Course>();
		
		for(int counter=1;counter<course_record.size();counter++)
		{
			String[] course_name= course_record.get(counter);
			Course course = new Course((course_name[0]),(course_name[1]),(course_name[2]));
			// courses_list.add(course);
			 map_Course.put((course_name[0]), course);
			// System.out.println(course.getId()+"  "+course.getName()+" "+course.getTeacher());
		}
		return map_Course.values();
	}
	
	public Course lookupCourse(String courseId)
	{
		return map_Course.get(courseId);
	}

}
