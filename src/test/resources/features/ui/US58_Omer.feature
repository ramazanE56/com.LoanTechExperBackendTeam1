Feature: US_58 As an administrator (admin), I want to have a Withdrawals menu in the admin panel in order to manage user Withdrawals transactions.

  Background: You can go to the admin homepage by following these steps.
    *  As admin, go to "adminUrl" page
    *  Enter a valid "adminUsernameO" and "password" and press the login button on page

    Scenario: TC_01 The Withdrawal Methods page should be accessible under the Withdrawals menu on the side bar in the admin panel.

      * Verify that the Withdrawals menu is accessible under the admin panel

    Scenario: TC_02 Payment methods (with Method, Currency, Charge, Withdrawal Limit, Status information) should be displayed in the Withdrawal Methods Table on the page.

      * Click the Withdrawals menu
      * Verify that the Withdrawal Methods menu is visible and active
      * Verify that the method-currency-charge-withdrawlimit-status-action information is visible

    Scenario: TC_03 In order to edit the method selected in the Withdrawal Methods Table, the edit page must be accessed under the Action heading.

      * Click the Withdrawals menu
      * Verify that the edit page is accessed under the Action heading.
      * Verify that edit the method selected in the Withdrawal Methods Table

    Scenario: TC_04 The Withdraw method must be updated by entering valid information on the Edit page.

      * Click the Withdrawals menu
      * Take the information in first raw on page
      * Click the edit button on withdrawal method section
      * Change the all information on edit page
      * Click the submit button on withdrawal methods menu
      * Verify that all information is change with updated data

    Scenario: TC_05 The visibility of the selected method should be controlled under the action heading in the Withdrawal Methods Table.

      * Click the Withdrawals menu
      * Click the enable-disable button on first raw
      * Click the confirmation alert on page
      * Verify that status is changed

    Scenario: TC_06 A new method should be created on the Withdrawal Methods page.

      * Click the Withdrawals menu
      * Verify that add new button is visible and accessible
      * Click on the Add New button
      * Fill the all information on page
      * Click the submit button on new page
      * Verify that new user is added in table
