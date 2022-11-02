package com.bancaedge.commonmethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.bancaedge.base.BaseClass;

public class CommonMethods extends BaseClass {
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void click(WebDriver getdDriver, WebElement locatorName) {
		Actions act = new Actions(getdDriver);
		act.moveToElement(locatorName).click().build().perform();

	}

	public static boolean findElement(WebDriver getdDriver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;

		} finally {
			if (flag) {
				System.out.println("Successfully found element at :");
			} else {
				System.out.println("Unable to find element at: ");
			}
		}
		return flag;

	}

	public static boolean isDisplayed(WebDriver getdDriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(getdDriver, ele);
		if (flag) {
			flag = ele.isDisplayed();

			if (flag) {
				System.out.println("The element is displayed : ");
			} else {
				System.out.println("The element is not displayed");
			}
		} else {
			System.out.println("Not displayed");
		}
		return flag;
	}

	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Location not found");

		}

		return flag;

	}
	
	public static String screenShot(WebDriver driver,String filename) {
		String dateName=new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File Source=takescreenshot.getScreenshotAs(OutputType.FILE);
		//String destination=System.getProperty(("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png");
		String destination=System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";
		try {
			FileUtils.copyFile(Source, new File(destination));
		}
		catch(Exception e){
			e.getMessage();
			
		}
		return destination;
		
	}
	
	public static boolean ListOfElementsDisplayed(WebElement[] elements) {
		boolean Value = false;
		try {
			for (WebElement CurrentElement : elements) {
				if (CurrentElement.isDisplayed()) {
					Value = true;
				} else {
					Value = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(" Element Is not displayed on screen");
			Value = false;
			e.printStackTrace();
		}
		return Value;
	}

	public static List<WebElement> GetlistOfOptions(WebDriver getDriver, By element) {
		WebElement ele = getDriver.findElement(element);
		Select dropdown = new Select(ele);
		List<WebElement> allOptions = dropdown.getOptions();
		return allOptions;
	}


}
