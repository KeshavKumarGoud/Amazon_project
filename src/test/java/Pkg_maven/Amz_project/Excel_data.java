package Pkg_maven.Amz_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_data {

	public String get_excel_data(int row_number) throws EncryptedDocumentException, IOException
	{
		FileInputStream file1=new FileInputStream("D:\\eclipse-workspace\\Amz_project\\DataFetching\\data_sheet.xlsx");
		Workbook workbook1=WorkbookFactory.create(file1);
		String username=workbook1.getSheet("credentials").getRow(row_number).getCell(0).getStringCellValue();
		String password=workbook1.getSheet("credentials").getRow(row_number).getCell(1).getStringCellValue();
		String credentials=username+"&"+password;
		return credentials;
		
	}
}
