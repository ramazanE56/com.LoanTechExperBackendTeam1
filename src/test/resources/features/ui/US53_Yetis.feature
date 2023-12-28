
Feature: US_53 As an administrator, I want to have a Successfully Deposit page so that
               I can view the deposit transactions that have been successfully completed.

  Background: You can reach the successful deposit page by following the steps below.
    *  As admin, go to "adminUrl" page
    *  Enter a valid "adminUsername" and "passwordAdmin" and press the login button.
    *  Click on the deposits
    *  Click  on the Successful Deposits


  Scenario: TC_01 When the Successful Deposits page link is clicked,
                 the admin/deposit/successful" page should be accessed.


    *  verifies that you are on the page where the deposit was successful

    Scenario: TC_02 The Successful Deposits list should be displayed on the page,
                    and the titles should be visible in the list.

          * Verifies that lists and titles are visible

    Scenario: TC_03 The Details button should be visible and active.

      * Verify that the Details button is visible and active

    Scenario: TC_04 Information should be displayed on the detail page of
                    the withdrawal transaction selected from the list

      * Click on the succesfulldetails
      * Information should be displayed on the detail page of the withdrawal transaction selected from the list.




