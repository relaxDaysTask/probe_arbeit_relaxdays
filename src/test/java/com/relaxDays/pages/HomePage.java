package com.relaxDays.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relaxDays.utilities.BrowserUtils;
import com.relaxDays.utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "btn-cookie-allow")
    private WebElement cookiesAccept;

    @FindBy(id = "search")
    public WebElement inputBox;

    /**
     * accepts the cookies
     */
    public void acceptCookies(){
        BrowserUtils.waitForClickability(cookiesAccept);
        cookiesAccept.click();
    }

    /**
     * searches for the given element by text
     * @param input
     */
    public void writeToInputBox(String input) {
        BrowserUtils.waitFor(2);
        inputBox.clear();
        inputBox.sendKeys(input);
        inputBox.sendKeys(Keys.ENTER);
    }
}
