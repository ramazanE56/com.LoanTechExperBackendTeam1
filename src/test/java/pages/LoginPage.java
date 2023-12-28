package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage extends ReusablePageElements {


    @FindBy(id = "username")
    public WebElement userNameBoxElement;

    @FindBy(id = "email")
    public WebElement emailBoxElement;

    @FindBy(xpath = "//div[@class='nice-select']")
    public WebElement countryDropDownElement;

    @FindBy(xpath = "//input[@name='mobile']")
    public WebElement mobileNumberElement;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordElement;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    public WebElement confirmPasswordElement;

    @FindBy(xpath = "//li[@data-value='France']")
    public WebElement countryDropDownSelectedElement;

    @FindBy(xpath = "//button[@class='btn btn--base btn--xxl w-100 text-capitalize xl-text']")
    public WebElement userLoginButtonElement2;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameElement;

    @FindBy(xpath = "//button[@class='btn btn--base btn--xxl w-100 text-capitalize xl-text']")
    public WebElement userLoginButtonElement;



    @FindBy(xpath = "(//i[@class='bx bxs-hide'])[1]")
    public WebElement passwordBoxEyeIconElement;

    @FindBy(id = "agree")
    public WebElement iAgreeTikElement;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstnameBoxElement;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastnameBoxElement;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressBoxElement;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateBoxElement;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipBoxElement;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityBoxElement;

    @FindBy(xpath = "//h4[@class='text-capitalize text-center mb-4 mt-0']")
    public WebElement pleaseComplateYourProfileTextElement;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitButtonElement;

    @FindBy(id = "recaptcha")
    public WebElement registerButtonElement;

    @FindBy(css = ".iziToast-message")
    public WebElement registrationSuccessfullyElement;


    @FindBy (xpath = "//a[@href='javascript:void(0)']")
    public WebElement cookiesAccept;

    @FindBy (xpath = "(//a[@class='btn btn--md btn--base fw-bold w-100'])[2]")
    public WebElement loginButtonElement;


    @FindBy(xpath = "//*[@class='auth-form__content section']")
    public WebElement loginformu;

    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement rememberCheckbox;

    @FindBy(xpath = "//*[@class='forgot-pass text-decoration-none']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//*[@class='btn btn--base btn--xxl w-100 text-capitalize xl-text']")
    public WebElement userLoginSubmit;

    @FindBy(xpath = "//*[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement messageWrong;

    @FindBy(xpath = "//*[@placeholder='Username or Email']")
    public WebElement userNameText;
    @FindBy(xpath = "//*[@placeholder='Your password']")
    public WebElement userPasswordText;

    @FindBy(xpath = "//*[@class='auth-form__input']")
    public WebElement resetAccount;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement succesfullMessage;

    @FindBy(xpath = "//*[@href='https://qa.loantechexper.com/user/password/reset']")
    public WebElement tryResetAgain;

    @FindBy(xpath = "//*[@class='form-control overflow-hidden']")
    public WebElement code;

    @FindBy(xpath = "//*[@class='text-decoration-none']")
    public WebElement registerLink;







}
