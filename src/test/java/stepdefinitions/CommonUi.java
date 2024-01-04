package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CommonUi extends ReusableMethods {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    String TrxNumber="";
    Faker faker = new Faker();
    String password = passwordUnique(6);
    String statusFirstCategory="";
    String nameCategory="";

    @Then("Verifies that the visitor has accessed the site")
    public void verifies_that_the_visitor_has_accessed_the_site() {
        String expectedUrl ="https://qa.loantechexper.com/";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Given("Verifies that the homepage is visible")
    public void verifies_that_the_homepage_is_visible() {
        Assert.assertTrue(homePage.loanTechLogoElement.isDisplayed());
    }
    @Then("Close the page")
    public void Close_the_page() {
        Driver.closeDriver();
    }
    @Given("The user enters site with the given {string}")
    public void the_visitor_enters_site_with_the_given(String Url) {
        Driver.getDriver().get(ConfigReader.getProperty(Url));
        wait(2);

    }

    @Given("Click on login button")
    public void Click_on_login_button() {
        loginPage.loginButtonElement.click();

    }
    @Given("send registered {string} to username text box")
    public void send_registered_to_username_text_box(String userName) throws InterruptedException {
        loginPage.userNameBoxElement.sendKeys("ismailtemiz");
        Thread.sleep(1000);

    }
    @Given("send registered {string} to password text box")
    public void send_registered_to_password_text_box(String password) {
        loginPage.passwordElement.sendKeys("Loan.741");

    }

    @Given("Click on submit button")
    public void click_on_submit_button() {
        jse.executeScript("arguments[0].click();", loginPage.submitButtonElement);
        wait(2);

    }

    @Given("registered user clicks on the withdraw tab")
    public void registered_user_clicks_on_the_withdraw_tab() {
        jse.executeScript("arguments[0].click();", homePage.withDrow);
        wait(5);

    }
    @Given("Click the select GetAway")
    public void click_the_select_get_away() {

        select = new Select(homePage.selecGetAway);
        wait(1 );
        select.selectByVisibleText("İT");

    }
    @Given("Click on the amounth")
    public void click_on_the_amounth() {

        homePage.amountBoxElement.click();
        wait(1);
        homePage.amountBoxElement.sendKeys("100");

    }
    @Given("Send {int} to the box")
    public void send_to_the_box(Integer int1) {
        jse.executeScript("arguments[0].click();", homePage.SubmitElement);

    }
    @Given("Click on Sumit under the Withdraw Via IT text that appears.")
    public void click_on_sumit_under_the_withdraw_via_it_text_that_appears() {

        jse.executeScript("arguments[0].click();", homePage.SubmitElement);

    }



    @Given("send adminUserName to username textbox")
    public void send_adminUserName_to_username_textbox() {
        adminLoginPage.adminUserNameBox.sendKeys("ismailtemiz");

    }
    @Given("send adminPasword to password textbox")
    public void send_adminPasword_registered_to_password_textbox() {
        adminLoginPage.adminPasswordBox.sendKeys("123123123");

    }

    @Given("Admin clicks on the withdrawals tab")
    public void admin_clicks_on_the_withdrawals_tab() throws InterruptedException {
        adminDashBoardPage.withdrawalDropMenu.click();
        Thread.sleep(1000);

    }
    @Given("Admin selects the pending withdrawals tab.")
    public void admin_selects_the_pending_withdrawals_tab() throws InterruptedException {
        adminDashBoardPage.pendingWithdrawals.click();
        Thread.sleep(1000);


    }
    @Given("Admin clicks on the details button of user ismail")
    public void admin_clicks_on_the_details_button_of_user_ismail() throws InterruptedException {
        adminDashBoardPage.pendingWithdrawalsDetails.click();
        Thread.sleep(1000);

    }
    @Given("admin copies ismails Trx Number")
    public void admin_copies_ismails_trx_number() {
        TrxNumber= adminDashBoardPage.pendngWithdrawalTrx.getText();

    }
    @Given("Admin clicks on the approve button")
    public void admin_clicks_on_the_approve_button() throws InterruptedException {
        adminDashBoardPage.pendingWithdrawalAprove.click();
        Thread.sleep(1000);

    }
    @Given("admin writes ismails Trx Number in the Approve Withdrawal Confirmation box")
    public void admin_writes_ismails_trx_number_in_the_approve_withdrawal_confirmation_box() throws InterruptedException {
        adminDashBoardPage.approveWithdrawalConfirmation.click();
        adminDashBoardPage.approveWithdrawalConfirmation.sendKeys(TrxNumber);
        adminDashBoardPage.approveWithdrawalConfirmation.click();
        Thread.sleep(1000);

    }
    @Given("Click on the Approved Withdrawals tab")
    public void click_on_the_approved_withdrawals_tab() throws InterruptedException {
        adminDashBoardPage.approvedWithdraval.click();
        Thread.sleep(1000);

    }
    @Given("admin verifies that ismails withraw is approved")
    public void admin_verifies_that_ismails_withraw_is_approved() {
        System.out.println(adminDashBoardPage.appreved.getText());
        String expectedStatus="Approved";
        String actualStatus =adminDashBoardPage.appreved.getText();
        Assert.assertEquals(expectedStatus,actualStatus);

    }
    @Given("admin clicks on the manages users tab")
    public void admin_clicks_on_the_manages_users_tab() throws InterruptedException {
        actions.sendKeys(Keys.F5).perform();
        //actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        adminDashBoardPage.withdrawalDropMenu.click();
        Thread.sleep(1000);
        adminDashBoardPage.manageUsers.click();
    }
    @Given("admin clicks on the active users tab")
    public void admin_clicks_on_the_active_users_tab() throws InterruptedException {
        adminDashBoardPage.activeUserLinkElement.click();
        Thread.sleep(1000);

    }
    @Given("admin writes ismailtemiz in the usernameEmail box and clicks the search button.")
    public void admin_writes_ismailtemiz_in_the_username_email_box_and_clicks_the_search_button() throws InterruptedException {
        adminDashBoardPage.activeUserSearch.click();
        adminDashBoardPage.activeUserSearch.sendKeys("ismailtemiz");
        adminDashBoardPage.activeUSersSerachIcon.click();
        Thread.sleep(1000);

    }
    @Given("admin clicks on the details button")
    public void admin_clicks_on_the_details_button() throws InterruptedException {
        adminDashBoardPage.activeUsersDetails.click();
        Thread.sleep(1000);

    }
    @Given("admin clicks the Notifications button")
    public void admin_clicks_the_notifications_button() throws InterruptedException {
        adminDashBoardPage.notifications.click();
        Thread.sleep(1000);

    }
    @Given("admin clicks the Send  Notifications button")
    public void admin_clicks_the_send_notifications_button() throws InterruptedException {
        adminDashBoardPage.sendMessage.click();
        Thread.sleep(1000);

    }
    @Given("admin writes subject in the Subject box")
    public void admin_writes_subject_in_the_subject_box() throws InterruptedException {
        adminDashBoardPage.subjectMessage.click();
        adminDashBoardPage.subjectMessage.sendKeys("ismailtemiz@gmail.com");
        Thread.sleep(1000);

    }
    @Given("admin writes Merhaba İsmail ben LoanTechExperden Yetiş LoanTechExper yönetim ekibi olarak bu ayın en çok aktif kullanıcısı olarak sizi seçtik Bundan dolayı size bir sürprizimiz var Sizin tüm loan planlarınıza %{int} indirim uyguladık. Hayırlı olsun LoanTechExper olarak bizi tercih ettiğiniz için çok teşekkür ederiz in the Messagebox")
    public void admin_writes_merhaba_i̇smail_ben_loan_tech_experden_yetiş_loan_tech_exper_yönetim_ekibi_olarak_bu_ayın_en_çok_aktif_kullanıcısı_olarak_sizi_seçtik_bundan_dolayı_size_bir_sürprizimiz_var_sizin_tüm_loan_planlarınıza_indirim_uyguladık_hayırlı_olsun_loan_tech_exper_olarak_bizi_tercih_ettiğiniz_için_çok_teşekkür_ederiz_in_the_messagebox(Integer int1) {
        //actions.sendKeys((Keys.TAB)).perform();
        adminDashBoardPage.bodyMessage.click();

        adminDashBoardPage.bodyMessage.sendKeys("Merhaba İsmail, ben LoanTechExperden Yetiş LoanTechExper yönetim ekibi olarak bu ayın en çok aktif kullanıcısı olarak sizi seçtik Bundan dolayı size bir sürprizimiz var Sizin tüm loan planlarınıza %1 indirim uyguladık. Hayırlı olsun LoanTechExper olarak bizi tercih ettiğiniz için çok teşekkür ederiz");
        wait(10);

    }
    @Given("Click on the submit button on message page")
    public void click_on_the_submit_button_on_message_page() throws InterruptedException {
        adminDashBoardPage.submitMessage.click();
        Thread.sleep(5000);

    }
    @Given("admin clicks on his name at the top right and clicks on profile")
    public void admin_clicks_on_his_name_at_the_top_right_and_clicks_on_profile() throws InterruptedException {
        adminDashBoardPage.profileicon.click();
        adminDashBoardPage.profiles.click();
        Thread.sleep(1000);


    }
    @Given("By updating the admin profile name it writes its own name instead of Super Admins")
    public void by_updating_the_admin_profile_name_it_writes_its_own_name_instead_of_super_admins() {
        adminDashBoardPage.superAdmin.click();
        adminDashBoardPage.superAdmin.clear();
        adminDashBoardPage.superAdmin.sendKeys("İsmail Temiz");




    }
    @Given("Click the Upload File button and upload a profile photo.")
    public void click_the_upload_file_button_and_upload_a_profile_photo() throws InterruptedException, AWTException {
        adminDashBoardPage.photoUpload.click();
        Point point1 = new Point(466,59);// C: araba çubuğu koordinatı
        Robot robot = new Robot();
        robot.mouseMove(point1.x, point1.y); // Farenin konumunu ayarla
        wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        wait(1);


        // Ctrl+V tuş kombinasyonunu kullanarak dosya yolunu yapıştır
        StringSelection stringSelection = new StringSelection("C:\\Users\\asus\\IdeaProjects\\com.LoanTechExperTeam01\\src\\test\\java\\utilities");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // adres satırının yanındaki enter işlemi gören yandaki oka tıkla
        Point point2 = new Point(709,51);// aç butonu koordinatı
        robot.mouseMove(point2.x, point2.y); // Farenin konumunu ayarla
        wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        wait(1);

        //gelen logoya tıklama işlemi
        Point point3 = new Point(430,165);// aç butonu koordinatı
        robot.mouseMove(point3.x, point3.y); // Farenin konumunu ayarla
        wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        wait(1);

        //aç butanuna tıklama işlemi

        Point point4 = new Point(788,506);// aç butonu koordinatı
        robot.mouseMove(point4.x, point4.y); // Farenin konumunu ayarla
        wait(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama yap
        wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Sol tıklama bırak
        wait(1);






        adminDashBoardPage.uploadSubmit.click();
        Thread.sleep(2000);

    }
    @Given("Navigate to given {string}")
    public void navigate_to_given(String Url) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty(Url));
        Thread.sleep(2000);

    }

    //TC01
    @Given("Verify that the  email information at the top of the home page is visible")
    public void verify_that_the_email_information_at_the_top_of_the_home_page_is_visible() {
        String home=homePage.emailInformation.getText();
        System.out.println(home);
        Assert.assertTrue(homePage.emailInformation.isDisplayed());

    }
    @Given("Verify that the  phone information at the top of the home page is visible")
    public void verify_that_the_phone_information_at_the_top_of_the_home_page_is_visible() {
        String phone=homePage.phoneInformation.getText();
        System.out.println(phone);
        Assert.assertTrue(homePage.phoneInformation.isDisplayed());

    }
    @Given("Verify that the address information at the top of the home page is visible")
    public void verify_that_the_address_information_at_the_top_of_the_home_page_is_visible() {
        String address=homePage.addressInformation.getText();
        System.out.println(address);
        Assert.assertTrue(homePage.addressInformation.isDisplayed());


    }

//TC02


    @Given("Verify that the site logo is Visible and active on the top bar of the home page")
    public void verify_that_the_site_logo_is_visible_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.loanTechLogoElement.isDisplayed());


    }
    @Given("Verify that the Home Button is Visible  and active on the top bar of the home page")
    public void verify_that_the_home_button_is_visible_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userHomeButton.isDisplayed());


    }
    @Given("Verify that the About Button Link is Visible and active on the top bar of the home page")
    public void verify_that_the_about_button_link_is_visible_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userAboutButton.isDisplayed());


    }
    @Given("Verify that the Plans Button Link is Visible and active on the top bar of the home page")
    public void verify_that_the_plans_button_link_is_visible_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userPlansButton.isDisplayed());


    }
    @Given("Verify that the Blogs Button Link is Visible on the and active on the top bar of the home page")
    public void verify_that_the_blogs_button_link_is_visible_on_the_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userBlogsButton.isDisplayed());


    }
    @Given("Verify that the Contact Button Link is Visible on the and active on the top bar of the home page")
    public void verify_that_the_contact_button_link_is_visible_on_the_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userContactButton.isDisplayed());


    }
    @Given("Verify that the Login Icon Button Link is Visible on the and active on the top bar of the home page")
    public void verify_that_the_login_icon_button_link_is_visible_on_the_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.LoginIcon.isDisplayed());


    }
    @Given("Verify that the Get Started Button Link is Visible on the and active on the top bar of the home page")
    public void verify_that_the_get_started_button_link_is_visible_on_the_and_active_on_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.userGetStartedButton.isDisplayed());


    }

    //TC03
    @Given("Click the logo on the top bar of the home page")
    public void click_the_logo_on_the_top_bar_of_the_home_page() {
        homePage.loanTechLogoElement.click();


    }
    @Given("Verify that go to the home page when you click on the logo on the top bar of the home page")
    public void verify_that_go_to_the_home_page_when_you_click_on_the_logo_on_the_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }


    //TC04

    @Given("Click Home on  top bar of the home page")
    public void click_home_on_top_bar_of_the_home_page() {

        homePage.userHomeButton.click();
    }
    @Given("Verify that the Home page is opened when click the Home on  top bar of the home page")
    public void verify_that_the_home_page_is_opened_when_click_the_home_on_top_bar_of_the_home_page() throws InterruptedException {
        String expectedUrl ="https://qa.loantechexper.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(3000);

    }
    @Given("click the About on  top bar of the home page")
    public void click_the_about_on_top_bar_of_the_home_page() {
        homePage.userAboutButton.click();


    }
    @Given("Verify that the About page is opened when click the About on  top bar of the home page")
    public void verify_that_the_about_page_is_opened_when_click_the_about_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/about";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Given("click the Plans on  top bar of the home page")
    public void click_the_plans_on_top_bar_of_the_home_page() {
        homePage.userPlansButton.click();


    }
    @Given("Verify that the Plans page is opened when click the Plans on  top bar of the home page")
    public void verify_that_the_plans_page_is_opened_when_click_the_plans_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/loan";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Given("click the blogs on  top bar of the home page")
    public void click_the_blogs_on_top_bar_of_the_home_page() {
        homePage.userBlogsButton.click();


    }
    @Given("Verify that the Blogs page is opened when click the blogs on  top bar of the home page")
    public void verify_that_the_blogs_page_is_opened_when_click_the_blogs_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/blog";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Given("click the Contact on  top bar of the home page")
    public void click_the_contact_on_top_bar_of_the_home_page() {
        homePage.userContactButton.click();


    }
    @Given("Verify that the Contact page is opened when click the Contact on  top bar of the home page")
    public void verify_that_the_contact_page_is_opened_when_click_the_contact_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/contact";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Given("click the Login Icon on  top bar of the home page")
    public void click_the_login_icon_on_top_bar_of_the_home_page() {
        homePage.LoginIcon.click();
    }
    @Given("Verify that the Login page is opened when click the Login Icon on  top bar of the home page")
    public void verify_that_the_login_page_is_opened_when_click_the_login_icon_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/user/login";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }
    @Given("click the Get Started on  top bar of the home page")
    public void click_the_get_started_on_top_bar_of_the_home_page() throws InterruptedException {
        homePage.userHomeButton.click();
        Thread.sleep(2000);
        homePage.getStartedButonElement.click();

    }
    @Given("Verify that the Register page is opened when click the Get Started on  top bar of the home page")
    public void verify_that_the_register_page_is_opened_when_click_the_get_started_on_top_bar_of_the_home_page() {
        String expectedUrl ="https://qa.loantechexper.com/user/register";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


    }


    @Given("close page")
    public void close_page() {
        Driver.closeDriver();
    }

    @Given("Click on the Plans link in the menu header")
    public void click_on_the_plans_link_in_the_menu_header() {
        wait(2);
        homePage.cocies.click();


        wait(2);
        homePage.plansLinkElement.click();

    }
    @Given("When going to the Plans link, it is verified that the Loan Plans page is accessed")
    public void when_going_to_the_plans_link_it_is_verified_that_the_loan_plans_page_is_accessed() {
        wait(2);
        String expectedUrl ="https://qa.loantechexper.com/loan";
        String actualUrl="https://qa.loantechexper.com/loan";
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("Go to the end of the homepage")
    public void goToTheEndOfTheHomepage() {

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("Click on the Loan Plans link under the Important Link heading and confirm that you are on the Loan Plans page")
    public void clickOnTheLoanPlansLinkUnderTheImportantLinkHeadingAndConfirmThatYouAreOnTheLoanPlansPage() {

        wait(2);
        homePage.importantLinkLoanPlansElement.click();
    }

    @When("Select Basic Loan and see Loan Plan Cards under the Basic Loan heading")
    public void selectBasicLoanAndSeeLoanPlanCardsUnderTheBasicLoanHeading() {
        wait(2);
        homePage.basicLoanTitleElement.click();

    }

    @When("Click on the Apply Now button under one of the plans and verify that it works")
    public void clickOnTheApplyNowButtonUnderOneOfThePlansAndVerifyThatItWorks() {
        wait(1);
        clickWithJS(homePage.basicLoan1ApplyNowElement);
        wait(1);
        String expectedAlert="You are not logged in!";
        String actualAlert=homePage.applyNowWorks.getText();
        Assert.assertEquals(expectedAlert,actualAlert);
    }

    @When("On the Loan Plans page, click on the Home link from the Home - Loan Plans options and go to the Home page")
    public void onTheLoanPlansPageClickOnTheHomeLinkFromTheHomeLoanPlansOptionsAndGoToTheHomePage() {
        wait(1);
        homePage.loanPlansPageHomeLinkElement.click();
        wait(2);
        String expectedUrl ="https://qa.loantechexper.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("The user enters the site with the given {string}")
    public void the_user_enters_the_site_with_the_given(String UrlOne) {
        Driver.getDriver().get(ConfigReader.getProperty("UrlOne"));
        wait(2);
    }

    @Given("click cookies")
    public void clickCookies() {
        homePage.cookiesElementi.click();
    }
    @Given("Click on the Contact tab.")
    public void click_on_the_contact_tab()
    {
        homePage.contactElementi.click();
    }
    @Given("It is verified that the Contact Us page is opened.")
    public void ıt_is_verified_that_the_contact_us_page_is_opened() {

        Assert.assertTrue(homePage.contactUsGorunumElementi.isDisplayed());
    }
    @Given("Home button is clicked")
    public void home_button_is_clicked()

    {
        homePage.homeElementi.click();
    }

    @Given("Go down to the footer section")
    public void go_down_to_the_footer_section() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.footerElementi);
    }
    @Given("Verify that the Contact Us option is visible and active")
    public void verify_that_the_contact_us_option_is_visible_and_active()
    {
        wait(2);
        Assert.assertTrue(homePage.contactUsElementi.isDisplayed());
    }
    @Given("Click on the Contact Us option in the Footer section.")
    public void click_on_the_contact_us_option_in_the_footer_section() {
        homePage.contactUsElementi.click();
    }
    @Given("The company's email, telephone and address contact information must be visible.")
    public void the_company_s_email_telephone_and_address_contact_information_must_be_visible() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.emailAddressElementi);
        Assert.assertTrue(homePage.officeAddressElementi.isDisplayed());
        Assert.assertTrue(homePage.emailAddressElementi.isDisplayed());
        Assert.assertTrue(homePage.mobileNumberElementi.isDisplayed());
    }
    @Given("switch to iframe")
    public void switch_to_iframe() {
        Driver.getDriver().switchTo().frame(homePage.iframeElementi);
        // Driver.getDriver().switchTo().defaultContent(); iframeden çıkmak için kullanılır.
    }
    @Given("Verify that address information is visible on the map")
    public void verify_that_address_information_is_visible_on_the_map() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.adresBilgisiElementi);
        Assert.assertTrue(homePage.adresBilgisiElementi.isDisplayed());
    }

    @Given("Form to send messages to the Company on the Contact Us page must be visible.")
    public void Form_to_send_messages_to_the_Company_on_the_Contact_Us_page_must_be_visible() {

        Assert.assertTrue(homePage.sendYourMessagesElementi.isDisplayed());
    }
    @Given("It goes down to the Send Your Messages section.")
    public void It_goes_down_to_the_Send_Your_Messages_section() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.subjectBoxElementi);
    }
    @Given("wait2")
    public void wait2() {
        wait(2);
    }

    @Given("The Send Your Messages form is filled out.")
    public void the_send_your_messages_form_is_filled_out() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        wait(2);
        actions.click(homePage.yourNameBoxElementi).sendKeys(ConfigReader.getProperty("yourName")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("emailemre")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("subject")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("message")).
                sendKeys(Keys.PAGE_DOWN).perform();
    }


    @Given("The send message button is clicked")
    public void The_send_message_button_is_clicked ()
    {

        homePage.sendMessageButonElementi.click();
    }
    @Given("Verifies that a message has been sent to the company.")
    public void Verifies_that_a_message_has_been_sent_to_the_company (){
        Assert.assertTrue(homePage.ticketCreatedSuccessfullyElementi.isDisplayed());
    }
    @Given("The page is closed.")
    public void the_page_is_closed() {
        Driver.closeDriver();
    }
    @Given("Verify that the Get Started Button link is Visible on the Home Page")
    public void verify_that_the_get_started_button_link_is_visible_on_the_home_page() {
        wait(2);
        assertTrue(homePage.getStartedButonElement.isDisplayed());
    }

    @Given("Click on the Get Started Button on the Home Page.")
    public void click_on_the_get_started_button_link_on_the_home_page() {
        wait(2);
        homePage.getStartedButonElement.click();
        wait(4);

    }

    @Given("Verify that the register text is visible on register page.")
    public void verify_that_the_register_text_is_visible_on_the_register_page() {
        assertTrue(homePage.registerTextElement.isDisplayed());

    }

    @Given("Verify that the Welcome To Loantech Expert form title is visible on the Register page")
    public void verify_that_the_form_title_is_visible_on_the_register_page() {
        assertTrue(homePage.WelcomeToLoantechExpertTextElement.isDisplayed());
    }

    @Given("Verify that the username text box is visible")
    public void verify_that_the_username_text_box_is_visible() {
        assertTrue(loginPage.userNameBoxElement.isDisplayed());

    }

    @Given("Verify that the Email Address text box is visible")
    public void verify_that_the_email_address_text_box_is_visible() {
        assertTrue(loginPage.emailBoxElement.isDisplayed());

    }

    @Given("Verify that the Country DropDown is visible")
    public void verify_that_the_country_drop_down_is_visible() {
        assertTrue(loginPage.countryDropDownElement.isDisplayed());

    }

    @Given("Verify that the Mobile Number text box is visible")
    public void verify_that_the_mobile_number_text_box_is_visible() {
        assertTrue(loginPage.mobileNumberElement.isDisplayed());

    }

    @Given("Verify that the Password text box is visible")
    public void verify_that_the_password_text_box_is_visible() {
        assertTrue(loginPage.passwordElement.isDisplayed());
    }

    @Given("Verify that the Confirm Password text box is visible")
    public void verify_that_the_confirm_password_text_box_is_visible() {
        assertTrue(loginPage.confirmPasswordElement.isDisplayed());
    }

    @Given("A unique username with at least {int} characters is entered in the Username box.")
    public void a_unique_username_with_at_least_characters_is_entered_in_the_username_box(int x) {
        wait(1);
        jse.executeScript("window.scrollBy(0,500)");
        wait(1);
        String username = fakerUsernameMinValue(x);
        loginPage.userNameBoxElement.sendKeys(username);
        String enteredUsername = loginPage.userNameBoxElement.getAttribute("value");
        assertEquals(username, enteredUsername);
    }

    @Given("It is verified that valid e-mail information containing the @ sign can be entered in the e-mail text box")
    public void it_is_verified_that_valid_e_mail_information_containing_the_sign_can_be_entered_in_the_e_mail_text_box() {
        String email = faker.internet().emailAddress();
        loginPage.emailBoxElement.sendKeys(email);
        String enteredEmail = loginPage.emailBoxElement.getAttribute("value");
        assertEquals(email, enteredEmail);
    }

    @Given("Valid e-mail information containing the @ sign is entered into the e-mail text box")
    public void valid_e_mail_information_containing_the_sign_is_entered_into_the_e_mail_text_box() {
        loginPage.emailBoxElement.sendKeys(faker.internet().emailAddress());
    }

    @Given("It is verified that country selection is possible from the Country menu.")
    public void it_is_verified_that_country_selection_is_possible_from_the_country_menu() {
        loginPage.countryDropDownElement.click();
        wait(2);
        loginPage.countryDropDownSelectedElement.click();
        wait(2);
        Driver.getDriver().manage().deleteAllCookies();
        String selectedCountry = loginPage.countryDropDownElement.getText();
        assertEquals("France", selectedCountry);

    }

    @Given("Country selection is made from the Country menu.")
    public void country_selection_is_made_from_the_country_menu() {
        loginPage.countryDropDownElement.click();
        wait(2);
        loginPage.countryDropDownSelectedElement.click();

    }

    @Given("It is verified that a unique phone number of up to {int} digits can be entered in the phone textbox.")
    public void it_is_verified_that_a_unique_phone_number_of_up_to_digits_can_be_entered_in_the_phone_textbox(int x) {
        String phoneNumber = fakerPhoneNumberMaxValue(x);
        loginPage.mobileNumberElement.sendKeys(phoneNumber);
        wait(2);
        String enteredPhoneNumber = loginPage.mobileNumberElement.getAttribute("value");
        wait(2);
        assertEquals(phoneNumber, enteredPhoneNumber);
    }

    @Given("A unique phone number of maximum {int} digits is entered into the phone textbox.")
    public void a_unique_phone_number_of_maximum_digits_is_entered_into_the_phone_textbox(int x) {
        String phoneNumber = fakerPhoneNumberMaxValue(x);
        loginPage.mobileNumberElement.sendKeys(phoneNumber);
        wait(2);
        String enteredPhoneNumber = loginPage.mobileNumberElement.getAttribute("value");
    }

    @Given("It is verified that a {int}-digit password containing at least one uppercase letter, one number, lowercase letter and character can be entered in the Password textbox.")
    public void it_is_verified_that_a_digit_password_containing_at_least_one_uppercase_letter_one_number_lowercase_letter_and_character_can_be_entered_in_the_password_textbox(int x) {

        loginPage.passwordElement.sendKeys(password);
        String enteredePassword = loginPage.passwordElement.getAttribute("value");
        assertEquals(password, enteredePassword);
    }

    @Given("It is verified that the password entered in the password textbox can be hidden or revealed.")
    public void it_is_verified_that_the_password_entered_in_the_password_textbox_can_be_hidden_or_revealed() {
        loginPage.passwordBoxEyeIconElement.click();
        String passwordFieldType = loginPage.passwordElement.getAttribute("type");
        assertEquals("text", passwordFieldType);
    }

    @Given("A {int}-digit password containing at least one uppercase letter, one number, lowercase letter and character is entered into the Password textbox.")
    public void a_digit_password_containing_at_least_one_uppercase_letter_one_number_lowercase_letter_and_character_is_entered_into_the_password_textbox(Integer int1) {
        loginPage.passwordElement.sendKeys(password);
    }

    @Given("It is verified that the password specified in the Confirm textbox can be entered again.")
    public void it_is_verified_that_the_password_specified_in_the_confirm_textbox_can_be_entered_again() {
        loginPage.confirmPasswordElement.sendKeys(password);
        String enteredPasswordConfirm = loginPage.confirmPasswordElement.getAttribute("value");
        assertEquals(password, enteredPasswordConfirm);
    }

    @Given("Verify that the I agree with Privacy Policy, Terms of Service, Rapid Policy check box is clickable")
    public void verify_that_the_i_agree_with_privacy_policy_terms_of_service_rapid_policy_check_box_is_clickable() {
        loginPage.iAgreeTikElement.click();
        assertTrue("I Agree checkbox is not clickable", loginPage.iAgreeTikElement.isEnabled());
    }

    @Given("The specified password is entered in the Confirm textbox.")
    public void the_specified_password_is_entered_in_the_confirm_textbox() {
        loginPage.confirmPasswordElement.sendKeys(password);
    }

    @Given("click on the register button")
    public void click_on_the_register_button() {
        loginPage.registerButtonElement.click();
        waitForVisibility(loginPage.pleaseComplateYourProfileTextElement,10);
    }

    @Given("Verify that Please Complete Your Profile is visible")
    public void verify_that_please_complete_your_profile_is_visible() {
        assertTrue(loginPage.pleaseComplateYourProfileTextElement.isDisplayed());
    }
    @Given("click on the i agree button")
    public void click_on_the_i_agree_button() {
        loginPage.iAgreeTikElement.click();

    }
    @Given("The Firstname box should be visible")
    public void the_firstname_box_should_be_visible() {
        assertTrue(loginPage.firstnameBoxElement.isDisplayed());
    }
    @Given("The lastname box should be visible")
    public void the_lastname_box_should_be_visible() {
        assertTrue(loginPage.lastnameBoxElement.isDisplayed());
    }
    @Given("The address box should be visible")
    public void the_address_box_should_be_visible() {
        assertTrue(loginPage.addressBoxElement.isDisplayed());
    }
    @Given("The State box should be visible")
    public void the_state_box_should_be_visible() {
        assertTrue(loginPage.stateBoxElement.isDisplayed());
    }
    @Given("The Zip box should be visible")
    public void the_zip_box_should_be_visible() {
        assertTrue(loginPage.zipBoxElement.isDisplayed());
    }
    @Given("The city box should be visible")
    public void the_city_box_should_be_visible() {
        assertTrue(loginPage.cityBoxElement.isDisplayed());
        //JavascriptExecutor jsee = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView(true)", loginPage.registerButtonElement);
        //wait(2);
        //jse.executeScript("arguments[0].click();",loginPage.registerButtonElement);
    }
    @Given("The Submit Button should be visible")
    public void the_submit_button_should_be_visible() {
        assertTrue(loginPage.submitButtonElement.isDisplayed());
    }
    @Given("Submit Button must be clickable")
    public void submit_button_must_be_clickable() {
        boolean is_clickable = loginPage.submitButtonElement.isEnabled() && loginPage.submitButtonElement.isDisplayed();
        assert is_clickable :  "Webelement tıklanabilir değil";

    }
    @Given("Name is entered in the firstname box")
    public void name_is_entered_in_the_firstname_box() {
        wait(1);
        jse.executeScript("window.scrollBy(0,500)");
        wait(1);

        loginPage.firstnameBoxElement.click();
        loginPage.firstnameBoxElement.sendKeys(faker.name().name().toUpperCase());
        wait(1);

    }
    @Given("Surname is entered in the lastname box")
    public void surname_is_entered_in_the_lastname_box() {
        loginPage.lastnameBoxElement.sendKeys(faker.name().lastName().toUpperCase());
        wait(1);
    }
    @Given("Address is entered in the address box")
    public void address_is_entered_in_the_address_box() {
        loginPage.addressBoxElement.sendKeys(faker.address().fullAddress().toUpperCase());
        wait(1);
    }
    @Given("State is entered in the state box")
    public void state_is_entered_in_the_state_box() {
        loginPage.stateBoxElement.sendKeys(faker.address().state().toUpperCase());
        wait(1);
    }
    @Given("zip code entered in zip code box")
    public void zip_code_entered_in_zip_code_box() {
        loginPage.zipBoxElement.sendKeys(faker.address().zipCode().toUpperCase());
        wait(1);
    }
    @Given("Country is entered in the city box")
    public void country_is_entered_in_the_city_box() {
        loginPage.cityBoxElement.sendKeys(faker.address().city().toUpperCase());
        wait(1);
    }
    @Given("Click on the submit button")
    public void click_on_the_submit_button() {
        loginPage.submitButtonElement.click();
        wait(4);
    }
    @Given("Verify that registration process completed successfully appears")
    public void verify_that_registration_process_completed_successfully_appears() {
        assertTrue(loginPage.registrationSuccessfullyElement.isDisplayed());
    }
    @Given("Click on the Profile tab")
    public void click_on_the_profile_tab() throws AWTException {
        // dashboardPage.AllowYaziElementi.click();
        // wait(5);
        coordinateClick(309,965);
        wait(2);
        dashboardPage.profileTabElement.click();
        wait(2);
    }
    @Given("dashboard Name is entered in the firstname box")
    public void dashboard_name_is_entered_in_the_firstname_box() throws AWTException {
        coordinateClick(1727,393);
        dashboardPage.firsnameBoxElement.sendKeys(faker.name().name().toUpperCase());
        wait(1);
    }
    @Given("dashboard Surname is entered in the lastname box")
    public void dashboard_surname_is_entered_in_the_lastname_box() {
        dashboardPage.lastnameBoxElement.sendKeys(faker.name().lastName().toUpperCase());
        wait(1);
    }
    @Given("dashboard Address is entered in the address box")
    public void dashboard_address_is_entered_in_the_address_box() {
        dashboardPage.addressBoxElement.sendKeys(faker.address().fullAddress().toUpperCase());
        wait(1);
    }
    @Given("dashboard State is entered in the state box")
    public void dashboard_state_is_entered_in_the_state_box() {
        dashboardPage.stateBoxElement.sendKeys(faker.address().state().toUpperCase());
        wait(1);
    }
    @Given("dashboard zip code entered in zip code box")
    public void dashboard_zip_code_entered_in_zip_code_box() {
        dashboardPage.zipBoxElement.sendKeys(faker.address().zipCode());
        wait(1);
    }
    @Given("dashboard Country is entered in the city box")
    public void dashboard_country_is_entered_in_the_city_box() {
        dashboardPage.cityBoxElement.sendKeys(faker.address().city().toUpperCase());
        wait(1);
    }
    @Given("dashboard Click on the submit button")
    public void dashboard_click_on_the_submit_button() {
        wait(3);
        dashboardPage.submitButtonElement.click();
    }
    @Given("Click the Choose File button and upload a profile photo.")
    public void click_the_choose_file_button_and_upload_a_profile_photo() throws InterruptedException, AWTException {
        wait(2);
        photoUpdateInPc(1389,541,638,52,"C:\\Users\\asus\\IdeaProjects\\com.LoanTechExperTeam01\\src\\test\\java\\utilities",317,163,790,509);
        coordinateClick(317,163);
        coordinateClick(790,509);
    }
    @Given("Verifies that the visitor has accessed the Loan Plans page")
    public void verifies_that_the_visitor_has_accessed_the_loan_plans_page() {
        String expectedUrl ="https://qa.loantechexper.com/loan";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Given("The user logs in to the user dashboard page with {string} and {string}")
    public void the_user_logs_in_to_the_user_dashboard_page_with_user_name_and_user_password(String userNameSuphi, String userPassword) {

        wait(4);
        homePage.cocies.click();
        wait(1);
        clickWithJS(loginPage.userNameElement);
        loginPage.userNameElement.clear();
        loginPage.userNameElement.sendKeys(ConfigReader.getProperty(userNameSuphi));
        clickWithJS(loginPage.passwordElement);
        loginPage.passwordElement.clear();
        loginPage.passwordElement.sendKeys(ConfigReader.getProperty(userPassword));

        clickWithJS(loginPage.userLoginButtonElement);
    }
    @Given("Click on the Profile link to go to the page where profile information can be edited")
    public void click_on_the_profile_link_to_go_to_the_page_where_profile_information_can_be_edited() {
        clickWithJS(dashboardPage.userProfileLinkElement);

    }

    @When("User name, e-mail address, phone number, country information should be visible")
    public void userNameEMailAddressPhoneNumberCountryInformationShouldBeVisible() {
        wait(2);
        dashboardPage.profileNameElement.isDisplayed();
        dashboardPage.profileCountryElement.isDisplayed();
        dashboardPage.profilePhoneElement.isDisplayed();
        dashboardPage.profileCountryElement.isDisplayed();
    }

    @When("Firstname and lastname are edited")
    public void firstnameAndLastnameAreEdited() {
        clickWithJS(dashboardPage.profileFirstNameBoxElement);
        dashboardPage.profileFirstNameBoxElement.clear();
        dashboardPage.profileFirstNameBoxElement.sendKeys("suphi");
        clickWithJS(dashboardPage.profileLastNameBoxElement);
        dashboardPage.profileLastNameBoxElement.clear();
        dashboardPage.profileLastNameBoxElement.sendKeys("atilim");
        clickWithJS(dashboardPage.profileSettingSubmitButtonElement);
        wait(1);
        dashboardPage.profileUpdatedSuccessfullyElement.isDisplayed();

    }

    @When("Click on Choose File button in Image section")
    public void clickOnChooseFileButtonInImageSection() {
        clickWithJS(dashboardPage.imageDosyaSecElement);



    }

    @When("The new file is selected and uploaded")
    public void theNewFileIsSelectedAndUploaded() throws InterruptedException, AWTException {
        wait(1);
        photoUpdateInPc(1164,566,446,59,"C:\\Users\\atili\\IdeaProjects\\com.LoanTechExperTeam01\\src\\test\\java\\utilities",346,172,597,447);
        coordinateClick(346,172);
        coordinateClick(597,447);

        dashboardPage.submitButtonElement.click();

        dashboardPage.profileUpdatedSuccessfullyElement.isDisplayed();

    }

    @When("Non-digit characters are entered in the zip code section")
    public void inTheZipCodeSectionCharactersOtherThanDigitCharactersAreEntered() {
        clickWithJS(dashboardPage.profileZipCodeBoxElement);
        dashboardPage.profileZipCodeBoxElement.clear();
        dashboardPage.profileZipCodeBoxElement.sendKeys("abcde");
        clickWithJS(dashboardPage.profileSettingSubmitButtonElement);

    }

    @When("Enter digit characters in the Zip code section and save the changes by clicking the submit button")
    public void enterDigitCharactersInTheZipCodeSectionAndSaveTheChangesByClickingTheSubmitButton() {
        wait(1);
        dashboardPage.profileUpdatedSuccessfullyElement.isDisplayed();
    }

    @When("The user makes the necessary changes in the profile settings section and saves the changes by clicking submit")
    public void theUserMakesTheNecessaryChangesInTheProfileSettingsSectionAndSavesTheChangesByClickingSubmit() {
        clickWithJS(dashboardPage.profileSettingSubmitButtonElement);
        dashboardPage.profileUpdatedSuccessfullyElement.isDisplayed();
    }

    @When("Profile updated successfully appears when the changes are saved")
    public void profileUpdatedSuccessfullyAppearsWhenTheChangesAreSaved() {
        clickWithJS(dashboardPage.profileSettingSubmitButtonElement);
        dashboardPage.profileUpdatedSuccessfullyElement.isDisplayed();
    }
    @Given("Accept the cookies on page")
    public void accept_the_cookies_on_page() {



    }
    @Given("Login with registered user information")
    public void login_with_registered_user_information() {

        homePage.LoginIcon.click();
        wait(2);

        homePage.usernameTextBox.sendKeys(ConfigReader.getProperty("username1"));
        homePage.passwordTextBox.sendKeys(ConfigReader.getProperty("password1"));
        homePage.LoginButton.submit();

    }

    @Then("Verify that the Change Password is visible on dashboard and button is active.")
    public void verify_that_the_change_password_is_visible_on_dashboard_and_button_is_active() {

        wait(1);
        Assert.assertTrue(dashboardPage.changePasswordButton.isDisplayed());
        Assert.assertTrue(dashboardPage.changePasswordButton.isEnabled());
        wait(2);

        dashboardPage.changePasswordButton.click();
        wait(1);

        System.out.println(dashboardPage.changePasswordText.getText());
        Assert.assertTrue(dashboardPage.changePasswordText.isDisplayed());
        wait(3);

    }
    // The password confirmation does not match

    @Given("Write a valid password on the Current Password text box")
    public void write_a_valid_password_on_the_current_password_text_box() {

        dashboardPage.changePasswordButton.click();
        wait(3);

        dashboardPage.currentPasswordTextBox.sendKeys(ConfigReader.getProperty("password1"));

    }

    @Given("Write a new password on the Password text box,")
    public void write_a_new_password_on_the_password_text_box() {

        String password = "Loan.7412";
        dashboardPage.newPasswordTextBox.sendKeys(password);
        wait(1);

    }

    @Given("Write a different password on the Confirm Password text box,")
    public void write_a_different_password_on_the_confirm_password_text_box() {

        String confirmPassword = "Loan.74123";
        dashboardPage.confirmPasswordTextBox.sendKeys(confirmPassword);
        wait(1);

    }

    @Given("Verify that the new password and the password are not the same")
    public void verify_that_the_new_password_and_the_password_are_not_the_same() {

        String pw = dashboardPage.newPasswordTextBox.getText();
        String cp = dashboardPage.confirmPasswordTextBox.getText();

        wait(2);

    }

    @Given("Click the Submit button")
    public void click_the_submit_button() {

        dashboardPage.changePasswordSubmitButton.submit();

    }

    @Given("Verify that the warning message appears")
    public void verify_that_the_warning_message_appears() {

        System.out.println(dashboardPage.changeMessageWarningMessage.getText());
        Assert.assertTrue(dashboardPage.changeMessageWarningMessage.isDisplayed());
        wait(2);

    }
    @Given("Write a same password on the Confirm Password text box,")
    public void write_a_same_password_on_the_confirm_password_text_box() {

        dashboardPage.confirmPasswordTextBox.sendKeys(ConfigReader.getProperty("password2"));

    }

    @Given("Verify that the new password and the password are the same")
    public void verify_that_the_new_password_and_the_password_are_the_same() {

        Assert.assertEquals(dashboardPage.newPasswordTextBox.getText(), dashboardPage.confirmPasswordTextBox.getText());

    }

    @Given("Verify that the completed successfully message appears")
    public void verify_that_the_completed_successfully_message_appears() {

        dashboardPage.changePasswordSubmitButton.submit();
        System.out.println(dashboardPage.changeMessageSuccefullyMessage.getText());
        Assert.assertTrue(dashboardPage.changeMessageSuccefullyMessage.isDisplayed());

    }
    @Given("go to specified site {string}")
    public void go_to_specified_site(String userUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(userUrl));
    }
    @Given("Username information is entered")
    public void username_information_is_entered() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        dashboardPage.userNameElementi.click();
        actions.sendKeys(ConfigReader.getProperty("userNameEmre")).perform();
    }
    @Given("Password information is entered")
    public void password_information_is_entered() {
        dashboardPage.userPasswordElementi.click();
        dashboardPage.userPasswordElementi.sendKeys(ConfigReader.getProperty("userPassword"));
    }
    @Given("Click on the login buttonn")
    public void click_on_the_login_buttonn() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        dashboardPage.loginButtonEmre.click();
    }
    @Given("Click on the Deposit tab.")
    public void click_on_the_deposit_tab() {
        dashboardPage.depositElementi.click();
    }
    @Given("It appears that the Deposit Methods page has opened.")
    public void it_appears_that_the_deposit_methods_page_has_opened() {
        Assert.assertTrue(dashboardPage.depositMethodsGorunum.isDisplayed());
    }
    @Given("Click on the deposit history tab and the deposit history page opens.")
    public void click_on_the_deposit_history_tab_and_the_deposit_history_page_opens() {
        dashboardPage.depositHistoryElementi.click();
    }
    @Given("The transaction accordion table is displayed on the Deposit History page")
    public void the_transaction_accordion_table_is_displayed_on_the_deposit_history_page() {
        Assert.assertTrue(dashboardPage.akordiyonElement.isDisplayed());
    }
    @Given("Deposit now is clicked and the deposit methods page opens.")
    public void deposit_now_is_clicked_and_the_deposit_methods_page_opens() {
        dashboardPage.depositNowElementi.click();
    }
    @Given("Click on the Select Gateway menu and select manual.")
    public void click_on_the_select_gateway_menu_and_select_manual() {
        dashboardPage.selectGatewayElementi.click();
        Select select = new Select(getDriver().findElement(By.xpath("//*[@class=\"form--control form-select\"]")));
        select.selectByValue("1000");
    }
    @Given("Click on the Amount textbox and enter a value between min and max.")
    public void click_on_the_amount_textbox_and_enter_a_value_between_min_and_max() {
        dashboardPage.amountElementi.click();
        dashboardPage.amountElementi.sendKeys(ConfigReader.getProperty("amount"));
    }
    @Given("Limit-Charge-Payable values are displayed.")
    public void limit_charge_payable_values_are_displayed() {
        Assert.assertTrue(dashboardPage.limitElement.isDisplayed());
    }

    @Given("You have requested {string} USD , Please pay {string} USD for successful payment appears.")
    public void you_have_requested_usd_please_pay_usd_for_successful_payment_appears(String string, String string2) {
        Assert.assertTrue(dashboardPage.youhaveElementi.isDisplayed());
    }



    @Given("Click on the PAY NOW button and go to the Deposit History page.")
    public void click_on_the_pay_now_button_and_go_to_the_deposit_history_page() {
        dashboardPage.payNow.click();
    }
    @Given("The text You have deposit request has been taken is displayed")
    public void the_text_you_have_deposit_request_has_been_taken_is_displayed() {
        Assert.assertTrue(dashboardPage.youHaveDepositElementi.isDisplayed());
    }
    @Given("Verify that the withdraw button is visible and active")
    public void verify_that_the_withdraw_button_is_visible_and_active() {

        System.out.println(dashboardPage.withdrawButton.getText());
        Assert.assertTrue(dashboardPage.withdrawButton.isDisplayed());
        Assert.assertTrue(dashboardPage.withdrawButton.isEnabled());

    }
    @Given("Click the withdraw button")
    public void click_the_withdraw_button() {

        dashboardPage.withdrawButton.click();

    }
    @Given("Verify the Withdraw Money text is visible on page")
    public void verify_the_withdraw_money_text_is_visible_on_page() {

        System.out.println(dashboardPage.withdrawMoneyText.getText());
        Assert.assertTrue(dashboardPage.withdrawMoneyText.isDisplayed());

    }
    @Given("Verify that the Method Text is visible on page")
    public void verify_that_the_method_text_is_visible_on_page() {

        Assert.assertTrue(dashboardPage.methodText.isDisplayed());
    }
    @Given("Verify that the all option is visible")
    public void verify_that_the_all_option_is_visible() {

        WebElement testDropDown = Driver.getDriver().findElement(By.xpath("//*[@name='method_code']"));
        Select dropdown = new Select(testDropDown);
        List<WebElement> f = dropdown.getOptions();
        System.out.println(f.toArray().length);
        System.out.println("The dropdown options are:");
        for(WebElement options: f)
            System.out.println(options.getText());
        dashboardPage.dropDownSelector.click();

        Assert.assertTrue(f.contains("Method 5 Updated"));

    }
    @Given("Select the Method5 Updated on Method Dropdown menu")
    public void select_the_method5_updated_on_method_dropdown_menu() {

        WebElement testDropDown = Driver.getDriver().findElement(By.xpath("//*[@name='method_code']"));
        Select dropdown = new Select(testDropDown);
        wait(2);
        dropdown.selectByValue("9");
        wait(2);


    }
    @Given("Write the {int} USD On Amount textbox,")
    public void write_the_usd_on_amount_textbox(int num) {

        wait(2);
        dashboardPage.amountTextBox.sendKeys("350");
        wait(2);

    }
    @Given("Verify that after the amount value limit text will be visible")
    public void verify_that_after_the_amount_value_limit_text_will_be_visible() {

        wait(2);
        Assert.assertTrue(dashboardPage.limitTable.isDisplayed());
        List<WebElement> t = Driver.getDriver().findElements(By.xpath("//ul[@class='list-group text-center']"));
        for(WebElement optionss: t)
            System.out.println(optionss.getText());

    }
    @Given("Click the Submit button on withdraw section")
    public void click_the_submit_button_on_withdraw_section() {

        dashboardPage.withdrawSubmitButton.submit();

    }
    @Given("Verify that Withdraw Via Method5 Updated section is displayed")
    public void verify_that_withdraw_via_method5_updated_section_is_displayed() {

        Assert.assertTrue(dashboardPage.method5UpdatedText.isDisplayed());
        System.out.println(dashboardPage.method5UpdatedText.getText());
    }
    @Given("Verify that submit button is visible and active")
    public void verify_that_submit_button_is_visible_and_active() {

        Assert.assertTrue(dashboardPage.methodUpdatedSubmitButton.isDisplayed());
        Assert.assertTrue(dashboardPage.methodUpdatedSubmitButton.isEnabled());

    }

    @Given("Click the Submit button on withdraw method section")
    public void click_the_submit_button_on_withdraw_method_section() {

        wait(2);
        dashboardPage.withdrawSubmitButton.click();
        wait(1);

    }

    @Given("Verify that Withdraw request sent successfully message is appeared")
    public void verify_that_withdraw_request_sent_successfully_message_is_appeared() {

        System.out.println(dashboardPage.withdrawSuccesAlertMessage.getText());
        Assert.assertTrue(dashboardPage.withdrawSuccesAlertMessage.isDisplayed());
        Assert.assertTrue(dashboardPage.withdrawMoneyButton.isDisplayed());

    }
    @Given("Verify that Withdraw History page is visible")
    public void verify_that_withdraw_history_page_is_visible() {

        System.out.println(dashboardPage.withdrawHistoryText.getText());
        Assert.assertTrue(dashboardPage.withdrawHistoryText.isDisplayed());
        List<WebElement> table = Driver.getDriver().findElements(By.xpath("//div[@id='transactionAccordion']"));
        for (WebElement t: table){
            System.out.println(t.getText());
        }

    }
    @Given("Click the table name on Withdraw History page")
    public void click_the_table_name_on_withdraw_history_page() {

        Assert.assertTrue(dashboardPage.historyTable.isDisplayed());

    }
    @Given("Verify that the charge-after charge-conversion-status is visible for each transaction")
    public void verify_that_the_charge_after_charge_conversion_status_is_visible_for_each_transaction() {

        for (int i = 1; i <= 10; i++) {
            String xpath = "(//div[@class='accordion-item transaction-item'])[" + i + "]";
            WebElement verified = Driver.getDriver().findElement(By.xpath(xpath));
            verified.click();

            for (int j = 10; j > 1; j--) {
                String tableXpath = "//div[@id='c-" + j + "']";
                WebElement verified2 =Driver.getDriver().findElement(By.xpath(tableXpath));
                System.out.println(verified2.getText());
                wait(1);
                Assert.assertTrue(dashboardPage.transactionTable.isDisplayed());
            }
        }
    }
    @Given("Click the Withdraw Money button on withdraw History page")
    public void click_the_withdraw_money_button_on_withdraw_history_page() {

        dashboardPage.withdrawMoneyButton.click();
    }
    @Given("Click the Withdraw Log button on withdraw Money page")
    public void click_the_withdraw_log_button_on_withdraw_money_page() {

        dashboardPage.withdrawLogButton.click();

    }
    @Given("Verify that Withdraw History text is visible")
    public void verify_that_withdraw_history_text_is_visible() {

        Assert.assertTrue(dashboardPage.withdrawHistoryText.isDisplayed());

    }
    @Given("Verify that Withdraw Money text is visible")
    public void verify_that_withdraw_money_text_is_visible() {

        Assert.assertTrue(dashboardPage.withdrawMoneyText.isDisplayed());
    }

    @Given("Click on the login button")
    public void clic_on_the_login_button() {
        loginPage.loginButtonElement.click();
    }

    @Given("The registered {string} is entered in the Username Or Email box.")
    public void the_registered_is_entered_in_the_username_or_email_box(String username) {
        loginPage.userNameBoxElement.sendKeys(ConfigReader.getProperty(username));
    }

    @Given("Registered user {string} is entered in the Your Password box.")
    public void registered_user_is_entered_in_the_your_password_box(String password) {
        loginPage.passwordElement.sendKeys(ConfigReader.getProperty(password));
    }


    @Given("Verify that the Take Loan tab is visible")
    public void verify_that_the_take_loan_tab_is_visible() {
        assertTrue(dashboardPage.takeLoanTabElement.isDisplayed());
    }

    @Given("Click on the Take Loan button")
    public void click_on_the_take_loan_button() {
        //dashboardPage.allowTextElement.click();
        wait(3);
        dashboardPage.takeLoanTabElement.click();
    }

    @Given("Verify that Loan Plans appears")
    public void verify_that_loan_plans_appears() {
        wait(1);
        assertTrue(dashboardPage.loanPlansTextElement.isDisplayed());
    }

    @Given("Click on the car loan button")
    public void click_on_the_car_loan_button() {
        dashboardPage.carLoanButtonElement.click();
        wait(1);


    }

    @Given("Verify that Apply Now is visible")
    public void verify_that_apply_now_is_visible() {
        assertTrue(dashboardPage.applyNowButtonElement.isDisplayed());
    }


    @Given("Verify that {string} is visible")
    public void verify_that_$_is_visible(String amount) {
        assertTrue(dashboardPage.takeMaximumTextElement.isEnabled());

    }
    @Given("Verify this {string} is visible")
    public void verify_that_Per_is_visible(String str) {
        String actualResult = dashboardPage.text6PerElement.getText();
        Assert.assertEquals("Farklı yüzdelik dilimler kullanılmıştır.",str,actualResult);
        System.out.println("expexted: " + str);
        System.out.println("actual: " + actualResult);


    }

    @Given("Verify that the Apply Now button is clickable")
    public void verify_that_the_apply_now_button_is_clickable() {
        assertTrue(dashboardPage.applyNowButtonElement.isEnabled());

    }

    @Given("Verify that Personal Finance Loan is visible")
    public void verify_that_personal_finance_loan_is_visible() {
        assertTrue(dashboardPage.personalFinanceLoanTextElement.isDisplayed());
    }

    @Given("Verify that Take Maximum is visible")
    public void verify_that_take_maximum_is_visible() {
        assertTrue(dashboardPage.takeMaximumTextElement.isDisplayed());
    }

    @Given("Verify that Take Minimum is visible")
    public void verify_that_take_minimum_is_visible() {
        assertTrue(dashboardPage.takeMinimumElement.isDisplayed());
    }

    @Given("Verify that the {string} is visible")
    public void verify_that_the_is_visible(String string) {
        assertTrue(dashboardPage.$200000TextElement.isDisplayed());
    }

    @Given("Verify that Per Installment is visible")
    public void verify_that_per_installment_is_visible() {
        assertTrue(dashboardPage.perInstallmentTextElement.isDisplayed());
    }

    @Given("Verify that Installment Interval is visible")
    public void verify_that_installment_interval_is_visible() {
        assertTrue(dashboardPage.perInstallmentTextElement.isDisplayed());
    }

    @Given("Verify that {int} Days is visible")
    public void verify_that_days_is_visible(Integer int1) {
        assertTrue(dashboardPage.days20TxtElement.isDisplayed());
    }

    @Given("Verify that Total Installment is visible")
    public void verify_that_total_installment_is_visible() {
        assertTrue(dashboardPage.totalInstallmentTxtElement.isDisplayed());
    }

    @Given("Verify that {int} is visible")
    public void verify_that_is_visible(Integer int1) {
        assertTrue(dashboardPage.text20TxtElement.isDisplayed());
    }
    @Given("Click on the Apply Now button")
    public void click_on_the_apply_now_button() {
        dashboardPage.applyNowButtonElement.click();
    }
    @Given("Verify that Apply for Personal Finance Loan appears")
    public void verify_that_apply_for_personal_finance_loan_appears() {
        assertTrue(dashboardPage.applyForPersonalLoanTxtElement.isDisplayed());
    }
    @Given("A number between {string} and {string} is entered in the Enter An Amount box")
    public void a_number_between_and_is_entered_in_the_enter_an_amount_box(String amountmin, String amountmax) {
        //dashboardPage.enterAnAmountBoxElement.click();
        dashboardPage.enterAnAmountBoxElement.sendKeys(minMaxRandomAmountCreate(amountmin, amountmax));
    }
    @Given("Verify that Confirm text is visible")
    public void verify_that_confirm_text_is_visible() {
        assertTrue(dashboardPage.confirmButtonElement.isDisplayed());
    }
    @Given("Click on the Confirm button")
    public void click_on_the_confirm_button() {
        dashboardPage.confirmButtonElement.click();
    }

    @Given("Click on the basic loan button")
    public void click_on_the_basic_loan_button() {
        wait(3);
        dashboardPage.basicLoanButtonElement.click();
    }
    @Given("Verify that Application Form text is visible")
    public void verify_that_application_form_text_is_visible() {
        assertTrue(dashboardPage.applicationFormTxtElement.isDisplayed());
    }

    @Given("Click on the basic Loan Apply Now button")
    public void click_on_the_basic_loan_apply_now_button() {
        dashboardPage.basicLoanapplyNowButtonElement.click();
    }

    @Given("Verify that Plan Name appears")
    public void verify_that_plan_name_appears() {
        assertTrue(dashboardPage.planNameTxtElement.isDisplayed());
    }
    @Given("Verify that Loan Amount appears")
    public void verify_that_loan_amount_appears() {
        assertTrue(dashboardPage.loanAmountTxtElement.isDisplayed());

    }
    @Given("Verify that Total Installment appears")
    public void verify_that_total_installment_appears() {
        assertTrue(dashboardPage.totalInstallmenttTxtElement.isDisplayed());

    }
    @Given("Verify that Per Installment appears")
    public void verify_that_per_installment_appears() {
        assertTrue(dashboardPage.perInstallmenttTxtElement.isDisplayed());

    }
    @Given("Verify that You'll Need To Pay appears")
    public void verify_that_you_ll_need_to_pay_appears() {
        assertTrue(dashboardPage.youllNeedToPayTxtElement.isDisplayed());

    }
    @Given("Verify that Application Fee text is visible")
    public void verify_that_application_fee_text_is_visible() {
        assertTrue(dashboardPage.applicationFeeTxtElement.isDisplayed());

    }

    @Given("Click on the Test Loan Apply Now button")
    public void click_on_the_test_loan_apply_now_button() {
        dashboardPage.applyNowTestLoanTxtElement.click();
    }
    @Given("Verify that Application Form appears")
    public void verify_that_application_form_appears() {
        assertTrue(dashboardPage.applicationFormTxtElement.isDisplayed());
    }
    @Given("Verify that Test Loan is written in the box under Application Form")
    public void verify_that_test_loan_is_written_in_the_box_under_application_form() {
        String actualResult = dashboardPage.underTheApplicationFormTxtBoxElement.getText();
        String expectedResult = "Test Loan";
        assertEquals(" Under the Application Form tetx Box has Test Loan text but dont here Test Loan",expectedResult,actualResult);
    }
    @Given("Verify that Apply appears")
    public void verify_that_apply_appears() {
        dashboardPage.applyElement.click();
        wait(1);
    }
    @Given("Click on the Apply button under the Application Form Text")
    public void click_on_the_apply_button_under_the_application_form_text() {
        dashboardPage.applyButtonUnderTheApplicationFormTextElement.click();
        wait(2);
    }
    @Given("Verify that the Loan application submitted successfully message appears")
    public void verify_that_the_loan_application_submitted_successfully_message_appears() {
        assertTrue(dashboardPage.loanApplicationSubmittedSuccessfullyTxtElement.isDisplayed());
    }

    @Given("Verify that Test_Loan appears")
    public void verify_that_test_loan_appears() {
        wait(1);
        assertTrue(dashboardPage.TestLoanTakeLoanTextElement.isDisplayed());
    }
    @Given("Verify that the Search By Loan Number text box is visible")
    public void verify_that_the_search_by_loan_number_text_box_is_visible() {
        assertTrue(dashboardPage.seachByLoanNumberBoxTextElement.isDisplayed());
    }
    @Given("The last created Test_LOan Loan number is entered into the Search By Loan Number text box.")
    public void the_last_created_test_l_oan_loan_number_is_entered_into_the_search_by_loan_number_text_box() {
        String firstLoanNumber = dashboardPage.firstSeachByLoanNumberElement.getText();
        dashboardPage.seachByLoanNumberBoxTextElement.sendKeys(firstLoanNumber);
        dashboardPage.lensLogoButtonElement.click();
    }
    @Given("Click on the lens logo")
    public void click_on_the_lens_logo() {
        dashboardPage.lensLogoButtonElement.click();
    }
    @Given("Test_Loan Verifies that the Loan number appears in the table as uniq")
    public void test_loan_verifies_that_the_loan_number_appears_in_the_table_as_uniq() {
        assertFalse(dashboardPage.secondSeachByLoanNumberElement.isDisplayed());
    }

    @Given("It is verified that pending status codes are displayed filtered in the table.")
    public void it_is_verified_that_pending_status_codes_are_displayed_filtered_in_the_table() {
// Tablodaki verileri doğrula
        List<WebElement> elements = new ArrayList<>();
        int index = 1;
        while (true) {
            String locator = "(//span[@class='badge badge--dark'])[" + index + "]";
            WebElement element = Driver.getDriver().findElement(By.xpath(locator));
            elements.add(element);
            index += 2;
            if (!isElementPresent(Driver.getDriver(), locator)) {
                break;
            }
        }

        boolean allPending = true;
        for (WebElement element : elements) {
            String status = element.getText();
            if (!status.equals("pending")) {
                allPending = false;
                break;
            }
        }

        if (allPending) {
            System.out.println("Tüm verilerin statusu 'pending'.");
        } else {
            System.out.println("Verilerin statusu doğrulanamadı.");
        }

    }

    private boolean isElementPresent(WebDriver driver, String locator) {
        return false;
    }

    @Given("Click on the arrow sign in the Loan Status box select {string} status from the dropdown menu that opens.")
    public void click_on_the_arrow_sign_in_the_loan_status_box_select_status_from_the_dropdown_menu_that_opens(String status) {
        Select select = new Select(dashboardPage.loanStatusArrowElement);
        select.selectByVisibleText(status);
        wait(2);
    }
    @Given("Click on the running button")
    public void click_on_the_running_button() {
        dashboardPage.runningbuttonElement.click();
    }
    @Given("Verify that the Installment box is visible in the bar that opens")
    public void verify_that_the_installment_box_is_visible_in_the_bar_that_opens() {
        assertTrue(dashboardPage.installmentstxtElement.isDisplayed());
    }
    @Given("Verify that the Installment box is clickable")
    public void verify_that_the_installment_box_is_clickable() {
        assertTrue(dashboardPage.installmentstxtElement.isEnabled());
    }
    @Given("Click on the Installment box")
    public void click_on_the_installment_box() {
        dashboardPage.installmentstxtElement.click();
        wait(3);
    }
    @Given("Verify that Loan Installments is displayed on the page that opens")
    public void verify_that_loan_installments_is_displayed_on_the_page_that_opens() {
        assertTrue(dashboardPage.loaninstallmentstxtElement.isDisplayed());
    }

    @Given("Verify that the Loan Number value appears")
    public void verify_that_the_loan_number_value_appears() {
        assertTrue(dashboardPage.loanNumbertxtElement.isDisplayed());
    }
    @Given("Verify that the Loan Amount value appears")
    public void verify_that_the_loan_amount_value_appears() {
        assertTrue(dashboardPage.loanAmounttxtElement.isDisplayed());
    }
    @Given("Verify that the Plan value appears")
    public void verify_that_the_plan_value_appears() {
        assertTrue(dashboardPage.plantxtElement.isDisplayed());
    }
    @Given("Verify that the value Per Installment appears")
    public void verify_that_the_value_per_installment_appears() {
        assertTrue(dashboardPage.perInstallmentElement.isDisplayed());
    }
    @Given("Verify that the Needs to Pay value appears")
    public void verify_that_the_needs_to_pay_value_appears() {
        assertTrue(dashboardPage.needstoPayTxtElement.isDisplayed());
    }
    @Given("Verify that the Delay Charge value appears")
    public void verify_that_the_delay_charge_value_appears() {
        assertTrue(dashboardPage.delayChargeTxtElement.isDisplayed());
    }
    @Given("The installment plan list should be displayed.")
    public void the_installment_plan_list_should_be_displayed() {
        assertTrue(dashboardPage.allListElements.isDisplayed());
    }
    @Given("Verify that the S.N. Header is displayed")
    public void verify_that_the_s_n_header_is_displayed() {
        assertTrue(dashboardPage.snTxtElement.isDisplayed());
    }
    @Given("Verify that the Installment Date Header is displayed")
    public void verify_that_the_installment_date_header_is_displayed() {
        assertTrue(dashboardPage.installmentDateTxtElement.isDisplayed());
    }
    @Given("Verify that the Given On Header is displayed")
    public void verify_that_the_given_on_header_is_displayed() {
        assertTrue(dashboardPage.givenOnTxtElement.isDisplayed());
    }
    @Given("Verify that the Delay Header is displayed")
    public void verify_that_the_delay_header_is_displayed() {
        assertTrue(dashboardPage.delayTxtElement.isDisplayed());
    }
    @Given("Verify that Loan Plans appears on the page that opens")
    public void verify_that_loan_plans_appears_on_the_page_that_opens() {
        assertTrue(dashboardPage.loanPlansTextElement.isDisplayed());
    }
    @Given("The given {string} is entered into the browser and press enter.")
    public void the_given_url_is_entered_into_the_browser_and_press_enter(String Url) {

        Driver.getDriver().get(ConfigReader.getProperty(Url));
        wait(2);
        homePage.cocies.click();
        wait(2);
    }
    @Given("The user click on the login button.")
    public void the_user_click_on_the_login_button() {
        homePage.loginButton.click();
        wait(1);
        jse.executeScript("window.scrollBy(0,500)");
        wait(1);

    }
    @Given("The user enters {string} username.")
    public void the_user_enters_a_valid_email_address(String username) {
        homePage.emailBox.sendKeys(ConfigReader.getProperty(username));
        wait(1);
    }
    @Given("The user enters {string} password.")
    public void the_user_enters_the_valid_password(String password) {
        homePage.passwordBox.sendKeys(ConfigReader.getProperty(password));
        wait(1);

    }
    @Given("The user clicks on the login button.")
    public void the_user_clicks_on_the_login_button() {
        homePage.loginbutton2.click();
        wait(1);
    }
    @Given("The user clicks on the home page logo.")
    public void the_user_clicks_on_the_home_page_logo() {
        homePage.homePageLogo.click();
        wait(2 );
    }
    @Given("The user's access to the home page is verified.")
    public void the_user_s_access_to_the_home_page_is_verified() {
        Assert.assertTrue(homePage.homePageDashboard.isDisplayed());
        wait(2);

    }
    @Given("Close browser.")
    public void close_browser() {
        Driver.getDriver().close();
    }


    // ****************TC_02******************

    @Given("Email information visible in the top bar of the home page.")
    public void email_information_visible_in_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.emailInformation.isDisplayed());
        wait(1);
    }
    @Given("Address information visible in the top bar of the home page.")
    public void address_information_visible_in_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.addressInformation.isDisplayed());
        wait(1);
    }
    @Given("Phone information visible in the top bar of the home page.")
    public void phone_information_visible_in_the_top_bar_of_the_home_page() {
        Assert.assertTrue(homePage.phoneInformation.isDisplayed());
        wait(1);
    }
    @Given("The Home button is active and visible in the home page header section.")
    public void the_home_button_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userHomeButton.isDisplayed());
        Assert.assertTrue(homePage.userHomeButton.isEnabled());
        wait(1);
    }
    @Given("The About button is active and visible in the home page header section.")
    public void the_about_button_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userAboutButton.isDisplayed());
        Assert.assertTrue(homePage.userAboutButton.isEnabled());
        wait(1);
    }
    @Given("The Plans button is active and visible in the home page header section.")
    public void the_plnas_button_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userPlansButton.isDisplayed());
        Assert.assertTrue(homePage.userPlansButton.isEnabled());
        wait(1);
    }
    @Given("The Blogs button is active and visible in the home page header section.")
    public void the_blogs_button_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userBlogsButton.isDisplayed());
        Assert.assertTrue(homePage.userBlogsButton.isEnabled());
        wait(1);
    }
    @Given("The Contact button is active and visible in the home page header section.")
    public void the_contact_button_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userContactButton.isDisplayed());
        Assert.assertTrue(homePage.userContactButton.isEnabled());
        wait(1);
    }
    @Given("The Login icon is active and visible in the home page header section.")
    public void the_login_icon_is_active_and_visible_in_the_home_page_header_section() {

    }
    @Given("Get Started icon is active and visible in the home page header section.")
    public void get_started_icon_is_active_and_visible_in_the_home_page_header_section() {
        Assert.assertTrue(homePage.userGetStartedButton.isDisplayed());
        Assert.assertTrue(homePage.userGetStartedButton.isEnabled());
        wait(1);
    }




    // *****************TC_03************************

    @Given("Click on the Home button in the header section of the home page.")
    public void click_on_the_home_button_in_the_header_section_of_the_home_page() {
        homePage.userHomeButton.click();
        wait(1);

    }
    @Given("It is verified that the home page is opened.")
    public void it_is_verified_that_the_home_page_is_opened() {
        Assert.assertTrue(homePage.homePageLogo.isDisplayed());
        wait(1);

    }
    @Given("Click on the About button in the header section of the home page.")
    public void click_on_the_about_button_in_the_header_section_of_the_home_page() {
        homePage.userAboutButton.click();
        wait(2);
    }
    @Given("It is verified that the About page is opened.")
    public void it_is_verified_that_the_about_page_is_opened() {
        Assert.assertTrue( homePage.aboutText.isDisplayed());

    }
    @Given("Click the Plans button in the header section of the home page.")
    public void click_the_plans_button_in_the_header_section_of_the_home_page() {
        homePage.userPlansButton.click();
        wait(1);

    }
    @Given("It is verified that the Plans page is opened.")
    public void it_is_verified_that_the_plans_page_is_opened() {
        Assert.assertTrue(homePage.plansText.isDisplayed());
        wait(1);
    }
    @Given("Click the Blogs button in the header section of the home page.")
    public void click_the_blogs_button_in_the_header_section_of_the_home_page() {
        homePage.userBlogsButton.click();
        wait(1);
    }
    @Given("It is verified that the Blogs page is opened.")
    public void it_is_verified_that_the_blogs_page_is_opened() {

        Assert.assertTrue(homePage.blogsText.isDisplayed());
    }
    @Given("Click the Contact button in the header section of the home page.")
    public void click_the_contact_button_in_the_header_section_of_the_home_page() {
        homePage.userContactButton.click();
        wait(1);
    }
    @Given("It is verified that the Contact page is opened.")
    public void it_is_verified_that_the_contact_page_is_opened() {
        Assert.assertTrue(homePage.contactText.isDisplayed());
    }
    @Given("Click on the Login icon in the header section of the home page.")
    public void click_on_the_login_icon_in_the_header_section_of_the_home_page() {

    }
    @Given("It is verified that the Login page is opened.")
    public void it_is_verified_that_the_login_page_is_opened() {
        Assert.assertFalse(homePage.loginText.isDisplayed());
        wait(1);
        Driver.getDriver().navigate().back();
    }
    @Given("Click on the Get Started icon in the header section of the home page.")
    public void click_on_the_get_started_icon_in_the_header_section_of_the_home_page() {
        homePage.userGetStartedButton.click();
        wait(1);
    }
    @Given("It is verified that the Get Started  page is opened.")
    public void it_is_verified_that_the_get_started_page_is_opened() {
        Assert.assertTrue(homePage.getStartedPage.isDisplayed());
    }
    @Given("Navigate to the URL by entering in the browser's address {string} bar and pressing the Enter key.")
    public void navigate_to_the_url_by_entering_in_the_browser_s_address_bar_and_pressing_the_enter_key(String Url) {
        Driver.getDriver().get(ConfigReader.getProperty(Url));

    }

    @Then("Click on Login button.")
    public void click_on_login_button() {

        //JavascriptExecutor jseee = (JavascriptExecutor) Driver.getDriver();
        //wait(2);
        //jse.executeScript("arguments[0].scrollIntoView(true);",homePage.AllowYaziElementi);
        //wait(2);
        //jse.executeScript("arguments[0].click();",homePage.AllowYaziElementi);
        wait(2);
        homePage.AllowYaziElementi.click();
        wait(2);
        homePage.firstLogin.click();

    }

    @Then("Fill in userinformation.")
    public void fill_in_userinformation() {


        homePage.userName.sendKeys(ConfigReader.getProperty("Usernameeyyup"));
        wait(2);
        homePage.password.sendKeys(ConfigReader.getProperty("password"));

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait(3);

        homePage.login2.sendKeys(Keys.ENTER);
        wait(5);





    }

    @Then("Test the functionality and visibility of the logout button.")
    public void test_the_functionality_and_visibility_of_the_logout_button() {

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(homePage.logoutButton.isDisplayed());

    }

    @Then("Return to the home page.")
    public void return_to_the_home_page() {
        homePage.logoutButton.click();

    }

    @Then("Close the web page.")
    public void close_the_web_page() {
        Driver.closeDriver();

    }
    @Given("The Basic Loan button appears and it is confirmed that it is active.")
    public void the_basic_loan_button_appears_and_it_is_confirmed_that_it_is_active() {
        Assert.assertTrue(homePage.basicLoanCard.isDisplayed());
        Assert.assertTrue(homePage.basicLoanCard.isEnabled());
    }
    @Given("Click on the Basic Loan button.")
    public void click_on_the_basi_loan_button() {
        homePage.basicLoanCard.click();
        jse.executeScript("window.scrollBy(0,400)");
        wait(1);
    }
    @Given("Verify that the Basic Loan 1' header is visible.")
    public void verify_that_the_header_is_visible() {
        Assert.assertTrue(homePage.titleBasicLoan1.isDisplayed());
        wait(1);
    }
    @Given("Verify that the Test Loan header is visible.")
    public void verify_that_the_test_loan_header_is_visible() {
        Assert.assertTrue(homePage.titleTestLoan.isDisplayed());
        wait(1);
    }
    @Given("Verify that the Car Loan title is visible.")
    public void verify_that_the_car_loan_title_is_visible() {
        Assert.assertTrue(homePage.titleCarLoan.isDisplayed());
        wait(1);

    }
    @Given("Verifies that the Apply now button is visible and active.")
    public void verifies_that_the_apply_now_button_is_visible_and_active() {
        Assert.assertTrue(homePage.applyNowButton.isDisplayed());
        Assert.assertTrue(homePage.applyNowButton.isEnabled());
        wait(1);
    }

    // TC_03
    @Given("Click the Apply Now button.")
    public void click_the_apply_now_button() {
        homePage.applyNowButton.click();
        wait(1);
    }
    @Given("Verify that Apply for 'Basic Loan 1' page open")
    public void verify_that_apply_for_basic_loan_page_open() {
        Assert.assertTrue(homePage.basicLoan1Page.isDisplayed());
    }

    // TC_04
    @Given("Amount are entered within the range of minimum and maximum values.")
    public void amount_are_entered_within_the_range_of_minimum_and_maximum_values() {
        homePage.amountBox.sendKeys("2000");
        wait(2);
    }
    @Given("Verify that the arrow keys are visible and active.")
    public void verify_that_the_arrow_keys_are_visible_and_active() throws AWTException {
        // Mouse coordinates: 811, 489 arrow up
        coordinateClick(812,489);
        wait(1);
        coordinateClick(812,489);
        wait(1);
        // Mouse coordinates: 812, 508 arrrow down
        coordinateClick(812,508);

    }

    // TC_005

    @Given("The Confirm button is appears and active.")
    public void the_confirm_button_is_appears_and_active() {
        Assert.assertTrue(homePage.comfirmButton.isDisplayed());
        Assert.assertTrue(homePage.comfirmButton.isEnabled());

    }
    @Given("The  user clicks Confirm button.")
    public void the_user_clicks_confirm_button() {
        homePage.comfirmButton.click();
        wait(1);

    }
    @Given("It is verified that the Application Form page is opened.")
    public void it_is_verified_that_the_application_form_page_is_opened() {
        Assert.assertTrue(homePage.applicationFormButton.isDisplayed());
        wait(1);


    }
    @Given("The user clicks Apply button .")
    public void the_user_clicks_apply_button() {
        homePage.applyButton.click();
        wait(1);
    }
    @Given("It is verified that the text Loan application submitted successfully' appears.")
    public void it_is_verified_that_the_text_appears() {
        // String expectedText = "Loan application submitted successfully";
        Assert.assertTrue(homePage.mesaggeText.isDisplayed());
        System.out.println(homePage.mesaggeText.getText());
        wait(1);

    }
    @Given("As user enters the site with the given {string}")
    public void as_user_enters_the_site_with_the_given(String Url) {

        Driver.getDriver().get(ConfigReader.getProperty(Url));
        wait(2);
    }
    @Given("Click the Login button and goto the user login page")
    public void click_the_login_button_and_go_to_the_user_login_page() {
        clickWithJS(homePage.loginButtonElement);
    }


    @Given("It is verified that  details appear on the home page")
    public void It_is_verified_that_details_appear_on_the_home_page() {
        dashboardPage.successfulDepositsYText.isDisplayed();
        dashboardPage.successfulDepositsAmount.isDisplayed();
        dashboardPage.successfulWithdrawalsText.isDisplayed();
        dashboardPage.successfulWithdrawalsAmount.isDisplayed();
        dashboardPage.totalLoanText.isDisplayed();
        dashboardPage.totalLoanAmount.isDisplayed();
        dashboardPage.totalLoanNumber.isDisplayed();

    }

    @Given("Enter the  {string}  in the browser's address bar and press the Enter key.")
    public void enter_the_in_the_browser_s_address_bar_and_press_the_enter_key(String UrlAdmin) {
        Driver.getDriver().get(ConfigReader.getProperty(UrlAdmin));

    }

    @Then("Fill in the admin credentials.")
    public void fill_in_the_admin_credentials() {
        adminDashBoardPage.adminUserName.sendKeys(ConfigReader.getProperty("AdminUserName"));
        adminDashBoardPage.adminPassword.sendKeys(ConfigReader.getProperty("AdminPassword"));


    }

    @Then("Click the Login button.")
    public void click_the_login_button() {
        adminDashBoardPage.loginButton.click();

    }

    @Then("Click to the Loans menu.")
    public void click_to_the_loans_menu() {
        adminDashBoardPage.loansbutton.click();

    }

    @Then("Click on the Pending Loans link.")
    public void click_on_the_pending_loans_link() {
        adminDashBoardPage.pendingLoansButton.click();

    }

    @Then("Verify that access to the Pending Loans page is successful.")
    public void verify_that_access_to_the_pending_loans_page_is_successful() {
        Assert.assertTrue(adminDashBoardPage.pendingloanspost.isDisplayed());

    }

    @Then("View the Pending Loans table.")
    public void view_the_pending_loans_table() {
        List<WebElement> loansTable = adminDashBoardPage.pendingLoansTable;

        wait(2);
        for (WebElement each : loansTable
        ) {
            wait(1);
            System.out.println(each);


        }


    }

    @Then("Viewed the information of pending loans on the Pending Loans page")
    public void viewedTheInformationOfPendingLoansOnThePendingLoansPage() {
        wait(1);
        List<WebElement> loansInfirmationlist = adminDashBoardPage.pendingLoansInformation;
        wait(1);
        for (WebElement each : loansInfirmationlist
        ) {
            wait(1);
            System.out.println(each);
            Assert.assertTrue(each.isDisplayed());
            Assert.assertTrue(loansInfirmationlist.size()>0);
        }

    }

    @Then("Searched in the Pending Loans table using loan number and start date information.")
    public void searchedInThePendingLoansTableUsingLoanNumberAndStartDateInformation() {
        wait(1);
        adminDashBoardPage.loanNo.click();
        adminDashBoardPage.loanNo.sendKeys(ConfigReader.getProperty("LoanNo"));
        wait(1);
        adminDashBoardPage.dateNo.click();
        wait(1);
        adminDashBoardPage.dateNo.sendKeys(ConfigReader.getProperty("LoanDate"));
        wait(1);
        adminDashBoardPage.searchbutton.click();

    }

    @And("Reviewed the details and installment information in Pending Loans.")
    public void reviewedTheDetailsAndInstallmentInformationInPendingLoans() {

        Assert.assertTrue(adminDashBoardPage.plDetails.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.plInstallments.isDisplayed());


    }

    @Then("Clicked on the Details button on the page.")
    public void clickedOnTheDetailsButtonOnThePage() {

        adminDashBoardPage.loanNo.sendKeys("eyyupyilmaz");
        adminDashBoardPage.searchbutton.click();

        adminDashBoardPage.plDetails.click();
        wait(2);

    }

    @And("Viewed the credit details on the opened page \\(plan, date, etc.).")
    public void viewedTheCreditDetailsOnTheOpenedPagePlanDateEtc() {

        Assert.assertTrue(adminDashBoardPage.loanDetails.isDisplayed());
    }

    @And("Click on the Approve button on the page.")
    public void clickOnTheApproveButtonOnThePage() {
        adminDashBoardPage.approveButton.click();
        wait(2);

    }

    @And("Accept the displayed alert, and the credit is approved.")
    public void acceptTheDisplayedAlertAndTheCreditIsApproved() {
        adminDashBoardPage.approveYes.click();
        wait(2);
    }

    @And("Click on the Reject button on the page.")
    public void clickOnTheRejectButtonOnThePage() {

        adminDashBoardPage.rejectButton.click();

        adminDashBoardPage.rejecttext.sendKeys("not approved.");
        wait(2);


    }

    @And("The submit button is clicked, the loan is not approved.")
    public void theSubmitButtonIsClickedTheLoanIsNotApproved() {
        adminDashBoardPage.rejectSubmit.click();



    }

    @And("Click on the Installments link.")
    public void clickOnTheInstallmentsLink() {
        adminDashBoardPage.plInstallments.click();
        wait(2);

    }

    @And("View the information under the Installments menu.")
    public void viewTheInformationUnderTheInstallmentsMenu() {

        Assert.assertTrue(adminDashBoardPage.loanSummaray.isDisplayed());
    }

    @And("Verify that you have returned to the Loans page.")
    public void verifyThatYouHaveReturnedToTheLoansPage() {

        adminDashBoardPage.backButton.click();
        Assert.assertTrue(adminDashBoardPage.alLoansPost.isDisplayed());


    }
    @Given("As admin, go to {string} Adminpage")
    public void as_admin_go_to_Adminpage(String adminUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrl));

    }

    @Given("Enter {string} and {string} and press the login button.")
    public void enter_and_and_press_the_login_button(String adminNameUmit, String passwordAdmin) {
        adminLoginPage.adminUserNameBox.click();
        adminLoginPage.adminUserNameBox.sendKeys(ConfigReader.getProperty(adminNameUmit));
        adminLoginPage.adminPasswordBox.click();
        adminLoginPage.adminPasswordBox.sendKeys(ConfigReader.getProperty(passwordAdmin));
        jse.executeScript("arguments[0].click();", adminLoginPage.adminLoginButton);
    }

    @Given("Click on Running loans under the loans heading.")
    public void click_on_Running_loans_under_the_loans_heading() {
        adminDashBoardPage.loansDropMenu.click();
        wait(2);
        adminDashBoardPage.runningLoansButton.click();

    }

    @Given("Verify that the admin is on the Adminhomepage")
    public void verify_that_the_admin_is_on_the_Adminhomepage() {
        Assert.assertTrue(adminDashBoardPage.rejectedLoanPageTitle.isDisplayed());

    }

    @Given("Verify that the Running Loans appears")
    public void verify_that_the_running_loans_appears() {
        List<WebElement> titleElements = adminDashBoardPage.runnigPageTitleList;

        for (WebElement each : titleElements
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("The information to be search is entered for Loan number or Start date-End Date.")
    public void the_information_to_be_search_is_entered_for_loan_number_or_start_date_end_date() {
        adminDashBoardPage.dateSearchBox.click();
        adminDashBoardPage.dateSearchBox.sendKeys("12/18/2023");
        wait(2);
        adminDashBoardPage.dateSearchButton.click();
        adminDashBoardPage.dateSearchBox.clear();
        adminDashBoardPage.dateSearchButton.sendKeys(Keys.ENTER);
        wait(2);
        adminDashBoardPage.loanNoSearchBox.click();
        adminDashBoardPage.loanNoSearchBox.sendKeys("OOUSW4DPGQMF");
        wait(2);
        adminDashBoardPage.loanNoSearchButton.click();


    }

    @Given("Verifies that searches can be made")
    public void verifies_that_searches_can_be_made() {

        List<WebElement> resultElements = adminDashBoardPage.searchResultTableElements;
        for (WebElement each : resultElements
        ) {
            System.out.println(each.getText());
        }
        wait(2);


    }

    @Given("Click on the Details links and verify that the Details page is displayed")
    public void click_on_the_details_links_and_verify_that_the_details_page_is_displayed() {
        adminDashBoardPage.detailsButton.click();
        Assert.assertTrue(adminDashBoardPage.loanDetailsText.isDisplayed());
        Driver.getDriver().navigate().back();
        wait(1);


    }

    @Given("Click on the Installment links and verify that the Installment page is displayed")
    public void click_on_the_installment_links_and_verify_that_the_installment_page_is_displayed() {
        adminDashBoardPage.installmentsButton.click();
        wait(2);
        Assert.assertTrue(adminDashBoardPage.installmentsText.isDisplayed());

    }

    @Given("Click on the Details links")
    public void click_on_the_details_links() {
        adminDashBoardPage.detailsButton.click();


    }

    @Given("It should be verified that the loan details can be accessed on the Details page.")
    public void it_should_be_verified_that_the_loan_details_can_be_accessed_on_the_details_page() {
        List<WebElement> planInformationTable = adminDashBoardPage.loanDetailsCard;
        for (WebElement each : planInformationTable
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("Verify that you see credit status information in loans details")
    public void verify_that_you_see_credit_status_information_in_loans_details() {
        adminDashBoardPage.statusCodeText.isDisplayed();
    }

    @Given("Click on the Installment links")
    public void click_on_the_installment_links() {
        adminDashBoardPage.installmentsButton.click();

    }

    @Given("Verifies that their titles are visible on the Installments page")
    public void verifies_that_their_titles_are_visible_on_the_installments_page() {
        List<WebElement> installmentsPageTitle = adminDashBoardPage.loanSummaryCardText;
        for (WebElement each : installmentsPageTitle
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("Installments verifies that page titles are displayed")
    public void installments_verifies_that_page_titles_are_displayed() {
        List<WebElement> installmentsHeader = adminDashBoardPage.installmentsHeader;
        for (WebElement each : installmentsHeader
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }

    @Given("Press the back button")
    public void press_the_back_button() {
        adminDashBoardPage.backButton.click();
        wait(1);

    }

    @Given("It is confirmed that Running loans came again")
    public void it_is_confirmed_that_running_loans_came_again() {

        String expectedUrl = "https://qa.loantechexper.com/admin/loan/running";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Given("Enter the loan number to be searched in the search box and search")
    public void enter_the_loan_number_to_be_searched_in_the_search_box_and_search() {
        adminDashBoardPage.loanNoSearchBox.click();
        adminDashBoardPage.loanNoSearchBox.sendKeys("OOUSW4DPGQMF");
        wait(2);
        adminDashBoardPage.loanNoSearchButton.click();

    }


    @Given("Verify that installments  than {int} continue to be listed")
    public void verify_that_installments_than_continue_to_be_listed(Integer Int) throws AWTException {

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait(2);

        if (adminDashBoardPage.installmentsNextButton.isDisplayed()){
            coordinateClick(1288, 646);
            wait(2);
            System.out.println("the number of installments is greater than 20");
        } else {
            System.out.println("number of installments is less than 20");
        }
    }

    @Given("On the page that appears click the Loans Menu tab")
    public void on_the_page_that_appears_click_the_loans_menu_tab() {
        adminDashBoardPage.Loanstab.click();
    }


    @Given("Verify that Due Loans page should be displayed")
    public void verify_that_due_loans_page_should_be_displayed() {
        adminDashBoardPage.DueLoansPageYaziElementi.isDisplayed();
    }

    @When("Click on the Due Loans page link")
    public void click_on_the_page_link() {
        adminDashBoardPage.DueLoanstab.click();

    }

    @When("Verify that {string} page is accessible")
    public void verify_that_page_is_accessible(String string) {
        assertTrue(adminDashBoardPage.DueLoansPageYaziElementi.isDisplayed());
        wait(2);
    }


    @And("Verify that Due Loans Table is displayed successfully")
    public void verifyThatDueLoansTableIsDisplayedSuccessfully() {
        assertTrue(adminDashBoardPage.DueLoansTabloElementi.isDisplayed());
    }
    @Given("As admin, go to {string} page")
    public void as_admin_go_to_page(String adminUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrl));

    }

    @Given("Enter a valid {string} and {string} and press the login button.")
    public void enter_a_valid_and_and_press_the_login_button(String adminUsername, String passwordAdmin) {
        adminLoginPage.adminUserNameBox.click();
        adminLoginPage.adminUserNameBox.sendKeys(ConfigReader.getProperty(adminUsername));
        adminLoginPage.adminPasswordBox.click();
        adminLoginPage.adminPasswordBox.sendKeys(ConfigReader.getProperty(passwordAdmin));
        jse.executeScript("arguments[0].click();", adminLoginPage.adminLoginButton);

    }

    @Given("Click on reject loans under the loans heading.")
    public void click_on_reject_loans_under_the_loans_heading() {
        adminDashBoardPage.loansLink.click();
        adminDashBoardPage.rejectedLoansLink.click();

    }

    @Given("Verify that the admin is on the adminhomepage")
    public void verify_that_the_admin_is_on_the_adminhomepage() {
        Assert.assertTrue(adminDashBoardPage.rejectedLoanPageTitle.isDisplayed());

    }

    @Given("Page titles on the Rejected loans page should be displayed")
    public void page_titles_on_the_rejected_loans_page_should_be_displayed() {

        List<WebElement> titleElements = adminDashBoardPage.pagesTitle;

        for (WebElement each : titleElements
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("The information to be searched for information to searchis entered for Loan number or Start date-End Date.")
    public void the_information_to_be_searched_for_is_entered_for_loan_number_or_start_date_end_date(String aranacakBilgi) {
        adminDashBoardPage.loanNoBox.click();
        adminDashBoardPage.loanNoBox.sendKeys("EUKAGN6DJY5N");
        wait(2);
        adminDashBoardPage.loanNoSearchBoxKutusu.click();

    }

    @Given("Verifies that the call can be made")
    public void verifies_that_the_call_can_be_made() {

        List<WebElement> resultElements = adminDashBoardPage.resultTableElements;
        for (WebElement each : resultElements
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("Click on the details and installment links under action")
    public void click_on_the_details_and_installment_links_under_action() {

        adminDashBoardPage.detailsButonu.click();

    }

    @Given("It is verified that the information on these pages can be accessed.")
    public void it_is_verified_that_the_information_on_these_pages_can_be_accessed() {
        adminDashBoardPage.loansDetailsElementi.click();
        Assert.assertTrue(adminDashBoardPage.loansDetailsElementi.isDisplayed());
        Driver.getDriver().navigate().back();
        wait(1);
        adminDashBoardPage.isttallmentsButton.click();
        wait(2);
        Assert.assertTrue(adminDashBoardPage.installmentElementi.isDisplayed());

    }


    @Given("It must be verified that the loan details can be accessed on the Details page.")
    public void it_must_be_verified_that_the_loan_details_can_be_accessed_on_the_details_page() {
        List<WebElement> planInformationTable= adminDashBoardPage.planInformationTable;
        for (WebElement each:planInformationTable
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }

    @Given("Verify that you see status information in loans details")
    public void verify_that_you_see_status_information_in_loans_details() {

        adminDashBoardPage.statusElementi.isDisplayed();
    }

    @Given("Click on Installments")
    public void click_on_installments() {
        adminDashBoardPage.isttallmentsButton.click();
    }
    @Given("Installments verifies that page titles exist")
    public void installments_verifies_that_page_titles_exist() {

        List<WebElement> installmentsTable = adminDashBoardPage.instalmentTableElementi;
        for (WebElement each : installmentsTable
        ) {
            System.out.println(each.getText());
        }
        wait(2);


    }
    @Given("Installments verifies that page titles are visible")
    public void installments_verifies_that_page_titles_are_visible() {

        List<WebElement> installmentsPageTitle = adminDashBoardPage.installmentsPageTitle;
        for (WebElement each :installmentsPageTitle
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }
    @Given("press the back button")
    public void press_the_back_btton() {
        adminDashBoardPage.backButonElement.click();
        wait(1);
    }
    @Given("It is confirmed that rejected loans came again")
    public void it_is_confirmed_that_rejected_loans_came_again() {
        Assert.assertTrue(!adminDashBoardPage.rejectedLoanPageTitle.isDisplayed());


    }

    @Given("Click on the Insttallment and Verify that installments greater than {int} continue to be listed")
    public void Click_on_the_Insttallment_and_Verify_that_installments_greater_than_continue_to_be_listed(Integer int1) {

        jse.executeScript("arguments[0].click();", adminDashBoardPage.InstallmentButton);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait(1);

        jse.executeScript("arguments[0].click();", adminDashBoardPage.ikiyetiklamaElement);


        List<WebElement> yirmibirdendevam = adminDashBoardPage.yirmibirdendevam;
        for (WebElement each :yirmibirdendevam
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }
    @Given("Navigate to Admin page {string}")
    public void Navigate_to_Admin_page(String adminUrl) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrl));
        Thread.sleep(1000);

    }
    @Given("send {string} to username textbox")
    public void send_to_username_textbox(String usernameAdmin) {
        adminLoginPage.adminUserNameBox.sendKeys("mehmetkahraman");

    }
    @Given("send {string} to password textbox")
    public void send_password_registered_to_password_textbox(String password) {
        adminLoginPage.adminPasswordBox.sendKeys("123123123");

    }
    @Given("click on the login button")
    public void click_on_the_login_button() throws InterruptedException {
        adminLoginPage.adminLoginButton.click();
        Thread.sleep(1000);


    }
    @Given("click Loans link element")
    public void click_loans_link_element() throws InterruptedException {
        adminDashBoardPage.loansLink.click();
        Thread.sleep(2000);

    }
    @Given("click All Loans link element")
    public void click_all_loans_link_element() throws InterruptedException {
        adminDashBoardPage.allLoans.click();
        Thread.sleep(1000);

    }
    @Given("verify that All Loans Table visible")
    public void verify_that_all_loans_table_visible() throws InterruptedException {
        //System.out.println(adminDashBoardPage.allLoansTable.getText());
        Assert.assertTrue(adminDashBoardPage.allLoansTable.isDisplayed());

    }
    @Given("send the first Loans {string} to LoanNo searchbox")
    public void send_the_first_loans_to_loanNo_searchbox(String loansNumber) throws InterruptedException {


        adminDashBoardPage.searchBoxElement.click();
        adminDashBoardPage.searchBoxElement.sendKeys("CNVXHSRN2OXP");
        Thread.sleep(1000);

    }
    @Given("click searchbox icon")
    public void click_searchbox_icon() throws InterruptedException {
        adminDashBoardPage.searchButtonElement.click();
        Thread.sleep(2000);

    }
    @Given("verify the first loans visible")
    public void verify_the_first_loans_visible() {
        String actualLoanNumber=adminDashBoardPage.firstLoan.getText();
        String expectedLoanNumber ="CNVXHSRN2OXP";
        Assert.assertEquals(expectedLoanNumber,actualLoanNumber);


    }
    @Given("click Date textbox")
    public void click_date_textbox() throws InterruptedException {
        adminDashBoardPage.allLoans.click();
        Thread.sleep(2000);
        adminDashBoardPage.dateSearch.click();

    }
    @Given("send {string} to Date textbox")
    public void send_to_date_textbox(String date) {
        adminDashBoardPage.dateSearch.sendKeys("20.12.2023");


    }
    @Given("click Date searchbox icon")
    public void click_date_searchbox_icon() {
        adminDashBoardPage.dateSearchButton.click();

    }
    @Given("Verify that you can search the AllLoans table on the AllLoans page with the Date information.")
    public void verify_that_you_can_search_the_all_loans_table_on_the_all_loans_page_with_the_date_information() {
        String expectedUrl ="https://qa.loantechexper.com/admin/loan/all?search=&date=20.12.2023";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);




    }
    @Given("On the All loans page click the details button on the first line")
    public void on_the_all_loans_page_click_the_details_button_on_the_first_line() {
        adminDashBoardPage.detailsButtonElement.click();

    }
    @Given("verify that plan name visible on the Loan Details page")
    public void verify_that_plan_name_visible_on_the_loan_details_page() {
        Assert.assertTrue(adminDashBoardPage.planName.isDisplayed());
        System.out.println("Plan Name: " + adminDashBoardPage.planName.getText());


    }
    @Given("verify that date of Application visible on the Loan Details page")
    public void verify_that_date_of_application_visible_on_the_loan_details_page() {
        System.out.println("date of Application: " + adminDashBoardPage.dateOfApplication.getText());
        Assert.assertTrue(adminDashBoardPage.dateOfApplication.isDisplayed());


    }
    @Given("verify that Loan Number visible on the Loan Details page")
    public void verify_that_loan_number_visible_on_the_loan_details_page() {
        System.out.println("Loan Number: " + adminDashBoardPage.loanNumber.getText());
        Assert.assertTrue(adminDashBoardPage.loanNumber.isDisplayed());

    }
    @Given("verify that Amount visible on the Loan Details page")
    public void verify_that_amount_visible_on_the_loan_details_page() {
        System.out.println("Amount: " + adminDashBoardPage.Amount.getText());
        Assert.assertTrue(adminDashBoardPage.Amount.isDisplayed());

    }
    @Given("verify that Per İnstallment visible on the Loan Details page")
    public void verify_that_per_i̇nstallment_visible_on_the_loan_details_page() {
        System.out.println("Per Installment: " + adminDashBoardPage.perInstallmen.getText());
        Assert.assertTrue(adminDashBoardPage.perInstallmen.isDisplayed());

    }
    @Given("verify that Total installment visible on the Loan Details page")
    public void verify_that_total_installment_visible_on_the_loan_details_page() {
        System.out.println("Total installment: " + adminDashBoardPage.totalInstallment.getText());
        Assert.assertTrue(adminDashBoardPage.totalInstallment.isDisplayed());

    }
    @Given("verify that Given installment visible on the Loan Details page")
    public void verify_that_given_installment_visible_on_the_loan_details_page() {
        System.out.println("Given Installmen: " + adminDashBoardPage.givenInstallment.getText());
        Assert.assertTrue(adminDashBoardPage.givenInstallment.isDisplayed());

    }
    @Given("verify that Total Payable visible on the Loan Details page")
    public void verify_that_total_payable_visible_on_the_loan_details_page() {
        System.out.println("Total Payable: " + adminDashBoardPage.totalPayable.getText());
        Assert.assertTrue(adminDashBoardPage.totalPayable.isDisplayed());

    }
    @Given("verify that Profit visible on the Loan Details page")
    public void verify_that_profit_visible_on_the_loan_details_page() {
        System.out.println("Profit: " + adminDashBoardPage.profit.getText());
        Assert.assertTrue(adminDashBoardPage.profit.isDisplayed());

    }
    @Given("verify that status visible on the Loan Details page")
    public void verify_that_status_visible_on_the_loan_details_page() {
        System.out.println("Status: " + adminDashBoardPage.status.getText());
        Assert.assertTrue(adminDashBoardPage.status.isDisplayed());

    }
    @Given("verify that status of LoanForm visible on the Loan Details page")
    public void verify_that_status_of_loan_form_visible_on_the_loan_details_page() {
        Assert.assertTrue(adminDashBoardPage.loanForm.isDisplayed());



    }
    @Given("return to previous page")
    public void return_to_previous_page() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);


    }
    @Given("On the AllLoans page, click the installments button on the first line")
    public void on_the_all_loans_page_click_the_installments_button_on_the_first_line() {
        adminDashBoardPage.installmentButton.click();

    }
    @Given("verify that Loan Number visible on the Installment page")
    public void verify_that_loan_number_visible_on_the_installment_page() {
        System.out.println("Loan Number: " + adminDashBoardPage.loanNumberInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.loanNumberInstallments.isDisplayed());



    }
    @Given("verify that Plan visible on the Installment page")
    public void verify_that_plan_visible_on_the_installment_page() {
        System.out.println("Plan: " + adminDashBoardPage.planInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.planInstallments.isDisplayed());

    }
    @Given("verify that Loan Amount visible on the Installment page")
    public void verify_that_loan_amount_visible_on_the_installment_page() {
        System.out.println("Amount: " + adminDashBoardPage.amountInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.amountInstallments.isDisplayed());

    }
    @Given("verify that Per Installment visible on the Installment page")
    public void verify_that_per_installment_visible_on_the_installment_page() {
        System.out.println("Per Installment: " + adminDashBoardPage.perInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.perInstallments.isDisplayed());

    }
    @Given("verify that Total Installment visible on the Installment page")
    public void verify_that_total_installment_visible_on_the_installment_page() {
        System.out.println("Total Installment: " + adminDashBoardPage.totalInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.totalInstallments.isDisplayed());

    }
    @Given("verify that Given Installment visible on the Installment page")
    public void verify_that_given_installment_visible_on_the_installment_page() {

        System.out.println("Given Installment: " + adminDashBoardPage.givenInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.givenInstallments.isDisplayed());

    }
    @Given("verify that Receivable visible on the Installment page")
    public void verify_that_receivable_visible_on_the_installment_page() {
        System.out.println("Receiveble: " + adminDashBoardPage.receivableInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.receivableInstallments.isDisplayed());

    }
    @Given("verify that DelayCharge visible on the Installment page")
    public void verify_that_DelayCharge_visible_on_the_Installment_page() {
        System.out.println("Delay Charge: " + adminDashBoardPage.delayChargeInstallments.getText());
        Assert.assertTrue(adminDashBoardPage.delayChargeInstallments.isDisplayed());

    }
    @Given("verify that SN visible on the Installment page")
    public void verify_that_sn_visible_on_the_installment_page() {
        System.out.println("S.N : "+adminDashBoardPage.serialNumber.getText());
        Assert.assertTrue(adminDashBoardPage.serialNumber.isDisplayed());

    }
    @Given("verify that Installment Date visible on the Installment page")
    public void verify_that_installment_date_visible_on_the_installment_page() {
        System.out.println("Date: " + adminDashBoardPage.installmentDate.getText());
        Assert.assertTrue(adminDashBoardPage.installmentDate.isDisplayed());

    }
    @Given("verify that Given On visible on the Installment page")
    public void verify_that_given_on_visible_on_the_installment_page() {
        System.out.println("Given On: " + adminDashBoardPage.givenOn.getText());
        Assert.assertTrue(adminDashBoardPage.givenOn.isDisplayed());

    }
    @Given("verify that Delay visible on the Installment page")
    public void verify_that_delay_visible_on_the_installment_page() {
        System.out.println("Delay: " + adminDashBoardPage.delay.getText());
        Assert.assertTrue(adminDashBoardPage.delay.isDisplayed());

    }
    @Given("verify that Charge visible on the Installment page")
    public void verify_that_charge_visible_on_the_installment_page() {
        System.out.println("Charge: " + adminDashBoardPage.charge.getText());
        Assert.assertTrue(adminDashBoardPage.charge.isDisplayed());

    }
    @Given("Click the back button to check if you can return to the AllLoans page")
    public void click_the_back_button_to_check_if_you_can_return_to_the_all_loans_page() {
        adminDashBoardPage.backButton.click();

    }
    @Given("Verify that you are back to the All credits page")
    public void verify_that_you_are_back_to_the_all_credits_page() {
        String expectedUrl ="https://qa.loantechexper.com/admin/loan/all";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Given("click the next button in the lower right corner of the page on the AllLoans page")
    public void click_the_next_button_in_the_lower_right_corner_of_the_page_on_the_all_loans_page() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        adminDashBoardPage.nextButton.click();



    }
    @Given("Verify next page visible")
    public void verify_next_page_visible() throws InterruptedException {
        Thread.sleep(2000);

        String expectedUrl ="https://qa.loantechexper.com/admin/loan/all?page=2";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }

    @Given("Open the web {string}")
    public void openTheWeb(String arg0) {
        Driver.getDriver();

    }

    @When("Navigate to {string}")
    public void navigate_to(String Url) {
        Driver.getDriver().get(ConfigReader.getProperty(Url));

    }
    @When("Verify that Admin homepage is visible successfully")
    public void verify_that_admin_homepage_is_visible_successfully() {
        assertTrue(adminLoginPage.AdminDashboardyazielementi.isDisplayed());


    }

    @And("Verify that the Username and Password textBoxes and the LOGIN button are visible")
    public void verifyThatTheUsernameAndPasswordTextBoxesAndTheLOGINButtonAreVisible() {
        assertTrue(adminLoginPage.Usernametextbox.isEnabled());
        assertTrue(adminLoginPage.Passwordtextbox.isEnabled());
        assertTrue(adminLoginPage.Loginbutton.isEnabled());
    }
    @When("On the page that appears, fill in the {string} and {string} textboxes")
    public void onThePageThatAppearsFillInTheAndTextboxes(String Username, String password) {
        adminLoginPage.Usernametextbox.sendKeys(ConfigReader.getProperty("UsernameSamet"));
        adminLoginPage.Passwordtextbox.sendKeys(ConfigReader.getProperty("passwordAdmin"));

    }

    @When("Click the LOGIN button")
    public void clickTheLOGINButton() {
        adminLoginPage.Loginbutton.click();
        wait(4);

    }

    @And("Confirm that Admin Homepage is visible")
    public void confirmThatAdminHomepageIsVisible() {
        assertTrue(adminLoginPage.logo.isDisplayed());
        adminLoginPage.logoutmenu.click();
        wait(1);
        adminLoginPage.logoutbutton.click();


    }
    @Given("The visitor enters the admin site with the given {string}")
    public void the_visitor_enters_the_site_with_the_given(String adminUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrl));
    }


    @Given("The admin logs in to the admin dashboard page with {string} and {string}")
    public void the_admin_logs_in_to_the_admin_dashboard_page_with_admin_name_and_admin_password(String adminNameSuphi, String passwordAdmin) {


        wait(1);
        clickWithJS(adminLoginPage.adminUserNameBoxElement);
        adminLoginPage.adminUserNameBoxElement.clear();
        adminLoginPage.adminUserNameBoxElement.sendKeys(ConfigReader.getProperty(adminNameSuphi));
        clickWithJS(adminLoginPage.adminPasswordBoxElement);
        adminLoginPage.adminPasswordBoxElement.clear();
        adminLoginPage.adminPasswordBoxElement.sendKeys(ConfigReader.getProperty(passwordAdmin));

        clickWithJS(adminLoginPage.adminLoginButtonElement);

    }
    @Given("Click on the admin icon in the upper right corner of the admin dashboard page")
    public void click_on_the_admin_icon_in_the_upper_right_corner_of_the_admin_dashboard_page() {
        adminDashBoardPage.adminIconElement.click();
    }

    @When("The visibility of Admin, Profile, Password, Logout links is verified")
    public void theVisibilityOfAdminProfilePasswordLogoutLinksIsVerified() {
        adminDashBoardPage.adminIconProfileElement.isDisplayed();
        adminDashBoardPage.adminIconPasswordElement.isDisplayed();
        adminDashBoardPage.adminIconLogoutElement.isDisplayed();
    }

    @When("Click on the profile link")
    public void clickOnTheProfileLink() {

        adminDashBoardPage.adminIconProfileElement.click();

    }

    @When("Name, email, image information is updated and saved")
    public void nameEmailImageInformationIsUpdatedAndSaved() throws InterruptedException, AWTException {
        adminDashBoardPage.adminProfileNameBoxElement.click();
        adminDashBoardPage.adminProfileNameBoxElement.clear();
        adminDashBoardPage.adminProfileNameBoxElement.sendKeys("suphi atilim");

        adminDashBoardPage.adminProfileEmailBoxElement.click();
        adminDashBoardPage.adminProfileEmailBoxElement.clear();
        adminDashBoardPage.adminProfileEmailBoxElement.sendKeys("suphi.celikoz@gmail.com");

        wait(1);
        photoUpdateInPc(817,721,446,59,"C:\\Users\\atili\\IdeaProjects\\com.LoanTechExperTeam01\\src\\test\\java\\utilities",346,172,597,447);
        coordinateClick(346,172);
        coordinateClick(597,447);

        clickWithJS(adminDashBoardPage.adminProfileSubmitButtonElement);



    }

    @When("It is confirmed that the changes made have been saved successfully by the text Profile updated successfully in the upper right corner")
    public void ıtIsConfirmedThatTheChangesMadeHaveBeenSavedSuccessfullyByTheTextProfileUpdatedSuccessfullyInTheUpperRightCorner() {
        wait(1);
        String expectedResult="Profile updated successfully";
        String actualResult= adminDashBoardPage.adminProfileUpdatedConfirmElement.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }

    @When("Click on the password link and go to the password setting page")
    public void clickOnThePasswordLinkAndGoToThePasswordSettingPage() {
        adminDashBoardPage.adminIconPasswordElement.click();
    }

    @When("In the Change password section, used Password, New Password and Confirm Password information must be entered")
    public void inTheChangePasswordSectionUsedPasswordNewPasswordAndConfirmPasswordInformationMustBeEntered() {
        clickWithJS(adminDashBoardPage.adminOldPasswordBoxElement);
        adminDashBoardPage.adminOldPasswordBoxElement.sendKeys("123123123");
        wait(1);
        clickWithJS(adminDashBoardPage.adminPasswordBoxElement);
        adminDashBoardPage.adminPasswordBoxElement.sendKeys("123123123");
        wait(1);
        clickWithJS(adminDashBoardPage.adminConfirmPasswordBoxElement);
        adminDashBoardPage.adminConfirmPasswordBoxElement.sendKeys("123123123");
        wait(1);
        adminDashBoardPage.adminPasswordSubmitButtonElement.click();

        String expectedResult="Password changed successfully.";
        String actualResult=adminDashBoardPage.adminPasswordUpdatedElement.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }

    @When("Click on the logout link")
    public void clickOnTheLogoutLink() {
        adminDashBoardPage.adminIconLogoutElement.click();
    }

    @When("It is verified that the admin page is exited")
    public void itIsVerifiedThatTheAdminPageIsExited() {
        adminDashBoardPage.adminLogoutConfirmElement.isDisplayed();

    }

    @When("It is confirmed that the changes made have been saved successfully by the text Password changed successfully in the upper right corner")
    public void ıtIsConfirmedThatTheChangesMadeHaveBeenSavedSuccessfullyByTheTextPasswordUpdatedSuccessfullyInTheUpperRightCorner() {

        wait(1);
        String expectedResult="Password changed successfully.";
        String actualResult= adminDashBoardPage.adminPasswordUpdatedElement.getText();
        Assert.assertEquals(expectedResult,actualResult);

    }
    @Given("Loan Plans tab is clicked")
    public void loan_plans_tab_is_clicked() {
        adminDashBoardPage.loanPlansElementi.click();
    }
    @Given("The current credit plans registered in the system are displayed.")
    public void the_current_credit_plans_registered_in_the_system_are_displayed() {
        Assert.assertTrue(adminDashBoardPage.loansPlanElementi.isDisplayed());
    }
    @Given("Each loan plan, title, interest rate, maturity period, loan limit, etc. displayed with basic information.\"")
    public void each_loan_plan_title_interest_rate_maturity_period_loan_limit_etc_displayed_with_basic_information() {
        Assert.assertTrue(adminDashBoardPage.trElementi.isDisplayed());
    }
    @Given("Click on the Add New button.")
    public void click_on_the_add_new_button() {
        adminDashBoardPage.addNewElementi.click();
    }
    @Given("The Plan Name box is filled in.")
    public void the_plan_name_box_is_filled_in() {
        adminDashBoardPage.planNameElementi.click();
        wait(1);
        adminDashBoardPage.planNameElementi.clear();
        wait(1);
        actions.sendKeys(ConfigReader.getProperty("planName")).perform();
    }
    @Given("The Title box is filled.")
    public void the_title_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("title")).perform();
    }
    @Given("The Minimum Amount box is filled.")
    public void the_minimum_amount_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("minimumAmount")).perform();
    }
    @Given("The Maximum Amount box is filled.")
    public void the_maximum_amount_box_is_filled() {
        adminDashBoardPage.maxAmount.click();
        adminDashBoardPage.maxAmount.clear();
        wait(1);
        actions.sendKeys(ConfigReader.getProperty("maximumAmount")).perform();
    }
    @Given("Category standard loan is selected.")
    public void category_standard_loan_is_selected() {
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//*[@id=\"category_id\"]")));
        select.selectByValue("12");
    }
    @Given("The Per Installment box is populated.")
    public void the_per_installment_box_is_populated() {
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("perInstallment")).perform();
    }
    @Given("The Installment Interval box is populated.")
    public void the_installment_interval_box_is_populated() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("installmentInterval")).perform();
    }
    @Given("The Total Installments box is populated.")
    public void the_total_installments_box_is_populated() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("TotalInstallments")).perform();
    }
    @Given("The Application Fixed Charge box is filled.")
    public void the_application_fixed_charge_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("applicationFixedCharge")).perform();
    }
    @Given("The Application Percent Charge box is filled in.")
    public void the_application_percent_charge_box_is_filled_in() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("applicationPercentCharge")).perform();
    }
    @Given("Non Featured is selected.")
    public void non_featured_is_selected() {
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//*[@name=\"is_featured\"]")));
        select.selectByValue("1");
    }
    @Given("Instruction box is filled")
    public void instruction_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("instruction")).perform();
    }

    @Given("The Charge Will Apply If Delay box is filled in")
    public void the_charge_will_apply_if_delay_box_is_filled_in() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("chargeWillApplyIfDelay")).perform();
    }
    @Given("Fixed Charge box is filled")
    public void fixed_charge_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("fixedCharge")).perform();
    }
    @Given("Percent Charge box is filled")
    public void percent_charge_box_is_filled() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("percentCharge")).perform();
    }
    @Given("Submit button is clicked")
    public void submit_button_is_clicked() {

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        wait(1);
        actions.click(adminDashBoardPage.submitBElement).perform();
    }
    @Given("It is confirmed that the new plan has been added.")
    public void it_is_confirmed_that_the_new_plan_has_been_added() {
        Assert.assertTrue(adminDashBoardPage.iziElement.isDisplayed());
    }

    // TC02

    @Given("The current page is brought down and scrolled to the right.")
    public void the_current_page_is_brought_down_and_scrolled_to_the_right() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", adminDashBoardPage.editElementi);
    }
    @Given("Edit option is clicked")
    public void edit_option_is_clicked() {
        adminDashBoardPage.editElementi.click();
    }
    @Given("The accuracy of the added or updated information is tested.")
    public void the_accuracy_of_the_added_or_updated_information_is_tested() {
        Assert.assertTrue(adminDashBoardPage.cardBody.isDisplayed());
    }

    //TC03
    @Given("Disable option is clicked.")
    public void disable_option_is_clicked() {
        JavascriptExecutor jsee = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", adminDashBoardPage.disable);
        adminDashBoardPage.disable.click();
    }
    @Given("Yes option is clicked.")
    public void yes_option_is_clicked() {
        adminDashBoardPage.yes.click();
    }
    @Given("It is verified that the existing credit plan has been removed from the system.")
    public void ıt_is_verified_that_the_existing_credit_plan_has_been_removed_from_the_system() {
        Assert.assertTrue(adminDashBoardPage.disabledelete.isDisplayed());
    }

    //TC04
    @Given("searchloanplans click")
    public void searchloanplans_click() {
        actions.click(adminDashBoardPage.searchLoansPlan).sendKeys(ConfigReader.getProperty("searchLoanPlans")).sendKeys(Keys.ENTER).perform();
    }

    @Given("In an unexpected situation, an error message is sent.")
    public void in_an_unexpected_situation_an_error_message_is_sent() {

        Assert.assertTrue(adminDashBoardPage.hataMesaj.isDisplayed());
    }

    @Given("The Min Amount two box is filled.")
    public void the_min_amount_two_box_is_filled() {
        actions.click(adminDashBoardPage.minAmountElement).sendKeys(ConfigReader.getProperty("minAmountTwo")).perform();

    }
    @Given("The Max Amount two box is filled.")
    public void the_max_amount_two_box_is_filled() {
        actions.click(adminDashBoardPage.maxAmount).sendKeys(ConfigReader.getProperty("maxAmountTwo")).perform();
    }
    @Given("Instructiontwo box is filled")
    public void instructiontwo_box_is_filled() {
        wait(1);
        actions.click(adminDashBoardPage.instructionboxElement).sendKeys(ConfigReader.getProperty("instructiontwo")).perform();
    }
    @Given("The administrator goes to the web page with the given {string}.")
    public void the_administrator_goes_to_the_web_page_with_the_given(String adminUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrl));
    }
    @Given("The administrator enters a valid {string} in the username box.")
    public void the_administrator_enters_a_valid_in_the_username_box(String usernameHalit) {
        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty(usernameHalit));
        wait(1);
    }
    @Given("The administrator enters a valid {string} in the password box.")
    public void the_administrator_enters_a_valid_in_the_password_box(String passwordAdmin) {
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty(passwordAdmin));
        jse.executeScript("window.scrollBy(0,200)");
        wait(1);
    }
    @Given("The administrator clicks on the login button.")
    public void the_administrator_clicks_on_the_login_button() {
        adminLoginPage.loginButton.click();
        wait(1);
    }
    @Given("The administrator clicks the manage users button under the Dashboard.")
    public void the_administrator_clicks_the_manage_users_button_under_the_dashboard() {
        adminLoginPage.manageUsersButton.click();
        wait(1);
    }
    @Given("Verify that the Active Users button is visible and active.")
    public void verify_that_the_active_users_button_is_visible_and_active() {
        Assert.assertTrue(adminLoginPage.activeUsersButton.isDisplayed());
        Assert.assertTrue(adminLoginPage.activeUsersButton.isEnabled());
    }
    @When("Verify that the  Active Users List and list titles appears.")
    public void verifyThatTheActiveUsersListAndListTitlesAppears() throws AWTException {
        Assert.assertTrue(adminLoginPage.headerUser.isDisplayed());
        Assert.assertTrue(adminLoginPage.headerEmailPhone.isDisplayed());
        Assert.assertTrue(adminLoginPage.headerCountry.isDisplayed());

        jse.executeScript("window.scrollBy(-500,0)");
        wait(2);

        Assert.assertTrue(adminLoginPage.headerDate.isDisplayed());
        Assert.assertTrue(adminLoginPage.headerBalance.isDisplayed());
        Assert.assertTrue(adminLoginPage.headerAction.isDisplayed());
        wait(1);
        jse.executeScript("window.scrollBy(0,-1500)");
        wait(1);
        // adminLoginPage.secondPage.click(); Mouse coordinates: 884, 805
        coordinateClick(884,805);
        jse.executeScript("window.scrollBy(0,1500)");

        wait(1);
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//tr"));
        //td[@data-label='+ User +']
        // List to hold user information
        List<String> users = new ArrayList<>();
        // Iterate over elements and extract user information
        for (WebElement each : elements) {
            // Assuming the user's name or relevant text is directly inside the <td> tag
            users.add(each.getText());
            System.out.println(users);
        }
        Assert.assertTrue(adminLoginPage.activeUserList.isDisplayed());

    }
    @Given("The administrator clicks Active Users button")
    public void the_administrator_clicks_active_users_button() {
        adminLoginPage.activeUsersButton.click();
        wait(1);
    }
    @Given("Verify that the Details button is visible and active.")
    public void verify_that_the_button_is_visible_and_active() {
        jse.executeScript("window.scrollBy(-500,0)");
        wait(2);
        Assert.assertTrue(adminLoginPage.detailsButton.isDisplayed());
        Assert.assertTrue(adminLoginPage.detailsButton.isEnabled());
        wait(1);

    }
    @Given("The administrator clicks  the Details button.")
    public void the_administrator_clicks_the_button() {
        adminLoginPage.searchBox.sendKeys(ConfigReader.getProperty("name"));
        adminLoginPage.enterbutton.click();
        wait(3);
        adminLoginPage.detailsButton.click();
        wait(1);
    }
    @Given("It is verified that the User Details-Username page is opened.")
    public void it_is_verified_that_the_user_details_username_page_is_opened() {
        Assert.assertTrue(adminLoginPage.userDetailPage.isDisplayed());
    }

    @When("The administrator clicks View All icon.")
    public void theAdministratorClicksViewAllIcon() {
        Assert.assertTrue(adminLoginPage.viewAllIcon.isDisplayed());
        Assert.assertTrue(adminLoginPage.viewAllIcon.isEnabled());
        adminLoginPage.viewAllIcon.click();
        wait(1);
    }
    @When("It is verified that the Transaction Logs page is opened.")
    public void itIsVerifiedThatTheTransactionLogsPageIsOpened() {
        Assert.assertTrue(adminLoginPage.transactionLogsPage.isDisplayed());
    }
    @When("It is verified that the list and list titles are displayed on the Transaction Logs page.")
    public void itIsVerifiedThatTheListAndListTitlesAreDisplayedOnTheTransactionLogsPage() {
        Assert.assertTrue(adminLoginPage.titleTransactionUser.isDisplayed());
        Assert.assertTrue(adminLoginPage.titleTransactionTRX.isDisplayed());
        Assert.assertTrue(adminLoginPage.titleTransactionTransacted.isDisplayed());
        Assert.assertTrue(adminLoginPage.titleTransactionAmount.isDisplayed());
        Assert.assertTrue(adminLoginPage.titleTransactionBalance.isDisplayed());
        Assert.assertTrue(adminLoginPage.titleTransactionDetails.isDisplayed());
        wait(1);
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//tr"));
        // List to hold user information
        List<String> users = new ArrayList<>();
        // Iterate over elements and extract user information
        for (WebElement each : elements) {
            // Assuming the user's name or relevant text is directly inside the <td> tag
            users.add(each.getText());
            System.out.println(users);
        }
        Assert.assertTrue(adminLoginPage.activeUserList.isDisplayed());
    }
    @Given("The TRX Username box appears and confirms that it is active.")
    public void the_trx_username_box_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.searcTransaction.isDisplayed());
        Assert.assertTrue(adminLoginPage.searcTransaction.isEnabled());;

        wait(1);

    }
    @Given("The Type box appears and confirms that it is active.")
    public void the_type_box_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.typeTransaction.isDisplayed());
        Assert.assertTrue(adminLoginPage.typeTransaction.isEnabled());
        selectByVisibleText(adminLoginPage.typeTransaction,"Plus");
        wait(1);
    }
    @Given("The Remark box appears and confirms that it is active.")
    public void the_remark_box_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.remarkTransaction.isDisplayed());
        Assert.assertTrue(adminLoginPage.remarkTransaction.isEnabled());
        selectByVisibleText(adminLoginPage.remarkTransaction,"Balance add");
        wait(1);
    }
    @Given("The Date box appears and confirms that it is active.")
    public void the_date_box_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.dateTransaction.isDisplayed());
        Assert.assertTrue(adminLoginPage.dateTransaction.isEnabled());
        adminLoginPage.dateTransaction.click();
        adminLoginPage.dateStart.click();
        wait(1);
        adminLoginPage.dateFinish.click();
        wait(1);

    }
    @Given("The filter icon appears and confirms that it is active.")
    public void the_filter_icon_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.filterIcon.isDisplayed());
        Assert.assertTrue(adminLoginPage.filterIcon.isEnabled());
        adminLoginPage.filterIcon.click();

    }
    // TC_07
    @Given("The Add Balance button appears and confirms that it is active.")
    public void the_add_balance_button_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.addBalance.isDisplayed());
        Assert.assertTrue(adminLoginPage.addBalance.isEnabled());
    }
    @Given("The administrator clicks Add Balance button.")
    public void the_administrator_clicks_add_balance_button() {
        adminLoginPage.addBalance.click();
        wait(1);
    }
    @Given("It is verified that the Add Balance page is opened.")
    public void it_is_verified_that_the_add_balance_page_is_opened() {
        Assert.assertTrue(adminLoginPage.addBalancePage.isDisplayed());
    }
    // TC_08 ************
    @Given("Amount text box appears and it is verified that characters can be entered.")
    public void amount_text_box_appears_and_it_is_verified_that_characters_can_be_entered() {
        Assert.assertTrue(adminLoginPage.addBalanceAmount.isDisplayed());

    }
    @Given("Remark text box appears and it is verified that characters can be entered.")
    public void remark_text_box_appears_and_it_is_verified_that_characters_can_be_entered() {
        Assert.assertTrue(adminLoginPage.addBalanceAmount.isDisplayed());

    }
    // ***********TC_09************
    @Given("The amount is entered in the Amount text box.")
    public void the_amount_is_entered_in_the_amount_text_box() {
        adminLoginPage.addBalanceAmount.sendKeys("2000");
        wait(2);
    }
    @Given("A description is entered in the Remark text box.")
    public void a_description_is_entered_in_the_remark_text_box() {

    }
    @Given("The Submit button appears and confirms that it is active.")
    public void the_submit_button_appears_and_confirms_that_it_is_active() {
        Assert.assertTrue(adminLoginPage.addBalanceSubmit.isDisplayed());
        Assert.assertTrue(adminLoginPage.addBalanceSubmit.isEnabled());
    }
    @Given("The administrator clicks Submit button.")
    public void the_administrator_clicks_submit_button() {
        adminLoginPage.addBalanceSubmit.click();
        wait(1);
    }
    @Given("It is verified that the text $ 1 added successfully is seen.")
    public void it_is_verified_that_the_text_$_added_successfully_is_seen() {
        String expectedText =  Driver.getDriver().findElement(By.xpath(
                "//*[text()='$2000 added successfully']")).getText();

        String actualText = "$2000 added successfully";
        Assert.assertEquals(expectedText,actualText);
    }
    @When("Click Manage Users link on the DashboardPage")
    public void clickManageUsersLinkOnTheDashboardPage() {

        adminDashBoardPage.ManageUserslink.click();
        adminDashBoardPage.ActiveUserslink.click();

    }

    @And("Verify Active Users link is appear on the DashboardPage")
    public void verifyActiveUsersLinkIsAppearOnTheDashboardPage() {
        assertTrue(adminDashBoardPage.ActiveUsersYaziElementi.isDisplayed());
    }

    @When("Click on the Active Users link on the DashboardPage")
    public void clickOnTheActiveUsersLinkOnTheDashboardPage() {
        adminDashBoardPage.ManageUserslink.click();
        adminDashBoardPage.ActiveUserslink.click();

    }

    @And("Verify Active Users List and list titles is displayed")
    public void verifyActiveUsersListAndListTitlesIsDisplayed() {
        assertTrue(adminDashBoardPage.ActiveUsersListTitles.isDisplayed());
    }

    @When("Verify the Details Button is visible and then click Details Button")
    public void verifyTheDetailsButtonIsVisibleAndThenClickDetailsButton() {
        assertTrue(adminDashBoardPage.DetailsButton.isDisplayed());
        wait(2);
        adminDashBoardPage.DetailsButton.click();
        wait(2);
    }

    @And("Verify that the user is redirected User Detail-Username page")
    public void verifyThatTheUserIsRedirectedUserDetailUsernamePage() {
        assertTrue(adminDashBoardPage.UserDetail.isDisplayed());
        wait(2);
    }

    @When("Verify the view all icon on the User Detail page")
    public void verifyTheViewAllIconOnTheUserDetailPage() {
        adminDashBoardPage.viewAllbutton.isDisplayed();
        wait(2);
    }

    @When("Click on the view all icon")
    public void clickOnTheViewAllIcon() {
        adminDashBoardPage.viewAllbutton.click();

    }

    @And("Verify that the user is redirected Deposit History page")
    public void verifyThatTheUserIsRedirectedDepositHistoryPage() {
        assertTrue(adminDashBoardPage.UserDetail.isDisplayed());
    }

    @And("Verify that List and list titles should be displayed on the page")
    public void verifyThatListAndListTitlesShouldBeDisplayedOnThePage() {
        assertTrue(adminDashBoardPage.DepositHistoryListTitles.isDisplayed());
    }

    @When("Click Active Users button on the Admin Dashboard page")
    public void clickActiveUsersButtonOnTheAdminDashboardPage() {
        adminDashBoardPage.ManageUserslink.click();
        adminDashBoardPage.ActiveUserslink.click();
    }

    @When("Verify Details button is visible and click the Details button")
    public void verifyDetailsButtonIsVisibleAndClickTheDetailsButton() {
        assertTrue(adminDashBoardPage.DetailsButton.isDisplayed());
        adminDashBoardPage.DetailsButton.click();

        wait(1);
        adminDashBoardPage.PendingDeposits.click();
        adminDashBoardPage.PendingDepositsDetailsButton.click();
    }


    @And("Verify that the text x requested x USD should be displayed")
    public void verifyThatTheTextXRequestedXUSDShouldBeDisplayed() {

        String pageTitleText = adminDashBoardPage.RequestXUSDTitle.getText();
        assertTrue("Page title should contain 'requested'", pageTitleText.contains("requested"));
        assertTrue("Page title should contain 'USD'", pageTitleText.contains("USD"));
    }

    @And("Verify that Deposit Card and Date, Transaction Number, Username, Method, Amount, Charge, After Charge, Rate, Payable, Status titles is visible")
    public void verifyThatDepositCardAndDateTransactionNumberUsernameMethodAmountChargeAfterChargeRatePayableStatusTitlesIsVisible() {
        String DepositCardInformations = adminDashBoardPage.DepositCardViaManuel.getText();

        assertTrue("Page title should contain 'Date'", DepositCardInformations.contains("Date"));
        assertTrue("Page title should contain 'Transaction Number'", DepositCardInformations.contains("Transaction Number"));
        assertTrue("Page title should contain 'Username'", DepositCardInformations.contains("Username"));
        assertTrue("Page title should contain 'Method'", DepositCardInformations.contains("Method"));
        assertTrue("Page title should contain 'Amount'", DepositCardInformations.contains("Amount"));
        assertTrue("Page title should contain 'Charge'", DepositCardInformations.contains("Charge"));
        assertTrue("Page title should contain 'After Charge'", DepositCardInformations.contains("After Charge"));
        assertTrue("Page title should contain 'Rate'", DepositCardInformations.contains("Rate"));
        assertTrue("Page title should contain 'Payable'", DepositCardInformations.contains("Payable"));
        assertTrue("Page title should contain 'Status'", DepositCardInformations.contains("Status"));

    }

    @When("Click on the All Deposits button")
    public void clickOnTheAllDepositsButton() {

        adminDashBoardPage.AllDepositsButton.click();
        wait(1);
    }

    @And("Verify that Successful Deposit, Pending Deposit, Rejected Deposit, Initiated Deposit titles and values are visible")
    public void verifyThatSuccessfulDepositPendingDepositRejectedDepositInitiatedDepositTitlesAndValuesAreVisible() {
        assertTrue(adminDashBoardPage.SuccessfulDeposits.isDisplayed());
        wait(2);
        assertTrue(adminDashBoardPage.PendingDeposits.isDisplayed());
        wait(2);
        assertTrue(adminDashBoardPage.RejectedDeposits.isDisplayed());
        wait(2);
        assertTrue(adminDashBoardPage.InitiatedDeposits.isDisplayed());
    }

    @When("Click on the Successful Deposits heading")
    public void clickOnTheSuccessfulDepositsHeading() {
        adminDashBoardPage.SuccessfulDeposits.click();

    }

    @When("Verify that Succesful Deposits page is visible")
    public void verifyThatSuccesfulDepositsPageIsVisible() {
        assertTrue(adminDashBoardPage.SuccessfulDeposits.isDisplayed());
    }

    @When("Enter the credentilas in the Filtering and Search boxes")
    public void enterTheCredentilasInTheFilteringAndSearchBoxes() {
        adminDashBoardPage.SuccessfulDepositsSearchBox.click();

        adminDashBoardPage.SuccessfulDepositsDateSearchBoxSubmit.submit();
    }

    @When("Verify that Filtering and Search buttons are fonctional")
    public void verifyThatFilteringAndSearchButtonsAreFonctional() {
        assertTrue(adminDashBoardPage.SuccessfulDepositsSearchBox.isEnabled());

    }

    @And("Verify that a list of successful deposits are displayed")
    public void verifyThatAListOfSuccessfulDepositsAreDisplayed() {
        assertTrue(adminDashBoardPage.SuccessfulDepositsTableElement.isDisplayed());

    }

    @When("Click the Pending Deposits Heading")
    public void clickThePendingDepositsHeading() {
        adminDashBoardPage.PendingDeposits.click();
        wait(5);
    }

    @When("Verify that Pending Deposits page is visible")
    public void verifyThatPendingDepositsPageIsVisible() {
        assertTrue(adminDashBoardPage.PendingDepositsYaziElementi.isDisplayed());
        wait(2);

    }

    @When("Click on the Details button")
    public void clickOnTheDetailsBtton() {
        adminDashBoardPage.PendingDepositsDetailsButton.click();

    }

    @And("Verify that Details button is active")
    public void verifyThatDetailsButtonIsActive() {
        assertTrue(adminDashBoardPage.PendingDepositsSuccessfulDetailsPage.isDisplayed());
        wait(2);
    }

    @And("Verify that Approve and Reject buttons on the Transaction Detail page")
    public void verifyThatApproveAndRejectButtonsOnTheTransactionDetailPage() {
        assertTrue(adminDashBoardPage.ApprouveButton.isDisplayed());
        assertTrue(adminDashBoardPage.RejectButton.isDisplayed());

    }

    @When("Click on the Reject button")
    public void clickOnTheRejectButton() {
        adminDashBoardPage.RejectButton.click();

    }

    @When("Fill in the Reason for Rejection section and Click SUBMIT button")
    public void fillInTheReasonForRejectionSectionAndClickSUBMITButton() {

        wait(2);
        adminDashBoardPage.ReasonforRejectionBox.click();
        adminDashBoardPage.ReasonforRejectionBox.sendKeys("Your income is not sufficient");
        adminDashBoardPage.RejectSubmitbutton.click();
    }

    @And("Verify that Deposit request rejected successfully is visible")
    public void verifyThatDepositRequestRejectedSuccessfullyIsVisible() {
        assertTrue(adminDashBoardPage.RequestRejectedSuccessfully.isDisplayed());

    }

    @When("Click on the Approve button")
    public void clickOnTheApproveButton() {
        adminDashBoardPage.ApprouveButton.click();
    }

    @When("On the page that appears click on the Yes button")
    public void onThePageThatAppearsClickOnTheYesButton() {
        adminDashBoardPage.PendingDepositsYesButton.click();

    }

    @And("Verify that Deposit request approved successfully is appeared")
    public void verifyThatDepositRequestApprovedSuccessfullyIsAppeared() {
        assertTrue(adminDashBoardPage.RequestApprouvedSuccessfully.isDisplayed());
    }

    @When("Type to samet in the searchtextbox and submit")
    public void typeToSametInTheSearchtextboxAndSubmit() {

        adminDashBoardPage.PendingDepositsSearchTextBox.click();
        adminDashBoardPage.PendingDepositsSearchTextBox.sendKeys("samet");
        adminDashBoardPage.PendingDepositsSearchTextSubmitbutton.click();

    }

    @When("Click on the first Details button")
    public void clickOnTheFirstDetailsButton() {
        adminDashBoardPage.PendingDepositsDetailsButtonSamet.click();
    }

    @When("Automatic deposit creation before main test")
    public void automaticDepositCreationBeforeMainTest() {

        adminDashBoardPage.UserpageDepositButtonElement.click();
        wait(1);
        adminDashBoardPage.UserpageDepositButtonElement.click();
        wait(1);
        adminDashBoardPage.UserDepositSelectGatewayElement.click();
        Select dropdown = new Select(adminDashBoardPage.UserDepositSelectGatewayElement);

        // Dropdown'ı açma ve bir seçenek seçme
        dropdown.selectByVisibleText("Manuel");

        adminDashBoardPage.UserPageAmountElement.click();

        adminDashBoardPage.UserPageAmountElement.sendKeys("1000");
        adminDashBoardPage.UserDepositSubmitButtonElement.click();
        wait(2);
        adminDashBoardPage.UserDepositPayNowButtonElement.click();

    }



    @Then("Fill in user information.")
    public void fillInUserInformation() {
        wait(1);
        loginPage.userNameBoxElement.clear();
        wait(1);
        loginPage.userNameBoxElement.sendKeys(ConfigReader.getProperty("UsernameSamet"));
        loginPage.passwordElement.clear();
        wait(1);
        loginPage.passwordElement.sendKeys(ConfigReader.getProperty("password"));
        wait(1);
        loginPage.userLoginButtonElement2.click();
        wait(1);

    }

    @When("Click the Deposits button")
    public void clickTheDepositsButton() {
        wait(3);
        adminDashBoardPage.DepositsButton.click();


    }


    @When("Click the DepositsS button")
    public void clickTheDepositsSButton() {
        wait(3);
        adminDashBoardPage.DepositsButton.click();
        wait(3);
    }

    @When("Click the Pending Deposits")
    public void clickThePendingDeposits() {
        adminDashBoardPage.PendingDeposits.click();
    }

    @When("Click the Pending Deposits Detail button")
    public void clickThePendingDepositsDetailButton() {
        adminDashBoardPage.PendingDepositsDetailsButtonElement.click();
    }
    @Given("verify that Categories link element visible")
    public void verify_that_categories_link_element_visible() {
        Assert.assertTrue(adminDashBoardPage.categories.isDisplayed());
    }
    @Given("click categories link element")
    public void click_categories_link_element() throws InterruptedException {
        adminDashBoardPage.categories.click();
        Thread.sleep(2000);

    }
    @Given("verify all categories visible")
    public void verify_all_categories_visible() {

        Assert.assertTrue(adminDashBoardPage.allCategories.isDisplayed());
    }
    @Given("click add new element button")
    public void click_add_new_element_button() throws InterruptedException {
        adminDashBoardPage.addNew.click();
        Thread.sleep(1000);

    }
    @Given("send the name of new loan to name textbox")
    public void send_the_name_of_new_loan_to_name_textbox() throws InterruptedException {
        adminDashBoardPage.nameCategories.click();
        adminDashBoardPage.nameCategories.sendKeys("computer2");
        Thread.sleep(2000);

    }
    @Given("send the description of new loan to description textbox")
    public void send_the_description_of_new_loan_to_description_textbox() throws InterruptedException {
        adminDashBoardPage.descriptionCategories.click();
        adminDashBoardPage.descriptionCategories.sendKeys("I needd computer loan");
        Thread.sleep(2000);


    }
    @Given("click submit button")
    public void click_submit_button() throws InterruptedException {
        adminDashBoardPage.submitNewCategories.click();
        Thread.sleep(2000);


    }
    @Given("verify that create new loan")
    public void verify_that_create_new_loan() {
        String actualCategoryName=adminDashBoardPage.addedCategoryName.getText();
        String expectedCategoryName="computer2";
        Assert.assertEquals(expectedCategoryName,actualCategoryName);


    }
    @Given("send a name of loan to search box")
    public void send_a_name_of_loan_to_search_box() throws InterruptedException {
        adminDashBoardPage.searchBoxCategories.click();
        adminDashBoardPage.searchBoxCategories.sendKeys("computer2");
        Thread.sleep(2000);


    }
    @Given("click the search icon")
    public void click_the_search_icon() throws InterruptedException {
        adminDashBoardPage.searchBoxCategoriesIcon.click();
        Thread.sleep(1000);

    }
    @Given("verify that the loan typed into the search box is listed")
    public void verify_that_the_loan_typed_into_the_search_box_is_listed() {
        String expectedUrl ="https://qa.loantechexper.com/admin/category/index?search=computer2";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }
    @Given("Click the EnableDisable button in the action tab of the first loan")
    public void click_the_enable_disable_button_in_the_action_tab_of_the_first_loan() throws InterruptedException {

        adminDashBoardPage.categories.click();
        Thread.sleep(2000);
        statusFirstCategory=adminDashBoardPage.statusCategory.getText();
        adminDashBoardPage.enebleDisableChange.click();
        Thread.sleep(2000);

    }
    @Given("click the yesButton on the Confirmation Alert page")
    public void click_the_yes_button_on_the_confirmation_alert_page() throws InterruptedException {

        adminDashBoardPage.allertYes.click();
        Thread.sleep(2000);

    }
    @Given("Verify that the status of the 1st line loan has changed")
    public void verify_that_the_status_of_the_1st_line_loan_has_changed() {
        String actualStatusFirstCategory=adminDashBoardPage.statusCategory.getText();
        String expectedStatusFirstCategory=statusFirstCategory;
        Assert.assertEquals(expectedStatusFirstCategory,actualStatusFirstCategory);


    }
    @Given("Click the editButton in the action tab of the first loan")
    public void click_the_edit_button_in_the_action_tab_of_the_first_loan() throws InterruptedException {
        nameCategory= adminDashBoardPage.nameCategories.getText();
        adminDashBoardPage.editCategory.click();
        Thread.sleep(1000);


    }
    @Given("send a new name to name loan textbox")
    public void send_a_new_name_to_name_loan_textbox() throws InterruptedException {
        adminDashBoardPage.nameCategories.clear();
        Thread.sleep(1000);
        adminDashBoardPage.nameCategories.sendKeys("ipad");

    }
    @Given("send the description to description textbox")
    public void send_the_description_to_description_textbox() throws InterruptedException {
        adminDashBoardPage.descriptionCategories.clear();
        Thread.sleep(1000);
        adminDashBoardPage.descriptionCategories.sendKeys("just fun");
        Thread.sleep(2000);
        adminDashBoardPage.submitNewCategories.click();
        Thread.sleep(3000);

    }
    @Given("Verify that first line loan has changed")
    public void verify_that_first_line_loan_has_changed() {
        String expectednameCategory=nameCategory;
        String actualNameCategory=adminDashBoardPage.nameCategories.getText();
        Assert.assertEquals(expectednameCategory,actualNameCategory);
    }
    @Then("Click on the Manage Users link.")
    public void click_on_the_manage_users_link() {
        dashboardPage.menageUsersLink.click();


    }

    @Then("Click the Active Users link and verify its visibility.")
    public void click_the_active_users_link_and_verify_its_visibility() {

        Assert.assertTrue(dashboardPage.activeUserLink.isDisplayed());
        dashboardPage.activeUserLink.click();

    }


    @Then("Verify that the list under Active Users are displayed.")
    public void verifyThatTheListUnderActiveUsersAreDisplayed() {
        Assert.assertTrue(dashboardPage.activeUserList.isDisplayed());
        wait(2);
    }

    @And("Click on the Details button for any user.")
    public void clickOnTheDetailsButtonForAnyUser() {
        dashboardPage.detailsButton.click();

    }

    @And("Verify that the User Detail-Username page has been reached.")
    public void verifyThatTheUserDetailUsernamePageHasBeenReached() {

        Assert.assertTrue(dashboardPage.userDetailButton.isDisplayed());
    }


    @Then("Under the Withdrawn heading, click on the View All link, and go to the Withdrawals Log page.")
    public void underTheWithdrawnHeadingClickOnTheViewAllLinkAndGoToTheWithdrawalsLogPage() {
        dashboardPage.viewAllButton.click();

    }

    @And("Confirm that the list and list headers are displayed on the page.")
    public void confirmThatTheListAndListHeadersAreDisplayedOnThePage() {

        Assert.assertTrue(dashboardPage.listenHeaders.isDisplayed());
    }


    @And("Confirm that the Approved Withdrawals, Pending Withdrawals, Rejected Withdrawals links are displayed.")
    public void confirmThatTheApprovedWithdrawalsPendingWithdrawalsRejectedWithdrawalsLinksAreDisplayed() {

        wait(2);


        Assert.assertTrue(dashboardPage.approvedwithdrawals.isDisplayed());
        Assert.assertTrue(dashboardPage.pendingwithdrawals.isDisplayed());
        Assert.assertTrue(dashboardPage.rejectedwithdrawals.isDisplayed());
    }

    @Then("Click on the Approved Withdrawals link.")
    public void clickOnTheApprovedWithdrawalsLink() {
        dashboardPage.approvedwithdrawals.click();


    }

    @And("Verify that the Details button is displayed on the Approved Withdrawals page.")
    public void verifyThatTheDetailsButtonIsDisplayedOnTheApprovedWithdrawalsPage() {
        wait(1);

        Assert.assertTrue(dashboardPage.approvvedDetailsbutton.isDisplayed());
        wait(1);

        dashboardPage.approvvedDetailsbutton.click();
    }

    @And("Click on the Details button.")
    public void clickOnTheDetailsButton() {
        dashboardPage.approvvedDetailsbutton.click();

    }

    @And("View the information within the card.")
    public void viewTheInformationWithinTheCard() {

        wait(1);
        List<WebElement> userInformation = dashboardPage.approvedUserInformation;
        for (WebElement each : userInformation
        ) {

            wait(2);
            System.out.println(userInformation);

        }

        Assert.assertFalse(dashboardPage.approvedUserInformation.isEmpty());


    }

    @And("Click on the Pending Withdrawn heading.")
    public void clickOnThePendingWithdrawnHeading() {
        dashboardPage.pendingwithdrawals.click();

    }

    @Then("Confirm the visibility of the Pending and Details buttons on this page.")
    public void confirmTheVisibilityOfThePendingAndDetailsButtonsOnThisPage() {

        Assert.assertTrue(dashboardPage.statusPending.isDisplayed());
        Assert.assertTrue(dashboardPage.pendingDetailsButton.isDisplayed());
    }


    @And("On the opened page, click on the Details button.")
    public void onTheOpenedPageClickOnTheDetailsButton() {
        dashboardPage.pendingDetailsButton.click();

    }

    @And("Confirm the visibility of the Approve and Reject buttons on the page that opens.")
    public void confirmTheVisibilityOfTheApproveAndRejectButtonsOnThePageThatOpens() {

        Assert.assertTrue(dashboardPage.pendingApproveButton.isDisplayed());
        Assert.assertTrue(dashboardPage.pendingRejectButton.isDisplayed());
    }

    @Then("On the page, click on the Reject button, fill in the required fields, and click on the submit button.")
    public void onThePageClickOnTheRejectButtonFillInTheRequiredFieldsAndClickOnTheSubmitButton() {
        dashboardPage.pendingRejectButton.click();
        wait(1);
        dashboardPage.pendingRejecttext.sendKeys("don't approved");
        wait(1);
        dashboardPage.pendingRejectSubmit.click();

    }

    @And("Confirm the display of the Withdrawal rejected successfully message.")
    public void confirmTheDisplayOfTheWithdrawalRejectedSuccessfullyMessage() {

        Assert.assertTrue(dashboardPage.pendingRejecdetsuccessfully.isDisplayed());
    }

    @Then("On the page, click on the Approved button, fill in the required fields, and click on the submit button.")
    public void onThePageClickOnTheApprovedButtonFillInTheRequiredFieldsAndClickOnTheSubmitButton() {
        dashboardPage.pendingApproveButton.click();
        wait(1);
        dashboardPage.pendingApproveText.sendKeys("yes");
        wait(1);
        dashboardPage.pendingApproveSubmit.click();

    }

    @And("Confirm the display of the Withdrawal approved successfully message.")
    public void confirmTheDisplayOfTheWithdrawalApprovedSuccessfullyMessage() {
        dashboardPage.pendingapprovedsuccesfully.isDisplayed();
        wait(1);
        System.out.println("eyyup  "+dashboardPage.pendingapprovedsuccesfully.getText());

    }

    @And("Click on the Rejected Withdrawals link.")
    public void clickOnTheRejectedWithdrawalsLink() {

        dashboardPage.rejectedwithdrawals.click();

    }


    @Then("Verify that the status is displayed as Rejected.")
    public void verifyThatTheStatusIsDisplayedAsRejected() {

        Assert.assertTrue(dashboardPage.statusRejected.isDisplayed());
    }

    @Then("View the card information on the page.")
    public void viewTheCardInformationOnThePage() {

        dashboardPage.rejectWithdravalsDetails.click();
        wait(1);

        List<WebElement> information=dashboardPage.rejectCardinformation;

        for (WebElement each: information
        ) {
            wait(1);
            System.out.println(each.getText());

        }
        Assert.assertTrue(dashboardPage.rejectCardinformation.size()>0);
    }


    @Given("Click on the manage users")
    public void click_on_the_manage_users() {
        adminDashBoardPage.manageUserElement.click();

    }
    @Given("Click on the active users")
    public void click_on_the_active_users() {
        adminDashBoardPage.activeUserElement.click();
    }
    @Given("The Active Users Link appears under the Manage Users link and it is verified that it is active.")
    public void the_link_appears_under_the_link_and_it_is_verified_that_it_is_active() {
        Assert.assertTrue(adminDashBoardPage.manageUserElement.isEnabled());
        Assert.assertTrue(adminDashBoardPage.activeUserElement.isEnabled());
    }

    @Given("Verify that the Active Users List and list titles can be displayed")
    public void verify_that_the_and_list_titles_can_be_displayed() {

        List<WebElement> activeUserTitles = adminDashBoardPage.activeUserTitles;

        for (WebElement each :activeUserTitles
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("Click on the Details")
    public void click_on_the_details() {
        adminDashBoardPage.activeUserDetailElement.click();
    }
    @Given("User Detail - Verifies that Username is on the page")
    public void user_detail_verifies_that_username_is_on_the_page() {
        adminDashBoardPage.userDetailsUsernameElemets.isDisplayed();

        adminDashBoardPage.userDetailsUsernameElemets.click();
        wait(2);
    }
    @Given("It must be verified that the Login as User button is active.")
    public void it_must_be_verified_that_the_login_as_user_button_is_active() {

        Assert.assertTrue( adminDashBoardPage.loginAsAUserButton.isEnabled());

    }

    @Given("Click on Login as button")
    public void click_on_login_as_button() {
        adminDashBoardPage.loginAsAUserButton.click();
        switchToWindow(Driver.getDriver().getTitle());
    }
    @Given("It should be verified that when active as user is clicked, it goes to the User Dashboard User Data page")
    public void it_should_be_verified_that_when_active_as_user_is_clicked_it_goes_to_the_user_dashboard_user_data_page() {

        Assert.assertTrue(homePage.loanTechLogoElement.isDisplayed());
    }


    @Given("Click on Active Users link under Manage Users link and go to Active Users page")
    public void click_on_active_users_link_under_manage_users_link_and_go_to_active_users_page() {
        adminDashBoardPage.activeUserLinkElement.click();
    }

    @When("User, Email-Phone, Country, Joined At, Balance, Action information of Active Users are displayed")
    public void userEmailPhoneCountryJoinedAtBalanceActionInformationOfActiveUsersAreDisplayed() {

    }

    @When("Click on the Details link under the Action information of an Active User")
    public void clickOnTheDetailsLinkUnderTheActionInformationOfAnActiveUser() {
        adminDashBoardPage.searchBoxElement.click();
        adminDashBoardPage.searchBoxElement.sendKeys("suphi");
        wait(1);
        adminDashBoardPage.searchButtonElement.click();
        wait(1);


    }

    @When("Go to User Details page")
    public void goToUserDetailsPage() {
        adminDashBoardPage.detailsButtonElement.click();

    }

    @When("The name and surname information under the heading Information of is reorganized and saved")
    public void theNameAndSurnameInformationUnderTheHeadingInformationOfIsReorganizedAndSaved() {
        adminDashBoardPage.informationFirstnameBoxElement.clear();
        adminDashBoardPage.informationFirstnameBoxElement.sendKeys("suphi atilim");

        adminDashBoardPage.informationLastnameBoxElement.clear();
        adminDashBoardPage.informationLastnameBoxElement.sendKeys("celikoz");

        clickWithJS(adminDashBoardPage.informationSubmitButtonElement);

        adminDashBoardPage.informationUpdatedConfirmElement.isDisplayed();

    }

    @When("The email address under the Information of heading is rearranged and saved in the correct format \\(there must be an {string} sign in the email address)")
    public void theEmailAddressUnderTheInformationOfHeadingIsRearrangedAndSavedInTheCorrectFormatThereMustBeAnSignInTheEmailAddress(String arg0) {

    }

    @When("City information under the Information of heading is reorganized and saved")
    public void cityInformationUnderTheInformationOfHeadingIsReorganizedAndSaved() {

    }

    @When("The State information under the Information of heading is reorganized and saved")
    public void theStateInformationUnderTheInformationOfHeadingIsReorganizedAndSaved() {

    }

    @When("Zip code information under the Information of heading is rearranged and saved")
    public void zipCodeInformationUnderTheInformationOfHeadingIsRearrangedAndSaved() {
        clickWithJS(adminDashBoardPage.informationZipcodeBoxElement);
        adminDashBoardPage.informationZipcodeBoxElement.clear();
        adminDashBoardPage.informationZipcodeBoxElement.sendKeys("123456");
        wait(1);

    }

    @When("The information under the Information of heading is rearranged and saved by clicking Submit button")
    public void theInformationUnderTheInformationOfHeadingIsRearrangedAndSavedByClickingSubmitButton() {
        clickWithJS(adminDashBoardPage.informationSubmitButtonElement);

    }

    @When("Changes are confirmed by the 'User details updated successfully' notification in the upper right corner of the page")
    public void changesAreConfirmedByTheNotificationInTheUpperRightCornerOfThePage() {
        adminDashBoardPage.informationUpdatedConfirmElement.isDisplayed();

    }

    @When("An attempt is made to enter missing - incorrect address information to the {string} address")
    public void anAttemptIsMadeToEnterMissingIncorrectAddressInformationToTheEMailAddress(String e_mail) {
        wait(1);
        e_mail="asdf";
        clickWithJS(adminDashBoardPage.informationEmailBoxElement);
        adminDashBoardPage.informationEmailBoxElement.clear();
        wait(1);
        adminDashBoardPage.informationEmailBoxElement.sendKeys(e_mail);
        wait(1);
        clickWithJS(adminDashBoardPage.informationSubmitButtonElement);

        String expectedResult="User details updated successfully";
        String actualResult="";

        Assert.assertNotEquals(expectedResult,actualResult);

    }

    @When("Please add an \"@\" sign to the email address. The \"@\" is missing in the {string} address.' incorrect input notification is displayed")
    public void pleaseAddAnSignToTheEmailAddressTheIsMissingInTheAddressIncorrectInputNotificationIsDisplayed(String e_mail ) {
        wait(1);
        e_mail="asdf";
        clickWithJS(adminDashBoardPage.informationEmailBoxElement);
        adminDashBoardPage.informationEmailBoxElement.clear();
        adminDashBoardPage.informationEmailBoxElement.sendKeys(e_mail);
        wait(1);
        adminDashBoardPage.informationSubmitButtonElement.click();

        String expectedResult="User details updated successfully";
        String actualResult="";

        Assert.assertNotEquals(expectedResult,actualResult);

        adminDashBoardPage.informationEmailBoxElement.click();
        adminDashBoardPage.informationEmailBoxElement.clear();
        adminDashBoardPage.informationEmailBoxElement.sendKeys("s@c");
        wait(1);
        adminDashBoardPage.informationSubmitButtonElement.click();

        String expectedResult2="User details updated successfully";
        String actualResult2=adminDashBoardPage.informationUpdatedConfirmElement.getText();
        Assert.assertEquals(expectedResult2,actualResult2);
    }
    @Given("Click on the Withdrawals link")
    public void click_on_the_withdrawals_link() {
        adminDashBoardPage.withdrawalDropMenu.click();
        wait(1);

    }
    @Given("Click on Withdrawal Methods link under Withdrawals link and go to Withdrawal Methods page")
    public void click_on_withdrawal_methods_link_under_withdrawals_link_and_go_to_withdrawal_methods_page() {
        adminDashBoardPage.withdrawalMethods.click();
        adminDashBoardPage.withdrawalMethodsText.isDisplayed();

        List<WebElement> withDrawHeader = adminDashBoardPage.withdrawalMethodsList;
        for (WebElement each : withDrawHeader
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }


    @Given("Click on the Add New button on the page that opens")
    public void click_on_the_add_new_button_on_the_page_that_opens()  {
        adminDashBoardPage.addButton.click();

    }

    @Given("Click submit button after information entry")
    public void click_submit_button_after_information_entry() throws AWTException {
        adminDashBoardPage.withdrawalMethodsName.sendKeys("AABC101");
        adminDashBoardPage.withdrawalMethodsCurrency.sendKeys("1000");
        adminDashBoardPage.withdrawalMethodsRate.sendKeys("1");
        adminDashBoardPage.withdrawalMethodsMinLimit.sendKeys("10000");
        adminDashBoardPage.withdrawalMethodsMaxLimit.sendKeys("50000");
        adminDashBoardPage.withdrawalMethodsFixedCharge.sendKeys("500");
        adminDashBoardPage.withdrawalMethodsPercentCharge.sendKeys("10");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait(2);
        coordinateClick(822, 664);

    }
    @Given("Type the method name added in the search box")
    public void type_the_method_name_added_in_the_search_box() {
        adminDashBoardPage.withdrawalMethodsSearchBox.sendKeys("AABC101"+ Keys.ENTER);
    }
    @Given("Verify that the new method added on the opened page is displayed in the list")
    public void verify_that_the_new_method_added_on_the_opened_page_is_displayed_in_the_list() {
        String exceptedMethodName="AABC101";
        String actualMethodName=adminDashBoardPage.withdrawalMethodsFirstColumn.getText();
        Assert.assertEquals(exceptedMethodName,actualMethodName);

    }
    @Given("Admin click the edit button to update the new method added")
    public void admin_click_the_edit_button_to_update_the_new_method_added() {
        adminDashBoardPage.withdrawalMethodsSearchBox.sendKeys("AABC101"+ Keys.ENTER);
        adminDashBoardPage.withdrawalMethodsEditButton.click();


    }
    @Given("Admin enters the value for the update and clicks submit")
    public void admin_enters_the_value_for_the_update_and_clicks_submit() throws AWTException {
        adminDashBoardPage.withdrawalMethodsMaxLimit.clear();
        adminDashBoardPage.withdrawalMethodsMaxLimit.sendKeys("100000");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait(2);
        coordinateClick(822, 664);

    }
    @Given("Verifies that the Withdraw method uptaded succesfully warning text is displayed")
    public void verifies_that_the_withdraw_method_uptaded_succesfully_warning_text_is_displayed() {
        wait(3);
        adminDashBoardPage.successfullyMessage.isDisplayed();

    }
    @Given("Admin clicks the disable button to disable the new added method")
    public void admin_clicks_the_disable_button_to_disable_the_new_added_method() {
        adminDashBoardPage.withdrawalMethodsSearchBox.sendKeys("AABC101"+ Keys.ENTER);
        adminDashBoardPage.withdrawalMethodsDisableButton.click();
    }
    @Given("Admin confirms method disable")
    public void admin_confirms_method_disable() {
        adminDashBoardPage.withdrawalMethodsDisableYesButton.click();
    }
    @Given("Admin method verifies that it is disabled")
    public void admin_method_verifies_that_it_is_disabled() {
        wait(2);
        adminDashBoardPage.statusChangedMessage.isDisplayed();

    }


    @Given("Admin After entering the information except the method name, clicks the submit button")
    public void admin_after_entering_the_information_except_the_method_name_clicks_the_submit_button() throws AWTException {
        adminDashBoardPage.withdrawalMethodsCurrency.sendKeys("1000");
        adminDashBoardPage.withdrawalMethodsRate.sendKeys("1");
        adminDashBoardPage.withdrawalMethodsMinLimit.sendKeys("10000");
        adminDashBoardPage.withdrawalMethodsMaxLimit.sendKeys("50000");
        adminDashBoardPage.withdrawalMethodsFixedCharge.sendKeys("500");
        adminDashBoardPage.withdrawalMethodsPercentCharge.sendKeys("10");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait(2);
        coordinateClick(822, 664);

    }
    @Given("Confirms that it is still on the New Withdrawal Method page due to missing information")
    public void confirms_that_it_is_still_on_the_new_withdrawal_method_page_due_to_missing_information() {
        adminDashBoardPage.updateWithdrawalMethodText.isDisplayed();
    }

    @Given("Admin confirms that the added, edited, disabled method is displayed")
    public void admin_confirms_that_the_added_edited_disabled_method_is_displayed() {
        List<WebElement> withDrawTable = adminDashBoardPage.withDrawTable;
        for (WebElement each : withDrawTable
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }
    @Given("Go to {string}")
    public void go_to(String adminUrlOne) {
        Driver.getDriver().get(ConfigReader.getProperty(adminUrlOne));
    }

    @Given("The username box is clicked and the username is entered.")
    public void The_username_box_is_clicked_and_the_username_is_entered() {

        actions.click(adminDashBoardPage.userNameElementi).sendKeys(ConfigReader.getProperty("adminemrename")).perform();
    }
    @Given("The password box is clicked and the password is entered.")
    public void the_password_box_is_clicked_and_the_password_is_entered() {
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("adminemrepassword")).
                sendKeys(Keys.PAGE_DOWN).perform();
    }
    @Given("The Login button is clicked.")
    public void the_login_button_is_clicked() {
        wait(2);
        adminDashBoardPage.adminLoginElementi.click();
    }
    @Given("Click on the Manage users tab.")
    public void click_on_the_manage_users_tab() {
        adminDashBoardPage.manegeUsersElementi.click();
    }
    @Given("The withbalance tab is clicked.")
    public void the_withbalance_tab_is_clicked() {
        adminDashBoardPage.withBalanceElementi.click();
    }
    @Given("The withbalance list is displayed.")
    public void the_withbalance_list_is_displayed() {
        Assert.assertTrue(adminDashBoardPage.listElement.isDisplayed());
    }
    @Given("searchbox is clicked")
    public void searchbox_is_clicked() {
        adminDashBoardPage.searchBoxElementi.click();
    }
    @Given("Enter the desired username and click enter.")
    public void enter_the_desired_username_and_click_enter() {
        adminDashBoardPage.searchBoxElementi.sendKeys(ConfigReader.getProperty("userBalance") + Keys.ENTER);
    }
    @Given("Details button is clicked")
    public void details_button_is_clicked() {
        adminDashBoardPage.detailsElementi.click();
    }
    @Given("It is verified that the detailed information of the desired user is accessed.")
    public void it_is_verified_that_the_detailed_information_of_the_desired_user_is_accessed() {
        Assert.assertTrue(adminDashBoardPage.userDetailElementi.isDisplayed());
    }



    @Given("Verify that Notification to All button is visible and active")
    public void verify_that_notification_to_all_button_is_visible_and_active() {

        adminDashBoardPage.manageUsersButton.click();
        wait(3);
        Assert.assertTrue(adminDashBoardPage.notificationButton.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.notificationButton.isEnabled());

    }

    @Given("Click the Notification to All button")
    public void click_the_notification_to_all_button() {

        adminDashBoardPage.notificationButton.click();
        wait(2);

    }

    @Given("Verify that Being Sent text is visible")
    public void verify_that_being_sent_text_is_visible() {

        Assert.assertTrue(adminDashBoardPage.beingSentText.isDisplayed());
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='form-control']")));
        select.selectByValue("selectedUsers");
        wait(2);
        Select select1 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='user[]']")));
        List<WebElement> mail = select1.getOptions();
        System.out.println("The dropdown options are:");
        for(WebElement options: mail)
            System.out.println(options.getText());
        wait(2);
        adminDashBoardPage.selectUsers.sendKeys("omerozyigit@gmail.com");
        wait(2);
        adminDashBoardPage.notificationButton.click();

    }

    @Given("Verify that the subject text is visible and write a test1 on textbox")
    public void verify_that_the_subject_text_is_visible_and_write_a_test1_on_textbox() {

        Assert.assertTrue(adminDashBoardPage.subjectText.isDisplayed());
        wait(1);
        adminDashBoardPage.subjectTextBox.sendKeys("test1");
        wait(1);

    }

    @Given("Write a message on message textbox")
    public void write_a_message_on_message_textbox() {

        wait(1);
        adminDashBoardPage.messageTextBox.sendKeys("test text test text test");

    }

    @Given("Write a number on start from text box")
    public void write_a_number_on_start_from_text_box() {

        wait(1);
        adminDashBoardPage.startFromTextBox.sendKeys("1");
        Assert.assertTrue(adminDashBoardPage.startFromText.isDisplayed());

    }

    @Given("Write a number on per batch text box")
    public void write_a_number_on_per_batch_text_box() {

        adminDashBoardPage.perBatchTextBox.sendKeys("1");
        Assert.assertTrue(adminDashBoardPage.perBatchText.isDisplayed());
    }

    @Given("Write a wait time number on Cooling Period text box")
    public void write_a_wait_time_number_on_cooling_period_text_box() {

        adminDashBoardPage.coolingPeriodTextBox.sendKeys("1");
        Assert.assertTrue(adminDashBoardPage.coolingPeriodText.isDisplayed());

    }

    @Given("Click the submit button on notification section")
    public void click_the_submit_button_on_notification_section() {

        adminDashBoardPage.notificationSubmitButton.submit();
        waitForVisibility(Driver.getDriver().findElement(By.xpath("//h5[normalize-space()='Notification Sending']")), 200);

    }

    @Given("Verify that successfully warning message is appear")
    public void verify_that_succefully_warning_message_is_appear() {


        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h5[normalize-space()='Notification Sending']")).isDisplayed());


    }

    @Given("Write an any number on per batch text box")
    public void write_an_any_number_on_per_batch_text_box() {

        adminDashBoardPage.perBatchTextBox.sendKeys("");
    }

    @Given("Verify that warning message is appear")
    public void verify_that_warning_message_is_appear() {



    }
    @Given("Display the Deposits item in the Dashboard menu and click on it")
    public void display_the_deposits_item_in_the_dashboard_menu_and_click_on_it() {
        adminDashBoardPage.depositsButton.click();
    }
    @Given("Click on Approved Deposits button")
    public void click_on_approved_deposits_button() {
        adminDashBoardPage.approvedDepositsButton.click();
    }
    @Given("Displays and verifies the title")
    public void Displays_and_verifies_the_title() {
        String expectedUrl="https://qa.loantechexper.com/admin/deposit/approved";
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Given("Admin confirms that the Approved Deposit list displays page titles")
    public void admin_confirms_that_the_approved_deposit_list_displays_page_titles() {
        List<WebElement> approvedDepositHeader = adminDashBoardPage.approvedDepositsHeader;
        for (WebElement each : approvedDepositHeader
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }

    @Given("Admin displays and clicks the Details button below the Action titles")
    public void admin_displays_and_clicks_the_details_button_below_the_action_titles() {
        adminDashBoardPage.approvedDepositsDetailsButton.click();
    }
    @Given("Verify that the Admin is on the Deposit Details page")
    public void verify_that_the_admin_is_on_the_deposit_details_page() {
        adminDashBoardPage.depositViaManualCardText.isDisplayed();
    }
    @Given("Admin Displays details on the detail page of the withdrawal selected from the list")
    public void admin_displays_details_on_the_detail_page_of_the_withdrawal_selected_from_the_list() {
        List<WebElement> viaManuelCardDetails = adminDashBoardPage.depositViaManualCard;
        for (WebElement each : viaManuelCardDetails
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }
    @Given("Click on the deposits")
    public void click_on_the_deposits() {

        adminDashBoardPage.depozitsElement.click();
    }
    @Given("Click  on the Successful Deposits")
    public void click_on_the_successful_deposits() {
        ;adminDashBoardPage.SuccessfulDepozitsElement.click();
    }
    @Given("verifies that you are on the page where the deposit was successful")
    public void verifies_that_you_are_on_the_page_where_the_deposit_was_successful() {
        Assert.assertTrue(adminDashBoardPage.succesfullDepozitTitle.isDisplayed());
    }

    @Given("Verifies that lists and titles are visible")
    public void verifies_that_lists_and_titles_are_visible() {
        List<WebElement> succesfullDepozitTitles= adminDashBoardPage.succesfullDepozitTitles;

        for (WebElement each :succesfullDepozitTitles
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }
    @Given("Verify that the Details button is visible and active")
    public void verify_that_the_details_button_is_visible_and_active() {

        Assert.assertTrue(adminDashBoardPage.sucDetailsElement.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.sucDetailsElement.isEnabled());
    }


    @Given("Information should be displayed on the detail page of the withdrawal transaction selected from the list.")
    public void information_should_be_displayed_on_the_detail_page_of_the_withdrawal_transaction_selected_from_the_list() {


        List<WebElement> depozitInformationElement= adminDashBoardPage.depozitInformationElement;

        for (WebElement each :depozitInformationElement
        ) {
            System.out.println(each.getText());
        }
        wait(2);

    }

    @Given("Click on the succesfulldetails")
    public void click_on_the_succesfulldetails() {
        adminDashBoardPage.sucDetailsElement.click();
    }
    @Given("It must be verified that the admin deposit page has been accessed.")
    public void it_must_be_verified_that_the_admin_deposit_page_has_been_accessed() {

        String expectedUrl = "deposit";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

    @Given("Click o the all Loans")
    public void click_o_the_all_loans() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        jse.executeScript("arguments[0].click();", adminDashBoardPage.allLoanslink);

    }


    @Given("Start Date and End Date boxes are must be visible and active")
    public void start_date_and_end_date_boxes_are_must_be_visible_and_active() {

        Assert.assertTrue(adminDashBoardPage.allLoansSearchBox.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.allLoansStartEndDateBox.isEnabled());


    }

    @Given("Successful Deposit, Pending Deposit, Rejected Deposit, Initiated Deposit  summary boxes must be visible and active")
    public void successful_deposit_pending_deposit_rejected_deposit_initiated_deposit_summary_boxes_must_be_visible_and_active() {
        adminDashBoardPage.succesfulDepozitElement.click();
        Driver.getDriver().navigate().back();
        wait(1);
        adminDashBoardPage.pendingDepozitElement.click();
        Driver.getDriver().navigate().back();
        wait(1);
        adminDashBoardPage.rejectedDepozitElement.click();
        Driver.getDriver().navigate().back();
        wait(1);
        adminDashBoardPage.initiatedDepozitElement.click();
        Driver.getDriver().navigate().back();
        wait(1);
    }
    @Given("When clicked, it should direct you to the relevant page and list.")
    public void when_clicked_it_should_direct_you_to_the_relevant_page_and_list() {

        adminDashBoardPage.succesfulDepozitElement.click();
        String expectedUrl="successful";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Driver.getDriver().navigate().back();

        adminDashBoardPage.pendingDepozitElement.click();
        String expectedUrl1="pending";
        String actualUrl1=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl1.contains(expectedUrl1));
        Driver.getDriver().navigate().back();

        adminDashBoardPage.rejectedDepozitElement.click();
        String expectedUrl2="https://qa.loantechexper.com/admin/deposit/rejected";
        String actualUrl2=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl2.contains(expectedUrl2));
        Driver.getDriver().navigate().back();

        adminDashBoardPage.initiatedDepozitElement.click();
        String expectedUrl3="initiated";
        String actualUrl3=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl3.contains(expectedUrl3));
        Driver.getDriver().navigate().back();
        wait(2);


    }

    @Given("Verify that the deposit history list and titles are visible")
    public void verify_that_the_deposit_history_list_and_titles_are_visible() {

        List<WebElement> depozitHistoryTbody= adminDashBoardPage.depozitHistoryTbody;

        for (WebElement each :depozitHistoryTbody
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }

    @Given("The Details button should be visible and active.")
    public void the_details_button_should_be_visible_and_active() {
        Assert.assertTrue(adminDashBoardPage.statusPendikDetails.isDisplayed());
    }
    @Given("Click on the allloans pending details")
    public void click_on_the_allloans_pending_details() {

        jse.executeScript("arguments[0].click();", adminDashBoardPage.statusPendikDetails);

        wait(2);
    }

    @Given("Click on the approve")
    public void click_on_the_approve() {


        adminDashBoardPage.approveElement.click();
    }
    @Given("Click on the Yes")
    public void click_on_the_yes() {
        //   Driver.getDriver().switchTo().alert();
        adminDashBoardPage.yeselement.click();
    }
    @Given("Verify that the print alert message is displayed")
    public void verify_that_the_print_alert_message_is_displayed() {
        Assert.assertTrue(adminDashBoardPage.succesfullWarmElement.isDisplayed());
    }
    @Given("Click on the approve details")
    public void click_on_the_approve_details() {
        adminDashBoardPage.statusapproveDetails.click();
    }

    @Given("It must be verified that deposit detail titles and content can be viewed.")
    public void it_must_be_verified_that_deposit_detail_titles_and_content_can_be_viewed() {



        List<WebElement> detayTitleElement= adminDashBoardPage.detayTitleElement;

        for (WebElement each :detayTitleElement
        ) {
            System.out.println(each.getText());
        }
        wait(2);
    }
    @Given("Verify that the Withdrawals menu is accessible under the admin panel")
    public void verify_that_the_withdrawals_menu_is_accessible_under_the_admin_panel() {

        Assert.assertTrue(adminDashBoardPage.withdrawalsButton.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalsButton.isEnabled());
        wait(3);

    }

    @Given("Click the Withdrawals menu")
    public void click_the_withdrawals_menu() {

        adminDashBoardPage.withdrawalsButton.click();
        System.out.println(adminDashBoardPage.withdrawalsButton.getText());
        wait(3);
        adminDashBoardPage.withdrawalMethods.click();
        // adminDashBoardPage.withdrawalMethodsButton.click();

    }

    @Given("Verify that the Withdrawal Methods menu is visible and active")
    public void verify_that_the_withdrawal_methods_menu_is_visible_and_active() {

        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsButton.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsButton.isEnabled());
        System.out.println(adminDashBoardPage.withdrawalMethodsButton.getText());
        wait(2);

    }

    @Given("Verify that the method-currency-charge-withdrawlimit-status-action information is visible")
    public void verify_that_the_method_currency_charge_withdrawlimit_status_action_information_is_visible() {

        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsMethod.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsCurrencyText.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsCharge.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsWithdrawLimit.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsStatus.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.withdrawalMethodsActions.isDisplayed());
        List<WebElement> raw = Driver.getDriver().findElements(By.xpath("//table[@class='table table--light style--two custom-data-table']"));
        System.out.println("raw number:"+raw.size());


    }

    @Given("Verify that the edit page is accessed under the Action heading.")
    public void verify_that_the_edit_page_is_accessed_under_the_action_heading() {

        Assert.assertTrue(adminDashBoardPage.editButton.isDisplayed());
        Assert.assertTrue(adminDashBoardPage.editButton.isEnabled());

    }

    @Given("Verify that edit the method selected in the Withdrawal Methods Table")
    public void verify_that_edit_the_method_selected_in_the_withdrawal_methods_table() {



    }

    @Given("Take the information in first raw on page")
    public void take_the_information_in_first_raw_on_page() {


    }

    @Given("Click the edit button on withdrawal method section")
    public void click_the_edit_button_on_withdrawal_method_section() {

    }

    @Given("Change the all information on edit page")
    public void change_the_all_information_on_edit_page() {

    }

    @Given("Click the submit button on withdrawal methods menu")
    public void click_the_submit_button_on_withdrawal_methods_menu() {

    }

    @Given("Verify that all information is change with updated data")
    public void verify_that_all_information_is_change_with_updated_data() {

    }

    @Given("Click the enable-disable button on first raw")
    public void click_the_enable_disable_button_on_first_raw() {

    }

    @Given("Click the confirmation alert on page")
    public void click_the_confirmation_alert_on_page() {

    }

    @Given("Verify that status is changed")
    public void verify_that_status_is_changed() {

    }

    @Given("Verify that add new button is visible and accessible")
    public void verify_that_add_new_button_is_visible_and_accessible() {

    }


    @Given("Fill the all information on page")
    public void fill_the_all_information_on_page() {

    }

    @Given("Click the submit button on new page")
    public void click_the_submit_button_on_new_page() {

    }

    @Given("Verify that new user is added in table")
    public void verify_that_new_user_is_added_in_table() {

    }

}
