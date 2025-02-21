package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleDeProdutosPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    private WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    private WebElement linkAdicionar;


    public ControleDeProdutosPO(WebDriver driver) {
        super(driver);
    }
}
