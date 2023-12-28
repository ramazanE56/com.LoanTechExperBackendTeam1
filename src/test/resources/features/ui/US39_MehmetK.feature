
Feature: as an admin, create categories and manage all categories.
  @regression
  Scenario: On the Categories page, verify that you can see all categories, create new categories, change them and reach the desired category
    * Navigate to Admin page "adminUrl"
    * send "username registered" to username textbox
    * send "password registered" to password textbox
    * click on the login button
    * verify that Categories link element visible
    * click categories link element
    * verify all categories visible
    * click add new element button
    * send the name of new loan to name textbox
    * send the description of new loan to description textbox
    * click submit button
    * verify that create new loan
    * send a name of loan to search box
    * click the search icon
    * verify that the loan typed into the search box is listed
    * Click the EnableDisable button in the action tab of the first loan
    * click the yesButton on the Confirmation Alert page
    * Verify that the status of the 1st line loan has changed
    * Click the editButton in the action tab of the first loan
    * send a new name to name loan textbox
    * send the description to description textbox
    * Verify that first line loan has changed
    * Close the page