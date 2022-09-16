package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonConst;

public class ElementUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(CommonConst.EXPLICIT_WAIT_TIMEOUT));
		action = new Actions(driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Exception: "  + e.getMessage() + " when get web element: " + locator);
		}
		return element;
	}

	/**
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		waitForElementPresent(locator);
		waitForElementEnabled(locator);
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}
	
	public boolean isElementBehind(By locator) {
		List<WebElement> eles = driver.findElements(locator);
		return eles.size() == 0;
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}	
	
	public void waitForElementEnabled(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}	
	
	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementNotVisible(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	
}
