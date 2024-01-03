Feature: User is able to login

  @test @regression @smoke
  Scenario: User logs in as Admin
    Given driver is made and navigates to the url
    And user enters credentials and presses enter
    Then User is naviagted to home page
    Then user must read excelfile

    @google
    Scenario: user is able to login into application

      @invalid @regression @smoke
      Scenario: Invalid login
        Given user is nagivated to the application
        When user enters invalid credentials
        And clicks the save button
        Then the user receives expected message

        @invalids
        Scenario Outline: Invalid login with multiple data sets
          Given user is nagivated to the application
          When user enters "<username>" and "<password>"
          And clicks the save button
          Then the user receives expected message
          Examples:
            |  username|password|
          |lu       |wavy  |
          |money    |man   |
          |big      |Stepper|

