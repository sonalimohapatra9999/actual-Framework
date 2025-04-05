package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation  implements ITestListener{
	ExtentReports report ;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"......started");
		report.createTest(methodname);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"......Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"......Failed");
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		
		String screenshotname = methodname+"-"+jutil.toGetSystemDateAndTime();
		try {
			wutil.toTakeScreenshot(BaseClass.sdriver, screenshotname);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"......Skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("......Test Suite Execution  started....");
		
	
	
	//ExtendsReports
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Reports-"+new JavaUtility().toGetSystemDateAndTime()+".html");
	htmlReport.config().setDocumentTitle("Vtiger Execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("Vtiger execution report");
	
	report = new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("BaseUrl","http://localhost:8888");
	report.setSystemInfo("UserName", "admin");
	report.setSystemInfo("Password", "password");
	report.setSystemInfo("ReporterName", "sonali");
	
	
	
	
	
	}
	
	
	
	
	
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("......Test Suite Execution finished.....");
		report.flush();
		
	}
	
	
	

}
