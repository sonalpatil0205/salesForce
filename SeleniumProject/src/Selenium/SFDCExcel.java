package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SFDCExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file=new FileInputStream("C:\\Sonal\\testing\\Selenium liveproject\\TC_1_Login_blankpass.xls");
		
		//ACCESS TO WORKBOOK
		HSSFWorkbook workbook=new HSSFWorkbook(file);
		
		//ACCESS TO SHEET
		HSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//access rows and columns
		String val=sheet.getRow(2).getCell(4).getStringCellValue();
		System.out.println(val);
	}

}
