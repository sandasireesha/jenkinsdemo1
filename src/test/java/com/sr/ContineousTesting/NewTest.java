package com.sr.ContineousTesting;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	
	WebDriver driver;
		
	  @BeforeClass
	  public void launchApplication() {
		  WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			driver.get("http://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
	  }
	  
	  @Test
	  public void login() {
		  driver.findElement(By.linkText("Log in")).click();
			driver.findElement(By.id("Email")).sendKeys("sandarevathi@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("revathi1288");
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			String expected="sandarevathi@gmail.com";
			String actual=driver.findElement(By.linkText("sandarevathi@gmail.com")).getText();
			assertEquals(expected,actual);
			driver.findElement(By.linkText("Log out")).click();

	  }
	  @Test
	  public void logout() {
		  driver.findElement(By.linkText("Log out")).click();
		  String expectedLink="Log in";
		  String actualLink=driver.findElement(By.linkText("Log in")).getText();
		  assertEquals(actualLink,expectedLink);
	  
	 
  }
	  @AfterClass
	  public void closeApplication() {
		  driver.close();
	  }
}
