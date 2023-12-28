Feature: US24: As a user, I should be able to see and manage my payments,
  withdrawals and total credits on the Home page.

  Background:Users use these steps to log in to the site.
    * As user enters the site with the given "Url"

  Scenario: TC01: The user should be able to view payments,
  withdrawals and total credit amount on the Home Page
    * Click the Login button and goto the user login page
    * The user logs into the user dashboard page with "userNameUmit" and "password"
    * It is verified that  details appear on the home page
    * Close the page