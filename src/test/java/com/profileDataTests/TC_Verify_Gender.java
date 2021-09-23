package com.profileDataTests;



import org.testng.annotations.Test;

import Utils.ExcelUtils;
import Utils.WebDriverProperties;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_Verify_Gender{
	WebDriver driver;
  @Test
  public void verifyGender() throws IOException, InterruptedException {
	  
	  LoginPage.loginButton(driver).click();
		 LoginPage.usernameTextBox(driver).sendKeys(ExcelUtils.getUsernameU());
		 LoginPage.passwordTextBox(driver).sendKeys(ExcelUtils.getPasswordU());
		 LoginPage.SignInButton(driver).submit();
		 
	  LoginPage.profileLink(driver).click();
	  
	  String ActualValue=ProfilePage.getActualGender(driver).getText();
	  assertEquals(ActualValue, "Male");
	  
	  System.out.println("Check with the Gender = Female");
	  System.out.println("Gender Test Case Verified Successfully");
	  
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  driver=WebDriverProperties.setChromeDriverProperties();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}

