package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// page factory or object repository
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]" ) WebElement loginClickButton;
	@FindBy(how =How.XPATH, using = "//input[@name='email']") WebElement username;
	@FindBy(how =How.XPATH, using = "//input[@name='password']") WebElement password;
	@FindBy(how =How.XPATH, using = "//div[contains(text(),'Login')]") WebElement loginButton;
	@FindBy(how =How.XPATH, using = "//a[contains(text(),'Sign Up')]") WebElement signup;
	@FindBy(how =How.XPATH, using = "//img[@class='img-responsive']/ancestor::div[1]/button/span[4]/following::a[1]/img") WebElement logoImage;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
public String validateLoginPageTitle() {
	return driver.getTitle();
}

public boolean validateCRMImage() {
	return logoImage.isDisplayed();
}

public HomePage login(String un, String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginButton.click();
	return new HomePage();
}
}
