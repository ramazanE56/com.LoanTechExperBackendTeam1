Feature: US16 : As a registered user, I want to be able to see my deposits and make transactions.

  Scenario: TC01 : As a registered user I should be able to view and trade my deposits

    Given go to specified site "userUrl"
  * wait2
  * click cookies
  * wait2
  * Username information is entered
  * wait2
  * Password information is entered
  * wait2
  * Click on the login buttonn
  * Click on the Deposit tab.
  * It appears that the Deposit Methods page has opened.
  * Click on the deposit history tab and the deposit history page opens.
  * The transaction accordion table is displayed on the Deposit History page
  * Deposit now is clicked and the deposit methods page opens.
  * Click on the Select Gateway menu and select manual.
  * Click on the Amount textbox and enter a value between min and max.
  * Limit-Charge-Payable values are displayed.
  * Click on the Submit button.
  * You have requested "1,000.00" USD , Please pay "1,120.00" USD for successful payment appears.
  * The page is closed.

  Scenario: TC02 : I should be able to see the Deposit History page open when the PAY NOW button is clicked.

    Given go to specified site "userUrl"
    * wait2
    * click cookies
    * wait2
    * Username information is entered
    * wait2
    * Password information is entered
    * wait2
    * Click on the login buttonn
    * Click on the Deposit tab.
    * Click on the Select Gateway menu and select manual.
    * Click on the Amount textbox and enter a value between min and max.
    * Click on the Submit button.
    * Click on the PAY NOW button and go to the Deposit History page.
    * The text You have deposit request has been taken is displayed
    * The transaction accordion table is displayed on the Deposit History page
    * The page is closed.

  Scenario: TC03 : When the "Deposit Now" button is clicked on the "Deposit History" page, I should be able to move to the "Deposit Methods" page.
    Given go to specified site "userUrl"
    * wait2
    * click cookies
    * wait2
    * Username information is entered
    * wait2
    * Password information is entered
    * wait2
    * Click on the login buttonn
    * Click on the Deposit tab.
    * Click on the deposit history tab and the deposit history page opens.
    * Deposit now is clicked and the deposit methods page opens.
    * It appears that the Deposit Methods page has opened.
    * The page is closed.