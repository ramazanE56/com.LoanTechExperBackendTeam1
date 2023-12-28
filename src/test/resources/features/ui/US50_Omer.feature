Feature: US_50 As an administrator (admin), I want to be able to send notifications to all users

  Background: You can go to the admin homepage by following these steps.
    *  As admin, go to "adminUrl" page
    *  Enter a valid "adminUsernameO" and "password" and press the login button on page

    Scenario: TC_01 The Notification to All Link must be visible and active in the admin dashboard.

      * Click Manage Users link on the DashboardPage
      * Verify that Notification to All button is visible and active

    Scenario: TC_02 There should be a filtering icon under the 'Being Sent' heading on the admin/users/send-notification page,
                and the administrator should be able to send a message by setting a specific starting date and period with a subject title and message to all users or to the users he/she can choose.

      * Click Manage Users link on the DashboardPage
      * Click the Notification to All button
      * Write a number on start from text box
      * Write a number on per batch text box
      * Write a wait time number on Cooling Period text box
      * Verify that Being Sent text is visible
      * Verify that the subject text is visible and write a test1 on textbox
      * Write a message on message textbox
      * Write a number on per batch text box
      * Write a wait time number on Cooling Period text box


    Scenario: TC_03 You should receive a warning message indicating a successful send.

      * Click Manage Users link on the DashboardPage
      * Click the Notification to All button
      * Write a number on start from text box
      * Write a number on per batch text box
      * Write a wait time number on Cooling Period text box
      * Verify that Being Sent text is visible
      * Verify that the subject text is visible and write a test1 on textbox
      * Write a message on message textbox
      * Write a number on per batch text box
      * Write a wait time number on Cooling Period text box
      * Click the submit button on notification section
      * Verify that successfully warning message is appear

    Scenario: TC_04 When any error is encountered (such as leaving a required field blank), an error message warning should be displayed.

      * Click Manage Users link on the DashboardPage
      * Click the Notification to All button
      * Write a number on start from text box
      * Write a number on per batch text box
      * Write a wait time number on Cooling Period text box
      * Verify that Being Sent text is visible
      * Verify that the subject text is visible and write a test1 on textbox
      * Write a message on message textbox
      * Write an any number on per batch text box
      * Write a wait time number on Cooling Period text box
      * Click the submit button on notification section
      * Verify that warning message is appear
