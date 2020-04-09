#Author: Siva Prasad
@tag
Feature: Saving Using Spare validations

  @settingGoal
  Scenario: Setting goal
    Given user launches the saving using spare application
    And user navigate to goal setting page
    Then user creates the following goal
      | GoalType        | TargetDate | Amount |
      | Anniversary Gift | 02/25/2020 |   1000 |

  @SavingSpareWithSaving
  Scenario: Payment transaction with Saving Option
    Given user launches the saving using spare application
    And user starts "mobile recharge" transaction
    And user enters transaction details and submits
    And user verifies the saving details when user opts "Yes" to savig Option
    And user confirms the payment details
    Then user verifies the transaction history
    #Then user verifies the saving bucket
    Then saving bucket bucker transaction "should" be updated

  @SavingSpareWithNoToSaving
  Scenario: Payment transaction When user opts No to Saving Option
    Given user launches the saving using spare application
    And user starts "mobile recharge" transaction
    And user enters transaction details and submits
    And user verifies the saving details when user opts "No" to savig Option
    And user confirms the payment details
    Then user verifies the transaction history
    #Then user verifies the saving bucket
    Then saving bucket bucker transaction "should not" be updated

  @ViewGoal
  Scenario: View goals
    Given user launches the saving using spare application
    And user navigate to goal setting page
    And user should be able to view  goals listed

  @verifyNotification
  Scenario: Notification
    Given user launches the saving using spare application
    When Saving bucket reaches one of the goal
    Then user should receive a notification
