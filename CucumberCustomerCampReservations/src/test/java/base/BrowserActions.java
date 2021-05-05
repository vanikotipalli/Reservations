package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {
	WebDriver driver;

	public BrowserActions() {

	}

	public BrowserActions(WebDriver driver) {
		this.driver = driver;

	}

	public static Properties loadProperties() {
		Properties prop = null;
		try {
			String path = System.getProperty("user.dir");
			prop = new Properties();
			prop.load(new FileInputStream(path + "//Config.properties"));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return prop;
	}

	public void navigateUrl() {
		String env = null;
		try {
			Properties prop = loadProperties();
			String url = null;
			env = prop.getProperty("Environment");
			if (env.equalsIgnoreCase("QA")) {
				url = prop.getProperty("Qa_Url");
			} else if (env.equalsIgnoreCase("DEV")) {
				url = prop.getProperty("Dev_Url");
			} else if (env.equalsIgnoreCase("UAT")) {
				url = prop.getProperty("Uat_Url");
			}
			driver.get(url);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Exception e) {

		}

	}

	public void clickElement(By locator, String msg) {
		try {
			waitForElement(locator);
			driver.findElement(locator).click();

		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	public void jsClickElement(By locator) {
		try {
			waitForElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(locator));
			// driver.findElement(locator).click();
		} catch (Exception e) {

		}
	}

	public void jsClickElement(WebElement locator) {
		try {
			// waitForElement(locator);
			hilightEle(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", locator);
			// driver.findElement(locator).click();
		} catch (Exception e) {

			// TODO: handle exception
		}
	}

	public void setElementText(By locator, String input, String msg) {
		try {
			waitForElement(locator);
			driver.findElement(locator).sendKeys(input);

		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		hilightEle(driver.findElement(locator));
	}

	public void selectValueFromDropDownBasedOnText(By locator, String text) {
		try {
			waitForElement(locator);
			WebElement ele = driver.findElement(locator);
			Select s = new Select(ele); // s.selectByIndex(0); // s.selectByValue(null);
			s.selectByVisibleText(text);

		} catch (Exception e) { // TODO: handle exception

		}
	}

	public void selectValueFromDropDownBasedOnIndex(By locator, int index) {
		String selectedOption = null;
		try {
			waitForElement(locator);
			WebElement ele = driver.findElement(locator);

			Select s = new Select(ele);
			s.selectByIndex(index);
			selectedOption = s.getFirstSelectedOption().getText();
		} catch (Exception e) {
			// TODO: handle exception
		}

	} // s.selectByValue(null); // s.selectByVisibleText(text); }

	public boolean getElementIsDisplyed(By locator) {
		try {
			waitForElement(locator);
			boolean ele = driver.findElement(locator).isDisplayed();
			return ele;
		} catch (Exception e) {
			return false;
		}
	}

	public String getElementText(By locator) {
		try {
			waitForElement(locator);
			String txt = driver.findElement(locator).getText();
			return txt;
		} catch (Exception e) {
			return null;
		}
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	}

	public void hilightEle(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", ele);
	}

	public void moveToElement(WebElement locator) {
		try {
			hilightEle(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(locator).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
