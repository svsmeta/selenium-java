package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smeta on 19.04.2016.
 */
public class MemberListPage {
    private WebDriver driver;
    private By linkourteam = By.linkText("Наша команда");
    private By ourteam =By.className("name");

    private static String baseUrl="http://skillsup.ua/";

    public MemberListPage(WebDriver driver){
        this.driver = driver;
        driver.get (baseUrl);
        PageFactory.initElements(driver, this);
    }
    public List<String> lookingPersonByNameList() {
        List <String> coachList = new ArrayList();
        List<WebElement> element = driver.findElements(ourteam);
        for (WebElement i : element) {
            coachList.add(i.getText());
        }

        return coachList;
    }
    public void goToPage(){
        driver.findElement(linkourteam).click();

    }

    public  Boolean checkThatPersonIsPresented (String PersonName)
    {
        return lookingPersonByNameList().contains(PersonName);
    }

    public void goToMemberPage (String PersonName)
    {

        List<WebElement> element = driver.findElements(ourteam);

        for (WebElement i : element) {
            if (i.getText().contains(PersonName)){
                i.click();
                break;
            };
        }
    }

    public void waitToCOntextIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBe(ourteam, "lol"));
    }

    public void waitToAlertIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.alertIsPresent());

    }

    public void callJavaScript (){
        ((JavascriptExecutor)driver).executeScript("alert('hello, world');");
    }

    public String callJavaScriptAgain (){
        WebElement w= (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return document.getElementsByClassName(\"name\")[0];");
        return w.getText();
    }

    public void pressOkButtonOnAlert (){
       // Actions action = new Actions(driver);
        driver.switchTo().alert().accept();

       // ((JavascriptExecutor)driver).executeScript("alert('hello, world');");
    }

    public String getTextFromAlert (){
        // Actions action = new Actions(driver);
      return  driver.switchTo().alert().getText();

        // ((JavascriptExecutor)driver).executeScript("alert('hello, world');");
    }

}
