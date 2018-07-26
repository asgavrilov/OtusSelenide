package ru.mail;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.mail.pages.MainPage;
import ru.mail.pages.mail.EmailMainPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.mail.pages.MainPage.enterToMainPage;


public class MailRuTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void mailRuLoginTest() {
//as option
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
        open("https://mail.ru");
        $("#mailbox\\:login").setValue("selenide");
        $x("//*[@id='mailbox:password']").setValue("123456!qA");
        $("select.o-control").selectOptionContainingText("bk");
        $(By.cssSelector("#mailbox\\:submit")).click();
        $(By.id("b-letters")).should(visible);
        $$(By.cssSelector("#b-letters .b-datalist__body > div")).shouldHave(size(3));

        $$(By.cssSelector("#b-letters .b-datalist__body > div")).get(0).should(matchesText("Mail.ru"));
    }


    @Test
    public void mailRuPageObjectTest() {

        MainPage mainPage = enterToMainPage();
        mainPage.inputToLogin("selenide@bk.ru");
        mainPage.inputPassword("123456!qA");
        mainPage.clickOnButton();
        EmailMainPage emailMainPage = mainPage.clickOnButton();
        emailMainPage.checkEmailContainerVisibility();

    }

    @Test
    public void prototype() {
        enterToMainPage()
                .inputToLogin("selenide@bk.ru")
                .inputPassword("123456!qA")
                .clickOnButton()
                .checkEmailContainerVisibility();

    }

}
