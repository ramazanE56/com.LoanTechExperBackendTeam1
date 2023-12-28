
  Feature: US_56 As an administrator ,I want to have an All Deposit page
                 so that I can view all deposit transactions on one page.

    Background: Go to the all deposit page by performing the following steps.

      *  As admin, go to "adminUrl" page
      *  Enter a valid "adminUsername" and "passwordAdmin" and press the login button.
      *  Click on the deposits


    Scenario: TC_01 When the All Deposits page link is clicked, the admin/deposit page should be accessed.

      * Click o the all Loans
      * It must be verified that the admin deposit page has been accessed.


    Scenario: TC_02 Search box and Start Date - End Date search box must be visible and active

      * Click o the all Loans
      * Start Date and End Date boxes are must be visible and active


    Scenario: TC_03 'Successful Deposit', 'Pending Deposit', 'Rejected Deposit', 'Initiated Deposit'
    summary boxes must be visible and active.When clicked, it should direct you to the relevant page and list.

    * Click o the all Loans
    * Successful Deposit, Pending Deposit, Rejected Deposit, Initiated Deposit  summary boxes must be visible and active
    * When clicked, it should direct you to the relevant page and list.


      Scenario: TC_04 The Deposit History list should be displayed,
                      the list titles and the information below should be visible.

        * Click o the all Loans
        * Verify that the deposit history list and titles are visible
      Scenario: TC_05 Accessing and confirming the details of the deposit whose status is Pending
                and to reject it the Details button must be visible and active

      * Click o the all Loans
      * The Details button should be visible and active.



      Scenario: TC_06 When the Approve/Rejection process is successful, a warning message should be displayed.

        * Click o the all Loans
        * Click on the allloans pending details
        * Click on the approve
        * Click on the Yes
        * Verify that the print alert message is displayed

    Scenario: TC_07 Deposit detail titles and content be displayed on the page that opens when the status is approved
        * Click o the all Loans
        * Click on the approve details
        * It must be verified that deposit detail titles and content can be viewed.



