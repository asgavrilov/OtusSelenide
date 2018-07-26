package ru.mail.pages.mail;

import org.openqa.selenium.By;
import ru.mail.pages.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EmailMainPage {

    public EmailMainPage checkEmailContainerVisibility() {
        $(By.id("b-letters")).should(visible);
        return this;
    }
}
