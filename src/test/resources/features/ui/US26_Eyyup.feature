

Feature: As an administrator, I want to have a pending loans page so I can see and process pending loans.


  Scenario: TC01: To verify that the admin can successfully access the "Pending Loans" page in the "Loans" menu and view the table.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    Then Verify that access to the Pending Loans page is successful.
    And View the Pending Loans table.
    And Close the web page.


  Scenario: TC02:Subheadings of pending loans are displayed in the Pending loans table, and searches are made by date on the Pending Loans page.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    Then Verify that access to the Pending Loans page is successful.
    And View the Pending Loans table.
    Then Viewed the information of pending loans on the Pending Loans page
    Then Searched in the Pending Loans table using loan number and start date information.
    And Close the web page.


  Scenario: TC03: Details and installment buttons under the action menu in the Pending Loans table should be visible.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    And Reviewed the details and installment information in Pending Loans.
    And Close the web page.

  Scenario: TC04: Credit headings should be displayed under the Details menu.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    Then Clicked on the Details button on the page.
    And Viewed the credit details on the opened page (plan, date, etc.).


  Scenario: TC05:The loan must be approved by going to the details menu.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    Then Clicked on the Details button on the page.
    And Click on the Approve button on the page.
    And Accept the displayed alert, and the credit is approved.


  Scenario: TC06:The loan must be rejected by going to the Details menu.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    Then Clicked on the Details button on the page.
    And Click on the Reject button on the page.
    And The submit button is clicked, the loan is not approved.


  Scenario: TC07:Subheadings in the Installment menu can be displayed.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    And Click on the Installments link.
    And View the information under the Installments menu.

@e2e
  Scenario: TC08: After going to the Installments page, you should be able to return to the loans page.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click to the Loans menu.
    And Click on the Pending Loans link.
    And Click on the Installments link.
    And Verify that you have returned to the Loans page.


