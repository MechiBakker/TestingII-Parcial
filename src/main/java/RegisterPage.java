import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

        private By firstName = By.id("input-firstname");

        private By lastName = By.id("input-lastname");

        private By email = By.id("input-email");

        private By telephone = By.id("input-telephone");

        private By password = By.id("input-password");

        private By confirmContrasena = By.id("input-confirm");

        private By agreePolicy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");

        private By submitButtom = By
                .xpath("//*[@id=\"content\"]/form/div/div/input[2]");

        private By mensajeExito = By.xpath("//*[@id=\"content\"]/p[1]");

        public RegisterPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public void escribirNombre(String nombre) throws InterruptedException {
            sendText(nombre, firstName);
        }

        public void escribirApellido(String apellido) throws InterruptedException {
            sendText(apellido, lastName);
        }

        public void escribirMail(String mail) throws InterruptedException {
            sendText(mail, email);
        }

        public void escribirTelephone(String telefone) throws InterruptedException {
            sendText(telefone,telephone);
        }

        public void escribirContrasena(String clave) throws InterruptedException {
            sendText(clave, password);
        }

        public void confirmarContrasena(String clave) throws InterruptedException {
            sendText(clave, confirmContrasena);
        }

        public void aceptarPoliticas() throws InterruptedException {
            click(agreePolicy);
        }

        public void clickEnviar() throws InterruptedException {
            click(submitButtom);
        }

        public String obtenerMensajeExito() throws InterruptedException {
            System.out.println("Cuenta creada con exito: " + getText(mensajeExito));
            return this.getText(mensajeExito);
        }

}
