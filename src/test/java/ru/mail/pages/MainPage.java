package ru.mail.pages;

import org.openqa.selenium.By;
import ru.mail.pages.components.LoginBlock;
import ru.mail.pages.mail.EmailMainPage;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage<MainPage> {

    private LoginBlock loginBlock;

    private static final By MAILBOX_LOGIN = By.cssSelector("#mailbox\\:login");

    public static MainPage enterToMainPage() {
        open("http://mail.ru");
        //return open("http://mail.ru",MainPage.class);

        return page(MainPage.class);
        //return this; as option
    }


    public MainPage inputToLogin(String login) {
        //  loginBlock.inputToLogin(login);
        $(MAILBOX_LOGIN).setValue(login);
        return this;

    }

    public MainPage inputPassword(String password) {
        // loginBlock.inputToPassword(password);
        $x("//*[@id='mailbox:password']").setValue(password);
        return this;
    }


    public EmailMainPage clickOnButton() {
        $(By.cssSelector("#mailbox\\:submit")).click();
        return page(EmailMainPage.class);
    }

}
