package com.selenium.bddselenium;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.annotation.en.Then;

public class SeleniumStepDefs {
WebDriver dr;

@After
public void after(){
	System.out.println("Closing browser.");
	dr.close();
}

@Given("^navigate to calculator page$")
public void navigate(){
		System.setProperty("webdriver.chrome.driver","/Users/rkadam/Downloads/chromedriver");
       dr=new ChromeDriver();
       dr.get("http://seleniumsimplified.com/testpages/calculate.php");         
       }

@When ("^user enter two integer (\\d+) and (\\d+)$")
public void login(int n1, int n2){
       dr.findElement(By.id("number1")).sendKeys(String.valueOf(n1));
       dr.findElement(By.id("number2")).sendKeys(String.valueOf(n2));
       dr.findElement(By.id("calculate")).click();
       dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       }

@Then("^answer should be (\\d+)$")
public void verifySuccessful(int answer){
      String expectedText = String.valueOf(answer);
      String actualText = dr.findElement(By.id("answer")).getText();
      Assert.assertTrue("Error in calculation",expectedText.equals(actualText));
      }
}

