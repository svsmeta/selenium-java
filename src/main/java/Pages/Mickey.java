package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by smeta on 07.06.2016.
 */
public class Mickey {
    private WebDriver driver;

    private By containerBy = By.className("ui left action input");
    private By selectorInput =By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[22]/div/input");
    private By selectorDropdown = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[1]/div[4]/div/select");



    private String idMainPage, idPopup;

    private  String baseUrl="http://semantic-ui.com/elements/input.html";

    public Mickey (WebDriver driver){
        this.driver = driver;
        driver.get (baseUrl);
        PageFactory.initElements(driver, this);
        Actions reloadPage = new Actions(driver);
        reloadPage.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorInput));}

   // //public getInputText( By selector){
      //  return findElement (selector);
//    }

   public void findElement() throws Exception{
        WebElement container ;
        container= driver.findElement(selectorInput);
       System.out.println(container.getAttribute("value"));
      //  System.out.println(rowValue.findElement(columnName).getText());

    }

    public void findDropDown (){
        WebElement element ;
        element= driver.findElement(selectorDropdown);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(1);

        element.findElement(By.tagName("select") );
        //System.out.println(container.getAttribute("value"));
    }
/*

    public WebElement getRowByPersonName(String name)throws Exception {
        WebElement r = null;

        List<WebElement> rows = driver.findElements(xpathTable);
        System.out.println(rows.get(3).findElement(columnName).getText());
        System.out.println(rows.get(3).findElement(columnName).getText().equals(name));
        int size = rows.size();
        for (WebElement elem : rows) {
            if (elem.findElement(columnName).getText().equals(name)) {
                r = elem;
            }
            ;

        };
        return r;
    }*/
}
