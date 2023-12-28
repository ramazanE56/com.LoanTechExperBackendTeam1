
Feature: As a visitor, I would like to have menu titles on the top bar of the Home Page that will make it easier to access the site.

  Background:Users use these steps to log in to the site.
    * Navigate to given "Url"

  Scenario: TC_01: Verify that email, phone and address information at the top of the home page is visible
    * Verify that the  email information at the top of the home page is visible
    * Verify that the  phone information at the top of the home page is visible
    * Verify that the address information at the top of the home page is visible
    * close page

  Scenario:  TC_02: The site logo, Home, About, Plans, Blogs, Contact, Login Icon, Get Started Icon must be visible and active on the top bar of the home page.
    * Verify that the site logo is Visible and active on the top bar of the home page
    * Verify that the Home Button is Visible  and active on the top bar of the home page
    * Verify that the About Button Link is Visible and active on the top bar of the home page
    * Verify that the Plans Button Link is Visible and active on the top bar of the home page
    * Verify that the Blogs Button Link is Visible on the and active on the top bar of the home page
    * Verify that the Contact Button Link is Visible on the and active on the top bar of the home page
    * Verify that the Login Icon Button Link is Visible on the and active on the top bar of the home page
    * Verify that the Get Started Button Link is Visible on the and active on the top bar of the home page
    * close page

  Scenario:  TC_03: Verify that you can go to home page when you click logo
    * Click the logo on the top bar of the home page
    * Verify that go to the home page when you click on the logo on the top bar of the home page
    * close page

  Scenario:  TC_04: Verify that you can switch to the relevant page when you click Home, About, Plans, Blogs, Contact, Login Icon, Get Started Icon on the top bar of the home page
    * Click Home on  top bar of the home page
    * Verify that the Home page is opened when click the Home on  top bar of the home page
    * click the About on  top bar of the home page
    * Verify that the About page is opened when click the About on  top bar of the home page
    * click the Plans on  top bar of the home page
    * Verify that the Plans page is opened when click the Plans on  top bar of the home page
    * click the blogs on  top bar of the home page
    * Verify that the Blogs page is opened when click the blogs on  top bar of the home page
    * click the Contact on  top bar of the home page
    * Verify that the Contact page is opened when click the Contact on  top bar of the home page
    * click the Login Icon on  top bar of the home page
    * Verify that the Login page is opened when click the Login Icon on  top bar of the home page
    * click the Get Started on  top bar of the home page
    * Verify that the Register page is opened when click the Get Started on  top bar of the home page
    * close page