
Feature: US09 : As a visitor, I want the site to have a Contact page with contact information so that I can contact the company.
  Background: Users use these steps to log in to the site.
    Given The user enters the site with the given "UrlOne"

    Scenario: TC01 :It must be possible to verify that the contact information on the Contact Us page is active.
      Given click cookies
      Given Click on the Contact tab.
      * It is verified that the Contact Us page is opened.
      * Home button is clicked
      * Go down to the footer section
      * Verify that the Contact Us option is visible and active
      * Click on the Contact Us option in the Footer section.
      * The company's email, telephone and address contact information must be visible.
      * Form to send messages to the Company on the Contact Us page must be visible.
      * switch to iframe
      * Verify that address information is visible on the map
      * The page is closed.

    Scenario: TC02 : The send your messages section on the Contact Us page must be filled in and a message sent to the company.

    * Click on the Contact tab.
    * It goes down to the Send Your Messages section.
    * wait2
    * click cookies
    * wait2
    * The Send Your Messages form is filled out.
    * wait2
    * The send message button is clicked
    * Verifies that a message has been sent to the company.
    * The page is closed.
