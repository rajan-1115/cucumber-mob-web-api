package utils;

import java.io.FileInputStream;
import java.util.Properties;

import tests.TestRunnerMobile;

public class ReadPropertiesFile extends TestRunnerMobile {

	static Properties prop;
	static FileInputStream fis;

	public static void loadProperties() throws Exception {
		try {
			log.info("Loading Properties file.");
			prop = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config/appConfig.properties");
			prop.load(fis);
		} catch (Exception e) {
			log.fatal("Failed to load properties file.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readReportPath() {
		try {
			return prop.getProperty("reportFolderName");
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readMobileDeviceName() {
		try {
			return prop.getProperty("deviceName");
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readAppPackage() {
		try {
			return prop.getProperty("appPackage");
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readAppMainActivity() {
		try {
			return prop.getProperty("appMainActivity");
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readAppiumServerUrl() {
		try {
			String string = prop.getProperty("appiumServerUrl");
			return string;
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readDriverPath(String driverType) throws Exception {
		log.info("Function readDriverPath started.");
		try {
			String driverPath = System.getProperty("user.dir")+"/";
			if (driverType.equals("chrome")) {
				driverPath += prop.getProperty("chromeDriverPath");
			} else {
				Common.throwNewException("Incorrect browser name to find path.");
			}
			return driverPath;
		} catch (Exception e) {
			log.fatal("Failed to get property.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readDriverSystemPropertyKey(String driverType) throws Exception {
		log.info("Function readDriverSystemPropertyKey started.");
		try {
			String driverPath = null;
			if (driverType.equals("chrome")) {
				driverPath = prop.getProperty("chromeSystemProp");
			} else {
				Common.throwNewException("Incorrect browser name to find system property key.");
			}
			return driverPath;
		} catch (Exception e) {
			log.fatal("Failed to get driver system property key.");
			e.printStackTrace();
			throw e;
		}
	}

	public static String readWebUrl(String driverType) throws Exception {
		log.info("Function readWebUrl started.");
		String webUrl = null;
		try {
			webUrl = prop.getProperty("testUrl");

		} catch (Exception e) {
			log.fatal("Failed to read web url.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function readWebUrl finished.");
		return webUrl;
	}
	
	
	public static String readScreenshotPath() throws Exception {
		log.info("Function readScreenshotPath started.");
		String screenshotPath = null;
		try {
			screenshotPath = prop.getProperty("screenshotPath");

		} catch (Exception e) {
			log.fatal("Failed to read screenshot path.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function readScreenshotPath finished.");
		return screenshotPath;
	}
	
	public static String readApiBaseUri() throws Exception {
		log.info("Function readApiBaseUri started.");
		String baseUri = null;
		try {
			baseUri = prop.getProperty("baseUri");

		} catch (Exception e) {
			log.fatal("Not able to read base uri.");
			e.printStackTrace();
			throw e;
		}
		log.info("Function readApiBaseUri finished.");
		return baseUri;
	}
}
