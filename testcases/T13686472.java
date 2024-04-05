package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.gl.xpath.CompanyDashboardPage;
import com.gl.xpath.CourseManagementPage;
import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;
import com.report.ReportClass;

public class T13686472 extends BaseClass {
	@Test
	public static void mainClass() throws IOException, InterruptedException, AWTException {
//		ReportClass.startReport();
//		extent.setSystemInfo("Test case ID", "T13686472");
//		extent.setSystemInfo("Test case Title", "Course page for enrolled Creator Manager (Evidence:Document Upload)");
//		test = extent.createTest("Course page for enrolled Creator Manager (Evidence:Document Upload)", "test to validate  ");
//		
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// log in as CA
		GLHomePage t = new GLHomePage();
		inputText(t.getUser(), stringData(11, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(11, 1));
		buttonClick(t.getLogin());
		insleep();

		/*-Create 3 users: Manager, Learner1 , Learner 2
		Manager manages Learner1 and Learner2
		-Log in as Manager
		-Go to Course Management -> Add course -> External Training
		-Fill in all fields with valid data on General information and add Certificate
		-Go to next step and enroll Learner1
		-Go to "Evidence tracking" step and select 'Upload Documents (i.e. Electronic Copy of Attendance Log)' and upload 2 document (e.g. doc 1 , doc 2)
		-Go to "Completion Settings" and select Doc 1 for Learner 1
		-Finish the creation
		-Publish course
		-Log in as CA -> enroll Manager in the same course (set Doc2 for Manager)*/

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
		minisleep();
		CompanyDashboardPage c = new CompanyDashboardPage();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getCreateUser());

		buttonClick(c.getCreateUser());
		buttonClick(c.getRole());

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		buttonClick(c.getGeneratePW());

		minisleep();

		WebElement pW = driver.findElement(By.xpath("//*[@id='id_newpassword']"));
		driver.findElement(By.xpath("//*[@class='icon fa fa-pencil fa-fw ']")).click();
		// pW.clear();
		pW.sendKeys("Test@123");

		// inputText(c.getNewPW(), "Test@123");
		minisleep();
		buttonClick(c.getForcePW());

		inputText(c.getFirseName(), "Santhiya");
		inputText(c.getLastName(), "Manager");
		inputText(c.getEmail(), "santhiyamanager@ti.com");
		buttonClick(c.getCreate());

		// create learner1
		buttonClick(c.getCd());
		lowsleep();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getCreateUser());

		buttonClick(c.getCreateUser());
		buttonClick(c.getRole());

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		buttonClick(c.getGeneratePW());
		
		driver.findElement(By.xpath("//*[@class='icon fa fa-pencil fa-fw ']")).click();
		// pW.clear();
		pW.sendKeys("Test@123");
		buttonClick(c.getForcePW());
		// inputText(c.getNewPW(), "Test@123");
		inputText(c.getFirseName(), "Santhiya");
		inputText(c.getLastName(), "learner1");
		inputText(c.getEmail(), "santhiyalearner1@ti.com");
		buttonClick(c.getCreate());

		// create learner2
		buttonClick(c.getCd());
		lowsleep();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getCreateUser());

		buttonClick(c.getCreateUser());
		buttonClick(c.getRole());

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		buttonClick(c.getGeneratePW());
		driver.findElement(By.xpath("//*[@class='icon fa fa-pencil fa-fw ']")).click();
		// pW.clear();
		pW.sendKeys("Test@123");
		buttonClick(c.getForcePW());
		// inputText(c.getNewPW(), "Test@123");
		inputText(c.getFirseName(), "Santhiya");
		inputText(c.getLastName(), "learner2");
		inputText(c.getEmail(), "santhiyalearner2@ti.com");
		buttonClick(c.getCreate());

		closeBrowser();

		// log in as manager
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// log in as CA
		inputText(t.getUser(), "santhiyamanager@ti.com");
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), "Test@123");
		buttonClick(t.getLogin());
		insleep();

		js.executeScript("arguments[0].scrollIntoView(true)", d.getCourseManagement());

		try {

			waitUntilElementVisible(driver, d.getCourseManagement());
			buttonClick(d.getCourseManagement());
		} catch (Exception e) {
			waitUntilElementVisible(driver, d.getCourseManagement());
			buttonClick(d.getCourseManagement());
		}
		minisleep();
		CourseManagementPage course = new CourseManagementPage();
		buttonClick(course.getAddCourse());
		buttonClick(course.getETCourse());
		buttonClick(course.getCreate());
		minisleep();
		inputText(course.getFullname(), "Creator Manager (Evidence)");
		inputText(course.getShortname(), "evidence M");

		js.executeScript("arguments[0].scrollIntoView(true)", course.getCatalog());
		buttonClick(course.getCatalog());
		buttonClick(course.getNext());
		lowsleep();
		js.executeScript("arguments[0].scrollIntoView(true)", course.getCheckbox1());
		buttonClick(course.getCheckbox1());
		//buttonClick(course.getCheckbox2());
		// js.executeScript("arguments[0].scrollIntoView(true)", c.getAddUser());
		buttonClick(course.getAddUser());
		lowsleep();
		buttonClick(course.getNext());
		minisleep();

		js.executeScript("arguments[0].scrollIntoView(true)", course.getUploadFile());

		// upload Doc1 
		inputText(course.getUploadFile(), "\"C:\\Users\\santhiya.palanisamy\\Downloads\\course2.jpg\"");
		minisleep();

		// upload Doc2
		inputText(course.getUploadFile(), "\"C:\\Users\\santhiya.palanisamy\\Downloads\\OIP (2).jpg\"");
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getViewCourse());
		minisleep();

		// ReportClass.endReport();
		
		
	}
}
