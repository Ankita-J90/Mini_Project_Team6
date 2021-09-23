package com.dashboardTests;

import Utils.WebDriverProperties;
import Utils.ExcelUtils;
import pageObjects.DashboardPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import pageObjects.LoginPage;
public class TC_Verify_SearchButton{
	
	WebDriver driver;
  @Test
  public void Verify_search() throws IOException 
  {

	  LoginPage.loginButton(driver).click();
	  LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsername());
      LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPassword());
      LoginPage.SignInButton(driver).submit();
      
      WebElement e=driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/button"));
      boolean display=e.isDisplayed();
      if(display)
    	  System.out.println("search Button is visible");
      else
    	  System.out.println("search Button is not present");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException 
  {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
