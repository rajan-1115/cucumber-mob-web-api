package utils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import tests.TestRunnerMobile;

public class WebDriverManager extends TestRunnerMobile {
	private static AppiumDriver<MobileElement> mdriver; 
	private static WebDriver wdriver;
	
	public AppiumDriver<MobileElement> createDriverMobile(String driverType) throws Exception {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			switch (driverType) {
			case "android":
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, driverType);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, ReadPropertiesFile.readMobileDeviceName());
				cap.setCapability(MobileCapabilityType.NO_RESET, true);
				cap.setCapability("appPackage", ReadPropertiesFile.readAppPackage());
				cap.setCapability("appActivity", ReadPropertiesFile.readAppMainActivity());
				mdriver = new AndroidDriver<MobileElement>(new URL(ReadPropertiesFile.readAppiumServerUrl()), cap);

				log.info("Android driver is created.");
				break;
			default:
				throw new IllegalArgumentException("Please pass correct correct value of mobile driver.");
			}

			mdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.fatal("@BeforeSuite setupTestBase failied. !");
			e.printStackTrace();
			throw e;
		}
		return mdriver;
	}
	
	public WebDriver createDriverWeb(String driverType) throws Exception {
		try {
			switch (driverType) {
			case "chrome":
				System.setProperty(ReadPropertiesFile
						.readDriverSystemPropertyKey(driverType), ReadPropertiesFile.readDriverPath(driverType));
				wdriver=new ChromeDriver();
				log.info("Chrome driver is created.");
				break;
			default:
				throw new IllegalArgumentException("Please pass correct correct value web driver.");
			}

			wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wdriver.get(ReadPropertiesFile.readWebUrl(driverType));
		} catch (Exception e) {
			log.fatal("@BeforeSuite setupTestBase failied. !");
			e.printStackTrace();
			throw e;
		}
		return wdriver;
	}
}
