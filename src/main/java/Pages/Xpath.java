package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by smeta on 15.05.2016.
 */
public class Xpath {


        private WebDriver driver;
        private By linkEduction = By.linkText("Обучение");
        private By linkCourse = By.linkText("Курсы");
        private By linkSendRequest = By.linkText("Оставить заявку");
        private By btn = By.className("editbutton");
    private By xpathRow= By.xpath(".//*[@id='main']/table[@class=\"w3-table-all\" ]/tbody/tr[last()]");
    private By xpathTable = By.xpath(".//*[@id='main']/table[@class=\"w3-table-all\" ]/tbody//tr");
    private By columnName= By.xpath("td[2]");

        private String idMainPage, idPopup;

        private  String baseUrl="http://www.w3schools.com/html/html_tables.asp";

        public Xpath(WebDriver driver){
            this.driver = driver;
            driver.get (baseUrl);
            PageFactory.initElements(driver, this);}

        public void findRow()throws Exception{
        WebElement rowValue;
        rowValue= driver.findElement(xpathRow);
        System.out.println(rowValue.getText());
        System.out.println(rowValue.findElement(columnName).getText());

    }

  /*   public void findTable()throws Exception{
        WebElement table;
        table= driver.findElements(xpathTable);
        System.out.println(rowValue.getText());
        System.out.println(rowValue.findElement(columnName).getText());

    }

   public void getRowByPersonName()throws Exception{
        int size = driver. findElements(xpathTable).size();
        for (int i=0; i<size; i++) {

        }
      */

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
    }
       /* public void ClickButtonSendRequest()
        {
            idMainPage = driver.getWindowHandle();
            driver.findElement(linkSendRequest).click();
            idPopup = driver.getWindowHandle();
            driver.findElement(btn).click();
Su

        }*/
    }



