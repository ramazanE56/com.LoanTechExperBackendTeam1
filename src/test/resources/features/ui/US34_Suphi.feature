
Feature: US34: As an administrator, I want to be able to access and update my profile information.

  Background:Users use these steps to log in to the site.


  Scenario: TC01: After logging in to the admin dashboard, the admin icon should appear in the upper right corner.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * Close the page

  Scenario: TC02: When clicking on the admin icon, profile, password, logout links should appear.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * The visibility of Admin, Profile, Password, Logout links is verified
    * Close the page

  Scenario: TC03: Clicking on the profile link should take you to the Profile Information page and
                  information updates should be possible.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * Click on the profile link
    * Name, email, image information is updated and saved
    * It is confirmed that the changes made have been saved successfully by the text Profile updated successfully in the upper right corner
    * Close the page

  Scenario: TC04: Clicking on the password link should take you to the password setting page and
                  you should be able to update the password.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * Click on the password link and go to the password setting page
    * In the Change password section, used Password, New Password and Confirm Password information must be entered
    * It is confirmed that the changes made have been saved successfully by the text Password changed successfully in the upper right corner
    * Close the page

  Scenario: TC05: When the Logout link is clicked, you must successfully leave the page.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * Click on the profile link
    * Click on the admin icon in the upper right corner of the admin dashboard page
    * Click on the logout link
    * It is verified that the admin page is exited
    * Close the page

