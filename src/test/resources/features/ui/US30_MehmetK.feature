
Feature: As an admin, I want to have the All Loans page to display all loans on a single page


  Scenario: As an administrator, it has been tested whether all loan features on the "All Loans" page are working
    * Navigate to Admin page "adminUrl"
    * send "username registered" to username textbox
    * send "password registered" to password textbox
    * click on the login button
    * click Loans link element
    * click All Loans link element
    * verify that All Loans Table visible
    * send the first Loans "loanNo" to LoanNo searchbox
    * click searchbox icon
    * verify the first loans visible
    * click Date textbox
    * send "date" to Date textbox
    * click Date searchbox icon
    * Verify that you can search the AllLoans table on the AllLoans page with the Date information.
    * On the All loans page click the details button on the first line
    * verify that plan name visible on the Loan Details page
    * verify that date of Application visible on the Loan Details page
    * verify that Loan Number visible on the Loan Details page
    * verify that Amount visible on the Loan Details page
    * verify that Per İnstallment visible on the Loan Details page
    * verify that Total installment visible on the Loan Details page
    * verify that Given installment visible on the Loan Details page
    * verify that Total Payable visible on the Loan Details page
    * verify that Profit visible on the Loan Details page
    * verify that status visible on the Loan Details page
    * verify that status of LoanForm visible on the Loan Details page
    * return to previous page
    * On the AllLoans page, click the installments button on the first line
    * verify that Loan Number visible on the Installment page
    * verify that Plan visible on the Installment page
    * verify that Loan Amount visible on the Installment page
    * verify that Per Installment visible on the Installment page
    * verify that Total Installment visible on the Installment page
    * verify that Given Installment visible on the Installment page
    * verify that Receivable visible on the Installment page
    * verify that DelayCharge visible on the Installment page
    * verify that SN visible on the Installment page
    * verify that Installment Date visible on the Installment page
    * verify that Given On visible on the Installment page
    * verify that Delay visible on the Installment page
    * verify that Charge visible on the Installment page
    * Click the back button to check if you can return to the AllLoans page
    * Verify that you are back to the All credits page
    * click the next button in the lower right corner of the page on the AllLoans page
    * Verify next page visible
    * Close the page