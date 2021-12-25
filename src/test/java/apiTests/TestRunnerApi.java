package apiTests;

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
import tests.TestRunnerMobile;
import utils.ReadPropertiesFile;
import utils.WebDriverManager;

@CucumberOptions(features = "src/test/java/feature/api", glue = "apiTests", plugin = "utils.CucumberReporter")
public class TestRunnerApi extends AbstractTestNGCucumberTests {
	public static Logger log = LogManager.getLogger(TestRunnerMobile.class.getClass());
	public static SoftAssert softAssert;
}
