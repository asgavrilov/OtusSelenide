package com.google.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ResultPage {

    public ResultPage pageIsLoaded(){
        $("div[id='res']").should(Condition.visible);
        return this;
    }

    public ResultPage numberOfResults(int number){
        $$x("//div[@class='g']").shouldHaveSize(number);
        return this;
    }

    public ResultPage firstStringContains(String query){
        $$x("//div[@class='g']").get(0).should(Condition.matchesText(query));
        return this;
    }
}
