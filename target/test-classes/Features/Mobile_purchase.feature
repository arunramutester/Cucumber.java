#Author: arunramu092@your.domain.com
Feature: Mobile Purchase in amazon

  Scenario: Buy Mobile
    Given user launches the amazon application
    When user search and choose mobiles
    And user clicked on buy now button and entired payment details
    Then user should be displayed " your order should bre conformed " message

  Scenario: Buy Mobile with one dim list
    Given user launches the amazon application
    When user search and choose mobiles by using 1 dim list
      | samsung |  | iphone 13 |  | realme |
    And user clicked on buy now button and entired payment details
    Then user should be displayed " your order should bre conformed " message

  Scenario: Buy Mobile with one dim Map
    Given user launches the amazon application
    When user search and choose mobiles by using one dim Map
      | sam  |  | samsung |
      | i    |  | iphone  |
      | real |  | realme  |
    And user clicked on buy now button and entired payment details
    Then user should be displayed " your order should bre conformed " message
