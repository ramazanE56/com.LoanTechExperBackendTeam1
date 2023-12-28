
Feature: US18 : As a registered user, I want to have a page where I can see my Credit plans and get Credit.

  Background:Users use these steps to log in to the site.

    * The user enters site with the given "Url"


  Scenario: TC01 : In order to manage loan transactions on the Dashboard page,
            there must be a "Take Loan" link element in the navbar on the left and it must be verified that
            when clicked, it is directed to the "Loan Plans" page.

    * Click on the login button
    * The registered "usernameIsmail" is entered in the Username Or Email box.
    * Registered user "password" is entered in the Your Password box.
    * Click on the login button to log in.
    * Verify that the Take Loan tab is visible
    * Click on the Take Loan button
    * Verify that Loan Plans appears
    * Close the page


    Scenario: TC02 : When the Car Loan 2 button is clicked on the Loan Plans page,
              the "Personal Finance Loan" card and Take Minimum $2,000.00 Take Maximum $5,000.00
              Per Installment 4% Installment Interval 20 Days Total Installment 20 information"
              and the "Apply Now" button will appear and verify that it is active

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the car loan button
      * Verify that Personal Finance Loan is visible
      * Verify that Take Maximum is visible
      * Verify that "$2,000.00" is visible
      * Verify that Take Minimum is visible
      * Verify that the "$5,000.00" is visible
      * Verify that Per Installment is visible
      * Verify this "4%" is visible
      * Verify that Installment Interval is visible
      * Verify that 20 Days is visible
      * Verify that Total Installment is visible
      * Verify that 20 is visible
      * Verify that Apply Now is visible
      * Verify that the Apply Now button is clickable
      * Close the page


    Scenario: TC03 : It must be verified that when the Apply Now button is clicked,
              you can go to the "Apply for Personal Finance Loan" page.

      * Click on the Login button.
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the car loan button
      * Click on the Apply Now button
      * Verify that Apply for Personal Finance Loan appears
      * Close the page


    Scenario: TC04 : On the "Apply for Personal Finance Loan" page,
              the "Amount" value "Minimum Amount $2,000.00 -Maximum Amount $5,000.00"
              should be entered and the "Confirm" button should be visible and active and when clicked,
              a successful registration should be confirmed.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the car loan button
      * Click on the Apply Now button
      * A number between "2000" and "5000" is entered in the Enter An Amount box
      * Verify that Confirm text is visible
      * Click on the Confirm button
      * Close the page


    Scenario: TC05 : When the "Basic Loan" button is clicked on the Loan Plans page,
              the titles "Basic Loan 1","Test_Loan","Car Loan 9" should be seen and the "Apply Now" button
              under any card should be visible and it should be verified that it is active.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Verify that Apply Now is visible
      * Verify that the Apply Now button is clickable
      * Close the page


    Scenario: TC06 : When the Apply Now button is clicked, an "Amount" value
              within the range of "Take Minimum / Take Maximum" values should be entered.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the basic Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Verify that Application Form text is visible
      * Close the page


    Scenario: T07 :  Plan Name, Loan Amount, Total Installment, Per Installment, You'll Need To Pay,
              Application Fee" fields became visible under the heading
              "You are applying to take loan (Be Sure Before Confirm)

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the basic Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Verify that Plan Name appears
      * Verify that Loan Amount appears
      * Verify that Total Installment appears
      * Verify that Per Installment appears
      * Verify that You'll Need To Pay appears
      * Verify that Application Fee text is visible
      * Close the page


    Scenario: TC08 : It must be verified that the selected loan card name and the "Apply" button
              are visible under the Application Form heading.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the Test Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Verify that Application Form appears
      * Verify that Test Loan is written in the box under Application Form
      * Verify that Apply appears
      * Close the page


      Scenario: TC09 : It should be verified that the "Loan application submitted successfully"
                message appears when the Apply button is clicked.

        * Click on the login button
        * The registered "usernameIsmail" is entered in the Username Or Email box.
        * Registered user "password" is entered in the Your Password box.
        * Click on the login button to log in.
        * Click on the Take Loan button
        * Click on the basic loan button
        * Click on the Test Loan Apply Now button
        * A number between "5000" and "15000" is entered in the Enter An Amount box
        * Click on the Confirm button
        * Click on the Apply button under the Application Form Text
        * Verify that the Loan application submitted successfully message appears
        * Close the page


    Scenario: TC10 : It must be verified that the transaction made on the My Loans page is visible

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the Test Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Click on the Apply button under the Application Form Text
      * Verify that Test_Loan appears
      * Close the page


  Scenario: TC11 : To search for a transaction, the "Search By Loan Number" text box must be visible and active.
            It must be verified that filtering can be done under the "Loan Status" heading.

    * Click on the login button
    * The registered "usernameIsmail" is entered in the Username Or Email box.
    * Registered user "password" is entered in the Your Password box.
    * Click on the login button to log in.
    * Click on the Take Loan button
    * Click on the basic loan button
    * Click on the Test Loan Apply Now button
    * A number between "5000" and "15000" is entered in the Enter An Amount box
    * Click on the Confirm button
    * Click on the Apply button under the Application Form Text
    * Verify that the Search By Loan Number text box is visible
    * The last created Test_LOan Loan number is entered into the Search By Loan Number text box.
    * Click on the lens logo
    * Test_Loan Verifies that the Loan number appears in the table as uniq
    * Click on the arrow sign in the Loan Status box select "pending" status from the dropdown menu that opens.
    * It is verified that pending status codes are displayed filtered in the table.
    * Close the page


    Scenario: TC12 : The "Installments" button must be visible and active for
              the running process on the My loans page. Clicking
              the button verifies that the "Loan Installments" page is accessible

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the Test Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Click on the Apply button under the Application Form Text
      * Click on the arrow sign in the Loan Status box select "running" status from the dropdown menu that opens.
      * Click on the running button
      * Verify that the Installment box is visible in the bar that opens
      * Verify that the Installment box is clickable
      * Click on the Installment box
      * Verify that Loan Installments is displayed on the page that opens
      * Close the page


      Scenario: TC13 : The "Installments" button must be visible and active for
                the running process on the My loans page. Clicking the button verifies
                that the "Loan Installments" page is accessible

        * Click on the login button
        * The registered "usernameIsmail" is entered in the Username Or Email box.
        * Registered user "password" is entered in the Your Password box.
        * Click on the login button to log in.
        * Click on the Take Loan button
        * Click on the basic loan button
        * Click on the Test Loan Apply Now button
        * A number between "5000" and "15000" is entered in the Enter An Amount box
        * Click on the Confirm button
        * Click on the Apply button under the Application Form Text
        * Click on the arrow sign in the Loan Status box select "running" status from the dropdown menu that opens.
        * Click on the running button
        * Click on the Installment box
        * Verify that the Loan Number value appears
        * Verify that the Loan Amount value appears
        * Verify that the Plan value appears
        * Verify that the value Per Installment appears
        * Verify that the Needs to Pay value appears
        * Verify that the Delay Charge value appears
        * Close the page


  Scenario: TC14 : Verify that the installment plan list is displayed

    * Click on the login button
    * The registered "usernameIsmail" is entered in the Username Or Email box.
    * Registered user "password" is entered in the Your Password box.
    * Click on the login button to log in.
    * Click on the Take Loan button
    * Click on the basic loan button
    * Click on the Test Loan Apply Now button
    * A number between "5000" and "15000" is entered in the Enter An Amount box
    * Click on the Confirm button
    * Click on the Apply button under the Application Form Text
    * Click on the arrow sign in the Loan Status box select "running" status from the dropdown menu that opens.
    * Click on the running button
    * Click on the Installment box
    * The installment plan list should be displayed.
    * Close the page


    Scenario: TC15 : List headings (S.N.,Installment Date,Given On,Delay)
              Headings should be displayed. It should be verified that the values are visible in the list.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the Test Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Click on the Apply button under the Application Form Text
      * Click on the arrow sign in the Loan Status box select "running" status from the dropdown menu that opens.
      * Click on the running button
      * Click on the Installment box
      * Verify that the S.N. Header is displayed
      * Verify that the Installment Date Header is displayed
      * Verify that the Given On Header is displayed
      * Verify that the Delay Header is displayed
      * Close the page

  @wip
    Scenario: TC16 : To move from the My Loans page to the Take Loan page,
              the "Take Loan" button appears and must be verified as active.

      * Click on the login button
      * The registered "usernameIsmail" is entered in the Username Or Email box.
      * Registered user "password" is entered in the Your Password box.
      * Click on the login button to log in.
      * Click on the Take Loan button
      * Click on the basic loan button
      * Click on the Test Loan Apply Now button
      * A number between "5000" and "15000" is entered in the Enter An Amount box
      * Click on the Confirm button
      * Click on the Apply button under the Application Form Text
      * Verify that the Take Loan tab is visible
      * Click on the Take Loan button
      * Verify that Loan Plans appears on the page that opens
      * Close the page



