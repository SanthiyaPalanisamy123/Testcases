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

public class T13686194 extends BaseClass {
@Test
	public static void mainClass() throws IOException, InterruptedException {
		ReportClass.startReport();
		extent.setSystemInfo("Test case ID", "T13686194");
		extent.setSystemInfo("Test case Title", "Uploading documents with different sizes");
		test = extent.createTest("Uploading documents with different sizes", "test to validate  ");
		
		
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
		 * Log in as CA 
		 * Go to Course Management ->Add course -> External Training ->
		 * Fill in all required fields with valid data on General information 
		 * Enroll at least one User 
		 * Go to Step 'Evidence Tracking'
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
		inputText(c.getFullname(), "Upload different size of file");
		inputText(c.getShortname(), "Different size of file");

		js.executeScript("arguments[0].scrollIntoView(true)", c.getCatalog());

		dropDownText(c.getCatalog(), "A_catalog");
		buttonClick(c.getNext());
		lowsleep();
		js.executeScript("arguments[0].scrollIntoView(true)", c.getCheckbox1());
		buttonClick(c.getCheckbox1());
		
		buttonClick(c.getAddUser());
		minisleep();
		buttonClick(c.getNext());
		minisleep();
		test.log(Status.INFO, "Starting test case_ID_T13686194");

		
		js.executeScript("arguments[0].scrollIntoView(true)", c.getUploadFile());
		
		//zero size file
		inputText(c.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Documents\\o doc.txt");
		minisleep();
		screenShot1("T13686194_Step_1");
        test.pass("Zero size file document is not uploaded");
      
		//upload 32KB file
		inputText(c.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Documents\\GL Testcases.xlsx");
		minisleep();
		screenShot1("T13686194_step_2");
        test.pass("32KB size file document is uploaded");

		//upload 2MB file
		inputText(c.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Documents\\Types of Query.docx");
		minisleep();
		screenShot1("T13686194_step_3");
        test.pass("2KB size file document is uploaded");
        
		//upload 50MB file
		inputText(c.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Downloads\\50MB.pdf");
		lowsleep();
		screenShot1("T13686194_step_4");
        test.pass("50KB size file document is uploaded");

		//upload 200MB file
		inputText(c.getUploadFile(), "\"C:\\Users\\santhiya.palanisamy\\Downloads\\200MB.pdf\"");
		insleep();
		screenShot1("T13686194_step_5");
        test.pass("200KB size file document is uploaded");

		//upload 1023MB file
		inputText(c.getUploadFile(), "C:\\Users\\santhiya.palanisamy\\Downloads\\testdocus-0.99GB.docx");
		Thread.sleep(30000);
		screenShot1("T13686194_step_6");
        test.pass("1023KB size file document is uploaded");

		ReportClass.endReport();

		
		
	}
}
