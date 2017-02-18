package com.TestFrameWork.ezyKeyWordFw.utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {

	WebDriver driver;
	public UIOperation(WebDriver driver){
		this.driver = driver;
	}
	public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
		System.out.println("");
		switch (operation.toUpperCase()) {
		case "CLICK":
			//Perform click
			driver.findElement(this.getObject(p,objectName,objectType)).click();
			break;
		case "SETTEXT":
			//Set text on control
			driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
			break;
			
		case "GOTOURL":
			//Get url of application
			driver.get(p.getProperty(value));
			break;
		case "GETTEXT":
			//Get text of an element
			driver.findElement(this.getObject(p,objectName,objectType)).getText();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(Properties p,String objectName,String objectType) throws Exception{
		By by = null;
		switch (objectType.toUpperCase()) {
		case "XPATH":      
			//Find by xpath
			by = By.xpath(p.getProperty(objectName));
			break;
		case "CLASSNAME":      
			//find by class
			by = By.className(p.getProperty(objectName));
			break;
		case "NAME":    
			//find by name
			by =  By.name(p.getProperty(objectName));
			break;
		case "CSS":    
		//Find by css
			by = By.cssSelector(p.getProperty(objectName));
			break;
		case "LINK":    
		//find by link
			by =  By.linkText(p.getProperty(objectName));
			break;
		case "PARTIALLINK":    
		//find by partial link
			by = By.partialLinkText(p.getProperty(objectName));
			break;
		default:
			throw new Exception("Wrong object type");
		}
		return by;
	}
}
