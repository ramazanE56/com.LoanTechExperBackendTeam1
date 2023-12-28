
Feature: US28 : As an administrator, I want to have a Due Loans page to view and process term loans.

  Background: Users use these steps to log in to the site.

    Given Open the web "browser"
    When Navigate to "UrlAdmin"
    When On the page that appears, fill in the "UsernameSamet" and "passwordAdmin" textboxes
    When Click the LOGIN button
    When On the page that appears click the Loans Menu tab
    When Click on the Due Loans page link



  Scenario: TC01: By clicking on the "Due Loans" page link under the Loans menu heading, the "Due Loans" page should be accessed

      And Verify that Due Loans page should be displayed
      Then Close the page

    Scenario: TC02: Due Installment Loans Table (with SN, Loan No.|Plan, User, Amount, Installment Amount, Installment, Created | Next Installment, Status information) should be displayed on the Due Loans page.

      And Verify that Due Loans Table is displayed successfully
      Then Close the page