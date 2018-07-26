package com.google.test;

import com.google.pages.SearchPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.google.pages.ResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class googlePageTest {
    @Test
    public void googleTest () {
        WebDriverManager.chromedriver().setup(); //todo
        Configuration.browser = "chrome";
       // Configuration.baseUrl = "https://www.google.ru";
        open("https://www.google.ru");
        $x("//*[@name='q']").setValue("idea").pressEnter();
        $(By.xpath("//*[@id='resultStats']")).should(Condition.visible);
        $$x("//div[@class='g']").shouldHave(size(9));

    }

@Test
    public void googlePageObjectTest(){
    SearchPage searchPage = new SearchPage();
    searchPage.goToMainPage();
    ResultPage resultPage = searchPage.search("selenide");
    resultPage.pageIsLoaded();
    resultPage.numberOfResults(10);
    resultPage.firstStringContains("selenide");
}

}

