Feature: Add positive Card Template feature

  Scenario: A user is adding a positive card template to the DAO
    Given the user calls the controller with a positive card template to add
    | headerText | bodyText |
    |   TEST     | POSITIVE |

    Then the template is added to the DAO layer


  Scenario: A user is adding a positive card template to the DAO
    Given the user calls the controller with a positive card template to add
      | headerText | bodyText |
      |   TEST     | POSITIVE |

    Then the template is assigned a positive enum for card type instance variable