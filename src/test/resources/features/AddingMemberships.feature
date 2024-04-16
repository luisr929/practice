Feature: Adding Memeberships as Admin
  Background:
    * driver is made and navigates to the url
    * user enters credentials and presses enter

  @member
  Scenario: As Admin user should be able to add new memberships under qualifications
    When Admin navigares to qualifications
    And selects membership
    Then Admin should be able to add memnerships