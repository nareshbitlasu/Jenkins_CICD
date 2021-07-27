package com.AccountsProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel_WritingDataToFile {

	
		// TODO Auto-generated method stub
		@Test
		public void write_Data() throws IOException {
		String path="C:\\Users\\pc\\eclipse-workspace\\testng\\testDataFolder\\InputData.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("TestData");
		int rowCount=sh.getLastRowNum()-sh.getFirstRowNum();
		
		Row row = sh.getRow(0);
		Row newRow=sh.createRow(rowCount+1);
		
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("H");
		al.add("Google");
		al.add("Google Cloud");
		al.add("Newyork");
		al.add("USA");
		//Object arr[]=al.toArray();
		
		for(int i=0;i<row.getLastCellNum();i++) {
			Cell cell = newRow.createCell(i);
			cell.setCellValue(al.get(i));
		}
		
		fis.close();
		
		FileOutputStream fops= new FileOutputStream(file);
		wb.write(fops);
		fops.close();
		
		}
	

}
