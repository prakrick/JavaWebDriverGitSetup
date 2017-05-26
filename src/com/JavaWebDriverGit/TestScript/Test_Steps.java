package com.JavaWebDriverGit.TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	WebDriver driver = null;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/guptap/git/JavaWebDriverGitSetup/external libraries/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		// throw new PendingException();
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		// throw new PendingException();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {

		driver.findElement(By.id("log")).sendKeys("prakrick");
		driver.findElement(By.id("pwd")).sendKeys("DemoPass@01..");
		driver.findElement(By.id("login")).click();

		// throw new PendingException();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("in meho");
		Thread.sleep(20000);
		String userNameAferLogin=driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']//a")).getText();
		System.out.println(userNameAferLogin);
		boolean status = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']//a")).getText()=="Howdy, prakrick";
		System.out.println(status);
		if (userNameAferLogin.equals("Howdy, prakrick"))
		{
			System.out.println("Login successful");
		}
		
		// throw new PendingException();
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		// throw new PendingException();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
		// throw new PendingException();
	}

}
