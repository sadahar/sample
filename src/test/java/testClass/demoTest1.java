package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.KiteBaseClass;
import baseClasses.KiteUtilityClass;
import pomClass.KiteHomePage1;
import pomClass.KiteLogIn1;
import pomClass.KiteLogIn2;

public class demoTest1 {

	WebDriver driver;
	KiteLogIn1 method1;
	KiteLogIn2 method2;
	KiteHomePage1 method;
	KiteBaseClass base;
	String TcId;

	@BeforeClass
	public void LaunchBrowser() {

		Reporter.log("....OPEN BROWSER...", true);

		base = new KiteBaseClass();

		// to launch Browser

		driver = base.LaunchBrowser();

		// POM 1 object

		method1 = new KiteLogIn1(driver);

		// POM 2 object

		method2 = new KiteLogIn2(driver);

		// POM 3 object

		method = new KiteHomePage1(driver);

	}

	@BeforeMethod
	public void LogInTOApplication() throws InterruptedException {

		method1.userid("KTS907");
		Thread.sleep(1000);

		method1.password("Sadahar047");
		Thread.sleep(1000);

		method1.clickloginbtn();

		Thread.sleep(2000);

		method2.PIN("252552");

		Thread.sleep(1000);
		method2.CONTINUE();

	}

	@Test
	public void TC01() throws InterruptedException {

		TcId = "TC01";

		Reporter.log("Running Account Verify", true);

		String ActualID = method.GET_ID();

		String ExpText = "KTS907";

		Assert.assertEquals(ActualID, ExpText);

//		Reporter.log("Test case name =Login Negative Test- Balnk Password", true);
//		Thread.sleep(1000);
//		method.userid("sadashiv");
//		Thread.sleep(1000);
//
//		method.clickloginbtn();
//
//		Thread.sleep(1000);
//
//		String actual = method.passErrormsg();
//
//		String ExpText = "Password should be minimum 6 characters.";
//
//		Assert.assertEquals(actual, ExpText);

	}

	// Test case 02

//	@Test
//	public void TC02() throws InterruptedException {

//		Reporter.log("Test case name =Login Negative Test- Blank UserId", true);
//
//		method.password("123456");
//		Thread.sleep(1000);
//
//		method.clickloginbtn();
//
//		Thread.sleep(1000);
//
//		String actual = method.idErrormsg();
//
//		String ExpText = "User ID should be minimum  characters.";
//
//		Assert.assertEquals(actual, ExpText);

	//}

	@AfterMethod

	public void Screenshot() throws IOException, InterruptedException {

		KiteUtilityClass.Screenshot(driver, TcId);

		Reporter.log("LogOut From The Application");

		Thread.sleep(2000);
		method.ID();

		Thread.sleep(2000);
		method.LOG_OUT();

	}

}
