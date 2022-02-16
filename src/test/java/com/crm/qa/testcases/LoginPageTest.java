package com.crm.qa.testcases;

import static com.crm.qa.base.TestBase.password;
import static com.crm.qa.base.TestBase.username;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	public  LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init();
		loginPage= new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Not the right page");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
	boolean flag=	loginPage.validateCRMImage();
	Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(username, password);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
