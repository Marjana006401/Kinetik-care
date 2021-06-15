package com.kinetikcare;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


	public class GoogleSearch {
	    static WebDriver driver ;
		public static void main(String[] args) throws InterruptedException, IOException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user012\\eclipse-workspace\\kinetikcare\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get("https://www.google.com/");
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			WebElement googleSearchBar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
			googleSearchBar.click();
			FileInputStream fs = new FileInputStream("C:\\Users\\user012\\eclipse-workspace\\kinetikcare\\excel\\sample.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String cellval = cell.getStringCellValue();
			
			googleSearchBar.sendKeys(cellval);
			try {
				Thread.sleep(2000);
				WebElement enterButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
				enterButton.click();
				
				WebElement clickToLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3"));
				clickToLink.click();
				//String searchValue = sheet.getRow(0).getCell(0);
			} catch (Exception e) {
				System.out.println(e);
			}
			Thread.sleep(1000);
			driver.close();
			
			
		}
}
