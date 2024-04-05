package testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.gl.xpath.CompanyDashboardPage;
import com.gl.xpath.GLDashboardPage;
import com.gl.xpath.GLHomePage;
import com.glbase.BaseClass;
import com.screenrec.BaseClassScreenRec;

public class GLTestcase3 extends BaseClass{
		@Test
			public void CertificateConfigurationTest() throws Exception {
			BaseClassScreenRec.startRecord("CertificateConfigurationTest");
			    // log in as CA
				browserLaunch("https://lms-stg-globallearn2.trialinteractive.com/");
				// maximize the browser
				maximize();
				// wait for all script
				time();

				// Enter the login credentials
				GLHomePage t = new GLHomePage();
				inputText(t.getUser(), stringData(3, 0));
				buttonClick(t.getLoginUser());

				inputText(t.getPass(), stringData(3, 1));
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
				minisleep();
				CompanyDashboardPage c=new CompanyDashboardPage();
				buttonClick(c.getManageSites());
				
				//create new site
				buttonClick(c.getAddSite());
				buttonClick(c.getStudyNumber());
				inputText(c.getStudyNumber(), "4122");
				inputText(c.getSiteId(), "4122-001");
				inputText(c.getSiteName(),"QA site");
				buttonClick(c.getSave());
				
				//CertificateConfiguration
				lowsleep();
				buttonClick(c.getCd());
				insleep();
				buttonClick(c.getCeritificate());
	            lowsleep();
				buttonClick(c.getIntegration());
				lowsleep();
				buttonClick(c.getAddNewIntegration());
				minisleep();
				buttonClick(c.getRoomId());
				inputText(c.getRoomId(), "4122");
				inputText(c.getProjectCode(), "PR4122");
				inputText(c.getDocTypeId(), "100");
				inputText(c.getIntegrationType(), "3");
				buttonClick(c.getSiteID());
				inputText(c.getSiteID(), "4122-534");
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				buttonClick(c.getSave());
				inputText(c.getReason(), "The Settings will be changed for Trial Interactive (Demo). Please provide a reason for editing the settings before saving changes");
				buttonClick(c.getSubmit());
			   			
				
}}