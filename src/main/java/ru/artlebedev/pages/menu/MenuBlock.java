package ru.artlebedev.pages.menu;

import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import ru.artlebedev.pages.ToolsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MenuBlock extends ElementsContainer {

    private static final By INVENTORY_BUTTON = By.xpath("//a[@href='/tools/']");

    public ToolsPage clickOnToolsBtn(){
        $(INVENTORY_BUTTON).click();
        return page(ToolsPage.class);
    }

}
