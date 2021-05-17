package com.springboot.samplerealtime.project.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.springboot.samplerealtime.project.model.Tutorial;

public class ExcelHelper {

	public static String Type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = {"Id","Name","Email"};
	static String SHEET="Tutorials";
	
	public static ByteArrayInputStream tutorialToExcel(List<Tutorial> jsonExcel) {
		
		try(Workbook workbook = new XSSFWorkbook();
				ByteArrayOutputStream out = new ByteArrayOutputStream();){
			Sheet sheet = workbook.createSheet(SHEET);
			
			Row headerRow = sheet.createRow(0);
			
			for(int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}
			
			int rowIdx=1;
			for (Tutorial tutorial : jsonExcel) {
		        Row row = sheet.createRow(rowIdx++);

		        row.createCell(0).setCellValue(tutorial.getId());
		        row.createCell(1).setCellValue(tutorial.getName());
		        row.createCell(2).setCellValue(tutorial.getEmail());
		      
		      }
		     
		      Date date=new Date();
		      DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		      String currentDateTime = dateformatter.format(date);
		      Row row = sheet.createRow(jsonExcel.size()+1);
		     
		      Cell cell = row.createCell(0);
		     cell.setCellValue(currentDateTime);
		     row.createCell(1).setCellValue("The number Product is " +jsonExcel.size());
		    
		      

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
			
	}
	
