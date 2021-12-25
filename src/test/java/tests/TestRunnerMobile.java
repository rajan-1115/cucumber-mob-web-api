package tests;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pageObjectsMobile.LandingPage;
import utils.ReadPropertiesFile;
import utils.WebDriverManager;

@CucumberOptions(features = "src/test/java/mobileFeature", glue = "tests", plugin = "utils.CucumberReporter")
public class TestRunnerMobile extends AbstractTestNGCucumberTests {
	public static AppiumDriver<MobileElement> driver;
	public static Logger log = LogManager.getLogger(TestRunnerMobile.class.getClass());
	public static ExtentReports extent;
	public static Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
	public static ExtentTest scenario;
	public static ExtentTest step;
	public static LandingPage landingpage;
	public static SoftAssert softAssert;
	WebDriverManager webDriverManager;
	@BeforeSuite
	@Parameters({ "platform" })
	public void setupTestBase(@Optional("android") String platform) throws Exception {
		log.info("Suite execution started.");
		try {
			ReadPropertiesFile.loadProperties();
			webDriverManager=new WebDriverManager();
			driver =webDriverManager.createDriverMobile(platform);
			landingpage = new LandingPage(driver);
			softAssert = new SoftAssert();

		} catch (Exception e) {
			log.fatal("@BeforeSuite setupTestBase failied. !");
			e.printStackTrace();
			throw e;
		}
	}

	@AfterSuite
	public void tearDownTestBase() {
		try {
			driver.quit();
			log.info("Suite execution finished.");
		} catch (Exception e) {
			log.fatal("@BeforeSuite setupTestBase failied. !");
			e.printStackTrace();
			throw e;
		}
	}
}
