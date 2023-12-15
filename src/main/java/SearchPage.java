import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private final By searchProduct = By.xpath("//*[@id=\"search\"]/input");
    private final By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private final By searchResult = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");

    private final By addToCartButton = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span");

    private final By estadoCesta = By.id("cart-total");
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void escribirNombreProducto(String producto) throws InterruptedException {
        this.sendText(producto, searchProduct);
    }

    public void clickBuscar() throws InterruptedException {
        this.click(searchButton);
    }

    public String obtenerResultado() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Resultado de la busqueda: " + this.getText(searchResult));
        return this.getText(searchResult);
    }

    public void clickAnadirCesta() throws InterruptedException {
        this.click(addToCartButton);
    }

    public String obtenerEstadoCesta() throws InterruptedException {
        return this.getText(estadoCesta);
    }
}
