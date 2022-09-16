package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utilities.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ElementUtils elementUtils = new ElementUtils(DriverFactory.getDriver());
	
	private By btnLogin = By.xpath("(//button//*[text()='Login'])[2]");
	
	By btnCloseChat = By.xpath("//div[@id='sp-close-frame']");
	By btnSubmitChat = By.id("submitChat");
	
	public void clickLogin() {
		elementUtils.doClick(btnLogin);
	}
	
}
