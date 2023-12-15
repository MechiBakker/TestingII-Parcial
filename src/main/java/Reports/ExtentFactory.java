package Reports;
import com.aventstack.extentreports.ExtentReports;
public class ExtentFactory {
        public static ExtentReports getInstance() {
            ExtentReports extent = new ExtentReports();
            extent.setSystemInfo("Environment", "PROD");
            extent.setSystemInfo("OS", "MAC");
            extent.setSystemInfo("Browser", "Chrome");
            return extent;
        }
}
