


Feature: As an administrator, I want to be able to see and manage payment plans of active users.


  Scenario: TC01: On the Dashboard page, the Active Users link under the Manage Users link should be displayed.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Close the web page.


  Scenario: TC02: Must know how to view list titles under Active Users.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    Then Verify that the list under Active Users are displayed.
    And Close the web page.


  Scenario: TC03:By clicking on the details link of any user, the Details Users page should be accessible.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    And Verify that the User Detail-Username page has been reached.
    And Close the web page.


  Scenario: TC04: By clicking on the 'view all' icon under the 'Withdrawn' heading, you can go to the 'Withdrawals Log' page and view the list.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Confirm that the list and list headers are displayed on the page.
    And  Close the web page.


  Scenario: TC05: The 'Approved Withdrawals', 'Pending Withdrawals', 'Rejected Withdrawals' links on the 'Withdrawals Log' page should be visible.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Confirm that the Approved Withdrawals, Pending Withdrawals, Rejected Withdrawals links are displayed.
    And  Close the web page.




  Scenario: TC06: The Details button on the 'Approved Withdrawals' page should be visible.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    Then Click on the Approved Withdrawals link.
    And Verify that the Details button is displayed on the Approved Withdrawals page.
    And  Close the web page.


  Scenario: TC07: 'User Withdraw Information' must be accessible and the list in the card must be displayed.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    Then Click on the Approved Withdrawals link.
    And Click on the Details button.
    And View the information within the card.
    And  Close the web page.

  Scenario: TC08: The 'pending' and 'details' buttons under the 'Pending Withdrawn' heading should be visible.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Pending Withdrawn heading.
    Then Confirm the visibility of the Pending and Details buttons on this page.
    And  Close the web page.



  Scenario: TC09: When you enter the Transaction Details page, 'Approve' and 'Reject' Buttons should be visible.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Pending Withdrawn heading.
    And On the opened page, click on the Details button.
    And Confirm the visibility of the Approve and Reject buttons on the page that opens.
    And  Close the web page.


  Scenario: TC010: When rejected, the text "Withdrawal rejected successfully" should be displayed.


    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Pending Withdrawn heading.
    And On the opened page, click on the Details button.
    Then On the page, click on the Reject button, fill in the required fields, and click on the submit button.
    And Confirm the display of the Withdrawal rejected successfully message.
    And  Close the web page.


  Scenario: TC011: When approved, the text "Withdrawal approved successfully" should be displayed.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Pending Withdrawn heading.
    And On the opened page, click on the Details button.
    Then On the page, click on the Approved button, fill in the required fields, and click on the submit button.
    And Confirm the display of the Withdrawal approved successfully message.
    And  Close the web page.


  Scenario: TC012:When the Rejected Withdrawals link is clicked, the status should be displayed as 'Rejected' in the list that opens.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Rejected Withdrawals link.
    Then Verify that the status is displayed as Rejected.
    And  Close the web page.


  Scenario: TC013:On the Rejected Withdrawals page, card information should be displayed when the 'Details' button is clicked.

    Given Enter the  "UrlAdmin"  in the browser's address bar and press the Enter key.
    Then Fill in the admin credentials.
    And Click the Login button.
    Then Click on the Manage Users link.
    And Click the Active Users link and verify its visibility.
    And Click on the Details button for any user.
    Then Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.
    And Click on the Rejected Withdrawals link.
    Then View the card information on the page.
    And Close the web page.








