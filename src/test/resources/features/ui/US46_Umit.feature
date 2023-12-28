Feature: US24: As an administrator, I should be able to manage the withdrawal methods available to users

 Background:Admin use these steps to log in to the site and Admindashboard.
    *  As admin, go to "adminUrl" Adminpage
    *  Enter "adminNameUmit" and "passwordAdmin" and press the login button.


  Scenario: TC_01:The Withdrawal Methods link should be visible and
                  accessible and the titles should be displayed in the list
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Close the page

  Scenario: TC_02:To add a new withdrawal method, the 'Add New' button should be visible and active.
                  The information of the withdrawal method to be added should be entered
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Click on the Add New button on the page that opens
    * Click submit button after information entry
    * Close the page

  Scenario: TC_03:The added capture method should be viewable in the List.
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Type the method name added in the search box
    * Verify that the new method added on the opened page is displayed in the list
    * Close the page

  Scenario: TC_04:The administrator should be able to update the information of available
                  withdrawal methods and check the validity of the updated information

    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Admin click the edit button to update the new method added
    * Admin enters the value for the update and clicks submit
    * Verifies that the Withdraw method uptaded succesfully warning text is displayed
    * Close the page

  Scenario: TC_05:The administrator confirms a withdrawal method with the Disable operation confirmation screen
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Admin clicks the disable button to disable the new added method
    * Admin confirms method disable
    * Admin method verifies that it is disabled
    * Close the page

  Scenario: TC_06:Admin Checks the validity of added or updated withdrawal methods
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Click on the Add New button on the page that opens
    * Admin After entering the information except the method name, clicks the submit button
    * Confirms that it is still on the New Withdrawal Method page due to missing information
    * Close the page

  Scenario: TC_07:Added, updated, or disabled capture methods should be recorded in the system log.
    * Click on the Withdrawals link
    * Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page
    * Type the method name added in the search box
    * Admin confirms that the added, edited, disabled method is displayed
    * Close the page

