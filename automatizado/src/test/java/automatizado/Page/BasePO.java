package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação de novas PagesObjects.
 * Todas as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {

    /** * Driver base que será usado pelas pages*/
    protected WebDriver driver;

    /**
     * Contrutor base para a criação da fabrica de elementos
     * @param driver Driver da pagina atual
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
}
