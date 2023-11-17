Feature: Terminating an employee

  Background:
    Given driver is made and navigates to the url
    And user enters credentials and presses enter
    Then User is naviagted to home page

    @terminate
    Scenario: Search employee by id number
      When user clicks on pim button
      When user accesses the list of employees in the system.
      And select a specified employee from the list.
      And navigate to the employee's job page.
      And select the option to terminate the employment of the specified employee.
      Then specified employee is terminated