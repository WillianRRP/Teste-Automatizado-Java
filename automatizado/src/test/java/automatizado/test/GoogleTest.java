package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleTest extends BaseTest{

    @Test
    public void deve_PesquisarNoGoogle() throws InterruptedException {
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Capivara" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement resultado = driver.findElement(By.cssSelector(".VwiC3b.yXK7lf.p4wth.r025kc.hJNv6b"));
        String resultadoTexto = resultado.getText();
        assertTrue(resultadoTexto, resultadoTexto.contains("É o maior roedor do mundo"));
    
    }
}