package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tests.TestRunnerMobile;

public class ExtentReportConfig extends TestRunnerMobile {

	public static void setupExtentReport() {
		log.info("Creating extent report.");
		try {
			
			File fileDri=new File(System.getProperty("user.dir")+ReadPropertiesFile.readReportPath());
			
			ExtentSparkReporter spark=new ExtentSparkReporter(fileDri);
			spark.config().setDocumentTitle("Testing Report");
			spark.config().setReportName("Automation testing");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Rajan");
			
		} catch (Exception e) {
			log.fatal("Failed to setup extent report.");
			e.printStackTrace();
			throw e;
		}
	}
}
