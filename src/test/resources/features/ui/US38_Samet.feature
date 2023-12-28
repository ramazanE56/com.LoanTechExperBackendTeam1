Feature: US38: As a User (Admin), I want to have a page where I can see active users on the site and manage Deposit (withdrawal) transactions.


  Scenario: TC01: The 'Active Users' link should appear and be active under the 'Manage Users' link in the Nawbar on the Dashboard page.

    Given Open the web "browser"
    When Navigate to "UrlAdmin"
    When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
    When Click the LOGIN button
    When Click Manage Users link on the DashboardPage
    And  Verify Active Users link is appear on the DashboardPage
    Then Close the page

    Scenario:  TC02: When the 'Active Users' link is clicked, the 'Active Users List' and list titles should be displayed.

      Given Open the web "browser"
      When Navigate to "UrlAdmin"
      When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
      When Click the LOGIN button
      When Click Manage Users link on the DashboardPage
      When Click on the Active Users link on the DashboardPage
      And Verify Active Users List and list titles is displayed
      Then Close the page

      Scenario: TC03: To access information about any user selected from the list, the 'Details' button must be visible and active. When clicked, it should redirect to the 'User Detail - Username' page.

        Given Open the web "browser"
        When Navigate to "UrlAdmin"
        When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
        When Click the LOGIN button
        When Click Manage Users link on the DashboardPage
        When Click on the Active Users link on the DashboardPage
        When Verify the Details Button is visible and then click Details Button
        And Verify that the user is redirected User Detail-Username page
        Then Close the page

        Scenario: TCO4: On the User Detail page, the 'view all' icon should be visible and active under the 'Deposit' heading. When the icon is clicked, it should direct you to the 'Deposit History' page.

          Given Open the web "browser"
          When Navigate to "UrlAdmin"
          When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
          When Click the LOGIN button
          When Click Manage Users link on the DashboardPage
          When Click on the Active Users link on the DashboardPage
          When Verify the Details Button is visible and then click Details Button
          When Verify the view all icon on the User Detail page
          When Click on the view all icon
          And Verify that the user is redirected Deposit History page
          Then Close the page

          Scenario: TC05: List and list titles should be displayed on the page that opens.

            Given Open the web "browser"
            When Navigate to "UrlAdmin"
            When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
            When Click the LOGIN button
            When Click Manage Users link on the DashboardPage
            When Click on the Active Users link on the DashboardPage
            When Verify the Details Button is visible and then click Details Button
            When Verify the view all icon on the User Detail page
            When Click on the view all icon
            When Verify that the user is redirected Deposit History page
            And Verify that List and list titles should be displayed on the page
            Then Close the page

        Scenario: TC06: On the User Detail page, the 'view all' icon should be visible and active under the 'Deposit' heading. When the icon is clicked, it should direct you to the 'Deposit History' page.


          Given Open the web "browser"
          When Navigate to "UrlAdmin"
          When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
          When Click the LOGIN button
          When Click Manage Users link on the DashboardPage
          When Click on the Active Users link on the DashboardPage
          When Verify the Details Button is visible and then click Details Button
          When Verify the view all icon on the User Detail page
          When Click on the view all icon
          When Click the Pending Deposits
          When Click the Pending Deposits Detail button
          And Verify that the text x requested x USD should be displayed
          Then Close the page

    Scenario: TC07: Deposit Card should be displayed on the page that opens. 'Date, Transaction Number, Username, Method, Amount, Charge, After Charge, Rate, Payable, Status' titles and values should be displayed in the Card.

          Given Open the web "browser"
          When Navigate to "UrlAdmin"
          When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
          When Click the LOGIN button
          When Click Manage Users link on the DashboardPage
          When Click on the Active Users link on the DashboardPage
          When Verify the Details Button is visible and then click Details Button
          When Verify the view all icon on the User Detail page
          When Click on the view all icon
          When Click the Pending Deposits
          When Click the Pending Deposits Detail button
          And Verify that Deposit Card and Date, Transaction Number, Username, Method, Amount, Charge, After Charge, Rate, Payable, Status titles is visible
          Then Close the page

    Scenario: TC08: 'Successful Deposit', 'Pending Deposit', 'Rejected Deposit', 'Initiated Deposit' titles and values should be displayed.


        Given Open the web "browser"
        When Navigate to "UrlAdmin"
        When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
        When Click the LOGIN button
        When Click the Deposits button
        When Click on the All Deposits button
        And Verify that Successful Deposit, Pending Deposit, Rejected Deposit, Initiated Deposit titles and values are visible
        Then Close the page

    Scenario: TC09 : The title 'Successful Deposits' should be active and when clicked, it should lead to the Successful Deposits page. Filtering and search buttons on this page should be functional and active. A list of successful deposits should be displayed on the page

        Given Open the web "browser"
        When Navigate to "UrlAdmin"
        When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
        When Click the LOGIN button
        When Click the Deposits button
        When Click on the All Deposits button
        When Click on the Successful Deposits heading
        When Verify that Succesful Deposits page is visible
        When Enter the credentilas in the Filtering and Search boxes
        When Verify that Filtering and Search buttons are fonctional
        And Verify that a list of successful deposits are displayed
        Then Close the page

      Scenario: TC10: The 'Pending Deposits' heading should be active and when clicked, it should lead to the Pending Deposits page. The Details Button should be visible and active in the List on this page

        Given Open the web "browser"
        When Navigate to "UrlAdmin"
        When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
        When Click the LOGIN button
        When Click the Deposits button
        When Click on the All Deposits button
        When Click the Pending Deposits Heading
        When Verify that Pending Deposits page is visible
        When Click on the Details button
        And Verify that Details button is active
        Then Close the page

        Scenario: TC11: When entering the Transaction Detail page, 'Approve' and 'Reject' Buttons should be visible and functional
          Given Open the web "browser"
          When Navigate to "UrlAdmin"
          When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
          When Click the LOGIN button
          When Click the Deposits button
          When Click the Pending Deposits Heading
          When Click on the Details button
          And Verify that Approve and Reject buttons on the Transaction Detail page
          Then Close the page

          Scenario: TC12: When rejected, you should be directed to the 'Reject Deposit Confirmation' page, mandatory fields should be filled in and the text "Deposit request rejected successfully" should be displayed.When Click the Deposits button
            When The visitor enters the site with the given "Url"
            Then Click on the Login button.
            Then Fill in user information.
            When Automatic deposit creation before main test
            When Close the page
  Scenario:
            Given Open the web "browser"
            When Navigate to "UrlAdmin"
            When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
            When Click the LOGIN button
            When Click the Deposits button
            When Click the Pending Deposits Heading
            When Type to samet in the searchtextbox and submit
            When Click on the first Details button
            When Click on the Reject button
            When Fill in the Reason for Rejection section and Click SUBMIT button
            And Verify that Deposit request rejected successfully is visible
            Then Close the page

            Scenario: TC13: When approved, the text "Deposit request approved successfully" should appear.
              Given Open the web "browser"
              When Navigate to "UrlAdmin"
              When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
              When Click the LOGIN button
              When Click the Deposits button
              When Click the Pending Deposits Heading
              When Type to samet in the searchtextbox and submit
              When Click on the first Details button
              When Click on the Approve button
              When On the page that appears click on the Yes button
              And Verify that Deposit request approved successfully is appeared
              Then Close the page

