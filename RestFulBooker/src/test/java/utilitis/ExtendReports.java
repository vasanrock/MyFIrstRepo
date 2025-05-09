package utilitis;

import java.time.LocalDateTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports implements ITestListener
{
	ExtentSparkReporter sparkReport;
	ExtentReports extent ;
	ExtentTest test;
	
	String ld;
	
	public void onStart(ITestContext context) 
	{
		 ld = LocalDateTime.now().toString().replaceAll(" ","").replaceAll(":","-");
		sparkReport = new ExtentSparkReporter("./reports/"+ld+".html");
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Rest_booking");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		
		extent.setSystemInfo("Author","keerthiVasan");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Browser Name","Chrome");

		System.out.println("Test Execution Started......");
		
	}

	public void onTestStart(ITestResult result) 
	{
		extent.createTest(result.getName());
		System.out.println("Test Started......");
	}


	public void onTestSuccess(ITestResult result) 
	{
		extent.createTest(result.getName());

	}


	public void onTestSkipped(ITestResult result) 
	{
		extent.createTest(result.getName());
	}


	public void onTestFailure(ITestResult result) 
	{
		extent.createTest(result.getName());
	}


	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

	
}
