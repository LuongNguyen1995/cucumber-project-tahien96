package stepsDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.HttpRequest;
import utilities.XLUtility;
import pageObjects.HomePage;
import common.CommonConst; 

public class LoginPageSteps {
	public LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	public HomePage homePage = new HomePage(DriverFactory.getDriver());
	

	@When("User input email {string} and password {string}")
	public void user_input_email_and_password(String email, String password) {
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
	}
	
	@When("User click Login button")
	public void user_click_login_button() {
		loginPage.clickLogin();
	}	
	
	@Then("Verify that log in status is {string}")
	public String verify_that_log_in_status_is(String loginStatus) throws InterruptedException {
		String result = "Failed";
		if (loginStatus.toLowerCase().equals("success")) {
			user_login_successfully();
			result = "Passed";
		} else {
			Assert.assertTrue(loginPage.isLoginFailed());
			result = "Passed";
		}
		return result;
	}
	
	@Then("User login successfully")
	public void user_login_successfully() throws InterruptedException {		
		Boolean isDisplayed = loginPage.isLoginButtonDisplayed();
		Assert.assertFalse(isDisplayed);
	}
}
