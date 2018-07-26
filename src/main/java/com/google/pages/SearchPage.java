package com.google.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SearchPage {

    private static final By INPUT = By.cssSelector("input[id='lst-ib']");

    public SearchPage goToMainPage(){
        open("http://google.com");
        return this;
    }

    public ResultPage search(String query){
        $(INPUT).setValue("selenide").pressEnter();
        return page(ResultPage.class);
    }
    }





