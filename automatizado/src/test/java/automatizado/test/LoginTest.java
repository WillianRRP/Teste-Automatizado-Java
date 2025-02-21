package automatizado.test;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import automatizado.Page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    private static LoginPO loginPage;


   
    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);

    }
    @Test
    public void TC001_naoDeveLogarNoSistmaComEmailESenhaVazios(){
        loginPage.executarAcaoDeLogar("", "");

        loginPage.buttonEntrar.click();
       String mensagem = loginPage.obterMensagem();

       assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    
    }
    @Test
    public void TC002_naoDeveLogarNoSistmaComEmailIncorretoESenhaVazia(){
        loginPage.executarAcaoDeLogar("Testezinho", "");

        loginPage.buttonEntrar.click();
       String mensagem = loginPage.obterMensagem();

       assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    
    }


    @Test
    public void TC003_naoDeveLogarNoSistmaComEmailVazioESenhaInvalida(){
        loginPage.executarAcaoDeLogar("", "oiasasdzxsii");
        loginPage.executarAcaoDeLogar("", "oiii");

        loginPage.buttonEntrar.click();
       String mensagem = loginPage.obterMensagem();

       assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    
    }

    @Test
    public void TC004_DeveLogarNoSistma(){
        loginPage.executarAcaoDeLogar("adm@admin.com", "admin@123");

        loginPage.buttonEntrar.click();

       assertEquals(loginPage.obterTitulo(), "Login");

    
    }
}