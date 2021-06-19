package com.webscraping.stockdata.selenium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class SeleniumConfig {
	
	public void seleniumDriver( ){
//	System.setProperty(Constants.webdriver,Constants.driverPath);  
		  WebDriverManager.chromedriver().setup();
	}
	
	public void Screenerlogin(WebDriver driver){
		try {
			driver.navigate().to("https://www.screener.in/login/"); 
			driver.findElement(By.id("id_username")).sendKeys("tushardesarda@outlook.com");
			driver.findElement(By.id("id_password")).sendKeys("Dnpcoe@15");
			//WebElement login=driver.findElement(By.className("button-primary"));
			Thread.sleep(10000);
			System.out.println("logged in successfully");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public  void writeDataForCustomSeperatorCSV(String filePath,List<String[]> data)
	{
		File file = new File(filePath);

		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter with '|' as separator
			CSVWriter writer = new CSVWriter(outputfile);			
			writer.writeAll(data);

			// closing writer connection
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
