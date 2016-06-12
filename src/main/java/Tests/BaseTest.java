package Tests;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by smeta on 19.04.2016.
 */
public class BaseTest extends TestCase{
    protected static WebDriver driver ;// static надо, чтобы был один инстанс создан, protected- чтобы был доступен только наследуемым классам
   // private String baseUrl="http://skillsup.ua/";


    @Before
    public  void setUp() throws Exception {
        driver = new FirefoxDriver();

        // driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }
}

