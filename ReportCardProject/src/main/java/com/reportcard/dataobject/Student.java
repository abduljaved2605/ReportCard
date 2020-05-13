package com.reportcard.dataobject;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.opencsv.CSVReader;

public class Student {
	
	String id;
	String name;
	public Student(String id, String name) {

		this.id=id;
		this.name=name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void readCsvFile(String file) throws IOException, IOException
	{
		String csvFile = file;
		HashMap map = new HashMap();
		
		try(CSVReader csv = new CSVReader(new FileReader(csvFile));)
		{
			String[] values=null;
			while (( values = csv.readNext()) != null)
			{
                System.out.println(values[0]);
			}
		}
	}
	
	

}
