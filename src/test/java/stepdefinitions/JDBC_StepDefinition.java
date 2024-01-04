package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.TimeStampedData;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.QueryManage;
import utilities.ReusableMethods;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.*;


public class JDBC_StepDefinition extends DBUtils {

    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();
    static String expectedData;
    static String actualData;
    String query;
    Faker faker = new Faker();
    int magic;


    ArrayList<String> lastnamesInReverseOrder = new ArrayList<>();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        createConnection();

    }

    @Given("Query hazirlanir ve chat_users tablosuna execute edilir.")
    public void query_hazirlanir_ve_chat_users_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getChatUsersQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Chat_users tablosundan donen resultSet dogrulanir.")
    public void chat_users_tablosundan_donen_result_set_dogrulanir() throws SQLException {

        expectedData = "11";

        resultSet.next();
        actualData = resultSet.getString(1);

        assertEquals(expectedData, actualData);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        closeConnection();
    }

    //********** Query02 ***********

    @Given("Query hazirlanir ve students tablosuna execute edilir.")
    public void query_hazirlanir_ve_students_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getStudentsQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Students tablosundan donen resultSet`teki email bilgisi dogrulanir.")
    public void students_tablosundan_donen_result_set_teki_email_bilgisi_dogrulanir() throws SQLException {

        expectedData = "brain@gmail.com";

        resultSet.next();

        actualData = resultSet.getString("email");

        assertEquals(expectedData, actualData);

    }


    //********* Query03 ***********

    @Given("Query hazirlanir ve onlineexam tablosuna execute edilir.")
    public void query_hazirlanir_ve_onlineexam_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getOnlineExamQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Onlineexam tablosundan donen resultSet`teki bilgiler listelenir.")
    public void onlineexam_tablosundan_donen_result_set_teki_bilgiler_listelenir() throws SQLException {

        while (resultSet.next()) {

            System.out.println(" exam : " + resultSet.getString(1) + " ->   ortalama: " +
                    resultSet.getString(2));

        }
    }

    //********** Query04 ***************

    @Given("Query hazirlanir ve transport_feemaster tablosuna executeUpdate edilir.")
    public void query_hazirlanir_ve_transport_feemaster_tablosuna_execute_update_edilir() {


    }

    @Given("The query is prepared and executed to the Support_messages table.")
    public void query_hazirlanir_ve_support_messages_tablosuna_execute_edilir() throws SQLException {
        query = queryManage.getSupportMessagesQuery();

        resultSet = getStatement().executeQuery(query);
    }

    @Given("The resultSet returned from the support_messages table is validated.")
    public void support_messages_tablosundan_donen_result_set_dogrulanir() throws SQLException {
        expectedData = "2";

        resultSet.next();
        actualData = resultSet.getString("support_ticket_id");

        assertEquals(expectedData, actualData);
    }

    @Given("The query is prepared and executedUpdate to the Catagories table.")
    public void the_query_is_prepared_and_executed_update_to_the_transport_feemaster_table() throws SQLException {

        String queryIdList = queryManage.getCategoriesIdListQuery();
        resultSet = getStatement().executeQuery(queryIdList);
        List<Integer> existingIds = new ArrayList<>();
        while (resultSet.next()) {
            existingIds.add(resultSet.getInt("id"));
        }
        int newId = 1;
        while (existingIds.contains(newId)) {
            newId++;
        }


        int rowcount = getStatement().executeUpdate("INSERT INTO  categories  (id, name, description) VALUES (" + newId + ", 'ismailtemiz', 'SDET')");
        System.out.println("Eklenecek yeni ID: " + newId);
        ReusableMethods.wait(3);

        resultSet = getStatement().executeQuery("SELECT name, description  FROM categories WHERE id = " + newId + ";");
        if (resultSet.next()) {
            // Verinin doğrulama işlemini yapın
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            assertEquals("ismailtemiz", name);
            assertEquals("SDET", description);
        }

        if (rowcount > 0) {
            System.out.println("Ekleme işlemi başarıyla gerçekleştirildi.");
        } else {
            System.out.println("Ekleme işlemi başarısız oldu.");
        }
    }


    @Given("The query is prepared and executedUpdate to the update_logs table.")
    public void the_query_is_prepared_and_executed_update_to_the_update_logs_table() throws SQLException {

        query = queryManage.getUpdate_logsQuery();
        String updateLog = faker.lorem().word();
        preparedUpdate(query, updateLog, "Windows 10", 79);
        System.out.println("Update_log :" + updateLog);
    }

    @Given("The query is prepared and executed to the support_tickets table.")
    public void the_query_is_prepared_and_executed_to_the_support_tickets_table() throws SQLException {

        query = queryManage.getSupportTicketsQuery();

        resultSet = getStatement().executeQuery(query);


    }

    @Given("The resultSet returned from the support_tickets table is validated.")
    public void the_result_set_returned_from_the_support_tickets_table_is_validated() throws SQLException {


        String[] expectedSubjects = {"Test", "testSubject", "Loantech", "s", "deserunt", "asdasd", "Test Ticket", "Test Ticket", "üüüüüü", "Test_attachment", "Test_attachment", "HelloWorld", "Ticket666", "Test Ticket", "Test Ticket", "Blue Test Ticket", "Blue Test Ticket", "Test Ticket", "Test Ticket", "Ticket666", "Blue Test Ticket", "Blue Test Ticket", "Blue Test Ticket", "Test Ticket", "Test Ticket", "Test Ticket", "Test Ticket"};

        int index = 0;

        while (resultSet.next() && index < expectedSubjects.length) {
            String subject = resultSet.getString("subject");
            System.out.println(subject);

            // Beklenen veri ile gerçek veriyi karşılaştır
            assertEquals(expectedSubjects[index], subject);
            index++;
        }

        //assertEquals(expectedData,actualData);

    }

    @Given("The query is prepared and executed to the users table.")
    public void the_query_is_prepared_and_executed_to_the_users_table() throws SQLException {
        query = queryManage.getUsersMobileUpdateQuery();

        preparedStatement = connection.prepareStatement(query);

        // '?' parametresini yeni mobil bilgisini set etme
        preparedStatement.setString(1, "0543526582");

        // Güncelleme sorgusunu çalıştırma
        int affectedRows = preparedStatement.executeUpdate();

        // Güncellenen satır sayısı
        System.out.println("Güncellenen satır sayısı: " + affectedRows);

    }


    //Support_attachment tablosuna yeni veri ekleme
    @Given("The query is prepared and executed to the support_attachment table to add new a row.")
    public void the_query_is_prepared_and_executed_to_the_support_attachment_table_to_add_new_a_row() throws SQLException {

        query = queryManage.getSupportAttachmentAddQuery();
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setNull(1, java.sql.Types.BIGINT);  // Otomatik artan sütun olduğu için null atanır.
        magic = faker.number().numberBetween(500, 32000);
        preparedStatement.setInt(2, magic);  // Parametre sırası 2
        preparedStatement.setString(3, faker.name().username());  // Parametre sırası 3
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        preparedStatement.setTimestamp(4, timeStamp);  // Parametre sırası 4
        preparedStatement.executeUpdate();

        // Oluşturulan id değerini almak
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            long id = generatedKeys.getLong(1);
            System.out.println("Support Message tablosunda Oluşturulan id : " + id);
        }
        System.out.println("Support Message tablosunda Oluşturulan support message id : " + magic);
    }


    //Suuport_attachment tablosundan veri silme
    @Given("The query is prepared and executed to the support_attachment table.")
    public void the_query_is_prepared_and_executed_to_the_support_attachment_table() throws SQLException {
        query = queryManage.getSupportAttachmentQuery();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, magic);
        preparedStatement.executeUpdate();
        System.out.println(magic + " sayılı support message id silindi");
    }


    //Support_attachment tablosundan silinen id yi kontrol etme
    @Given("Verify that supportmessageid is deleted.")
    public void verify_that_supportmessageid_is_deleted() throws SQLException {

        try {
            query = queryManage.getSupportAttachmentVerifyQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, magic);
            resultSet = preparedStatement.executeQuery();// Sorguyu çalıştırma

            // ResultSet verilerini konsolda yazdırma
            if (resultSet.next()) {
                do {
                    String id = String.valueOf(resultSet.getInt("id"));
                    System.out.println(id + " sayılı support message_id henüz silinmedi.");
                    Assert.assertNotNull(id);

                } while (resultSet.next());
            } else {

                System.out.println(magic + " sayılı support message_id silindiği içi bulunamamıştır.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Given("query hazirlanir ve bir tablo, verilen tablo ismi {string} ile o tablodaki tum satir ve sutunlr excel dosyasi olarak proje klasorune kaydedilir")
    public void query_hazirlanir_ve_bir_tablo_verilen_tablo_ismi_ile_o_tablodaki_tum_satir_ve_sutunlr_excel_dosyasi_olarak_proje_klasorune_kaydedilir(String tabloIsmi) throws SQLException, IOException {
        query = queryManage.getCategoriesListExcelQuery();
        exportToExcel(query, tabloIsmi);

    }


    @When("Retrieve user data without country_code!=TR and id=11")
    public void retrieveUserData() throws SQLException {

        String sql = "SELECT firstname, lastname FROM users WHERE country_code != 'TR' AND id = 11";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
    }

    @Then("Verify firstname and lastname information")
    public void verifyUserData() throws SQLException {

        while (resultSet.next()) {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");

            assertEquals("Mehmet", firstname);
            assertEquals("Genç", lastname);
            System.out.println(firstname + " " + lastname);
        }

    }

    @When("Retrieve users in reverse order by lastname and firstname")
    public void retrieveUsersInReverseOrder() throws SQLException {

        String sql = "SELECT lastname, firstname FROM users ORDER BY lastname DESC, firstname DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String lastname = resultSet.getString("lastname");
            lastnamesInReverseOrder.add(lastname);
        }


        resultSet.close();
    }

    @Then("Verify the first lastname in the list")
    public void verifyFirstLastname() {

        String expectedFirstLastname = "ZULAUF";
        String actualFirstLastname = lastnamesInReverseOrder.get(0);

        assertEquals(expectedFirstLastname, actualFirstLastname);


        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Given("there are installments in the database")
    public void thereAreInstallmentsInTheDatabase() throws SQLException {
        // Veritabanına örnek veriler ekleyelim
        connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec", "u168183796_qaloantecuser", "0&vG1A/MuWN");
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO installments (loan_id, delay_charge, installment_date, given_at) VALUES (?, ?, ?, ?)")) {
            statement.setInt(1, 1);
            statement.setDouble(2, 10.0);
            statement.setString(3, "2024-01-01");
            statement.setString(4, "2023-12-01");
            statement.executeUpdate();
        }
    }


    private int loanId;
    private double totalDelayCharge;

    @Given("the loan with ID {string}")
    public void setLoanId(String loanId) {
        this.loanId = Integer.parseInt(loanId);
    }

    @When("I calculate the total_delay_charge for the loan")
    public void calculateTotalDelayCharge() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://45.87.83.5/u168183796_qaloantec", "u168183796_qaloantecuser", "0&vG1A/MuWN");
            Statement statement = connection.createStatement();

            String query = "SELECT SUM(delay_charge) FROM installments WHERE loan_id = " + loanId;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                totalDelayCharge = resultSet.getDouble(1);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Then("the total_delay_charge should be {string}")
    public void assertTotalDelayCharge(String expectedTotalDelayCharge) {
        double expected = Double.parseDouble(expectedTotalDelayCharge);
        assert totalDelayCharge == expected : "Total delay charge does not match the expected value";
    }


    @Given("The query is prepared and executed to the gateways table.")
    public void the_query_is_prepared_and_executed_to_the_gateways_table() throws SQLException {
        query = queryManage.getGatewaysListQuery();

        resultSet = getStatement().executeQuery(query);
    }

    @Given("The resultSet returned from the gateways table is validated")
    public void the_result_set_returned_from_the_gateways_table_is_validated() throws SQLException {

        while (resultSet.next()) {
            int code = resultSet.getInt("code");
            System.out.println("Code: " + code);
        }
    }


    @Given("The query is prepared and executed to the admin_notifications table.")
    public void the_query_is_prepared_and_executed_to_the_admin_notifications_table() throws SQLException {
        query = queryManage.getAdminNotificationsQuery();
        resultSet = getStatement().executeQuery(query);
    }

    @Given("The resultSet returned from the admin_notifications table is validated")
    public void the_result_set_returned_from_the_admin_notifications_table_is_validated() throws SQLException {
        if (resultSet.next()) {
            int notificationCount = resultSet.getInt(1);
            System.out.println("Kullanici adedi: " + notificationCount);
        } else {
            System.out.println("Kullanici bulunamadi");
        }
    }

    @Given("The query is prepared and executed to the Deposits from gateway_currencies table.")
    public void the_query_is_prepared_and_executed_to_the_deposits_from_gateway_currencies_table() throws SQLException {
        query = queryManage.getDepositsGatewayCurrenciesQuery();
        resultSet = getStatement().executeQuery(query);
    }

    @Given("currency USD Verifies that the Total Amount of Deposits is Calculated from the gateway_currencies table")
    public void currency_USD_verifies_that_the_total_amount_of_deposits_is_calculated_from_the_gateway_currencies_table() throws SQLException {
        expectedData = "916375.18000000";

        resultSet.next();
        actualData = resultSet.getString("toplam_usd");

        assertEquals(expectedData, actualData);
    }


    @Given("The query is prepared and executed to the deposits amount table")
    public void the_query_is_prepared_and_executed_to_the_deposits_amount_table() throws SQLException {
        query = queryManage.getAdmindeposits();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("The resultSet returned from the deposits amount table is validated")
    public void the_result_set_returned_from_the_deposits_amount_table_is_validated() throws SQLException {
        expectedData = "1";
        resultSet.next();
        actualData = resultSet.getString("user_id");
        assertEquals(expectedData,actualData);
    }
    @Given("The query is prepared and executed to the deposits table.")
    public void the_query_is_prepared_and_executed_to_the_deposits_table() throws SQLException {
        query = queryManage.getDepositsQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("The query is prepared and executed to the one admin notifications table.")
    public void the_query_is_prepared_and_executed_to_the_one_admin_notifications_table() throws SQLException {
        query = queryManage.getAdminNotifications();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("The resultSet returned from the one admin notifications table is validated.")
    public void the_result_set_returned_from_the_one_admin_notifications_table_is_validated() throws SQLException {
        Assert.assertFalse(resultSet.next());
    }


    @Given("The query is prepared and executed to the admin password resets table to add new a row.")
    public void the_query_is_prepared_and_executed_to_the_admin_password_resets_table_to_add_new_a_row() throws SQLException {


        query = queryManage.getAdminPasswordResetsQuery();
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setNull(1, java.sql.Types.BIGINT);  // Otomatik artan sütun olduğu için null atanır.
        preparedStatement.setString(2, faker.internet().emailAddress());  // Parametre sırası 2
        preparedStatement.setString(3, faker.name().username());  // Parametre sırası 3
        magic = faker.number().numberBetween(0, 1);
        preparedStatement.setInt(4, magic);  // Parametre sırası 4


        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        preparedStatement.setTimestamp(5, timeStamp);  // Parametre sırası 5
        preparedStatement.executeUpdate();

        // Oluşturulan id değerini almak
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            long id = generatedKeys.getLong(1);
            System.out.println("admin password resets tablosunda Oluşturulan  yeni id : " + id);
        }



    }

    @Given("The query is prepared and verified by executing it on the cron job logs table.")
    public void the_query_is_prepared_and_verified_by_executing_it_on_the_cron_job_logs_table() throws SQLException {
        query = queryManage.getCronJobLogsQuery();
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, faker.number().numberBetween(500, 1000));  // parametre sirasi 1

        magic = faker.number().numberBetween(1, 9);
        preparedStatement.setInt(2, magic); // parametre sirasi 2

        // Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        // preparedStatement.setTimestamp(3, timeStamp); // parametre sirasi 3
        // preparedStatement.setTimestamp(4, timeStamp);  // parametre sirasi 4
        magic = faker.number().numberBetween(0, 100);
        preparedStatement.setInt(3, magic);      // parametre sirasi 5

        preparedStatement.setString(4, faker.name().username());  // Parametre sırası 6
        //preparedStatement.setTimestamp(7, timeStamp);  // parametre sirasi 7
        //preparedStatement.setTimestamp(8, timeStamp);  // parametre sirasi 8


        int rowCount = preparedStatement.executeUpdate();
        Assert.assertEquals(1, rowCount);
        if (rowCount > 0) {
            System.out.println("Ekleme işlemi başarıyla gerçekleştirildi.");
        } else {
            System.out.println("Ekleme işlemi başarısız oldu.");
        }
    }

    @Given("user login query is prepared en executed")
    public void user_login_query_is_prepared_en_executed() throws SQLException {

        query = queryManage.getUserloginsQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);


    }

    @Given("data from the user login query is validated")
    public void data_from_the_user_login_query_is_validated() throws SQLException {
        resultSet.next();
        String city = resultSet.getString("city");


        Assert.assertEquals("", city);


    }
    @Given("The resultSet returned from the deposits table is validated.")
    public void the_result_set_returned_from_the_deposits_table_is_validated() throws SQLException {
        expectedData = "102.00000000";
        resultSet.next();
        actualData = resultSet.getString("charge");
        assertEquals(expectedData,actualData);
    }

}






