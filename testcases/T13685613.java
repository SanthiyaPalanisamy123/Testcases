package testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gl.xpath.CourseManagementPage;
import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;
import com.report.ReportClass;
import com.screenrec.BaseClassScreenRec;

public class T13685613 extends BaseClass {
	@Test
	public void executionClass() throws Exception {
		BaseClassScreenRec.startRecord("executionClass");
		ReportClass.startReport();
		extent.setSystemInfo("Test case ID", "T13685613");
		extent.setSystemInfo("Test case Title", "Add activity to External training (admin view,Draft)");
		test = extent.createTest("Add activity to External training course", "test to validate  ");

		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		// Enter the login credentials
		GLHomePage t = new GLHomePage();
		inputText(t.getUser(), "1instrutor@ti.com");
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), "!Instrutor1");
		buttonClick(t.getLogin());
		insleep();

		/*
		 * -Log in as CA -Go to Course Management -> Add course -> External Training
		 * -Create external training , e.g. Test Training ->Fill in all fields with
		 * valid data on General information -Go to next step and enroll one individual
		 * User1 -Go to "Evidence tracking" step and select 'self-uploaded evidence of
		 * external training from Learner`s external training" -Finish the last step of
		 * creation -Click on "view course" on success pop up.
		 */

		GLDashboardPage d = new GLDashboardPage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", d.getCourseManagement());

		try {

			waitUntilElementVisible(driver, d.getCourseManagement());
			buttonClick(d.getCourseManagement());
		} catch (Exception e) {
			waitUntilElementVisible(driver, d.getCourseManagement());
			buttonClick(d.getCourseManagement());
		}
		minisleep();
		CourseManagementPage c = new CourseManagementPage();
		buttonClick(c.getAddCourse());
		buttonClick(c.getETCourse());
		buttonClick(c.getCreate());
		minisleep();
		inputText(c.getFullname(), "Add activity testcase1");
		inputText(c.getShortname(), "Addact testcase1");

		js.executeScript("arguments[0].scrollIntoView(true)", c.getCatalog());

		dropDownText(c.getCatalog(), "A_catalog");
		buttonClick(c.getNext());
		lowsleep();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getCheckbox1());
		buttonClick(c.getCheckbox1());
		// js.executeScript("arguments[0].scrollIntoView(true)", c.getAddUser());
		buttonClick(c.getAddUser());
		lowsleep();
		buttonClick(c.getNext());
		minisleep();

		buttonClick(c.getSelfUpload());
		buttonClick(c.getNext());
		minisleep();
		buttonClick(c.getNext());
		minisleep();
		buttonClick(c.getNext());
		minisleep();
		buttonClick(c.getViewCourse());
		minisleep();
		buttonClick(c.getTurnEditingOn());
		minisleep();
		test.log(Status.INFO, "Starting test case_ID_T13685613");

		buttonClick(c.getAddActivity());
		buttonClick(c.getActivity());
		lowsleep();
		screenShot3("T13685613_step_1");
		test.pass("\"Add an Activity or Recourse\" Popup appears with list");

		buttonClick(c.getFile());
		minisleep();
		screenShot3("T13685613_step_2");
		test.pass("File activity with description appears");

		
		String parentWindowID = driver.getWindowHandle();
		System.out.println(parentWindowID);
		// click more help button
		buttonClick(c.getHelp());
		//lowsleep();

		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);

		for (String allWindows : allWindowsId) {

			if (!allWindows.equals(parentWindowID)) {

				driver.switchTo().window(allWindows);

				lowsleep();

				screenShot3("T13685613_step_3");
				test.pass("Global Learn Help Online page is opened in new browser`s window");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowID);

		insleep();
		inputText(c.getFileName(), "PDF document f1");
		minisleep();
		js.executeScript("arguments[0].click()", c.getUploadBox());

	    buttonClick(c.getUploadBox());
		minisleep();
		
		buttonClick(c.getChooseFile());
		minisleep();
		Robot r = new Robot();
		//r.delay(2000);

		// Copy the path
		StringSelection s = new StringSelection("C:\\Users\\santhiya.palanisamy\\Downloads\\Traditional Foods.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		// paste the path
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		// Enter the path
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		r.delay(2000);
	
		buttonClick(c.getUploadThisFile());
		lowsleep();
		screenShot3("T13685613_step_4.1");
		test.pass("PDF document was uploaded successfully");

		buttonClick(c.getSaveAndReturnToCourse());
		minisleep();
		screenShot3("T13685613_step_4.2");
		test.pass("Course page is opened. File is successfully added to the course\r\n"
				+ "Your training content block is presented with 1 activity");

		ReportClass.endReport();
        BaseClassScreenRec.stopRecord();
        
        
        driver.findElement(By.xpath("")).sendKeys("tamil");
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        WebElement element = driver.findElement(By.xpath(""));
        element.sendKeys("tamil");
        Thread.sleep(3000);
        Select s1 = new Select(element);
        s1.selectByIndex(1);
        s1.selectByValue("Tamil Nadu");
        s1.selectByVisibleText("Tamil Nadu");
        
        
	}
}
