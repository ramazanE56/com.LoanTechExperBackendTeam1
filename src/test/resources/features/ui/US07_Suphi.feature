

Feature: US07: I would like to have a page where I, as a visitor, can access and select Loan Plans

  Background:Users use these steps to log in to the site.


  Scenario: TC01: The visitor should be able to access the 'Loan Plans' page by clicking on Plans from the Home menu title

    * The user enters site with the given "Url"
    * Click on the Plans link in the menu header
    * When going to the Plans link, it is verified that the Loan Plans page is accessed
    * Close the page

  Scenario: TC02:  The visitor should be able to see the 'Loan Plans' link under the Important Link heading
                   in the Footer section of the Homepage and go to the relevant page when clicking on the link

    * The user enters site with the given "Url"
    * Go to the end of the homepage
    * Click on the Loan Plans link under the Important Link heading and confirm that you are on the Loan Plans page
    * Close the page

  Scenario: TC03: Loan Plan Cards should be displayed under the Basic Loan heading on the Loan Plans Page,
                  and the Apply Now buttons under the cards should be visible and active.

    * The user enters site with the given "Url"
    * Click on the Plans link in the menu header
    * Select Basic Loan and see Loan Plan Cards under the Basic Loan heading
    * Click on the Apply Now button under one of the plans and verify that it works
    * Close the page

  Scenario: TC04: When you click on the Home \ Loan Plans links on the Loan Plans Page, you can go to the relevant pages.

    * The user enters site with the given "Url"
    * Click on the Plans link in the menu header
    * On the Loan Plans page, click on the Home link from the Home - Loan Plans options and go to the Home page
    * Close the page