package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
    
    private static ExtentReports extent;
    

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            
            // Add system info to the report
         //   extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Naveen");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
