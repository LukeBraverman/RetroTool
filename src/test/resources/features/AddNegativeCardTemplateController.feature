Feature: Add negative Card Template feature

  Scenario: A user is adding a negative card template to the DAO
    Given the user calls the controller with a negative card template
      | headerText | bodyText |
      |   TEST     | NEGATIVE |

    Then the template is added to the DAO layer


  Scenario: A user is adding a negative card template to the DAO
    Given the user calls the controller with a negative card template
      | headerText | bodyText |
      |   TEST     | NEGATIVE |

    Then the template is assigned a negative enum for card type instance variable