
Feature: As a registered user, I want to be able to access the login page from the home page in order to log in to my own panel

  Background:Users use these steps to log in to the site.
    * Navigate to given "Url"

  Scenario: TC01: On the login page, it is verified that the registered information (username, password) can be entered and the links (Remember Me, Checkbox, Forgot Password, Login Button) are active.
    * click the Login on  top bar of the home page
    * Verify that the Login page is a form
    * Verify that the Username texbox is Visible and active
    * Verify that the Password texbox is Visible and active
    * Verify that the Remember Me link is Visible and active
    * Verify that the Forgot Password link is Visible and active
    * Verify that the Login button is Visible and active
    * send the registered "username" to username text box
    * send the registered "sifre" to password text box
    * Verify that the username textbox is filled with the registered username
    * Verify that the password textbox fields is filled with the registered password
    * Verify that the message warning appears when incorrect entry is made
    * Click the login button
    * Verify that the Dashboard page is opened
    * Close the page

  Scenario: TC02:Verify that your account has been reset by entering your Username or email address on the "Account Recovery" page when you click on the "Forgot password?"
    * click the Login on  top bar of the home page
    * Click the Forgot password link element
    * verify that Recovery page open when when you click on Forgot button
    * send the "Username or email address" registered in the textBox
    * click on the summit button
    * Verify that Password reset email sent successfully message appears when the Submit button is clicked
    * Click the Try to send again link element
    * Verify that the user password reset page opens again when the Try to send again link element is clicked
    * send the "Username or email address" registered in the textBox
    * click on the summit button
    * Enter the digit digit verification "123456" sent to the e-mail address in the textBox
    * click the submit button
    * Close the page

  Scenario: TC03:The Register Now Link element on the login page should be visible and should direct you to the Register page when clicked.
    * click the Login on  top bar of the home page
    * verify that The Register Now Link element on the login page visible
    * Click the Register Now link element.
    * verify that The Register page open.
    * Close the page
