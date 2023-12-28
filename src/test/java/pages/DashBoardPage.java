package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class DashBoardPage {


    @FindBy(xpath = "(//*[@class=\"auth-form__input\"])[1]")
    public WebElement userNameElementi;
    @FindBy (xpath = "//*[@placeholder=\"Your password\"]")
    public WebElement userPasswordElementi;
    @FindBy(xpath = "//*[@class=\"btn btn--base btn--xxl w-100 text-capitalize xl-text\"]")
    public WebElement loginButtonEmre;
    @FindBy (xpath = "(//*[@href=\"https://qa.loantechexper.com/user/deposit\"])[2]")
    public WebElement depositElementi;
    @FindBy(xpath = "//*[@class=\"mb-2\"]")
    public WebElement depositMethodsGorunum;
    @FindBy(xpath = "//*[@class=\"btn btn--base btn--smd\"]")
    public WebElement depositHistoryElementi;
    @FindBy(xpath = "//*[@class=\"accordion table--acordion\"]")
    public WebElement akordiyonElement;
    @FindBy(xpath = "//*[@class=\"btn btn--base btn--smd\"]")
    public WebElement depositNowElementi;
    @FindBy(xpath = "//*[@class=\"form--control form-select\"]")
    public WebElement selectGatewayElementi;
    @FindBy(xpath = "//*[@class=\"form-control form--control\"]")
    public WebElement amountElementi;
    @FindBy(xpath = "//*[@class=\"list-group\"]")
    public WebElement limitElement;
    @FindBy(xpath = "//*[@class=\"btn btn--base w-100 mt-3\"]")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@class=\"text-center mt-2\"]")
    public WebElement youhaveElementi;
    @FindBy(xpath = "//*[@class=\"btn btn--base w-100\"]")
    public WebElement payNow;
    @FindBy(xpath = "//p[@class='iziToast-message slideIn']")
    public WebElement youHaveDepositElementi;


    @FindBy(xpath = "(//span[@class='menu-title'])[2]")
    public WebElement menageUsersLink;
    //eyyup

    @FindBy(xpath = "(//span[@class='menu-title'])[3]")
    public WebElement activeUserLink;
    //eyyup


    @FindBy(xpath = "//div[@class='bodywrapper__inner']")
    public WebElement activeUserList;
    //eyyup

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-outline--primary'][normalize-space()='Details'])[1]")
    public WebElement detailsButton;
    //eyyup


    @FindBy(xpath = "//h6[@class='page-title']")
    public WebElement userDetailButton;
    //eyyup

    @FindBy(xpath = "//div[@class='row justify-content-center']")
    public WebElement listenHeaders;
    //eyyup


    @FindBy(xpath = "(//a[@class='widget-two__btn btn btn-outline--danger'])[1]")
    public WebElement viewAllButton;
    //eyyup


    @FindBy(xpath = "(//a[@class='item-link'])[1]")
    public WebElement approvedwithdrawals;
    //eyyup


    @FindBy(xpath = "(//a[@class='item-link'])[2]")
    public WebElement pendingwithdrawals;
    //eyyup



    @FindBy(xpath = "(//a[@class='item-link'])[3]")
    public WebElement rejectedwithdrawals;
    //eyyup

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-outline--primary ms-1'])[1]")
    public WebElement approvvedDetailsbutton;
    //eyyup


    @FindBy(xpath = "//ul[@class='list-group']")
    public List <WebElement> approvedUserInformation;
    //eyyup


    @FindBy(xpath = "(//span[@class='badge badge--warning'])[1]")
    public WebElement statusPending;
    //eyyup

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-outline--primary ms-1'])[1]")
    public WebElement pendingDetailsButton;
    //eyyup

    @FindBy(xpath = "//button[@class='btn btn-outline--success ms-1 approveBtn']")
    public WebElement pendingApproveButton;
    //eyyup


    @FindBy(xpath = "//button[@class='btn btn-outline--danger ms-1 rejectBtn']")
    public WebElement pendingRejectButton;
    //eyyup


    @FindBy(xpath = "(//textarea[@class='form-control pt-3'])[2]")
    public WebElement pendingRejecttext;
    //eyyup

    @FindBy(xpath = "(//button[@class='btn btn--primary w-100 h-45'])[2]")
    public WebElement pendingRejectSubmit;
    //eyyup

    @FindBy(xpath = "//*[text()='Withdrawal rejected successfully']")
    public WebElement pendingRejecdetsuccessfully;
    //eyyup


    @FindBy(xpath = "(//textarea[@class='form-control pt-3'])[1]")
    public WebElement pendingApproveText;
    //eyyup

    @FindBy(xpath = "(//button[@class='btn btn--primary w-100 h-45'])[1]")
    public WebElement pendingApproveSubmit;
    //eyyup

    @FindBy(xpath = "//*[text()='Withdrawal approved successfully']")
    public WebElement pendingapprovedsuccesfully;
    //eyyup


    @FindBy(xpath = "(//span[@class='badge badge--danger'])[1]")
    public WebElement statusRejected;
    //eyyup

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-outline--primary ms-1'])[1]")
    public WebElement rejectWithdravalsDetails;
    //eyyup

    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    public  List< WebElement> rejectCardinformation;
    //eyyup





    // -------------------------------------------------------
    /* SUPHİ */
    @FindBy(xpath = "//a[text()='Profile']")
    public WebElement userProfileLinkElement;

    @FindBy(xpath = "//h3[@class='mb-2']")
    public WebElement profileSettingElement;

    @FindBy(xpath = "(//li[@class='list-group-item d-flex flex-column gap-1 aling-items-center'])[1]")
    public WebElement profileNameElement;

    @FindBy(xpath = "(//li[@class='list-group-item d-flex flex-column gap-1 aling-items-center'])[2]")
    public WebElement profileEmailElement;

    @FindBy(xpath = "(//li[@class='list-group-item d-flex flex-column gap-1 aling-items-center'])[3]")
    public WebElement profilePhoneElement;

    @FindBy(xpath = "(//li[@class='list-group-item d-flex flex-column gap-1 aling-items-center'])[4]")
    public WebElement profileCountryElement;


    @FindBy(xpath = "//input[@class='form-control form--control']")
    public  WebElement profileFirstNameBoxElement;


    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement profileLastNameBoxElement;


    @FindBy(xpath = "//input[@name='zip']")
    public WebElement profileStateBoxElement;


    @FindBy(xpath = "//input[@name='zip']")
    public WebElement profileZipCodeBoxElement;



    @FindBy(xpath = "//input[@id='imageUpload']")
    public WebElement imageDosyaSecElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement profileSettingSubmitButtonElement;

    @FindBy(xpath = "//div[@class='iziToast-texts']")
    public WebElement profileUpdatedSuccessfullyElement;

    @FindBy(xpath ="//input[@name='firstname']")
    public WebElement firsnameBoxElement;

    @FindBy(xpath ="//input[@name='lastname']")
    public WebElement lastnameBoxElement;

    @FindBy(xpath ="//input[@name='state']")
    public WebElement stateBoxElement;

    @FindBy(xpath ="//*[text()='Profile']")
    public WebElement profileTabElement;

    @FindBy(xpath ="//input[@name='zip']")
    public WebElement zipBoxElement;

    @FindBy(xpath ="//input[@name='city']")
    public WebElement cityBoxElement;
    @FindBy(xpath ="//input[@name='address']")
    public WebElement addressBoxElement;


    @FindBy(xpath ="//button[@type='submit']")
    public WebElement submitButtonElement;
    @FindBy(xpath = "//a[@href='javascript:void(0)']")
    public WebElement allowTextElement;




    @FindBy (xpath = "//div[@id='dashboard-sidebar']//li[10]")
    public WebElement changePasswordButton;

    @FindBy (xpath = "//div[@class='mb-4']")
    public WebElement changePasswordText;

    @FindBy (xpath = "//input[@id='current_password']")
    public WebElement currentPasswordTextBox;

    @FindBy (xpath = "//input[@id='password']")
    public  WebElement newPasswordTextBox;

    @FindBy (xpath = "//input[@id='password_confirmation']")
    public WebElement confirmPasswordTextBox;

    @FindBy (xpath = "//button[normalize-space()='Submit']")
    public WebElement changePasswordSubmitButton;

    @FindBy (xpath = "//p[@class='iziToast-message slideIn']")
    public  WebElement changeMessageWarningMessage;

    @FindBy (xpath = "//div[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public  WebElement changeMessageSuccefullyMessage;

    @FindBy (css = "a[href='https://qa.loantechexper.com/user/loan/plans']")
    public  WebElement takeLoanTabElement;

    @FindBy (xpath = "//*[text()='Loan Plans']")
    public  WebElement loanPlansTextElement;

    @FindBy (id = "pills-car-loan-tab")
    public  WebElement carLoanButtonElement;

    @FindBy (xpath = "(//*[text()='Personel Finance Loan'])[1]")
    public  WebElement personalFinanceLoanTextElement;

    @FindBy (xpath = "(//*[text()='Take Maximum'])[3]")
    public  WebElement takeMaximumTextElement;


    @FindBy (xpath = "(//*[text()='Apply Now                                        '])[3]")
    public  WebElement applyNowButtonElement;

    @FindBy (xpath = "(//*[text()='Apply Now                                        '])[6]")
    public  WebElement basicLoanapplyNowButtonElement;

    @FindBy (xpath = "(//*[text()='Take Minimum'])[3]")
    public  WebElement takeMinimumElement;

    @FindBy (xpath = "//*[text()='$2,000.00']")
    public  WebElement $200000TextElement;

    @FindBy (xpath = "(//*[text()='Per Installment'])[3]")
    public  WebElement perInstallmentTextElement;

    @FindBy (xpath = "(//*[text()='6%'])[2]")
    public  WebElement text6PerElement;

    @FindBy (xpath = "(//*[text()='Installment Interval'])[3]")
    public  WebElement InstallmentIntervalTxtElement;

    @FindBy (xpath = "(//span[@class='plan-feature-list-amount'])[8]")
    public  WebElement days20TxtElement;

    @FindBy (xpath = "(//*[text()=' Total Installment'])[3]")
    public  WebElement totalInstallmentTxtElement;

    @FindBy (xpath = "(//*[text()='20'])[1]")
    public  WebElement text20TxtElement;

    @FindBy (xpath = "//h5[@id='exampleModalLabel']")
    public  WebElement applyForPersonalLoanTxtElement;

    @FindBy (xpath = "//h5[text()='Application Form']")
    public  WebElement applicationFormTxtElement;

    @FindBy (xpath = "//input[@placeholder='Enter An Amount']")
    public  WebElement enterAnAmountBoxElement;

    @FindBy (xpath = "//button[@type='submit']")
    public  WebElement confirmButtonElement;

    @FindBy (xpath = "(//button[@class='nav-link '])[2]")
    public  WebElement basicLoanButtonElement;

    @FindBy (xpath = "(//*[@class='caption'])[1]")
    public  WebElement planNameTxtElement;

    @FindBy (xpath = "(//*[@class='caption'])[2]")
    public  WebElement loanAmountTxtElement;

    @FindBy (xpath = "(//*[@class='caption'])[3]")
    public  WebElement totalInstallmenttTxtElement;

    @FindBy (xpath = "(//*[@class='caption'])[4]")
    public  WebElement perInstallmenttTxtElement;

    @FindBy (xpath = "(//*[@class='caption'])[5]")
    public  WebElement youllNeedToPayTxtElement;

    @FindBy (css = "div[class='card-body'] h4")
    public  WebElement applicationFeeTxtElement;

    @FindBy (xpath = "(//button[@class='btn btn-md btn--xl xl-text w-100 btn--base loanBtn'])[5]")
    public  WebElement applyNowTestLoanTxtElement;

    @FindBy (xpath = "//p[@class='caption-list-two p-3 bg--light']")
    public  WebElement underTheApplicationFormTxtBoxElement;

    @FindBy (xpath = "//button[@type='submit']")
    public  WebElement applyElement;





    public static WebElement webElementVariable(String amount) {
        WebElement element =  Driver.getDriver().findElement(By.xpath("//*[contains(text(),'" + amount + "')]"));
        return element;
    }

    @FindBy (xpath = "//div[@id='dashboard-sidebar']//li[5]")
    public WebElement withdrawButton;

    @FindBy (xpath = "//h3[@class='mb-2']")
    public WebElement withdrawMoneyText;

    @FindBy (xpath = "//label[@for='method_code']")
    public WebElement methodText;

    @FindBy (xpath = "//*[@name='method_code']")
    public WebElement dropDownSelector;

    @FindBy (xpath = "//input[@name='amount']")
    public WebElement amountTextBox;

    @FindBy (xpath = "//ul[@class='list-group text-center']")
    public WebElement limitTable;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement withdrawSubmitButton;

    @FindBy (xpath = "//h5[normalize-space()='Withdraw Via Method 5 Updated']")
    public WebElement method5UpdatedText;

    @FindBy (xpath = "//button[normalize-space()='Submit']")
    public WebElement methodUpdatedSubmitButton;

    @FindBy (xpath = "//div[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement withdrawSuccesAlertMessage;

    @FindBy (xpath = "//a[@class='btn btn--base btn--smd']")
    public WebElement withdrawMoneyButton;

    @FindBy (xpath = "//div[@id='transactionAccordion']")
    public WebElement historyTable;

    @FindBy (xpath = "//h3[normalize-space()='Withdraw History']")
    public WebElement withdrawHistoryText;

    @FindBy (xpath = "//a[normalize-space()='Withdraw Log']")
    public WebElement withdrawLogButton;

    @FindBy (xpath = "//div[@class='accordion-collapse collapse show']")
    public WebElement transactionTable;





















    // ***************ÜMİT***********************//

    // DashBoardPage->

    @FindBy(xpath = "(//h5[@class='text-secondary'])[1]")
    public WebElement successfulDepositsYText;

    @FindBy(xpath = "(//*[@class='text--secondary my-4'])[1]")
    public WebElement successfulDepositsAmount;

    @FindBy(xpath = "(//h5[@class='text-secondary'])[2]")
    public WebElement successfulWithdrawalsText;

    @FindBy(xpath = "(//*[@class='text--secondary my-4'])[2]")
    public WebElement successfulWithdrawalsAmount;
    @FindBy(xpath = "(//h5[@class='text-secondary'])[3]")
    public WebElement totalLoanText;

    @FindBy(xpath = "(//*[@class='text--secondary my-4'])[3]")
    public WebElement totalLoanAmount;

    @FindBy(xpath = " /html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/p/small")
    public WebElement totalLoanNumber;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement applyButtonUnderTheApplicationFormTextElement;

    @FindBy(xpath = "//p[@class='iziToast-message slideIn']")
    public WebElement loanApplicationSubmittedSuccessfullyTxtElement;


    @FindBy(xpath = "//div[@class='d-flex justify-content-between']")
    public WebElement TestLoanTakeLoanTextElement;

    @FindBy(xpath = "//input[@placeholder='Search By Loan Number']")
    public WebElement seachByLoanNumberBoxTextElement;

    @FindBy(xpath = "(//p[@class='text-muted font-size--14px'])[1]")
    public WebElement firstSeachByLoanNumberElement;

    @FindBy(xpath = "//*[@class='las la-search']")
    public WebElement lensLogoButtonElement;

    @FindBy(xpath = "(//p[@class='text-muted font-size--14px'])[3]")
    public WebElement secondSeachByLoanNumberElement;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement loanStatusArrowElement;

    @FindBy(xpath = "(//span[@class='badge badge--primary'])[1]")
    public WebElement runningbuttonElement;

    @FindBy(xpath = "(//a[@class='btn btn--outline-primary btn--sm '])[1]")
    public WebElement installmentstxtElement;

    @FindBy(tagName = "h3")
    public WebElement loaninstallmentstxtElement;

    @FindBy(xpath= "//*[text()='Loan Number']")
    public WebElement loanNumbertxtElement;

    @FindBy(xpath= "//*[text()='Loan Amount']")
    public WebElement loanAmounttxtElement;

    @FindBy(xpath= "//*[text()='Plan']")
    public WebElement plantxtElement;

    @FindBy(xpath= "//*[text()='Per Installment']")
    public WebElement perInstallmentElement;

    @FindBy(xpath= "//*[text()='Needs to Pay']")
    public WebElement needstoPayTxtElement;


    @FindBy(xpath= "//*[text()='Delay Charge']")
    public WebElement delayChargeTxtElement;


    @FindBy(xpath= "//tbody]")
    public WebElement allListElements;

    @FindBy(xpath= "//tr/th[1]")
    public WebElement snTxtElement;


    @FindBy(xpath= "//tr/th[2]")
    public WebElement installmentDateTxtElement;

    @FindBy(xpath= "//tr/th[3]")
    public WebElement givenOnTxtElement;

    @FindBy(xpath= "//tr/th[4]")
    public WebElement delayTxtElement;





}
