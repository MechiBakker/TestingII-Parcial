import Reports.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reports/RegisterTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("Register")
    @Tag("ALL")
    public void RegisterExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Success");
        test.log(Status.INFO, "Start");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMyAccount();
            registerPage.clickRegister();
            test.log(Status.PASS, "Register page");

            registerPage.escribirNombre("Renee");
            registerPage.escribirApellido("Ewing");
            registerPage.escribirMail("mi.aliquam.gravida@yahoo.ca");
            registerPage.escribirTelephone("1-728-882-8014");
            registerPage.escribirContrasena("ABC123");
            registerPage.confirmarContrasena("ABC123");
            registerPage.aceptarPoliticas();
            registerPage.clickEnviar();
            test.log(Status.PASS, "Register correct");

            Assertions.assertEquals(registerPage.obtenerMensajeExito(), "Congrats! You have a new account");
            test.log(Status.PASS, "Correct validation");
        } catch (Exception error) {
            test.log(Status.FAIL, "It's been an error" + error.getMessage());
        }
    }


    @AfterEach
    public void cerrar() {
        RegisterPage loginPage = new RegisterPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
