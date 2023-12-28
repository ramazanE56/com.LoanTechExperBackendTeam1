package pages;


import utilities.Driver;

public class PageInitializer extends Driver {

    public static LoginPage loginPage;
    public static DashBoardPage dashboardPage;
    public static AdminLoginPage adminLoginPage;
    public static AdminDashBoardPage adminDashBoardPage;
    public static HomePage homePage;



    public static void initialize() {

        loginPage=new LoginPage();


    }
}
