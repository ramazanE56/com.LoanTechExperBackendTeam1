
  Feature: US_21 As a User, I must be able to access the Home Page


    Background: In this step, the registered user reaches the user home page by entering his username and password.

      Given The given "Url" is entered into the browser and press enter.
      And The user click on the login button.
      And The user enters "usernameHalit" username.
      And The user enters "password" password.
      And The user clicks on the login button.
      And The user clicks on the home page logo.

    @TC_01
    Scenario: TC_01 The registered user must be able to access the website from the browser with the given URL.

      Given The user's access to the home page is verified.

    @TC_02
    Scenario: TC_02 There should be email, phone and address information in the top bar of the home page.
      The site logo and menu titles (Home, About, Plans, Blogs, Contact, Login Icon, Get Started Icon)
      should be visible and active in the top bar of the home page.

      Given Email information visible in the top bar of the home page.
      And Address information visible in the top bar of the home page.
      And Phone information visible in the top bar of the home page.
      And The Home button is active and visible in the home page header section.
      And The About button is active and visible in the home page header section.
      And The Plans button is active and visible in the home page header section.
      And The Blogs button is active and visible in the home page header section.
      And The Contact button is active and visible in the home page header section.
      And The Login icon is active and visible in the home page header section.
      And Get Started icon is active and visible in the home page header section.



    Scenario:
      Given Click on the Home button in the header section of the home page.
      And It is verified that the home page is opened.
      And Click on the About button in the header section of the home page.
      And It is verified that the About page is opened.
      And Click the Plans button in the header section of the home page.
      And It is verified that the Plans page is opened.
      And Click the Blogs button in the header section of the home page.
      And It is verified that the Blogs page is opened.
      And Click the Contact button in the header section of the home page.
      And It is verified that the Contact page is opened.
      And Click on the Login icon in the header section of the home page.
      And It is verified that the Login page is opened.
      And Click on the Get Started icon in the header section of the home page.
      And It is verified that the Get Started  page is opened.