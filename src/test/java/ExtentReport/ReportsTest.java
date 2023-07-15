package ExtentReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportsTest extends TestListenerAdapter {

		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		
			
		public void onStart(ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/ExtentReports/"+repName);//specify location of the report
			
			extent=new ExtentReports();
			
			//add environment details
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("User","Ganesh");
			
			//configuration to change look and feel
			sparkReporter.config().setDocumentTitle("Page Object Model Project"); // Tile of report
			sparkReporter.config().setReportName("Functional Test Automation Report"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy,hh:mm a '('zzz')'");
		
		}
		
		public void onTestSuccess(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in the report
			logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		}
		
		public void onTestFailure(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			 // send the passed information to the report with RED color highlighted
			logger.fail(tr.getThrowable());
			
			String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
			
			File f = new File(screenshotPath); 
			
			if(f.exists())
			{
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			
		}
		
		public void onTestSkipped(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		}
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
		
	}

