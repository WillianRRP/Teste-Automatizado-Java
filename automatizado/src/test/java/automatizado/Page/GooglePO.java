package automatizado.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO{


    @FindBy(name = "q")
    public WebElement inputPesquisa;
    @FindBy(css = ".mgAbYb.OSrXXb.RES9jf.pb3iw")
    public WebElement cssResultado;
    @FindBy(css = ".VwiC3b.yXK7lf.p4wth.r025kc.hJNv6b")
    public WebElement cssResultado2;

/**
 * Contrutor base para a criação da pagina do google.

 * @param driver Driver da pagina do Google.
 */
public GooglePO(WebDriver driver){
    super(driver);

}


/**
 * Metodo que faz a pesquisa no google baseando no texto informado e concluindo com o enter
 * @param texto Texto a ser pesquisado
 */
public void pesquisar(String texto){
    inputPesquisa.sendKeys(texto + Keys.ENTER);
}


/**
 * Metodo que retorna o resultado aproximado da primeira pesquisa
 * @return Retorna o resultado da primeira pesquisa
 */
public String obtertResultadoDaPesquisa(){
    return cssResultado.getText();
}
/**
 * Metodo que retorna o resultado aproximado da segunda pesquisa
 * @return Retorna o resultado da segunda pesquisa
 */
public String obtertResultadoDaPesquisa2(){
    return cssResultado2.getText();
}



}
