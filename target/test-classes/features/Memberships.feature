Feature: Memberships page functionality
  @US19Nergis
  Scenario:
    #Given user navigates to HRMS web application
    When user enters valid admin username and password
    And user clicks on the login button
    Then user is successfully logged in

    When user clicks on Admin from the Dashboard directory menu
    And user clicks on Qualifications from the Dashboard Admin menu
    And user clicks on Memberships from the dropdown menu
    Then user should be able to verify they are on the "Memberships" List Page
    When user clicks on the add button
    And user enters the membership name "JavaClubGroup89" into the name field
    And user clicks on the save button
    Then user should be able to verify the membership is added successfully
