package com.relaxDays.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.relaxDays.pages.*;
import com.relaxDays.utilities.ConfigurationReader;
import com.relaxDays.utilities.Driver;
import java.util.*;

public class AddItemsStepDef {

    protected final static Logger LOG = LoggerFactory.getLogger(AddItemsStepDef.class);

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ArticlePage articlePage = new ArticlePage();
    CartPage cartPage = new CartPage();


    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @And("accepts the cookies")
    public void accepts_the_cookies() {
        homePage.acceptCookies();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String itemName)  {
        homePage.writeToInputBox(itemName);
    }

    @When("the item {string} is displayed in search results, the user adds the item to the cart")
    public void the_item_is_displayed_in_search_results_the_user_adds_the_item_to_the_cart(String article) {
        searchResultsPage.goToArticlePage(article);
        articlePage.addItemToCart(article);
    }

    @When("verifies the color is {string}")
    public void verifies_the_color_is_white(String color) {
        Assert.assertEquals(color,articlePage.getArticleColor());
    }

    @When("the user goes to cart")
    public void the_user_goes_to_cart() {
        cartPage.goToCart();
    }

    @Then("verifies all the items are displayed with the correct total price")
    public void verifies_all_the_items_are_displayed_with_the_correct_total_price(List<String> expectedItemNames) {
        List<String> actualItemNames = cartPage.getItemsInCart();
        Assert.assertEquals(expectedItemNames,actualItemNames);

        LOG.info("\nExpected Items : {} \nActual Items : {}",expectedItemNames,actualItemNames);

        Assertions.assertThat(cartPage.getExpectedTotalAmount()).isCloseTo(cartPage.getActualTotalAmount(), Offset.offset(0.0001D));
        LOG.info("\nActual Total Amount : {} \nExpected Total Amount : {}",cartPage.getActualTotalAmount(),cartPage.totalExpectedAmount);

    }

}
