package com.webscraping.stockdata.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import com.webscraping.stockdata.entity.ScreenerRatioEntity;


public class ScreenerRatioParser{
	@Autowired
	SeleniumConfig seleniumConfig;
	
	public ArrayList<ScreenerRatioEntity> getScreenerRatioService(List<String> stockList)  {
		ArrayList<ScreenerRatioEntity> lstRatio=new ArrayList<>();
		long startTime = System.currentTimeMillis();
		try {

			Callable<Integer> task = () -> {
				seleniumConfig.seleniumDriver();
				WebDriver driver = new ChromeDriver();
				Screenerlogin(driver);
				for (String stock : stockList) {
					System.out.println("inside for loop");
					driver.navigate().to(Constants.ScreenerURL + stock + "/");
					ScreenerRatioEntity screenerRatioEntity=new ScreenerRatioEntity();
					WebElement mktCap = driver.findElement(By.xpath("//ul[@id='top-ratios']"));
					Actions actions = new Actions(driver);
					actions.moveToElement(mktCap).build().perform();

					System.out.println("mktCap----" + mktCap);
					List<WebElement> allElements = mktCap.findElements(By.tagName("li"));

					String companies = driver.findElement(By.className("margin-0")).getText();
					screenerRatioEntity.setCompanyName(stock);

					System.out.println("---------------------companyName:" + stock + "--" + companies + "------------------------------------------------------");

					for (WebElement allElement : allElements) {
						System.out.println(allElement.getText());
						if (allElement.getText().startsWith("Market") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setMarketCap(Float.parseFloat(allElement.getText().split("₹")[1].replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("Current") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setCurrentPrice(Float.parseFloat(allElement.getText().split("₹")[1].replace(",", "")));
						}
						if (allElement.getText().startsWith("High / Low") && !(allElement.getText().isEmpty())) {
							String highLow = allElement.getText().split("₹")[1];
							String[] high=highLow.split("/");
							screenerRatioEntity.setWeek52High(Float.parseFloat(high[0].replace(",", "")));
							screenerRatioEntity.setWeek52Low(Float.parseFloat(high[1].replace(",", "")));
						}
						if (allElement.getText().startsWith("Book") && !(allElement.getText().isEmpty()) && (allElement.getText().length() > 12)) {
							screenerRatioEntity.setBookValue(Float.parseFloat((allElement.getText().split("₹")[1]).replace(",", "")));
						}
						if (allElement.getText().startsWith("Stock") && !(allElement.getText().isEmpty()) && (allElement.getText().length() > 10)) {
							screenerRatioEntity.setPE(Float.parseFloat(allElement.getText().split("Stock P/E")[1].replace(",", "")));
						}
						if (allElement.getText().startsWith("Dividend") && !(allElement.getText().isEmpty()) && (allElement.getText().length() > 16)) {
							screenerRatioEntity.setDivYeild(allElement.getText().split("Dividend Yield")[1]);
						}
						if (allElement.getText().startsWith("ROCE") && !(allElement.getText().isEmpty()) && (allElement.getText().length() > 5)) {
							screenerRatioEntity.setROCE(Float.parseFloat(allElement.getText().split("ROCE")[1].replace("%", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("ROE") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setROE(Float.parseFloat(allElement.getText().split("ROE")[1].replace("%", "")));
						}
						if (allElement.getText().startsWith("Face") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setFaceValue(Float.parseFloat(allElement.getText().split("₹")[1]));
						}
						if (allElement.getText().startsWith("Debt") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("₹").length > 1)
								screenerRatioEntity.setDebt(Float.parseFloat((allElement.getText().split("₹")[1]).replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("Debt to equity") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("equity").length > 1)
								screenerRatioEntity.setDebtToEquity(Float.parseFloat((allElement.getText().split("equity")[1])));
						}
						if (allElement.getText().startsWith("Promoter") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("holding").length > 1)
								screenerRatioEntity.setPromoterHolding((allElement.getText().split("holding")[1]));
						}
						if (allElement.getText().startsWith("Pledged") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setPledgedShare((allElement.getText().split("percentage")[1]));
						}
						if (allElement.getText().startsWith("Sales") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setSales(Float.parseFloat((allElement.getText().split("₹")[1]).replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("OPM") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setOPM(Float.parseFloat((allElement.getText().split("OPM")[1].replace("%", "").replace(",", ""))));
						}
						if (allElement.getText().startsWith("Profit after tax") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("₹").length > 1)
								screenerRatioEntity.setPat(Float.parseFloat((allElement.getText().split("₹")[1]).replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("Asset Turnover") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("Turnover").length > 1)
								screenerRatioEntity.setAsset_Turnover_Ratio(Float.parseFloat((allElement.getText().split("Turnover")[1]).replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().startsWith("EVEBITDA") && !(allElement.getText().isEmpty())) {
							if (allElement.getText().split("EVEBITDA").length > 1)
								screenerRatioEntity.setEVEBITDA(Float.parseFloat((allElement.getText().split("EVEBITDA")[1].replace(",", ""))));
						}
						if (allElement.getText().startsWith("Price to book value") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setPricetoBookValue(Float.parseFloat((allElement.getText().split("value")[1].replace(",", ""))));
						}
						if (allElement.getText().startsWith("Int Coverage") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setinterest_cov_ratio(Float.parseFloat(allElement.getText().split("Coverage")[1].replace("%", "").replace(",", "")));
						}
						if (allElement.getText().contains("Tax") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setTax(Float.parseFloat(allElement.getText().split("₹")[1].replace("Cr.", "").replace(",", "")));
						}
						if (allElement.getText().contains("Tax latest quarter") && !(allElement.getText().isEmpty())) {
							screenerRatioEntity.setTaxLatestQuarter(Float.parseFloat(allElement.getText().split("₹")[1].replace("Cr.", "").replace(",", "")));
						}
					}
					WebElement salesGrowth = driver.findElement(By.xpath("//table[@class='ranges-table'][1]"));
					String[] split = salesGrowth.getText().replace("%", "").split("\\r?\\n");
					for (int i = 0; i < split.length; i++) {
						if (split[1].split(":")[1].length() > 1)
							screenerRatioEntity.setSalesGrowth10Year(Float.parseFloat(split[1].split(":")[1]));
						if (split[2].split(":")[1].length() > 1)
							screenerRatioEntity.setSalesGrowth5Year(Float.parseFloat(split[2].split(":")[1]));
						if (split[3].split(":")[1].length() > 1)
							screenerRatioEntity.setSalesGrowth3Year(Float.parseFloat(split[3].split(":")[1]));
						if (split[4].split(":")[1].length() > 1)
							screenerRatioEntity.setSalesGrowthTTM(Float.parseFloat(split[4].split(":")[1]));
					}
					WebElement profitGrowth = driver.findElement(By.xpath("//table[@class='ranges-table'][2]"));
					String[] split1 = profitGrowth.getText().replace("%", "").split("\\r?\\n");
					for (int i = 0; i < split1.length; i++) {
						if (split1[1].split(":")[1].length() > 1)
							screenerRatioEntity.setProfitGrowth10Year(Float.parseFloat(split1[1].split(":")[1]));
						if (split1[2].split(":")[1].length() > 1)
							screenerRatioEntity.setProfitGrowth5Year(Float.parseFloat(split1[2].split(":")[1]));
						if (split1[3].split(":")[1].length() > 1)
							screenerRatioEntity.setProfitGrowth3Year(Float.parseFloat(split1[3].split(":")[1]));
						if (split1[4].split(":")[1].length() > 1)
							screenerRatioEntity.setProfitGrowthTTM(Float.parseFloat(split1[4].split(":")[1]));
					}
					WebElement priceCagr =driver.findElement(By.xpath("//table[@class='ranges-table'][3]"));
					String[] split2 = priceCagr.getText().replace("%", "").split("\\r?\\n"); 
					for (int i = 0; i < split2.length; i++) {
						if (split2[1].split(":")[1].length() > 1)
							screenerRatioEntity.setPriceGrowth10Year(Float.parseFloat(split2[1].split(":")[1])); 
						if (split2[2].split(":")[1].length() > 1)
							screenerRatioEntity.setPriceGrowth5Year(Float.parseFloat(split2[2].split(":")[1]));
						if (split2[3].split(":")[1].length() > 1)
							screenerRatioEntity.setPriceGrowth3Year(Float.parseFloat(split2[3].split(":")[1])); 
						if (split2[4].split(":")[1].length() > 1)
							screenerRatioEntity.setPriceGrowth1year(Float.parseFloat(split2[4].split(":")[1])); 
					}
					WebElement roe =driver.findElement(By.xpath("//table[@class='ranges-table'][4]")); 
					String[] split3 = roe.getText().replace("%", "").split("\\r?\\n");
					for (int i = 0; i < split3.length; i++) { 
						if (split3[1].split(":")[1].length() > 1)
							screenerRatioEntity.setROE10Year(Float.parseFloat(split3[1].split(":")[1]));
						if (split3[2].split(":")[1].length() > 1)
							screenerRatioEntity.setROE5Year(Float.parseFloat(split3[2].split(":")[1]));
						if (split3[3].split(":")[1].length() > 1)
							screenerRatioEntity.setROE3Year(Float.parseFloat(split3[3].split(":")[1]));
						if (split3[4].split(":")[1].length() > 1)
							screenerRatioEntity.setROETTM(Float.parseFloat(split3[4].split(":")[1]));
					}
					System.out.println("---------------------end----------");
					lstRatio.add(screenerRatioEntity);
					driver.close();
				}
				return lstRatio.size();

			};
			
			ExecutorService executor = Executors.newWorkStealingPool(10);
			Future<Integer> future = executor.submit(task);

			System.out.println("future done? " + future.isDone());

			Integer result = future.get();
			System.out.println("future done? " + future.isDone());
			System.out.print("result: " + result);
			executor.shutdown();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("--------That took " + (endTime - startTime)/1000 + " seconds");
		return lstRatio;
	}

	public void Screenerlogin(WebDriver driver){
		try {
			driver.navigate().to("https://www.screener.in/login/"); 
			driver.findElement(By.id("id_username")).sendKeys("tushardesarda@outlook.com");
			driver.findElement(By.id("id_password")).sendKeys("Dnpcoe@15");
			WebElement login=driver.findElement(By.className("button-primary"));
			Thread.sleep(6000);
			System.out.println("logged in successfully");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
