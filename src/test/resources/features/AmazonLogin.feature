Feature: Amazon Login Feature
  User should be redirected to amazon Home page if credentials of an existing account entered is correct

  Scenario: Customer can Login with valid credentials
    Given Customer is in Amazon Landing page
    And Validate Amazon landing page has been loaded
    Then Hover on AccountsList and click on sign in
    And Validate Amazon Login page has been loaded
    When Customer is in Amazon Login page, enter <email> and <password> for login
      | email | woodcrewteam@gmail.com |
      | password | woodcrewteam321@ |
    Then Validate Amazon home page has been loaded