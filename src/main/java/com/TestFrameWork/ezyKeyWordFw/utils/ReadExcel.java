package com.TestFrameWork.ezyKeyWordFw.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	Workbook wbWorkbook;
	Sheet shSheet;

	public void openSheet(String filePath) {
		openSheet(filePath,0);
	}
	
	public void openSheet(String filePath, Integer sheet) {
		FileInputStream fs;
		try {
			fs = new FileInputStream(filePath);
			wbWorkbook = Workbook.getWorkbook(fs);
			shSheet = wbWorkbook.getSheet(sheet);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCell(int iColNumber, int iRowNumber) {
		return getValueFromCell( iColNumber, iRowNumber);
	}
	
	public String getValueFromCell(int iColNumber, int iRowNumber) {
		return shSheet.getCell(iColNumber, iRowNumber).getContents();
	}

	public int getRowCount() {
		return shSheet.getRows();
	}

	public int getColumnCount() {
		return shSheet.getColumns();
	}
}

