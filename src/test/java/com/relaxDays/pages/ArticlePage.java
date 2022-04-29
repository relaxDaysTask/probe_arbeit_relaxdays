package com.relaxDays.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relaxDays.utilities.BrowserUtils;
import com.relaxDays.utilities.Driver;

import java.util.Objects;

public class ArticlePage {

    public ArticlePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='ri ri-right close pointer margin-right-s']")
    private WebElement closeCartButton;

    @FindBy(xpath = "//*[@id=\"product-options-wrapper\"]//span[2]")
    private WebElement articleColor;

    /**
     * adds the given item to the cart
     * @param itemName
     */
    public void addItemToCart (String itemName){
        addToCartButton.click();
        if (!Objects.equals(itemName, "Bierzeltgarnitur klappbar BASTIAN")){
            BrowserUtils.waitForClickability(closeCartButton);
            closeCartButton.click();
        }
    }

    /**
     * returns the color of the item
     * @return
     */
    public String getArticleColor(){
        return articleColor.getText();
    }


}
