Feature: As an  admin, I want to have an Approved Deposit page to
         view deposit transactions approved by the admin.

  Background:Admin use these steps to log in to the site and Admindashboard.
    *  As admin, go to "adminUrl" Adminpage
    *  Enter "adminNameUmit" and "passwordAdmin" and press the login button.

Scenario: TC_01:Admin accesses the admin/deposit/approved page by clicking on the
          Approved Deposits page link under the Admin Deposits menu title
  * Display the Deposits item in the Dashboard menu and click on it
  * Click on Approved Deposits button
  * Displays and verifies the title
  * Close the page

Scenario: TC_02:Displays Admin Approved Deposit list page headers
  * Display the Deposits item in the Dashboard menu and click on it
  * Click on Approved Deposits button
  * Admin confirms that the Approved Deposit list displays page titles
  * Close the page

Scenario: TC_03:Admin displays and clicks the Details button to access the details of the approved deposit
  * Display the Deposits item in the Dashboard menu and click on it
  * Click on Approved Deposits button
  * Admin displays and clicks the Details button below the Action titles
  * Verify that the Admin is on the Deposit Details page
  * Close the page

Scenario: TC_04:Admin On the detail page of the withdrawal transaction selected from the list,Date, Trx Number,
          User Name, Method, Amount, Fee, After Fee, Rate, Payable, Status information should be displayed.
  * Display the Deposits item in the Dashboard menu and click on it
  * Click on Approved Deposits button
  * Admin displays and clicks the Details button below the Action titles
  * Admin Displays details on the detail page of the withdrawal selected from the list
  * Close the page