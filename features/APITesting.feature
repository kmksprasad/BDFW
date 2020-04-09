#Author: Siva Prasad
@tag
Feature: API validation testing

  @APISetGoal
  Scenario: API testing the Setting goal
    Given user connects to the "createGoal" API
    Then the server should handle it and return a success status

  @APITransactionHistory
  Scenario: API testing the Transaction history
    Given user connects to the "getTransactionHistory" API
    Then response should contain all the following values
      | Key               | Value      |
      | Date              | 01/01/1990 |
      | TransactionAmount |      10000 |
      | Saving Amount     |       1233 |

  @APIGetpaymentCategories
  Scenario: API testing the payment categories
    Given user connects to the "getPaymentcategories" API
    Then response "getpaymentcategories" should contain all the following values
      | Key          | Value           |
      | categoryType | Mobile Recharge |

  @APIGetGoals
  Scenario: API testing the get Goals
    Given user connects to the "getGoals" API
    Then response getGoals should contain all the following values
      | Key      | Value      |
      | Name     | Random     |
      | Date     | 01/03/2019 |
      | Priority | Low        |
      | Amount   |     1223.0 |

  @APIPostGoals
  Scenario: API testing to Post Goals
    Given user post data to "postGoals" api
