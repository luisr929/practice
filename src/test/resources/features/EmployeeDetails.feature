Feature: Employee can change customize their profile on their own

  @contactDetails
  Scenario: As an employee i can change the contact info
    Given User navigates to the login page
    When user enters valid credentials pressed login button then is navigated to homepage
    And user clicks MY INFO tab and clicks on Contact Details
    And user pressed the Edit button and adds contact details
    And hits the save button
    Then users contacts details have been saved

