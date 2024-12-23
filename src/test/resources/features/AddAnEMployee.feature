Feature: Adding an employee

  Background:
    * driver is made and navigates to the url
    * user enters credentials and presses enter
    * User is naviagted to home page
    * user clicks on pim button
    * user clicks on add an employee button

    @new
    Scenario: Adding an new employee
      When user clicks on add an employee button
      And user enters employees information and clicks save button
      Then new user will be created

      @outline
      Scenario Outline: When user enter multiple data in scenario outline
        When user clicks on add an employee button
        When user enters "<firstname>" and "<middlename>" and "<lastname>" in the data driven format
        And user clicks on save button
        Then user is saved successfully
        Examples:
          | firstname |middlename|lastname|
          |luis       |money     |man     |
          |gangbanger |drugdealer|enforcer |
          |king       |coder     |java     |

        @datatable
        Scenario: When user enters multiple data using data table
          When user enters firstname and middlename and lastname and verify employee has been added
          |firstname|middlename|lastname|
          |luis     |money     |man    |
          |tmoney   |king      |trapper|
          |apple    |money     |peach  |


          @excel
          Scenario: Adding employee using excel file
            When user adds employee using excel "EmployeeDataBatch16" and verify it


            @db
            Scenario: adding a user on ui then checking in database
              When use adds "Lu" and "wavy" and "king"
              And user clicks on save button
              And employee is added successfully
              Then user verfy in the database

              @dependants
              Scenario: admin adding dependants to employee profile
                When use adds "Lu" and "wavy" and "king"
                And user clicks on save button
                And user clicks dependants tab
                And user presses add button and provides the enters the information needed and clicks save
                Then employees dependants are save successfully

                @experience
                Scenario Outline: Adding work experience as an employee
                  When user adds "<firstname>" and "<middlename>" and "<lastname>"
                  And user clicks on save button
                  And user clicks on qualifications tab
                  And user clicks the add button and provides the "<company>" and "<jobTitle>" needed and clicks save button
                  Then users work experience is successfully added

                  Examples:
                  |firstname|middlename|lastname|company|jobTitle|
                  |big      |stepper   |king    |Verizon|p3       |
                  |the      |best      |to do it|adidas |CEO      |
                  |man      |in        |charge  |traphouse|trapper|











