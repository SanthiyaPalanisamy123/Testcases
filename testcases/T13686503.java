package testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gl.xpath.CourseManagementPage;
import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;
import com.report.ReportClass;

public class T13686503 extends BaseClass {

	@Test
	public void test5() throws IOException, InterruptedException {
		ReportClass.startReport();
		extent.setSystemInfo("Test case ID", "T13686503");
		extent.setSystemInfo("Test case Title", "Update document from \"Upload\" button -> Enroll Users and Manage Evidence (at Published course)");
		test = extent.createTest("Update document from \"Upload\" button -> Enroll Users and Manage Evidence (at Published course)", "test to validate  ");
		
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
		CourseManagementPage course = new CourseManagementPage();
		buttonClick(course.getAddCourse());
		buttonClick(course.getETCourse());
		buttonClick(course.getCreate());
		minisleep();
		inputText(course.getFullname(), "Upload(self Evidence)1");
		inputText(course.getShortname(), "Upload self evidenceM1");
		buttonClick(course.getCertificateIcon());
		minisleep();

		js.executeScript("arguments[0].scrollIntoView(true)", course.getCatalog());
		dropDownMethod(course.getCatalog(), "A_catalog");
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		inputText(course.getSearchusers(), "learner2002");
		minisleep();
		js.executeScript("arguments[0].scrollIntoView(true)", course.getCheckbox1());
		buttonClick(course.getCheckbox1());
		buttonClick(course.getCheckbox2());

		// js.executeScript("arguments[0].scrollIntoView(true)", c.getAddUser());
		buttonClick(course.getAddUser());
		lowsleep();
		buttonClick(course.getNext());
		minisleep();

		js.executeScript("arguments[0].scrollIntoView(true)", course.getUploadFile());

		// upload Doc1
		inputText(course.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Downloads\\course2.jpg");
		minisleep();
		// upload Doc2
		inputText(course.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Downloads\\OIP (2).jpg");
		minisleep();
		buttonClick(course.getNext());

		dropDownMethod(course.getSelectDoc1(), "course2.jpg");
		dropDownMethod(course.getSelectDoc2(), "course2.jpg");
		
		
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getViewCourse());
		minisleep();
		buttonClick(course.getPublish());
		minisleep();
		buttonClick(course.getViewCourse());
		minisleep();
		buttonClick(course.getUpload());
		lowsleep();
		buttonClick(course.getNext());
		minisleep();
		dropDownMethod(course.getSelectDoc1(), "OIP (2).jpg");
		buttonClick(course.getSaveChanges());
		lowsleep();

		test.log(Status.INFO, "Starting test case_ID_T13686503");

		buttonClick(course.getUsers());
		minisleep();
		screenShot4("T13686503_step_1");
		test.pass("In verify users popup, Doc2 is presented at column \"Evidence\" for Learner1\r\n"
				+ "Doc1 is presented at column \"Evidence\" for Learner2");

		buttonClick(course.getUser1checkbox());
		buttonClick(course.getEditevidencedocument());
		minisleep();
		screenShot4("T13686503_step_2");
		test.pass("Doc2 is presented at Evidence document dropdown as selected");

		buttonClick(course.getClose());
		minisleep();
		buttonClick(course.getEnrollUsers());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		screenShot4("T13686503_step_3");
		test.pass(
				"In verify users popup_completion settings page,Doc2 is presented at column \"Evidence\" for Learner1\r\n"
						+ "Doc1 is presented at column \"Evidence\" for Learner2");

		buttonClick(course.getSaveChanges());
		minisleep();
		buttonClick(course.getEnrollUserspopup());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		buttonClick(course.getNext());
		minisleep();
		screenShot4("T13686503_step_4");
		test.pass(
				"In verify enroll users_completion settings page,Doc2 is presented at column \"Evidence\" for Learner1\r\n"
						+ "Doc1 is presented at column \"Evidence\" for Learner2");

		buttonClick(course.getSaveChanges());
		minisleep();
		buttonClick(course.getUpload());
		lowsleep();
		buttonClick(course.getNext());
		minisleep();
		screenShot4("T13686503_step_5");
		test.pass("In uplod button_completion settings page, Doc2 is presented at column \"Evidence\" for Learner1\r\n"
				+ "Doc1 is presented at column \"Evidence\" for Learner2");

		buttonClick(course.getSaveChanges());
		lowsleep();
		closeBrowser();

		// log in learner 1
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		inputText(t.getUser(), stringData(9, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(9, 1));
		buttonClick(t.getLogin());
		insleep();

		buttonClick(course.getCoursename());
		lowsleep();
		buttonClick(course.getDocument());
		lowsleep();

		screenShot4("T13686503_step_6");
		test.pass("Tooltip with Doc2 appears");

		buttonClick(course.getDoc2());
		lowsleep();
		screenShot4("T13686503_step_7");
		test.pass("\"Document View and Properties\" popup is opened with Doc2");

		closeBrowser();

		// log in as learner 1 email
		browserLaunch("https://mail.google.com/mail/u/0/#inbox");
		// maximize the browser
		maximize();
		// wait for all script
		time();
		
		GLHomePage login=new GLHomePage();
		inputText(login.getEmail(), stringData(9, 0));
		buttonClick(login.getSubmit());
		insleep();
		inputText(login.getPassword(), "Test*123");
		buttonClick(login.getSubmit());
		insleep();
		screenShot4("T13686503_step_8");
        test.pass("Verify email,Certificate is sent only once");
		
		closeBrowser();
		
		// log in as learner 2
		browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
		// maximize the browser
		maximize();
		// wait for all script
		time();

		inputText(t.getUser(), stringData(16, 0));
		buttonClick(t.getLoginUser());

		inputText(t.getPass(), stringData(16, 1));
		buttonClick(t.getLogin());
		insleep();

		buttonClick(course.getCoursename());
		lowsleep();
		buttonClick(course.getDocument());
		lowsleep();

		screenShot4("T13686503_step_9");
		test.pass("Tooltip with Doc1 appears");

		buttonClick(course.getDoc2());
		lowsleep();
		screenShot4("T13686503_step_10");
		test.pass("\"Document View and Properties\" popup is opened with Doc1");

		ReportClass.endReport();
	}

}