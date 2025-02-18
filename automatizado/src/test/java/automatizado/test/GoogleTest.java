package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class GoogleTest {
    private WebDriver driver;
    private final String URL_BASE = "https://www.google.com/"; 
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    ChromeOptions options = new ChromeOptions();

    // Versão utilizada do chromedriver 132.0.6834.197
    private final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe"; 

    private void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);

        //tive que colocar essas opções pois meu chromedriver estava pedindo para eu verificar se eu não sou robô
        options.addArguments("user-agent=" + userAgent);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--profile-directory=Default");
        options.addArguments("--incognito");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @Test
    public void deve_PesquisarNoGoogle() throws InterruptedException {
        iniciar();
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Capivara" + Keys.ENTER);
        Thread.sleep(5000);
        WebElement resultado = driver.findElement(By.cssSelector(".VwiC3b.yXK7lf.p4wth.r025kc.hJNv6b"));
        String resultadoTexto = resultado.getText();
        assertTrue(resultadoTexto, resultadoTexto.contains("É o maior roedor do mundo, pesando até 91 kg e medindo até 1,2 m de comprimento e 60 cm de altura. A pelagem é densa, de cor avermelhada a marrom escuro."));
     driver.quit();
    
    }
}