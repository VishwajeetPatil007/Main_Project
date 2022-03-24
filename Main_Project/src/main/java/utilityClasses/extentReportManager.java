package utilityClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class extentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		if (report == null) {
			String reportName = dateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\test-output\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("Microsoft", "Windows");
			report.setSystemInfo("Enviorme", "UAT");
			report.setSystemInfo("Browser", "Chrome");

			htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyyy HH:mm:ss");

		}
		return report;
	}
}
