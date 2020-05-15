package com.reportcard.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reportcard.dataobject.Marks;
import com.reportcard.dataobject.Student;

public class MarksCSVReader extends ReportCardCSVReader{
	Map<String,List<Marks>> map_Marks = new HashMap<String,List<Marks>>();
	

	public Map<String,List<Marks>> readMarksCSVReader () throws IOException
	{
		List<String[]> marks_records = super.readcsvfile("source/marks.csv");
		
		for(int counter=1;counter<marks_records.size();counter++)
		{

			String[] marks_record = marks_records.get(counter);
			Marks marks = new Marks(((marks_record[0])),((marks_record[1])),(Integer.parseInt(marks_record[2])));
			List<Marks> marks_list = map_Marks.get((marks_record[1]));
			if(marks_list==null)
			{
				marks_list = new ArrayList<Marks>();
				map_Marks.put((marks_record[1]), marks_list);
			}
			
			marks_list.add(marks);
								
		}
			
		return map_Marks;
	}
	
	public List<Marks> lookupforStudent(String studentId)
	{
		return map_Marks.get(studentId);
	}

}
