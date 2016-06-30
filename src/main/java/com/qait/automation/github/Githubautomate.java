package com.qait.automation.github;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Githubautomate extends NewTest
{
	
			// for login userName
			@FindBy(name = "login")
			public static WebElement username;
			// for login password
			@FindBy(name = "password")
			public static WebElement password;
			// for Sign In
			@FindBy(css = ".btn.btn-primary.btn-block")
			public static WebElement logIn;
			
			WebDriver driver;
			
			public Githubautomate(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);
				
		
			}
			public String log_in_home_page()
			{
					
					username.sendKeys("anshul1005");
					password.sendKeys("AnshulG@1994");
					logIn.click();
					return driver.getTitle();
			}
	}

