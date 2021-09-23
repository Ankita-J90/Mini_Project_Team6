package com.loginTests;

import org.testng.annotations.Test;


import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TC_Verify_login_Dashboard {
	WebDriver driver;

  
  @Test//(groups= {"Login"})
  public void LoginUser() throws IOException, InterruptedException {
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
		 LoginPage.SignInButton(driver).submit();
		
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Dashboard";
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("TC Passed : Login Successfully , DashBoard Opened");
	
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();

  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
