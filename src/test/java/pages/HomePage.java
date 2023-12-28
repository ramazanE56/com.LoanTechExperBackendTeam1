package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage extends ReusablePageElements {


    @FindBy(xpath = "//img[@alt='viserhyip']")
    public WebElement loanTechLogoElement;




@FindBy(xpath= "//a[@class='btn btn--xl xl-text btn--base btn--outline mt-3']")
public WebElement getStartedButonElement;

    @FindBy(xpath = "//h2[normalize-space()='Register']")
    public WebElement registerTextElement;

    @FindBy(xpath = "//h3[@class = 'text-capitalize text-center mt-0 mb-4']")
    public WebElement WelcomeToLoantechExpertTextElement;


// ---- Arif Emre Home Page ----
@FindBy(xpath = "(//*[@href=\"https://qa.loantechexper.com/contact\"])[1]")
    public WebElement contactElementi;

@FindBy(xpath = "//*[@class=\"hero__content-title text-capitalize t-text-white\"]")
    public WebElement contactUsGorunumElementi;

@FindBy(xpath = "//*[@aria-current=\"page\"]")
    public WebElement homeElementi;

@FindBy(xpath = "//*[@class=\"footer\"]")
    public WebElement footerElementi;
@FindBy(xpath = "(//*[@class=\"t-link t-link--primary t-text-white text-capitalize\"])[3]")
    public WebElement contactUsElementi;
@FindBy(xpath = "//*[@class=\"address\"]")
    public WebElement adresBilgisiElementi;
@FindBy(xpath = "(//*[@class=\"d-flex align-items-center bg--light-1 p-3 p-lg-4\"])[1]")
    public WebElement officeAddressElementi;
@FindBy(xpath = "(//*[@class=\"d-flex align-items-center bg--light-1 p-3 p-lg-4\"])[2]")
    public WebElement emailAddressElementi;
@FindBy(xpath = "(//*[@class=\"d-flex align-items-center bg--light-1 p-3 p-lg-4\"])[3]")
    public WebElement mobileNumberElementi;
@FindBy(xpath = "//*[@class=\"query bg--light-1\"]")
    public WebElement sendYourMessagesElementi;
@FindBy(xpath = "(//*[@type=\"text\"])[1]")
    public WebElement yourNameBoxElementi;
@FindBy(xpath = "(//*[@type=\"email\"])[1]")
    public WebElement emailAddressBoxElementi;
@FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElement subjectBoxElementi;
@FindBy(xpath = "//*[@name=\"message\"]")
    public WebElement writeYourMessageBoxElementi;
@FindBy(xpath = "(//*[@type=\"submit\"])[1]")
    public WebElement sendMessageButonElementi;
@FindBy(xpath = ("//p[@class='iziToast-message slideIn']"))
    public WebElement ticketCreatedSuccessfullyElementi;

@FindBy(xpath = "//*[@href=\"javascript:void(0)\"]")
    public WebElement cookiesElementi;
@FindBy(xpath = "(//iframe)[1]")
    public WebElement iframeElementi;


@FindBy (xpath = "//a[normalize-space()='Login']")
    public WebElement LoginIcon;

@FindBy (xpath = "//input[@id='username']")
    public WebElement usernameTextBox;

@FindBy (xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

@FindBy (xpath = "//button[normalize-space()='Login']")
    public WebElement LoginButton;


    // Home page Login (Halit)

    @FindBy(xpath = "//a[@class='btn btn--base btn--xl w-100 policy']")
    public WebElement cocies;
    @FindBy(xpath = "(//*[@class='btn btn--md btn--base fw-bold w-100'])[2]")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@name='username']")
    public WebElement emailBox;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement loginbutton2;
    @FindBy(xpath = "(//a[@class='logo'])[1]")
    public WebElement homePageLogo;
    @FindBy(xpath = "(//*[@class='btn btn--md btn--base fw-bold w-100'])[2]")
    public WebElement homePageDashboard;
    @FindBy(xpath = "(//*[@class='mb-0 vf-info-list__text'])[1]")
    public WebElement emailInformation;
    @FindBy(xpath = "(//*[@class='mb-0 vf-info-list__text'])[2]")
    public WebElement addressInformation;
    @FindBy(xpath = "//*[@class='mb-0 fw-md vf-info-list__text']")
    public WebElement phoneInformation;
    @FindBy(xpath = "(//*[@class='nav-item'])[1]")
    public WebElement userHomeButton;
    @FindBy(xpath = "(//*[@class='nav-item'])[2]")
    public WebElement userAboutButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement aboutText;
    @FindBy(xpath = "(//*[@class='nav-item'])[3]")
    public WebElement userPlansButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement plansText;
    @FindBy(xpath = "(//*[@class='nav-item'])[4]")
    public WebElement userBlogsButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement blogsText;
    @FindBy(xpath = "(//*[@class='nav-item'])[5]")
    public WebElement userContactButton;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement contactText;

    @FindBy(xpath = "//h2")
    public WebElement loginText;
    @FindBy(xpath = "//*[@class='btn btn--xl xl-text btn--base btn--outline mt-3']")
    public WebElement userGetStartedButton;
    @FindBy(xpath = "//*[text()='ACCOUNT BALANCE']")
    public WebElement getStartedPage;
    @FindBy(xpath = "//*[@id='pills-basic-loan-tab']")
    public WebElement basicLoanCard;
    @FindBy(xpath = "(//*[@class='plan-name'])[5]")
    public WebElement titleBasicLoan1;
    @FindBy(xpath = "(//*[@class='plan-name'])[6]")
    public WebElement titleCarLoan;
    @FindBy(xpath = "(//*[@class='plan-name'])[7]")
    public WebElement titleTestLoan;
    @FindBy(xpath = "//body[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/button[1]")
    public WebElement applyNowButton;
    @FindBy(xpath = "//*[@class='modal-header']")
    public WebElement basicLoan1Page;
    @FindBy(xpath = "//*[@name='amount']")
    public WebElement amountBox;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement concainerType;
    @FindBy (xpath = "(//*[@type='submit'])[2]")
    public WebElement comfirmButton;
    @FindBy (xpath = "//*[text()='Application Form']")
    public WebElement applicationFormButton;
    @FindBy (xpath = "//*[@type='submit']")
    public WebElement applyButton;
    @FindBy (xpath = "//*[text()='Loan application submitted successfully']")
    public WebElement mesaggeText;


// -------------------------------------------------------
    // -------------------------------------------------------
    /* SUPHİ */

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg navbar-light']")
    public WebElement homePageHeaderElement;

    @FindBy(xpath = "//a[text()='Plans']")
    public WebElement plansLinkElement;

    @FindBy(xpath = "//h2[@class='hero__content-title text-capitalize t-text-white']")
    public WebElement loanPlansPageTitleElement;

    @FindBy(xpath = "//a[@class='t-link breadcrumbs__link text-uppercase t-text-white t-link--primary']")
    public WebElement loanPlansPageHomeLinkElement;

    @FindBy(xpath = "//h1[@class='hero__content-title text-capitalize t-text-white']")
    public WebElement goHomePageVerifyElement;

    @FindBy(xpath = "(//a[@class='t-link t-link--primary t-text-white text-capitalize'])[1]")
    public WebElement importantLinkLoanPlansElement;

    @FindBy(xpath = "//button[@id='pills-basic-loan-tab']")
    public WebElement basicLoanTitleElement;

    @FindBy(xpath = "//h4[text()='Basic Loan 1']")
    public WebElement basicLoan1Element;

    @FindBy(xpath = "//button[@data-planname='Basic Loan 1']")
    public WebElement basicLoan1ApplyNowElement;

    @FindBy(xpath = "//h3[@class='text-center mt-3']")
    public WebElement applyNowWorks;

    @FindBy(xpath = "(//a[@class='btn btn--md btn--base fw-bold w-100'])[2]")
    public WebElement loginButtonElement;



// -------------------------------------------------------




    @FindBy(xpath = "//*[@class='account d-none d-lg-block']")
    public WebElement firstLogin;
    //eyyup
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;
    //eyyup
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    //eyyup
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement login2;
    //eyyup

    @FindBy(xpath = "(//a[@href='https://qa.loantechexper.com/user/logout'])[1]")
    public WebElement logoutButton;
    //eyyup

    @FindBy(xpath = "//a[@href='javascript:void(0)']")
    public WebElement AllowYaziElementi;
    //eyyup


    @FindBy(xpath = "//a[@class='btn btn--dark btn--smd']")
    public WebElement withDrow;

    @FindBy(xpath = "//select[@class='form-select form--control']")
    public WebElement selecGetAway;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amountBoxElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SubmitElement;


}
