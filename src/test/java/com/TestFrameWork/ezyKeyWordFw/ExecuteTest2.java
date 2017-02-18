package com.TestFrameWork.ezyKeyWordFw;

import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;

import com.TestFrameWork.ezyKeyWordFw.utils.ReadObject;
import com.TestFrameWork.ezyKeyWordFw.utils.UIOperation;
import com.TestFrameWork.ezyKeyWordFw.utils.ReadExcel;

/**
 * THIS IS THE EXAMPLE OF KEYWORD DRIVEN TEST CASE
 *
 */
public class ExecuteTest2 {
    @Test
	public void testLogin() throws Exception {
		// TODO Auto-generated method stub
       WebDriver webdriver = new FirefoxDriver();
        ReadObject object = new ReadObject();
        Properties allObjects =  object.getObjectRepository();
        UIOperation operation = new UIOperation(webdriver);
        //Read keyword sheet
        ReadExcel  excel = new ReadExcel();
        String filePath = System.getProperty("user.dir")+"\\TestCase.xlsx" ;
        excel.openSheet(filePath,1);
      //Find number of rows in excel file
    	int rowCount = excel.getRowCount();
    	//Create a loop over all the rows of excel file to read it
    	for (int i = 1; i < rowCount+1; i++) {
    		//Loop over all the rows
    		String gval = excel.getCell(0, i);
    		//Check if the first cell contain a value, if yes, That means it is the new testcase name
    		if(gval.isEmpty()){
    		//Print testcase detail on console
    			System.out.println(excel.getCell(1, i)+"----"+ excel.getCell(2,i)+"----"+
    			excel.getCell(3,i)+"----"+ excel.getCell(4,i));
    		//Call perform function to perform operation on UI
    			operation.perform(allObjects, excel.getCell(1,i), excel.getCell(2,i),
    				excel.getCell(3, i), excel.getCell(4,i));
    	    }
    		else{
    			//Print the new  testcase name when it started
    				System.out.println("New Testcase->"+excel.getCell(0,i) +" Started");
    			}
    		}
	}

}
