
  Feature: US_23 As a User, I want to have a page on the Home Page where I can access Loan Plans.

    Background: In this step, the registered user reaches the user home page by entering his username and password.

      Given The given "Url" is entered into the browser and press enter.
      And The user click on the login button.
      And The user enters "usernameHalit" username.
      And The user enters "password" password.
      And The user clicks on the login button.
      And The user clicks on the home page logo.


    @TC_001
    Scenario: TC_01 Loan cards should be displayed under the Plans link in the top bar of the homepage.

      Given The Plans button is active and visible in the home page header section.
      And Click the Plans button in the header section of the home page.
      And It is verified that the Plans page is opened.

    @TC_002
    Scenario: TC_02 When the Basic Loan button is clicked, the titles Basic Loan 1, Test_Loan, Car Loan should be
                displayed on the cards opened.

      Given Click the Plans button in the header section of the home page.
      And The Basic Loan button appears and it is confirmed that it is active.
      And Click on the Basic Loan button.
      And Verify that the Basic Loan 1' header is visible.
      And Verify that the Test Loan header is visible.
      And Verify that the Car Loan title is visible.


    @TC_003
    Scenario: Apply Now Button should be visible and active. When clicked,
              the "Apply for 'Selected card name'" page should open.

      Given Click the Plans button in the header section of the home page.
      And Click on the Basic Loan button.
      And Verifies that the Apply now button is visible and active.
      And Click the Apply Now button.
      And Verify that Apply for 'Basic Loan 1' page open

    @TC_004
    Scenario: A value within the digit minimum and maximum value range must be entered in the Amount text box.
            The arrow keys on the page must be active.

      Given Click the Plans button in the header section of the home page.
      And Click on the Basic Loan button.
      And Click the Apply Now button.
      And Amount are entered within the range of minimum and maximum values.
      And Verify that the arrow keys are visible and active.

    @TC_005
    Scenario: When the 'Confirm' button is clicked, you should be transferred to the 'Application Form' page.

      Given
      Given Click the Plans button in the header section of the home page.
      And Click on the Basic Loan button.
      And Click the Apply Now button.
      And Amount are entered within the range of minimum and maximum values.
      And The Confirm button is appears and active.
      And The  user clicks Confirm button.
      And It is verified that the Application Form page is opened.

    @TC_007
    Scenario: When the Apply button is clicked, the message "Loan application submitted successfully" should appear.

      Given Click the Plans button in the header section of the home page.
      And Click on the Basic Loan button.
      And Click the Apply Now button.
      And Amount are entered within the range of minimum and maximum values.
      And The  user clicks Confirm button.
      And The user clicks Apply button .
      And It is verified that the text Loan application submitted successfully' appears.

