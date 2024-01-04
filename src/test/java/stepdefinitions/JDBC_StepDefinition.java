package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;

import org.bouncycastle.asn1.cms.TimeStampedData;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.QueryManage;
import utilities.ReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


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

    @Given("The query is prepared and executedUpdate to the transport_feemaster table.")
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

        resultSet = getStatement().executeQuery("SELECT name, description  FROM categories WHERE id = "+newId+";");
        if (resultSet.next()) {
            // Verinin doğrulama işlemini yapın
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            assertEquals("ismailtemiz", name);
            assertEquals("SDET", description);
        }

        if(rowcount > 0){
            System.out.println("Ekleme işlemi başarıyla gerçekleştirildi.");
        } else{
            System.out.println("Ekleme işlemi başarısız oldu.");
        }
    }


    @Given("The query is prepared and executedUpdate to the update_logs table.")
    public void the_query_is_prepared_and_executed_update_to_the_update_logs_table() throws SQLException {

                query=queryManage.getUpdate_logsQuery();
                 String updateLog= faker.lorem().word();
                preparedUpdate(query,updateLog,"Windows 10",79);
                 System.out.println("Update_log :"+updateLog);
    }

    @Given("The query is prepared and executed to the support_tickets table.")
    public void the_query_is_prepared_and_executed_to_the_support_tickets_table() throws SQLException {

        query= queryManage.getSupportTicketsQuery();

        resultSet= getStatement().executeQuery(query);


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
        query= queryManage.getUsersMobileUpdateQuery();

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

        query=queryManage.getSupportAttachmentAddQuery();
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setNull(1, java.sql.Types.BIGINT);  // Otomatik artan sütun olduğu için null atanır.
        magic = faker.number().numberBetween(500,32000);
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
        query=queryManage.getSupportAttachmentQuery();
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,magic);
        preparedStatement.executeUpdate();
        System.out.println(magic+ " sayılı support message id silindi");
    }


    //Support_attachment tablosundan silinen id yi kontrol etme
    @Given("Verify that supportmessageid is deleted.")
    public void verify_that_supportmessageid_is_deleted() throws SQLException {

        try {
            query = queryManage.getSupportAttachmentVerifyQuery();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,magic);
            resultSet = preparedStatement.executeQuery();// Sorguyu çalıştırma

            // ResultSet verilerini konsolda yazdırma
            if (resultSet.next()) {
                do {
                    String id = String.valueOf(resultSet.getInt("id"));
                    System.out.println(id +" sayılı support message_id henüz silinmedi.");
                    Assert.assertNotNull(id);

                } while (resultSet.next());
            } else {

                System.out.println(magic+ " sayılı support message_id silindiği içi bulunamamıştır.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

}

    @Given("The query is prepared and executed to the deposits table.")
    public void the_query_is_prepared_and_executed_to_the_deposits_table() throws SQLException {
        query = queryManage.getDepositsQuery();

        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("The resultSet returned from the deposits table is validated.")
    public void the_result_set_returned_from_the_deposits_table_is_validated() throws SQLException {
        expectedData = "102.00000000";

        resultSet.next();
        actualData = resultSet.getString("charge");

        assertEquals(expectedData,actualData);
    }
    @Given("The query is prepared and executed to the admin notifications table.")
    public void the_query_is_prepared_and_executed_to_the_admin_notifications_table() throws SQLException {
        query = queryManage.getAdminNotifications();

        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("The resultSet returned from the admin notifications table is validated.")
    public void the_result_set_returned_from_the_admin_notifications_table_is_validated() throws SQLException {
    Assert.assertFalse(resultSet.next());
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
}





