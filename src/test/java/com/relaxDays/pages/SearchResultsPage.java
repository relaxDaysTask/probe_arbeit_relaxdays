package com.relaxDays.pages;

import org.openqa.selenium.By;
import com.relaxDays.utilities.Driver;

public class SearchResultsPage {

    public void goToArticlePage (String article){
        Driver.get().findElement(By.xpath("//strong/a[contains(text(),'"+ article +"')]")).click();
    }

}
