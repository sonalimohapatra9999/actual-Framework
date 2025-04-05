package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class consist of methods related to excel file
 */
public class ExcelFileUtility {
	/**
	 * This method is used to Read the data from excel File provide by shetname,row and cell
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throwsbEncryptedDocumentException
	 * @throws IOException
	  */
	public String toReadtheDataFfromExcel(String sheetname,int row,int cell)throws EncryptedDocumentException, IOException{ 
	
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
	

	}

	/*
	 * public String toReadDataFromExcelFile(String string, int i, int j) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public String toReadDataFromExcelFile1(String string, int i, int j) { // TODO
	 * Auto-generated method stub return null; }
	 */
	
	}

