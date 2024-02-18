package com.maven.handleiframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handle_SingleFrame 
{

	public static WebDriver driver;

	@BeforeMethod
	public void pre_condition() 
	{

		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	}

	@AfterMethod
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test
	public void singleframe() 
	{
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		driver.switchTo().frame(frame);
		
		// Entering the valid data inside frames
		WebElement usernameTextfield= driver.findElement(By.id("username"));
		           usernameTextfield.sendKeys("madehs");
		WebElement passwordTextfield= driver.findElement(By.id("password"));
		           passwordTextfield.sendKeys("1234567");
		           
	   driver.findElement(By.id("submitButton")).submit();
		           
	}

}

