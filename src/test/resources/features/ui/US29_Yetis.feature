

Feature:US_29 As an administrator, I want to have a Rejected Loans page in the panel to view rejected loans.

  Background: You can go to the admin homepage by following these steps.
    *  As admin, go to "adminUrl" page
    *  Enter a valid "adminUsername" and "passwordAdmin" and press the login button.

  Scenario: TC_01 User must be able to access the Rejected Loans page

    *  Click on reject loans under the loans heading.
    *  Verify that the admin is on the adminhomepage
    *  Close the page

  Scenario: TC_O2 Page titles on the Rejected loans page should be displayed

    * Click on reject loans under the loans heading.
    * Page titles on the Rejected loans page should be displayed
    * Close the page

    Scenario: TC_03 Searching should be possible with Loan Number and Start Date - End Date" information.
      * Click on reject loans under the loans heading.
      * The information to be searched for information to searchis entered for Loan number or Start date-End Date.
      * Verifies that the call can be made
      * Close the page

    Scenario: TC_04 Details and Installment information of the selected loan
                    should be accessible under the Action heading.
      * Click on reject loans under the loans heading.
      * Click on the details and installment links under action
      * It is verified that the information on these pages can be accessed.
      * Close the page

    Scenario: TC_05 Loan details should be accessed on the details page.
      * Click on reject loans under the loans heading.
      * Click on the details
      * It must be verified that the loan details can be accessed on the Details page.
      * Close the page

   Scenario: TC_06 Status should appear in loans details
     * Click on reject loans under the loans heading.
     * Click on the details
     * Verify that you see status information in loans details
     * Close the page

    Scenario: TC_07 Loan summary information should be displayed on the Installments page
      * Click on reject loans under the loans heading.
      * Click on Installments
      * Installments verifies that page titles exist
      * Close the page

    Scenario: CT_08 Installments page titles should appear
      * Click on reject loans under the loans heading.
      * Click on Installments
      * Installments verifies that page titles are visible
      * Close the page

    Scenario: TC_O9 It should be possible to return to the Rejected Loans page from the Installments page.

      * Click on reject loans under the loans heading.
      * Click on Installments
      * press the back button
      * It is confirmed that rejected loans came again
  @US56
    Scenario: TC_1O Installments greater than 20 must continue to be listed

      * Click on reject loans under the loans heading.
      * Click on the Insttallment and Verify that installments greater than 20 continue to be listed
      * Close the page