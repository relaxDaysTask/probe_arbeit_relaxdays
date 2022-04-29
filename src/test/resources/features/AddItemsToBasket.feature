@wip
Feature: Add Items to Basket

  Scenario: add items to basket
    Given the user is on the homepage
    And accepts the cookies
    And the user searches for "Pavillon 3x3 m mit 2 Seitenteilen"
    When the item "Pavillon 3x3 m mit 2 Seitenteilen" is displayed in search results, the user adds the item to the cart
    And the user searches for "Zeltheringe 20er Set"
    When the item "Zeltheringe 20er Set" is displayed in search results, the user adds the item to the cart
    And the user searches for "Bierzeltgarnitur klappbar BASTIAN"
    When the item "Bierzeltgarnitur klappbar BASTIAN" is displayed in search results, the user adds the item to the cart
    And verifies the color is "Weiß"
    When the user goes to cart
    Then verifies all the items are displayed with the correct total price
      |Bierzeltgarnitur klappbar BASTIAN|
      |Zeltheringe 20er Set |
      |Pavillon 3x3 m mit 2 Seitenteilen|






