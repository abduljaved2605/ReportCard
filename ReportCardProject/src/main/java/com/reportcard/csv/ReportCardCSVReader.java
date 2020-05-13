package com.reportcard.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

public class ReportCardCSVReader {
	
	/*
	 *Method to read CSV Files 
	 * Parameters: It takes file name as parameter
	 */
	
	public  List readcsvfile(String file) throws IOException, IOException
	{
		String csvFile = file;
		List<String[]> records = new ArrayList<String[]>();
		
		try(CSVReader csv = new CSVReader(new FileReader(csvFile));)
		{
			String[] values=null;
			while (( values = csv.readNext()) != null)
			{
				records.add(values);
			}
			//System.out.println(records);
		}
		
		return records;

	}
	/*
	 *Method to write to file
	 * Parameters: It takes string name as parameter
	 */
	
	
	public static void write(List data) throws IOException {
		File file = new File("source\\Reportcard.txt");
		FileWriter writer = new FileWriter(file);
		
		for(int i=0;i<data.size();i++)
		{
			String str = data.get(i).toString();
			writer.write(str+System.lineSeparator());
		}
		
		
		writer.close();
		
		//FileOutputStream fos = new FileOutputStream(file,true);
		//byte[] stringtobyte = data.getBytes();
		//fos.write(stringtobyte);
		//fos.close();
		//fos.write("wewe");
		
		
	}
	
	
	
	

}
