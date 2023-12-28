
Feature: US14: As a registered user, I want to be able to access and update my profile information.

  Background:Users use these steps to log in to the site.


  Scenario: TC01: The user should be able to view and edit their profile information from the user dashboard page
                  after logging into the site with their user information.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * Close the page

  Scenario: TC02: The user should be able to see and edit card information on the Profile Settings page.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * User name, e-mail address, phone number, country information should be visible
    * Close the page

  Scenario: TC03: Information in the Profile Card section should be editable in Profile Settings.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * Firstname and lastname are edited
    * Close the page

  Scenario: TC04: The user should be able to select and upload new files from the image section of the profile settings.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * Click on Choose File button in Image section
    * The new file is selected and uploaded
    * Close the page

  Scenario: TC05: In the Zip Code section in the profile settings section, characters other than digits should not be entered.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * Non-digit characters are entered in the zip code section
    * Enter digit characters in the Zip code section and save the changes by clicking the submit button
    * Close the page

  Scenario: TC06: The user can make the necessary changes in the profile settings section and save these changes.

    * The user enters site with the given "Url"
    * Click the Login button.
    * The user logs in to the user dashboard page with "userNameSuphi" and "password"
    * Click on the Profile link to go to the page where profile information can be edited
    * The user makes the necessary changes in the profile settings section and saves the changes by clicking submit
    * Profile updated successfully appears when the changes are saved
    * Close the page