package com.reportcard.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reportcard.dataobject.Course;
import com.reportcard.dataobject.Marks;
import com.reportcard.dataobject.Tests;

public class TestCSVReader extends ReportCardCSVReader {
	
	Map<String,Tests> map_Test = new HashMap<String,Tests>();

	
	public Map<String,Tests> readTestCSVReader() throws IOException
	{
		List<String[]> tests_record = super.readcsvfile("source\\tests.csv");
		
		for(int counter=1;counter<tests_record.size();counter++)
		{
			String[] tests_name = tests_record.get(counter);
			Tests tests = new Tests((tests_name[0]), (tests_name[1]), Integer.parseInt(tests_name[2]));
			
				map_Test.put((tests_name[0]), tests);
		
			
			//System.out.println(tests.getId()+" "+tests.getCourse_id()+"  "+tests.getWeight());
		}
		return map_Test;
	}
	
	
	public Tests lookupforTest(String testID)
	{
		return map_Test.get(testID);
	}


}
