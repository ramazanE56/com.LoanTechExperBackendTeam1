
Feature:US_43 As a User (Admin) I want to be able to access the User panel of the selected active user

  Background:You should go to the active user page without any problems.

    * As admin, go to "adminUrl" page
    * Enter a valid "adminUsername" and "passwordAdmin" and press the login button.
    * Click on the manage users
    * Click on the active users

  Scenario: TC_01 The 'Active Users' Link appears under the 'Manage Users' link and must be active.

    * The Active Users Link appears under the Manage Users link and it is verified that it is active.

  Scenario: TC_02 When the 'Active Users' link is clicked,
                  the 'Active Users List' and list titles should be displayed

    * Verify that the Active Users List and list titles can be displayed



    Scenario: TC_03 The 'Details' button should be visible and active. When clicked,
                    it should redirect to the 'User Detail - Username' page.

      * Click on the Details
      * User Detail - Verifies that Username is on the page

    Scenario: TC_04 The Login as User button must be active and viewable.
      * Click on the Details button
      * It must be verified that the Login as User button is active.


    Scenario: TC_05 When the Login as User button is clicked,
                   the User Dashboard should direct you to the User Data page.

      * Click on the Details button
      * Click on Login as button
      * It should be verified that when active as user is clicked, it goes to the User Dashboard User Data page
