
Feature: I would like to have a page to register as a visitor

  Background:Users use these steps to log in to the site.

    * The user enters site with the given "Url"



  Scenario: TC01 : It must be verified that the Get Started Button Link is visible and active on the Home Page.

    * Verify that the Get Started Button link is Visible on the Home Page
    * Click on the Get Started Button on the Home Page.
    * Verify that the register text is visible on register page.
    * Close the page



  Scenario: TC02 : Verify that the registration form is visible on the registration page
    * Click on the Get Started Button on the Home Page.
    * Verify that the Welcome To Loantech Expert form title is visible on the Register page
    * Close the page


  Scenario: TC03 : It must be verified that the Username, Email Address, Country DropDown,
            Mobile Number, Password, Confirm Password text boxes are visible in the form.

    * Click on the Get Started Button on the Home Page.
    * Verify that the username text box is visible
    * Verify that the Email Address text box is visible
    * Verify that the Country DropDown is visible
    * Verify that the Mobile Number text box is visible
    * Verify that the Password text box is visible
    * Verify that the Confirm Password text box is visible
    * Close the page


  Scenario: TC04 : It must be verified that a unique value of at least 6 characters can be entered in the Username box.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Close the page


  Scenario: TC05 : It must be verified that valid e-mail information containing
            the @ sign can be entered in the e-mail text box.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * It is verified that valid e-mail information containing the @ sign can be entered in the e-mail text box
    * Close the page


  Scenario: TC06 : It must be verified that country selection is possible from the Country menu.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Valid e-mail information containing the @ sign is entered into the e-mail text box
    * It is verified that country selection is possible from the Country menu.
    * Close the page


  Scenario: TC07 : It must be verified that country selection is possible from the Country menu.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Valid e-mail information containing the @ sign is entered into the e-mail text box


    * Country selection is made from the Country menu.
    * It is verified that a unique phone number of up to 14 digits can be entered in the phone textbox.
    * Close the page


  Scenario: TC08 : It must be verified that a 6-digit password containing at least
            one uppercase letter, one number, lowercase letter and character can be entered in the
            Password textbox and that the entered password can be hidden or unlocked.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Valid e-mail information containing the @ sign is entered into the e-mail text box
    * Country selection is made from the Country menu.
    * A unique phone number of maximum 14 digits is entered into the phone textbox.
    * It is verified that a 6-digit password containing at least one uppercase letter, one number, lowercase letter and character can be entered in the Password textbox.
    * It is verified that the password entered in the password textbox can be hidden or revealed.
    * Close the page


  Scenario: TC009 : It must be verified that the password specified in the Confirm textbox can be re-entered.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Valid e-mail information containing the @ sign is entered into the e-mail text box
    * Country selection is made from the Country menu.
    * A unique phone number of maximum 14 digits is entered into the phone textbox.
    * A 6-digit password containing at least one uppercase letter, one number, lowercase letter and character is entered into the Password textbox.
    * It is verified that the password specified in the Confirm textbox can be entered again.
    * Close the page


  Scenario: TC10 : Verify that the 'I agree with Privacy Policy, Terms of Service, Rapid Policy' check box is clickable

    * Click on the Get Started Button on the Home Page.
    * Verify that the I agree with Privacy Policy, Terms of Service, Rapid Policy check box is clickable
    * Close the page


  Scenario: TC11 : By clicking on the Register button, the user registration form must
            be submitted and it must be verified that it can be directed to the User Data page to complete the registration.

    * Click on the Get Started Button on the Home Page.
    * A unique username with at least 6 characters is entered in the Username box.
    * Valid e-mail information containing the @ sign is entered into the e-mail text box
    * Country selection is made from the Country menu.
    * A unique phone number of maximum 14 digits is entered into the phone textbox.
    * A 6-digit password containing at least one uppercase letter, one number, lowercase letter and character is entered into the Password textbox.
    * The specified password is entered in the Confirm textbox.
    * click on the i agree button
    * click on the register button
    * Verify that Please Complete Your Profile is visible
    * Close the page


    Scenario: TC12 : It appears in the form opened on the User Data page
              (firstname, lastname, address, State, Zip, city, Submit Button) and must be verified as active.

      * Click on the Get Started Button on the Home Page.
      * A unique username with at least 6 characters is entered in the Username box.
      * Valid e-mail information containing the @ sign is entered into the e-mail text box
      * Country selection is made from the Country menu.
      * A unique phone number of maximum 14 digits is entered into the phone textbox.
      * A 6-digit password containing at least one uppercase letter, one number, lowercase letter and character is entered into the Password textbox.
      * The specified password is entered in the Confirm textbox.
      * click on the i agree button
      * click on the register button
      * The Firstname box should be visible
      * The lastname box should be visible
      * The address box should be visible
      * The State box should be visible
      * The Zip box should be visible
      * The city box should be visible
      * The Submit Button should be visible
      * Submit Button must be clickable
      * Close the page


    Scenario: TC13 : It must be verified that the registration process
              can be completed by filling in the mandatory fields in the form (firstname/lastname/address textboxes).

      * Click on the Get Started Button on the Home Page.
      * A unique username with at least 6 characters is entered in the Username box.
      * Valid e-mail information containing the @ sign is entered into the e-mail text box
      * Country selection is made from the Country menu.
      * A unique phone number of maximum 14 digits is entered into the phone textbox.
      * A 6-digit password containing at least one uppercase letter, one number, lowercase letter and character is entered into the Password textbox.
      * The specified password is entered in the Confirm textbox.
      * click on the i agree button
      * click on the register button
      * Name is entered in the firstname box
      * Surname is entered in the lastname box
      * Address is entered in the address box
      * State is entered in the state box
      * zip code entered in zip code box
      * Country is entered in the city box
      * Click on the submit button
      * Verify that registration process completed successfully appears
      * Close the page





