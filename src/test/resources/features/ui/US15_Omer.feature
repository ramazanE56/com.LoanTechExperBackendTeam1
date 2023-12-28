
Feature: US_15 As a registered user, I want to be able to access my password information and change my current password.

  Background:   Background:Users use these steps to log in to the site.
    * The user enters site with the given "Url"
    * Accept the cookies on page
    * Login with registered user information

    Scenario: TC_01 After logging in to the site as a user,
              the 'Change Password' link should be displayed on the user dashboard page
                    and
              when clicked, it should direct you to the "Change Password" page.

      * Verify that the Change Password is visible on dashboard and button is active.


    Scenario: TC_02 Valid password information must be entered in the "Current Password" textbox.
              New and valid password must be entered in the "Password" text box.
              The password entered in the "Password" text box must be entered in the "Confirm Password" text box.
              If the password entered in the "Confirm Password" text box and the "Password" text box are not the same, a warning message should appear.

      * Write a valid password on the Current Password text box
      * Write a new password on the Password text box,
      * Write a different password on the Confirm Password text box,
      * Verify that the new password and the password are not the same
      * Click the Submit button
      * Verify that the warning message appears


    Scenario: TC_03 When the Submit button is clicked, the message that the update has been completed successfully should be displayed.

      * Write a valid password on the Current Password text box
      * Write a new password on the Password text box,
      * Write a same password on the Confirm Password text box,
      * Verify that the new password and the password are the same
      * Click the Submit button
      * Verify that the completed successfully message appears