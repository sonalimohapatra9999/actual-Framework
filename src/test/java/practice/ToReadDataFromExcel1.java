package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcel1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String orgnization = wb.getSheet("Organization").getRow(1).getCell(2).toString();
		System.out.println(orgnization);
		
		
		

	}

}
