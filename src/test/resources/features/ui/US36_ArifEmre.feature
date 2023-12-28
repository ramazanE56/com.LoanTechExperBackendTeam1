
Feature: US36 : As an administrator, I want to be able to access the Loan Plans page and manage loan plans transactions

  Background:The user uses this step to log in to the site.
    Given Go to "adminUrlOne"

  Scenario: TC01: As an administrator, it is tested that you can access the Loan Plans page, manage loan plan transactions and add a new loan plan.
  * The username box is clicked and the username is entered.
  * The password box is clicked and the password is entered.
  * The Login button is clicked.
  * Loan Plans tab is clicked
  * The current credit plans registered in the system are displayed.
  * Each loan plan, title, interest rate, maturity period, loan limit, etc. displayed with basic information."
  * Click on the Add New button.
  * The Plan Name box is filled in.
  * The Title box is filled.
  * The Minimum Amount box is filled.
  * The Maximum Amount box is filled.
  * Category standard loan is selected.
  * The Per Installment box is populated.
  * The Installment Interval box is populated.
  * The Total Installments box is populated.
  * The Application Fixed Charge box is filled.
  * The Application Percent Charge box is filled in.
  * Non Featured is selected.
  * Instruction box is filled
  * The Charge Will Apply If Delay box is filled in
  * Fixed Charge box is filled
  * Percent Charge box is filled
  * wait2
  * Submit button is clicked
  * It is confirmed that the new plan has been added.
  * The page is closed.



  Scenario: TC02: As a manager, existing credit information can be updated and the accuracy of the added or updated information is tested.
  * The username box is clicked and the username is entered.
  * The password box is clicked and the password is entered.
  * The Login button is clicked.
  * Loan Plans tab is clicked
  * The current page is brought down and scrolled to the right.
  * Edit option is clicked
  * The Plan Name box is filled in.
  * The Minimum Amount box is filled.
  * The Maximum Amount box is filled.
  * The Installment Interval box is populated.
  * The accuracy of the added or updated information is tested.
  * The page is closed.



  Scenario: TC03: Available credit plan from the system test removed is done.
    * The username box is clicked and the username is entered.
    * The password box is clicked and the password is entered.
    * The Login button is clicked.
    * Loan Plans tab is clicked
    * The current page is brought down and scrolled to the right.
    * Disable option is clicked.
    * Yes option is clicked.
    * It is verified that the existing credit plan has been removed from the system.
    * The page is closed.


  Scenario: TC04: When an error occurs in the system, a clear error message must be displayed to the user.
  In case of incorrect entries (negative interest rate, invalid maturity period, etc.), the user should be informed with appropriate error messages.
    * The username box is clicked and the username is entered.
    * The password box is clicked and the password is entered.
    * The Login button is clicked.
    * Loan Plans tab is clicked
    * searchloanplans click
    * Edit option is clicked
    * The Min Amount two box is filled.
    * The Max Amount two box is filled.
    * Instructiontwo box is filled
    * wait2
    * Submit button is clicked
    * In an unexpected situation, an error message is sent.
    * The page is closed.