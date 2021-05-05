package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;*/


public class LoginStepDefs {
	
	WebDriver driver ;
	//LoginStepDefs loginStepDefs = new LoginStepDefs();

	@Given("Navigate to url")
	public void navigateUrl() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vani.kotipalli\\eclipse-workspace_new\\CucumberCustomerCampReservations\\ExeFiles\\geckodriver.exe");					
		 driver= new FirefoxDriver();
	       driver.manage().window().maximize();			
	       driver.get("https://il-qa.egovreservations.com/");	
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.manage().window().maximize();
		   driver.findElement(By.xpath("//*[contains(text(),'LOGIN / CREATE ACCOUNT')]")).click();
		System.out.println("Navigate url");
	}
		
	
	  @When("I enter userName {string} and password {string}")
	  public void enterDetails(String uName, String pwd) throws InterruptedException {
	//	  loginStepDefs.navigateUrl();
		  Thread.sleep(3000);
		  driver.findElement(By.id("loginUsername")).sendKeys(uName);							
	       driver.findElement(By.id("loginPassword")).sendKeys(pwd);	
	       Thread.sleep(3000);
		  
	  System.out.println("Enter user name and password "+uName+"   "+pwd);
	  }
	 
	
	@And("I select Login button")
	public void selectLogin() {
		//loginStepDefs.enterDetails(uName, pwd);
		 
		WebElement ele =driver.findElement(By.xpath("//*[text()='SUBMIT']"));
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);
		System.out.println("Select Login buttons");
	}
	
	@Then("User should be Logged in")
	public void validateLogin() {
		System.out.println("User should be login in");
	}
	
}
