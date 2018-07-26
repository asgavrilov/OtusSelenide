package ru.artlebedev.test;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static ru.artlebedev.pages.MainPage.enterToMainPage;


public class ArtLebedevTest {
public static final String KEY_WORD = "пряники";
    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
    }


    @Test
    public void SearchCrazyIdeasTest() {
        enterToMainPage()
                .chooseToolFromMenu()
                .toolPageHeaderIsCorrect()
                .goToMatrixPage()
                .ideaMatrixPageHeaderIsCorrect()
                .search(KEY_WORD)
                .checkQueryResults(KEY_WORD, 2);
    }
}
