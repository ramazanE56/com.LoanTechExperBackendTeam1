

Feature: As a registered user, I want to be able to log out of the site safely.


  Scenario: TC_22: You can go to the site with your user information. The visibility and effectiveness of the logout link is tested and returned to the home page.

    Given Navigate to the URL by entering in the browser's address "Url" bar and pressing the Enter key.
    Then Click on Login button.
    Then Fill in userinformation.
    And Test the functionality and visibility of the logout button.
    Then Return to the home page.
    And Close the web page.