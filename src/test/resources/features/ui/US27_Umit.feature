Feature: As an administrator, I want to have a Running Loans page to
  access and process existing loans.

  Background:Admin use these steps to log in to the site and Admindashboard.
    *  As admin, go to "adminUrl" Adminpage
    *  Enter "adminNameUmit" and "passwordAdmin" and press the login button.

  Scenario: TC_01: The "Running Loans" page should be
  accessed by clicking on the Loans menu heading
    *  Click on Running loans under the loans heading.
    *  Verify that the admin is on the Adminhomepage
    *  Close the page

  Scenario: TC_02: Verify that the "Running Loans" appears
    *  Click on Running loans under the loans heading.
    *  Verify that the Running Loans appears
    *  Close the page

  Scenario: TC_03:Running Loans page verification including
   "Loan Number and Start Date - End Date" information
    * Click on Running loans under the loans heading.
    * The information to be search is entered for Loan number or Start date-End Date.
    * Verifies that searches can be made
    * Close the page

  Scenario: TC_04:Detail and Installment information of the selected loan should be accessed
    * Click on Running loans under the loans heading.
    * Click on the Details links and verify that the Details page is displayed
    * Click on the Installment links and verify that the Installment page is displayed
    * Close the page

  Scenario: TC_05:Loan details should be available on the Details page.
    * Click on Running loans under the loans heading.
    * Click on the Details links
    * It should be verified that the loan details can be accessed on the Details page.
    * Close the page

  Scenario: TC_06:Status of credit should be appear in loans details
    * Click on Running loans under the loans heading.
    * Click on the Details links
    * Verify that you see credit status information in loans details
    * Close the page

  Scenario: TC_07: Loan details should be available on the Installment page.
    * Click on Running loans under the loans heading.
    * Click on the Installment links
    * Verifies that their titles are visible on the Installments page
    * Close the page

  Scenario: TC_08:Headers should be available on the Installments page.
    * Click on Running loans under the loans heading.
    * Click on the Installment links
    * Installments verifies that page titles are displayed
    * Close the page

  Scenario: TC_09:It should be possible to return to the Running Loans page from the Installments page.
    * Click on Running loans under the loans heading.
    * Click on the Installment links
    * Press the back button
    * It is confirmed that Running loans came again
    * Close the page

  Scenario: TC_10:Installments greater than 20 must continue to be listed
    * Click on Running loans under the loans heading.
    * Enter the loan number to be searched in the search box and search
    * Click on the Installment links
    * Verify that installments  than 20 continue to be listed
    * Close the page



