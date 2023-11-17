Feature: Adding an employee

  Background:
    * driver is made and navigates to the url
    * user enters credentials and presses enter
    * User is naviagted to home page
    * user clicks on pim button

    @new
    Scenario: Adding an new employee
      When user clicks on add an employee button
      And user enters employees information and clicks save button
      Then new user will be created
