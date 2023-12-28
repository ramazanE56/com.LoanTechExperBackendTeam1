Feature: US_17 As a registered user, I would like to have a page to manage my payment transactions.

  Background: Users use these steps to log in to the site.
    * The user enters site with the given "Url"
    * Accept the cookies on page
    * Login with registered user information

     Scenario: TC_01 - TC_02 There should be a "Withdraw" button on the Dashboard page to manage withdrawals.
              WhenN the Withdraw button is clicked, it should redirect to the "Withdraw Money" page.

      * Verify that the withdraw button is visible and active
      * Click the withdraw button
      * Verify the Withdraw Money text is visible on page

     Scenario: TC_02 Method name must be selected from the "Method" dropdown menu.

      * Click the withdraw button
      * Verify that the Method Text is visible on page
      * Verify that the all option is visible

     Scenario: TC_03 A value between 300.00 USD - 8000.00 USD should be entered in the Amount textbox.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Verify that after the amount value limit text will be visible

     Scenario: TC_04 When the Submit button is clicked, the text "Withdraw Via Method 5 Updatedé" should be displayed.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Verify that after the amount value limit text will be visible
       * Click the Submit button on withdraw section
       * Verify that Withdraw Via Method5 Updated section is displayed

     Scenario: TC_05 The Submit button should be clickable and the text "Withdraw request sent successfully" should be displayed.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Click the Submit button on withdraw section
       * Verify that submit button is visible and active
       * Click the Submit button on withdraw method section
       * Verify that Withdraw request sent successfully message is appeared

     Scenario: TC_06 The withdrawal made on the Withdraw History page must be visible in the accordion table.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Click the Submit button on withdraw section
       * Click the Submit button on withdraw method section
       * Verify that Withdraw History page is visible

     Scenario: TC_07 Charge-After Charge-Conversion-Status values should be displayed in a selected withdrawal transaction in the accordion table.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Click the Submit button on withdraw section
       * Click the Submit button on withdraw method section
       * Click the table name on Withdraw History page
       * Verify that the charge-after charge-conversion-status is visible for each transaction

     Scenario: TC_08 When you click on the "Withdraw Money" button on the Withdraw History page, you should go to the "Withdraw Money" page.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Click the Submit button on withdraw section
       * Click the Submit button on withdraw method section
       * Click the Withdraw Money button on withdraw History page
       * Verify that Withdraw Money text is visible

     Scenario: TC_09 When you click on the "Withdraw Log" button on the "Withdraw Money" page, you should go to the Withdraw History page.

       * Click the withdraw button
       * Select the Method5 Updated on Method Dropdown menu
       * Write the 350 USD On Amount textbox,
       * Click the Submit button on withdraw section
       * Click the Submit button on withdraw method section
       * Click the Withdraw Money button on withdraw History page
       * Click the Withdraw Log button on withdraw Money page
       * Verify that Withdraw History text is visible



