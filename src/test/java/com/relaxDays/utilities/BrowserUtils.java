package com.relaxDays.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {

    /**
     * waits for the given element to be visible on the page
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * waits for the element to be clickable
     * @param element
     */

    public static void waitForClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Performs a pause
     * @param seconds
     */
    public static void waitFor (int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
