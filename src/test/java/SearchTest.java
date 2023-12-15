import Reports.ExtentFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reports/SearchTest.html");
    static ExtentReports extent;

    @BeforeAll
    public void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setUp();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("Search")
    @Tag("ALL")
    public void testSearchIphone() throws InterruptedException {
        ExtentTest test = extent.createTest("Iphone found correctly");
        test.log(Status.INFO, "Start testing");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.escribirNombreProducto("Iphone");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Iphone search");


        Assertions.assertEquals(searchPage.obtenerResultado(), "iPhone");
        test.log(Status.PASS, "Success search");
    }

    @Test
    @Tag("AddToCart")
    @Tag("All")
    public void testBuy() throws InterruptedException {
        ExtentTest test = extent.createTest("Add to car");
        test.log(Status.INFO, "Starting test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.clickAnadirCesta();
        test.log(Status.PASS, "Correct adding");

        Assertions.assertEquals(searchPage.obtenerEstadoCesta(), "1 item(s) - $123.20");
        test.log(Status.PASS, "Success adding");
    }

    @AfterAll
    public void quit() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
        extent.flush();
    }
}