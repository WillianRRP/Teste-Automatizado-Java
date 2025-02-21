package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.Page.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest extends BaseTest{


    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);

    }
    @Test
    public void TC001_deveSerPesquisarNoGoogleOTextoCapivara(){
        googlePage.pesquisar("Capivara");
        //WebElement inputPesquisa = driver.findElement(By.name("q"));

        String resultado = googlePage.obtertResultadoDaPesquisa();
        assertTrue(resultado, resultado.contains("Sobre"));
    
    }
    /**
     * Este teste é semelhante ao primeiro teste (TC001), mas com uma verificação adicional.
     * O objetivo é garantir que, ao pesquisar por "Capivara", o resultado da pesquisa contenha
     * a frase específica "É o maior roedor do mundo".
     */
    @Test
    public void TC002_deveRetornarResultadoComFraseEspecificaAoPesquisarPorCapivara(){

        googlePage.pesquisar("Capivara");
        //WebElement inputPesquisa = driver.findElement(By.name("q"));

        String resultado = googlePage.obtertResultadoDaPesquisa2();
        assertTrue(resultado, resultado.contains("É o maior roedor do mundo"));
    
    }
}