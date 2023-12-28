package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class AdminLoginPage extends ReusablePageElements {




    // AdminLoginPage (Samet)

    @FindBy (xpath = "//p[@class='text-white']")
    public WebElement AdminDashboardyazielementi;

    @FindBy (xpath = "//input[@type=\"text\"]")
    public WebElement Usernametextbox;

    @FindBy (xpath = "//input[@type=\"password\"]")
    public WebElement Passwordtextbox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement Loginbutton;

    @FindBy(xpath = "(//img[@alt='image'])[1]")
    public WebElement logo;

    @FindBy(xpath = "//span[@class='navbar-user__name']")
    public WebElement logoutmenu;

    @FindBy (xpath = "(//span[@class='dropdown-menu__caption'])[3]")
    public WebElement logoutbutton;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//span[text()='Manage Users']")
    public WebElement manageUsersButton;
    @FindBy(xpath = "(//*[text()='Active Users'])[1]")
    public WebElement activeUsersButton;

    @FindBy(xpath = "//*[@class='btn btn-sm btn-outline--primary']")
    public WebElement detailsButton;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement enterbutton;
    @FindBy(xpath = "(//*[@type='search'])[2]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement userDetailPage;

    @FindBy(xpath = "//*[text()='User']")
    public WebElement headerUser;
    @FindBy(xpath = "//*[text()='Email-Phone']")
    public WebElement headerEmailPhone;

    @FindBy(xpath = "//*[text()='Country']")
    public WebElement headerCountry;

    @FindBy(xpath = "//*[text()='Joined At']")
    public WebElement headerDate;
    @FindBy(xpath = "//*[text()='Balance']")
    public WebElement headerBalance;
    @FindBy(xpath = "//*[text()='Action']")
    public WebElement headerAction;

    @FindBy(xpath = "(//*[@class='page-link'])[11]")
    public WebElement secondPage;
    @FindBy(xpath = "//tr")
    public WebElement activeUserList;
    @FindBy(xpath = "(//*[text()='View All'])[1]")
    public WebElement viewAllIcon;
    @FindBy(xpath = "//*[text()='Transaction Logs']")
    public WebElement transactionLogsPage;
    @FindBy(xpath = "//*[text()='User']")
    public WebElement titleTransactionUser;
    @FindBy(xpath = "//*[text()='TRX']")
    public WebElement titleTransactionTRX; //
    @FindBy(xpath = "//*[text()='Transacted']")
    public WebElement titleTransactionTransacted;
    @FindBy(xpath = "//*[text()='Amount']")
    public WebElement titleTransactionAmount;
    @FindBy(xpath = "//*[text()='Post Balance']")
    public WebElement titleTransactionBalance;
    @FindBy(xpath = "//*[text()='Details']")
    public WebElement titleTransactionDetails;
    @FindBy(xpath = "//*[@id='search']")
    public WebElement searcTransaction;
    @FindBy(xpath = "//*[@id='trx_type']")
    public WebElement typeTransaction;
    @FindBy(xpath = "//*[@id='remark']")
    public WebElement remarkTransaction;
    @FindBy(xpath = "//*[@name='date']")
    public WebElement dateTransaction;
    @FindBy(xpath = "(//*[@data-date='1'])[1]")
    public WebElement dateStart;
    @FindBy(xpath = "//*[@data-date='20']")
    public WebElement dateFinish;
    @FindBy(xpath = "(//*[text()=' Filter'])[2]")
    public WebElement filterIcon;

    @FindBy(xpath = "//input[@*='username']")
    public WebElement adminUserNameBoxElement;

    @FindBy(xpath = "//input[@*='password']")
    public WebElement adminPasswordBoxElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminLoginButtonElement;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement adminUserNameBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement adminPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminLoginButton;

    // TC_07>US_37
    @FindBy(xpath = "(//*[@class='flex-fill'])[1]")
    public WebElement addBalance;
    @FindBy(xpath = "(//*[@class='modal-header'])[1]")
    public WebElement addBalancePage;
    @FindBy(xpath = "//*[@id='amount']")
    public WebElement addBalanceAmount;
    @FindBy(xpath = "//*[@id='remark']")
    public WebElement addBalanceRemark;
    @FindBy(xpath = "//*[@id='remark']")
    public WebElement addBalanceSubmit;



}


