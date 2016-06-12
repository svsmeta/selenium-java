package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by smeta on 24.04.2016.
 */
public class MemberPage {
    private By greenHeader= By.className("greenHeader");
    private WebDriver driver;
    public MemberPage(WebDriver driver){
        this.driver = driver;
         PageFactory.initElements(driver, this);
    }
    public boolean isPageOfMember (String memberName){
    return driver.findElement(greenHeader).getText().contains(memberName);
    }
}
