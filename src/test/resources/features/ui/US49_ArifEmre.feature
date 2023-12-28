
Feature: US49 : As an administrator, I want to have a list of users where I can see their balance amounts.

  Scenario: TC01 :I should display the with balance list and access the detailed information of the desired user.
    Given Go to "adminUrlOne"
  * The username box is clicked and the username is entered.
  * The password box is clicked and the password is entered.
  * The Login button is clicked.
  * Click on the Manage users tab.
  * The withbalance tab is clicked.
  * The withbalance list is displayed.
  * searchbox is clicked
  * Enter the desired username and click enter.
  * Details button is clicked
  * It is verified that the detailed information of the desired user is accessed.
  * The page is closed.