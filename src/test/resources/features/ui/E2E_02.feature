@e2e02
Feature: E2E_02 E2E testing is performed by following the steps below
  Scenario: Registered user creates and submits a new withdrawal value from the withdrawal tab
    * The user enters site with the given "Url"
    * Click on login button
    * send registered "username" to username text box
    * send registered "sifre" to password text box
    * Click on submit button
    * registered user clicks on the withdraw tab
    * Click the select GetAway
    * Click on the amounth
    * Send 100 to the box
    * Click on Sumit under the Withdraw Via IT text that appears.
    * Close the page
  Scenario: Admin approves pending withdrawal and manage an active users and send message and change some information about profile
    * Navigate to Admin page "adminUrl"
    * send adminUserName to username textbox
    * send adminPasword to password textbox
    * click on the login button
    * Admin clicks on the withdrawals tab
    * Admin selects the pending withdrawals tab.
    * Admin clicks on the details button of user ismail
    * admin copies ismails Trx Number
    * Admin clicks on the approve button
    * admin writes ismails Trx Number in the Approve Withdrawal Confirmation box
    * Click on the submit button
    * Click on the Approved Withdrawals tab
    * admin verifies that ismails withraw is approved
    * admin clicks on the manages users tab
    * admin clicks on the active users tab
    * admin writes ismailtemiz in the usernameEmail box and clicks the search button.
    * admin clicks on the details button
    * admin clicks the Notifications button
    * admin clicks the Send  Notifications button
    * admin writes subject in the Subject box
    * admin writes Merhaba İsmail ben LoanTechExperden Yetiş LoanTechExper yönetim ekibi olarak bu ayın en çok aktif kullanıcısı olarak sizi seçtik Bundan dolayı size bir sürprizimiz var Sizin tüm loan planlarınıza %1 indirim uyguladık. Hayırlı olsun LoanTechExper olarak bizi tercih ettiğiniz için çok teşekkür ederiz in the Messagebox
    * Click on the submit button on message page
    * admin clicks on his name at the top right and clicks on profile
    * By updating the admin profile name it writes its own name instead of Super Admins
    * Click the Upload File button and upload a profile photo.
    * Close the page
