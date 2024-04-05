package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.gl.xpath.CompanyDashboardPage;
import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;

public class GLTestcase1 extends BaseClass {
	// log in as instructor
	@Test(priority=1)
	public void Alogintest() throws IOException, InterruptedException {
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// Enter the login credentials
		GLHomePage t = new GLHomePage();
		inputText(t.getUser(), stringData(11, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(11, 1));
		buttonClick(t.getLogin());
		insleep();
		System.out.println("'Courses statistics' for Instructor and CA/DM");
		minisleep();
		GLDashboardPage d = new GLDashboardPage();
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		jp.executeScript("arguments[0].scrollIntoView(true)", d.getLearningPlan());
		
		System.out.println("'Courses statistics' dashlet is not presented for Instructor");
		System.out.println("Dropdown doesn`t appear");
		
		driver.quit();

	}
    //log in as CA
	@Test(priority=2)
	public void CAlogintest1() throws IOException, InterruptedException {
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// Enter the login credentials
		GLHomePage t = new GLHomePage();
		inputText(t.getUser(), stringData(10, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(10, 1));
		buttonClick(t.getLogin());
		insleep();

		GLDashboardPage d = new GLDashboardPage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", d.getCD());
		try {

			waitUntilElementVisible(driver, d.getCD());
			buttonClick(d.getCD());
		} catch (Exception e) {
			waitUntilElementVisible(driver, d.getCD());
			buttonClick(d.getCD());
		}

		CompanyDashboardPage c=new CompanyDashboardPage();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getListUsers());
        //
		buttonClick(c.getListUsers());
		lowsleep();
		//change user role
		inputText(c.getSearchUser(), stringData(11, 0));
		minisleep();
		buttonClick(c.getSelectuserCheckbox());
		buttonClick(c.getBulkActions());
		buttonClick(c.getChangeUserRole());
		buttonClick(c.getAddCARole());
		buttonClick(c.getApply());
		System.out.println("CA role is added for the Instructor");
		driver.quit();
	}
	@Test(priority=3)
	public void Blogintest() throws IOException, InterruptedException, AWTException{
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// Enter the login credentials
		GLHomePage t = new GLHomePage();
		inputText(t.getUser(), stringData(11, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(11, 1));
		buttonClick(t.getLogin());
		insleep();
		
		GLDashboardPage d = new GLDashboardPage();
		//scroll down
		JavascriptExecutor jp = (JavascriptExecutor) driver;
		
		Actions a= new Actions(driver);
		a.doubleClick(d.getDashboard());
		System.out.println("'Courses statistics' dashlet is NOT presented on Dashboard");
		System.out.println("Dropdown appears with:\r\n"
				+ "-My Dashboard\r\n"
				+ "-KPI Analytics");
		takeScreenShot();
		buttonClick(d.getKpiAnalytics());
		lowsleep();
		System.out.println("	\r\n"
				+ "Page is opened with blocks:\r\n"
				+ "-Compliance Health\r\n"
				+ "-Course Statistics");
		//jp.executeScript("arguments[0].scrollIntoView(true)", d.getLearningPlan());
		lowsleep();
		
		jp.executeScript("arguments[0].scrollIntoView(true)", d.getCourseStatistics());
		buttonClick(d.getCourseStatistics());
		buttonClick(d.getCourseStatus());
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		buttonClick(d.getCourseStatus());
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		jp.executeScript("arguments[0].scrollIntoView(true)", d.getSearch());
		buttonClick(d.getSearch());
		lowsleep();
		System.out.println("\"Courses statistics\" dashlet is presented for Instructor+CA with present MY Direct reports course status");
		System.out.println("\"Courses statistics\" dashlet is presented for Instructor+DM with present MY Direct reports course status");
		
	    driver.quit();
	}
	//log in as CA
		@Test(priority=4)
		public void CAlogintest2() throws IOException, InterruptedException, AWTException {
			browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
			// maximize the browser
			maximize();
			// wait for all script
			time();

			// Enter the login credentials
			GLHomePage t = new GLHomePage();
			inputText(t.getUser(), stringData(10, 0));
			buttonClick(t.getLoginUser());

			inputText(t.getPass(), stringData(10, 1));
			buttonClick(t.getLogin());
			insleep();

			GLDashboardPage d = new GLDashboardPage();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", d.getCD());
			try {

				waitUntilElementVisible(driver, d.getCD());
				buttonClick(d.getCD());
			} catch (Exception e) {
				waitUntilElementVisible(driver, d.getCD());
				buttonClick(d.getCD());
			}

			CompanyDashboardPage c=new CompanyDashboardPage();
			js.executeScript("arguments[0].scrollIntoView(true)", c.getListUsers());
	        //
			buttonClick(c.getListUsers());
			lowsleep();
			//change user role
			inputText(c.getSearchUser(), stringData(11, 0));
			minisleep();
			buttonClick(c.getSelectuserCheckbox());
			buttonClick(c.getBulkActions());
			buttonClick(c.getChangeUserRole());
			buttonClick(c.getAddDMRole());
			buttonClick(c.getApply());
			System.out.println("DM role is added for the Instructor");
			Blogintest();
			driver.quit();
		}
}
