package com.DataDriven;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Driven_Classnew {
	
	public static String path = "D:\\Testing Course Materials\\snip\\IPT\\NopCommerce Project\\Customer_Data.xlsx";
	
	public String getEmail() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	public String getPassword() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	public String getFirstName() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	public String getLastName() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	public String getDOB() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	public String getCompany() throws InvalidFormatException, IOException {
		File f = new File(path);
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		return value;		
	}
	

}
