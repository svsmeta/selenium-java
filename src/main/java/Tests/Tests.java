package Tests;

import Pages.*;
import org.junit.Test;


/**
 * Created by smeta on 19.04.2016.
 */
public class Tests extends BaseTest{
    private MemberListPage memberListPage;
    private MemberPage memberPage;
    private Education education;
    private Xpath xpath;
    private Mickey mickey;
    String member1 = "Михаил Чокан";
    String member2 = "Артем Карпов";
    String member3 = "Александр Галковский";


    @Test
    public void testFoundMember1() throws Exception {

        memberListPage = new MemberListPage(driver);
        memberListPage.goToPage();

        assertTrue("Member " + member1 + "was not found", memberListPage.checkThatPersonIsPresented(member1));
        memberListPage.goToMemberPage(member1);
        memberPage= new MemberPage(driver) ;
        assertTrue("Wrong page is opened", memberPage.isPageOfMember(member1));

      //  assertEquals();

    }
  @Test
    public void testNotFoundMember() throws Exception{
        memberListPage = new MemberListPage(driver);
    memberListPage.goToPage();
    assertFalse(memberListPage.checkThatPersonIsPresented(member2));
    }
    @Test
    public void testFoundMember3() throws Exception{
        memberListPage = new MemberListPage(driver);
        memberListPage.goToPage();
        assertTrue("Member " + member1 + "was not found", memberListPage.checkThatPersonIsPresented(member3));
        memberListPage.goToMemberPage(member3);
        memberPage= new MemberPage(driver) ;
        assertTrue("Wrong page is opened",memberPage.isPageOfMember(member3));

    }

    @Test
    public void testAwait () throws Exception{

            memberListPage = new MemberListPage(driver);
            memberListPage.goToPage();
            memberListPage.waitToCOntextIsLoaded();
    }

    @Test
    public void testAlert () throws Exception{

        memberListPage = new MemberListPage(driver);
        memberListPage.goToPage();
        memberListPage.callJavaScript();
        assertEquals("hello, world", memberListPage.getTextFromAlert());
        memberListPage.pressOkButtonOnAlert();
        memberListPage.waitToAlertIsPresent();
    }

    @Test
    public void testJavaScript() throws Exception{

        memberListPage = new MemberListPage(driver);
        memberListPage.goToPage();

        assertEquals("Ольга Симчак", memberListPage.callJavaScriptAgain());

    }

    @Test
    public void testEducation() throws Exception{

        education = new Education (driver);
        education.goToPage("Курс по подготовке к сертификации ISTQB Foundation Level");
        education.ClickButtonSendRequest();

       // assertEquals("Ольга Симчак", memberListPage.callJavaScriptAgain());

    }

    @Test
    public void testXpath() throws Exception {

        xpath = new Xpath(driver);
        xpath.findRow();
        //xpath.findTable();
        xpath.getRowByPersonName("Adam");
    }

        @Test
        public void testMickey() throws Exception {

            mickey = new Mickey(driver);
            mickey.findElement();
            mickey.findDropDown();


            // assertEquals("Ольга Симчак", memberListPage.callJavaScriptAgain());


    }
}
       // WebElement webElement = driver.findElement(linkourteam);
       // webElement.click();
        //System.out.println("Start looking for " + PersonName);
        //  lookingPersonByName (PersonName);
        //lookingPersonByNameList();
      //  assertTrue("Where is Misha??", lookingPersonByNameList().contains(PersonName));


 //   @Test
  /*  public void testNotFoundKarpov() throws Exception{
        String PersonName = "Артем Карпов";
        WebElement webElement = driver.findElement(linkourteam);
        webElement.click();
        System.out.println("Start looking for " + PersonName);
        //  lookingPersonByName (PersonName);

        assertFalse("Why is Karpov here??", lookingPersonByNameList().contains(PersonName));
    }*/

