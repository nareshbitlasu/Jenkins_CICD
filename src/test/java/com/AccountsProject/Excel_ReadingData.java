package com.AccountsProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.testng.annotations.Test;

public class Excel_ReadingData {

	@Test
	public void readingDataFromFile() throws IOException {
		
		String pathOfTheFile="C:\\Users\\pc\\eclipse-workspace\\testng\\testDataFolder\\InputData.xlsx";
		
		File file = new File(pathOfTheFile);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh=wb.getSheet("TestData");
		int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
		for(int i=0;i<rowCount+1;i++) {
			Row row = sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			}
			System.out.println();
		}
			wb.close();
			fis.close();
			
		
	}
}
