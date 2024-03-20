Feature: API Testing

  Background:
    Given generate API token



    @token
    Scenario: Generating token

      @API
      Scenario: creating an employee using API
        Given request is prepped to create an employee
        When A post call is made
        Then the status code for creation of employee is 201

