package com.relaxDays.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relaxDays.utilities.BrowserUtils;
import com.relaxDays.utilities.Driver;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    public CartPage () {
        PageFactory.initElements(Driver.get(),this);
    }

    public double totalExpectedAmount= 0.0;

    @FindBy(xpath = "(//*[@data-gtm-action=\"goto-cart\"])[2]")
    private WebElement gotoCartButton;

    @FindBy(xpath = "//*[@class=\"price-including-tax\"]")
    private List<WebElement> itemPriceList;

    @FindBy(xpath = "//tr[@class=\"grand totals\"]//span")
    private WebElement grandTotal;

    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]//a[@class=\"product-item-link\"]")
    private List<WebElement> itemsInCart;

    /**
     * navigates to the cart page
     */
    public void goToCart(){
        BrowserUtils.waitForClickability(gotoCartButton);
        gotoCartButton.click();
    }

    /**
     * returns the expected total sum of the items in the cart
     * @return
     */
    public double getExpectedTotalAmount(){
        String itemPrice = "";

        for (WebElement elem : itemPriceList) {
            String str = elem.getText();
            String[] str1 = str.split("\\€");

            if (str1[0].contains(",")){
                itemPrice = str1[0].replace(",",".");
            }else {
                itemPrice = str1[0];
            }

            totalExpectedAmount = totalExpectedAmount + Double.parseDouble(itemPrice);
        }
        return totalExpectedAmount;
    }

    /**
     * returns total amount value of the cart
     * @return
     */
    public double getActualTotalAmount(){
        String totalAmount = "";

        BrowserUtils.waitForVisibility(grandTotal,5);

        String str = grandTotal.getText();
        String[] str1 = str.split("\\€");

        if (str1[0].contains(",")){
            totalAmount = str1[0].replace(",",".");
        }else {
            totalAmount = str1[0];
        }

        return Double.parseDouble(totalAmount);
    }

    /**
     * gets the items and returns a list of them all
     * @return
     */

    public List<String> getItemsInCart(){
        List<String> itemNames = new ArrayList<>();

        for (WebElement elem : itemsInCart) {
            String eachItemName = elem.getText();
            itemNames.add(eachItemName);
        }
        return itemNames;
    }
}
