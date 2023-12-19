Feature: User is able to login

  @test
  Scenario: User logs in as Admin
    Given driver is made and navigates to the url
    And user enters credentials and presses enter
    Then User is naviagted to home page
    Then user must read excelfile

    @google
    Scenario: user is able to login into application
      When