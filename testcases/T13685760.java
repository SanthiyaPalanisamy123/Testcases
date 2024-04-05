package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;
import com.report.ReportClass;

public class T13685760 extends BaseClass {
	@Test
	public static void mainClass() throws IOException, InterruptedException, AWTException {
		ReportClass.startReport();
		extent.setSystemInfo("Test case ID", "T13685760");
		extent.setSystemInfo("Test case Title", "Upload new document into simple record without linked course on \"External Training\" Page");
		
		test = extent.createTest("Upload new document into simple record without linked course on \"External Training\" Page", "test to validate  ");
		
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

		/*
		 * Log in as CA Go to Transcript -> External Training 
		 * Click "Add New Record"
		 * Fill in all required fields -> Click "Next" 
		 * Select user -> Click "Next"
		 * Upload any document -> Click "Next" 
		 * Select Evidence Document for User1 -> Click "Next" 
		 * Click "Add Record"
		 */

		GLDashboardPage d = new GLDashboardPage();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", d.getTranscript());
		try {

//	waitUntilElementVisible(driver, d.getTranscript());
			buttonClick(d.getTranscript());
		} catch (Exception e) {
//		waitUntilElementVisible(driver, d.getTranscript());
			buttonClick(d.getTranscript());
		}
		js.executeScript("arguments[0].scrollIntoView(true)", d.getRecord());
		lowsleep();
		try {

			waitUntilElementVisible(driver, d.getRecord());
			buttonClick(d.getRecord());
		} catch (Exception e) {
			waitUntilElementVisible(driver, d.getRecord());
			buttonClick(d.getRecord());
		}
		lowsleep();
		buttonClick(d.getAddRecord());
		inputText(d.getRecordName(), "ET simple record1234");
		inputText(d.getCompanyName(), "TI demo company");
		buttonClick(d.getNext());
		buttonClick(d.getSearchUser());
		buttonClick(d.getSelectcheckbox());
		buttonClick(d.getAddUser());
		buttonClick(d.getNext());
		minisleep();
		inputText(d.getEvidence(), "C:\\Users\\santhiya.palanisamy\\Downloads\\TIfile.docx");
		minisleep();

		
		buttonClick(d.getNext());
		lowsleep();
		buttonClick(d.getNext());
		minisleep();
		buttonClick(d.getAdd());
		minisleep();
//		buttonClick(d.getLeave());
//		minisleep();
		buttonClick(d.getClose());
		minisleep();

		buttonClick(d.getSelect());
		minisleep();
		screenShot2("T13685760_step1");
		minisleep();

		test.pass("\"Edit\" button at the top of the page has become available");
		
		
		buttonClick(d.getEditETrecord());
		minisleep();
		screenShot2("T13685760_step2");
		minisleep();

		test.pass("\"Edit Record\" pop-up is appeared");

		
		buttonClick(d.getChange());
		lowsleep();
		screenShot2("T13685760_step3");
		minisleep();

		test.pass("\"Change Evidence Document\" Pop-up appeared");
		
	
		inputText(d.getUpload(), "C:\\Users\\santhiya.palanisamy\\Downloads\\OIP (2).jpg");
		insleep();

		screenShot2("T13685760_step4");
		minisleep();

		test.pass("Uploaded document opened in \"Upload Document\" Pop-up\r\n"
				+ "\"Remove\" button appeared");
		
		
		buttonClick(d.getSaveFile());
		minisleep();
		screenShot2("T13685760_step5");
		minisleep();
		test.pass("\"Upload Document\" Pop-up closed\r\n"
				+ "\"Edit Record\" pop-up is appeared");
		
		
		buttonClick(d.getSubmit());
		minisleep();
		screenShot2("T13685760_step6");
		minisleep();
		
		test.pass("\"Edit Record\" pop-up is closed\r\n"
				+ "\"Record Changed\" pop-up with text \"The record for the User Name Course was successfully changed.\" is appeared");
		
		
		buttonClick(d.getClose());
		buttonClick(d.getSelect());
		minisleep();
		screenShot2("T13685760_step7");
		minisleep();

		test.pass("Document uploaded in step 5 is displayed at \"Evidence\" field");
		
		
		ReportClass.endReport();
	}
}