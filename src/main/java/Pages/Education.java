package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by smeta on 07.05.2016.
 */
public class Education {
    private WebDriver driver;
    private By linkEduction = By.linkText("Обучение");
    private By linkCourse = By.linkText("Курсы");
    private By linkSendRequest = By.linkText("Оставить заявку");
    private By btn = By.className("editbutton");
    private String idMainPage, idPopup;

    private static String baseUrl="http://skillsup.ua/";

    public Education (WebDriver driver){
        this.driver = driver;
        driver.get (baseUrl);
        PageFactory.initElements(driver, this);}
    public void goToPage(String CourseName){
        Actions builder = new Actions(driver);
        builder.moveToElement(  driver.findElement(linkEduction)).perform();
        builder.moveToElement(  driver.findElement(linkCourse)).perform();
        builder.moveToElement(  driver.findElement(By.linkText(CourseName))).click().perform();

        //driver.findElement(linkourteam).click();

    }
    public void ClickButtonSendRequest()
    {
        idMainPage = driver.getWindowHandle();
        driver.findElement(linkSendRequest).click();
        idPopup = driver.getWindowHandle();
        driver.findElement(btn).click();


    }
};

