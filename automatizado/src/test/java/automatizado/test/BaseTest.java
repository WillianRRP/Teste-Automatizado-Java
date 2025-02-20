package automatizado.test;

import java.util.Collections;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String URL_BASE = "https://www.google.com/"; 
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe"; 

    @BeforeClass
    public static void iniciar(){

        
/*
* Versão utilizada do chromedriver 132.0.6834.197
*/ 
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);

/*
*  tive que colocar essas opções pois meu chromedriver estava pedindo para eu verificar se eu não sou robô
*/ 
       
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
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


    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
