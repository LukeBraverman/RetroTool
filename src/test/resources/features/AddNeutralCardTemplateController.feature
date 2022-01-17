Feature: Add neutral Card Template feature

  Scenario: A user is adding a neutral card template to the DAO
    Given the user calls the controller with a neutral card template
      | headerText | bodyText |
      |   TEST     | NEUTRAL  |

    Then the template is added to the DAO layer


  Scenario: A user is adding a neutral card template to the DAO
    Given the user calls the controller with a neutral card template
      | headerText | bodyText |
      |   TEST     | NEUTRAL  |

    Then the template is assigned a neutral enum for card type instance variable