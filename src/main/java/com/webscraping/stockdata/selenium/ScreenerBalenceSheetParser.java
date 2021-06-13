package com.webscraping.stockdata.selenium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.opencsv.CSVWriter;
import com.webscraping.stockdata.entity.ScreenerBalanceSheetEntity;


public class ScreenerBalenceSheetParser extends SeleniumConfig{

	public ArrayList<ScreenerBalanceSheetEntity> getScreenerBSService(List<String> stockList)  {
		ArrayList<ScreenerBalanceSheetEntity> lstBS=new ArrayList<>();
		try {
			seleniumDriver();
			WebDriver driver = new ChromeDriver();
			Screenerlogin(driver);
			List<String[]> data = new ArrayList<String[]>();
			for (String stock : stockList) {
				System.out.println("inside for loop");
				driver.navigate().to(Constants.ScreenerURL + stock + "/");
				ScreenerBalanceSheetEntity screenerBalanceSheetEntity=new ScreenerBalanceSheetEntity();
				WebElement mktCap = driver.findElement(By.xpath("//ul[@id='top-ratios']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(mktCap).build().perform();

				System.out.println("mktCap----" + mktCap);
				List<WebElement> allElements = mktCap.findElements(By.tagName("li"));

				String companies = driver.findElement(By.className("margin-0")).getText();
				screenerBalanceSheetEntity.setCompanyName(stock);
				System.out.println("---------------------companyName:" + stock + "--" + companies + "------------------------------------------------------");


				WebElement QuarterlyResults = driver.findElement(By.xpath("//table[@class='data-table responsive-text-nowrap'][1]"));
				//	System.out.println("-------Quarterly Results------\n\n"+QuarterlyResults.getText());
				String[] QuterlyEntity=QuarterlyResults.getText().split("\\r?\\n");


				String[] company= {"Company",companies};
				data.add(company);
				String[] result= {"Quarterly Results","(Consolidated Figures in Rs. Crores )"};
				data.add(result);
				for(int i=0;i<QuterlyEntity.length;i++) {
					//	System.out.println("for loop:"+QuterlyEntity[i]);
					if(i==0) {
						ArrayList<String> ArrlstMonthYear=new ArrayList<>();
						ArrlstMonthYear.add("Quater");
						String[] arrMonthYear=QuterlyEntity[0].split("(?<!\\G\\w+)\\s");
						ArrlstMonthYear.addAll(Arrays.asList(arrMonthYear));
						arrMonthYear=ArrlstMonthYear.toArray(arrMonthYear);
						data.add(arrMonthYear);
					}

					if(i==1) { 
						String Sale=QuterlyEntity[i].split("\\+")[1];
						String[] arrSale=Sale.split("\\s");
						ArrayList<String> arrlstSale=new ArrayList<>();
						arrlstSale.add("Sales");
						arrlstSale.addAll(Arrays.asList(arrSale));
						arrlstSale.remove(1);
						arrSale=arrlstSale.toArray(arrSale);
						data.add(arrSale); 
					}
					if(i==2) {
						String expenses=QuterlyEntity[i].split("\\+")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("expenses");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					//-------------change variables
					if(i==3) {
						String expenses=QuterlyEntity[i].split("Profit")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Operating Profit");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}


					if(i==4) {
						String expenses=QuterlyEntity[i].split("OPM %")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("OPM");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==5) {
						String expenses=QuterlyEntity[i].split("Income")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Other Income");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==6) {
						String expenses=QuterlyEntity[i].split("Interest")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Interest");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==7) {
						String expenses=QuterlyEntity[i].split("Depreciation")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Depreciation");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==8) {
						String expenses=QuterlyEntity[i].split("tax")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Profit before tax");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==9) {
						String expenses=QuterlyEntity[i].split("Tax %")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Tax");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}

					if(i==10) {
						String expenses=QuterlyEntity[i].split("Profit")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Net Profit");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}if(i==11) {
						String expenses=QuterlyEntity[i].split("Rs")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("EPS in Rs");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}

				}

				WebElement profitLoss = driver.findElement(By.xpath("//body/main[1]/section[5]/div[2]"));
				String[] result1= {"Profit & Loss","(Consolidated Figures in Rs. Crores )"};
				data.add(result1);
				String[] arrProfitLoss=profitLoss.getText().split("\\r?\\n");
				if(arrProfitLoss.length<2) {
					profitLoss = driver.findElement(By.xpath("//body/main[1]/section[5]/div[3]"));
					arrProfitLoss=profitLoss.getText().split("\\r?\\n");
				}
				for(int i=0;i<arrProfitLoss.length;i++) {
					if(i==0) {
						System.out.println("for loop Profit Loss:"+arrProfitLoss[i]);
						ArrayList<String> ArrlstMonthYear=new ArrayList<>();
						ArrlstMonthYear.add("Yearly result");
						String[] arrMonthYear=arrProfitLoss[0].split("(?<!\\G\\w+)\\s");
						ArrlstMonthYear.addAll(Arrays.asList(arrMonthYear));
						arrMonthYear=ArrlstMonthYear.toArray(arrMonthYear);
						data.add(arrMonthYear);
					}

					if(i==1) { 
						String Sale=arrProfitLoss[i].split("\\+")[1];
						String[] arrSale=Sale.split("\\s");
						ArrayList<String> arrlstSale=new ArrayList<>();
						arrlstSale.add("Sales");
						arrlstSale.addAll(Arrays.asList(arrSale));
						arrlstSale.remove(1);
						arrSale=arrlstSale.toArray(arrSale);
						data.add(arrSale); 
					}
					if(i==2) {
						String expenses=arrProfitLoss[i].split("\\+")[1];
						String[] arrExpenses=expenses.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("expenses");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==3) {
						String operProfit=arrProfitLoss[i].split("Profit")[1];
						String[] arrExpenses=operProfit.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Operating Profit");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}


					if(i==4) {
						String opmPER=arrProfitLoss[i].split("OPM %")[1];
						String[] arrExpenses=opmPER.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("OPM");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==5) {
						String income=arrProfitLoss[i].split("Income")[1];
						String[] arrExpenses=income.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Other Income");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==6) {
						String interest=arrProfitLoss[i].split("Interest")[1];
						String[] arrExpenses=interest.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Interest");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==7) {
						String depereciation=arrProfitLoss[i].split("Depreciation")[1];
						String[] arrExpenses=depereciation.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Depreciation");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==8) {
						String tax=arrProfitLoss[i].split("tax")[1];
						String[] arrExpenses=tax.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Profit before tax");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
					if(i==9) {
						String taxPer=arrProfitLoss[i].split("Tax %")[1];
						String[] arrExpenses=taxPer.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Tax");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}

					if(i==10) {
						String profit=arrProfitLoss[i].split("Profit")[1];
						String[] arrExpenses=profit.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Net Profit");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}if(i==11) {
						String eps=arrProfitLoss[i].split("Rs")[1];
						String[] arrExpenses=eps.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("EPS in Rs");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}

					if(i==12) {
						String payout=arrProfitLoss[i].split("Payout %")[1];
						String[] arrExpenses=payout.split("\\s");
						ArrayList<String> arrlstExpenses=new ArrayList<>();
						arrlstExpenses.add("Dividend Payout");
						arrlstExpenses.addAll(Arrays.asList(arrExpenses));
						arrlstExpenses.remove(1);
						arrExpenses=arrlstExpenses.toArray(arrExpenses);
						data.add(arrExpenses); 
					}
				}

				// System.out.println("-------Profit & Loss------\n\n"+profitLoss.getText());
				/*
				 * System.out.println("---------------------Profit & Loss end----------");
				 * 
				 * WebElement BalanceSheet =
				 * driver.findElement(By.xpath("//body/main[1]/section[6]/div[2]"));
				 * System.out.println("-------Balance Sheet------\n\n"+BalanceSheet.getText());
				 * 
				 * System.out.println("---------------------BS end----------"); WebElement
				 * CashFlows = driver.findElement(By.xpath("//body/main[1]/section[7]/div[2]"));
				 * System.out.println("-------Cash Flows------\n\n"+CashFlows.getText());
				 * 
				 * System.out.println("---------------------Cash Flows end----------");
				 * WebElement Ratios =
				 * driver.findElement(By.xpath("//body/main[1]/section[8]/div[2]"));
				 * System.out.println("-------Ratios------\n\n"+Ratios.getText());
				 * 
				 * System.out.println("---------------------Ratios end----------");
				 */		

				WebElement cashFlow = driver.findElement(By.xpath("//body/main[1]/section[8]/div[2]"));
				String[] resultCF= {"Cash flow"};
				data.add(resultCF);
				String[] arrCashFlow=cashFlow.getText().split("\\r?\\n");
			}
			writeDataForCustomSeperatorCSV("E:\\project\\outputfile.csv",data);


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lstBS;
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

			// create a List which contains String array
			/*
			 * List<String[]> data = new ArrayList<String[]>();
			 *  data.add(new String[] {
			 * "Name", "Class", "Marks" }); data.add(new String[] { "Aman", "10", "620" });
			 * data.add(new String[] { "Suraj", "10", "630" });
			 */
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
