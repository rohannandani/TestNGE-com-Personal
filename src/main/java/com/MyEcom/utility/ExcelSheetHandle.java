package com.MyEcom.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.MyEcom.base.BaseClass;

public class ExcelSheetHandle extends BaseClass
{
	public static FileInputStream fis;
	public static FileInputStream getexcelfile() throws FileNotFoundException
	{
	fis = new FileInputStream(projectPath +"\\src\\test\\resources\\TestData\\testwebsite.xlsx");
	return fis;
	}
	
	public static Sheet getSheet(FileInputStream filename, String sheetName)
	{
		Sheet sh=null;
		try {
			sh = WorkbookFactory.create(filename).getSheet(sheetName);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sh;		
	}
	
	public Map<String, Object> getExcelSheetData(Sheet sh)
	{
		int getRow = sh.getLastRowNum();
		
		Map<String, Object> data = new HashMap<>();
		for(int i=0; i<getRow; i++)
		{
			int col = sh.getRow(i).getLastCellNum();
			
			for(int j=0; j<col; j++)
			{
				if(sh.getRow(i+1).getCell(j).getCellType().name().equals("STRING"))
				{
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				
				else if(sh.getRow(i+1).getCell(j).getCellType().name().equals("NUMERIC"))
				{
					String str = String.valueOf((long)sh.getRow(i+1).getCell(j).getNumericCellValue());
					data.put(sh.getRow(0).getCell(j).getStringCellValue(), str);
				}
			}
		}
		
		return data;
	}
	
	public String getSingleStringValue(Sheet sh,  int row, int col )
	{
		return sh.getRow(row).getCell(col).getStringCellValue();
	}

}
