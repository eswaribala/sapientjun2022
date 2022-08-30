package com.amex.cucumberdemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@Slf4j
public class StepDefinitions {
	private WebDriver webDriver;
    @Given("^Open the Chrome and Launch the application$")
	public void openChrome_LaunchtheApplication() {
		
    	 System.setProperty("webdriver.chrome.driver","c:/chromedriver.exe");
			webDriver=new ChromeDriver();			
			webDriver.manage().window().maximize();
			webDriver.get("http://demo.guru99.com/v4");	
	       log.info("This Step open the Chrome and launch the application.");				
	    
	}
    
    @When("^Enter Username \"(.*)\" and Password \"(.*)\"$")
    public void enterUserNameAndPassword(String userName,String password) {
    	 webDriver.findElement(By.name("uid")).sendKeys(userName);					
		 webDriver.findElement(By.name("password")).sendKeys(password);
    }
    
    @Then("^Reset the credentials$")
    public void resetButton() {
    	webDriver.findElement(By.name("btnReset")).click();	
    	webDriver.close();
    }
	
}
