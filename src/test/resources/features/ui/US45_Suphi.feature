
Feature: US45: As an administrator, I want to be able to edit the profile information of a user I choose.

  Background:Users use these steps to log in to the site.


  Scenario: TC01: The 'Active Users' link should appear and be active under the 'Manage Users' link
                  in the Nawbar on the Dashboard page.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * Close the page

  Scenario: TC02: When the 'Active Users' link is clicked, the 'Active Users List' and list titles should be displayed.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed
    * Close the page

  Scenario: TC03: To access information about any user selected from the list, the 'Details' button must be visible and active.
                  when clicked, it should redirect to the 'User Detail - Username' page.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed
    * Click on the Details link under the Action information of an Active User
    * Go to User Details page
    * Close the page

  Scenario: TC04: The selected user's current profile information should be directed to the editing screen.
                  Basic information such as 'name, surname, e-mail, phone' should be editable.
                  Other private information about the user (if any) should be displayed and updated on the editing screen.
                  The validity of the updated information should be checked. For example, it should be checked whether
                  the email address is in the correct format. Required fields cannot be left blank.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed
    * Click on the Details link under the Action information of an Active User
    * Go to User Details page
    * The name and surname information under the heading Information of is reorganized and saved
    * The email address under the Information of heading is rearranged and saved in the correct format (there must be an "@" sign in the email address)
    * City information under the Information of heading is reorganized and saved
    * The State information under the Information of heading is reorganized and saved
    * Zip code information under the Information of heading is rearranged and saved
    * Close the page

  Scenario: TC05: When the changes are approved, the user profile information in the system must be updated.
                  The user should be shown a notification that the changes were successfully saved.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed
    * Click on the Details link under the Action information of an Active User
    * Go to User Details page
    * The information under the Information of heading is rearranged and saved by clicking Submit button
    * Changes are confirmed by the 'User details updated successfully' notification in the upper right corner of the page
    * Close the page
@smoke
  Scenario: TC06: When an unexpected error occurs in the system, a clear error message should be displayed to the user.
                  In case of incorrect entries (invalid e-mail, missing mandatory fields, etc.), the user should be informed
                  with appropriate error messages.

    * The visitor enters the admin site with the given "adminUrl"
    * The admin logs in to the admin dashboard page with "adminNameSuphi" and "passwordAdmin"
    * Click on the Manage Users link
    * Click on Active Users link under Manage Users link and go to Active Users page
    * User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed
    * Click on the Details link under the Action information of an Active User
    * Go to User Details page
    * An attempt is made to enter missing - incorrect address information to the "e_mail" address
    * Please add an "@" sign to the email address. The "@" is missing in the "e_mail" address.' incorrect input notification is displayed
    * Close the page
