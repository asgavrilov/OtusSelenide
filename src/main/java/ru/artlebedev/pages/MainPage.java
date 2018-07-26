package ru.artlebedev.pages;

import ru.artlebedev.pages.menu.MenuBlock;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage> {

    private MenuBlock menuBlock;

    public static MainPage enterToMainPage() {
        open("https://artlebedev.ru/");
        return page(MainPage.class);
    }

    public ToolsPage chooseToolFromMenu() {
        menuBlock.clickOnToolsBtn();
        return page(ToolsPage.class);
    }

}
