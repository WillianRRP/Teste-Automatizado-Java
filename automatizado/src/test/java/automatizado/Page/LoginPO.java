package automatizado.Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{


    @FindBy(id = "email")
    public WebElement inputEmail;


    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    /**
     * Contrutor padrão para a criação de uma nova instancia de pagina de login.
     * @param driver Driver da pagina de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
    public String obterTitulo(){
        return driver.getTitle();
    }

    public void escrever(WebElement input, String texto){
        input.sendKeys(texto + Keys.TAB);
        input.clear();
    }

    /**
     * Metodo que tenta executar a ação de logar no sistema
     * @param email E-mail para a tentativa de login
     * @param senha Senha para a tentativa de login
     */
    public  void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }
    
    
}
