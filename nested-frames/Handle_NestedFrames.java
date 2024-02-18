package com.maven.handleiframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handle_NestedFrames 
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
	public void nestedframe() 
	{
		driver.get("https://demoapps.qspiders.com/ui/frames/nested?sublist=1");
		
		WebElement frame_01 = driver.findElement(By.xpath("//iframe[@class='w-full h-96']"));
		
		driver.switchTo().frame(frame_01);
		
		WebElement frame_02  = driver.findElement(By.xpath("//div[@class='form_container']/iframe"));
		driver.switchTo().frame(frame_02);
		
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		
//		driver.findElement(By.xpath("//span[@class='passwordEye']")).click();
		
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		
		driver.findElement(By.id("submitButton")).submit();
	}
		
}
