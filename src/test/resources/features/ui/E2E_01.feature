
Feature:The visitor must be able to register to the site and fill out his/her profile information.
@e2e01
  Scenario: E2E01 : The visitor must be able to register to the site and fill out his/her profile information.
    * The user enters site with the given "Url"
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
    * Click on the Profile tab
    * dashboard Name is entered in the firstname box
    * dashboard Surname is entered in the lastname box
    * dashboard Address is entered in the address box
    * dashboard State is entered in the state box
    * dashboard zip code entered in zip code box
    * dashboard Country is entered in the city box
    * Click the Choose File button and upload a profile photo.
    * dashboard Click on the submit button
    * Close the page
