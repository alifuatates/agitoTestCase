Feature: Product search and product add basket on hepsiburada.com

  Background:
    Given I navigate to hepsiburada.com homepage

  @done
  Scenario: Adding products to the basket by entering the user
    When user login system
    Then the page must have "Hesabım" content
    And user select "Elektronik" category
    And user select "Bilgisayar/Tablet" subcategory
    And user select "Dizüstü Bilgisayar" product on subcategory
    And user 4. product add to basket & validate the added product in the basket
    And user click basket and go to basket page
    And delete all items in the basket
    Then Confirm "Sepetin şu an boş" content on user basket page


  @done
    Scenario: Adding products to the basket without user login
      And user select "Elektronik" category
      And user select "Bilgisayar/Tablet" subcategory
      And user select "Dizüstü Bilgisayar" product on subcategory
      And user 4. product add to basket & validate the added product in the basket